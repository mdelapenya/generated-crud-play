
package controllers;

import com.avaje.ebean.Ebean;

import controllers.portletitem.PortletitemFormData;

import models.portletitem.Portletitem;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.portletitem.portletitem;
import views.html.portletitem.portletitems;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PortletitemApplication extends Controller {

	public static Result addPortletitem() {
		Form<PortletitemFormData> form = Form.form(
			PortletitemFormData.class).fill(new Portletitem().toFormData());

		return ok(portletitem.render(form));
	}

	public static Result get(Long id) {
		Portletitem dbPortletitem = Portletitem.find.byId(id);

		Form<PortletitemFormData> form = Form.form(
			PortletitemFormData.class).fill(dbPortletitem.toFormData());

		return ok(portletitem.render(form));
	}

	public static Result all() {
		List<Portletitem> portletitemList = Portletitem.find.all();

		return ok(portletitems.render(portletitemList));
	}

	public static Result submit() {
		Form<PortletitemFormData> formData = Form.form(
			PortletitemFormData.class).bindFromRequest();

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

	public static Result edit(Form<PortletitemFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPortletitem();
		}
		else {
			PortletitemFormData portletitemFormData = formData.get();

			String id = portletitemFormData.portletItemId;

			long portletitemId = 0;

			if (id != null) {
				portletitemId = Long.valueOf(id);
			}

			Portletitem portletitem;

			if (portletitemId > 0) {
				portletitem = Portletitem.find.byId(portletitemId);

				portletitem.setMvccVersion(Long.valueOf(portletitemFormData.mvccVersion));
				portletitem.setPortletItemId(Long.valueOf(portletitemFormData.portletItemId));
				portletitem.setGroupId(Long.valueOf(portletitemFormData.groupId));
				portletitem.setCompanyId(Long.valueOf(portletitemFormData.companyId));
				portletitem.setUserId(Long.valueOf(portletitemFormData.userId));
				portletitem.setUserName(portletitemFormData.userName);
				portletitem.setCreateDate(new Date(portletitemFormData.createDate));
				portletitem.setModifiedDate(new Date(portletitemFormData.modifiedDate));
				portletitem.setName(portletitemFormData.name);
				portletitem.setPortletId(portletitemFormData.portletId);
				portletitem.setClassNameId(Long.valueOf(portletitemFormData.classNameId));
			}
			else {
				portletitem = new Portletitem(portletitemFormData);
			}

			Ebean.save(portletitem);

			flash("success", "Portletitem instance created/edited: " + portletitem);

			return all();
		}
	}

	public static Result delete(Form<PortletitemFormData> formData) {
		PortletitemFormData portletitemFormData = formData.get();

		String id = portletitemFormData.portletItemId;

		long portletitemId = 0;

		if (id != null) {
			portletitemId = Long.valueOf(id);
		}

		Portletitem portletitem;

		if (portletitemId > 0) {
			portletitem = Portletitem.find.byId(portletitemId);

			Ebean.delete(portletitem);
		}
		else {
			flash("error", "Cannot delete Portletitem");
		}

		return all();
	}

}
