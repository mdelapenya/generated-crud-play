
package controllers;

import com.avaje.ebean.Ebean;

import controllers.portlet.PortletFormData;

import models.portlet.Portlet;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.portlet.portlet;
import views.html.portlet.portlets;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PortletApplication extends Controller {

	public static Result addPortlet() {
		Form<PortletFormData> form = Form.form(
			PortletFormData.class).fill(new Portlet().toFormData());

		return ok(portlet.render(form));
	}

	public static Result get(Long id) {
		Portlet dbPortlet = Portlet.find.byId(id);

		Form<PortletFormData> form = Form.form(
			PortletFormData.class).fill(dbPortlet.toFormData());

		return ok(portlet.render(form));
	}

	public static Result all() {
		List<Portlet> portletList = Portlet.find.all();

		return ok(portlets.render(portletList));
	}

	public static Result submit() {
		Form<PortletFormData> formData = Form.form(
			PortletFormData.class).bindFromRequest();

		String[] postSubmit = request().body().asFormUrlEncoded().get("submit");

		if (postSubmit == null || postSubmit.length == 0) {
			return badRequest("You must provide a valid action");
		}
		else {
			String action = postSubmit[0];

			if ("edit".equals(action)) {
				return edit(formData);
			}
			else if ("delete".equals(action)) {
				return delete(formData);
			}
			else {
				return badRequest("This action is not allowed");
			}
		}
	}

	public static Result edit(Form<PortletFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPortlet();
		}
		else {
			PortletFormData portletFormData = formData.get();

			String id = portletFormData.id;

			long portletId = 0;

			if (id != null) {
				portletId = Long.valueOf(id);
			}

			Portlet portlet;

			if (portletId > 0) {
				portlet = Portlet.find.byId(portletId);

				portlet.setMvccVersion(Long.valueOf(portletFormData.mvccVersion));
				portlet.setId(Long.valueOf(portletFormData.id));
				portlet.setCompanyId(Long.valueOf(portletFormData.companyId));
				portlet.setPortletId(portletFormData.portletId);
				portlet.setRoles(portletFormData.roles);
				portlet.setActive(Boolean.valueOf(portletFormData.active));
			}
			else {
				portlet = new Portlet(portletFormData);
			}

			Ebean.save(portlet);

			flash("success", "Portlet instance created/edited: " + portlet);

			return all();
		}
	}

	public static Result delete(Form<PortletFormData> formData) {
		PortletFormData portletFormData = formData.get();

		String id = portletFormData.id;

		long portletId = 0;

		if (id != null) {
			portletId = Long.valueOf(id);
		}

		Portlet portlet;

		if (portletId > 0) {
			portlet = Portlet.find.byId(portletId);

			Ebean.delete(portlet);
		}
		else {
			flash("error", "Cannot delete Portlet");
		}

		return all();
	}

}
