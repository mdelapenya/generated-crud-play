
package controllers;

import com.avaje.ebean.Ebean;

import controllers.portletpreferences.PortletpreferencesFormData;

import models.portletpreferences.Portletpreferences;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.portletpreferences.portletpreferences;
import views.html.portletpreferences.portletpreferencess;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PortletpreferencesApplication extends Controller {

	public static Result addPortletpreferences() {
		Form<PortletpreferencesFormData> form = Form.form(
			PortletpreferencesFormData.class).fill(new Portletpreferences().toFormData());

		return ok(portletpreferences.render(form));
	}

	public static Result get(Long id) {
		Portletpreferences dbPortletpreferences = Portletpreferences.find.byId(id);

		Form<PortletpreferencesFormData> form = Form.form(
			PortletpreferencesFormData.class).fill(dbPortletpreferences.toFormData());

		return ok(portletpreferences.render(form));
	}

	public static Result all() {
		List<Portletpreferences> portletpreferencesList = Portletpreferences.find.all();

		return ok(portletpreferencess.render(portletpreferencesList));
	}

	public static Result submit() {
		Form<PortletpreferencesFormData> formData = Form.form(
			PortletpreferencesFormData.class).bindFromRequest();

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

	public static Result edit(Form<PortletpreferencesFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPortletpreferences();
		}
		else {
			PortletpreferencesFormData portletpreferencesFormData = formData.get();

			String id = portletpreferencesFormData.portletPreferencesId;

			long portletpreferencesId = 0;

			if (id != null) {
				portletpreferencesId = Long.valueOf(id);
			}

			Portletpreferences portletpreferences;

			if (portletpreferencesId > 0) {
				portletpreferences = Portletpreferences.find.byId(portletpreferencesId);

				portletpreferences.setMvccVersion(Long.valueOf(portletpreferencesFormData.mvccVersion));
				portletpreferences.setPortletPreferencesId(Long.valueOf(portletpreferencesFormData.portletPreferencesId));
				portletpreferences.setOwnerId(Long.valueOf(portletpreferencesFormData.ownerId));
				portletpreferences.setOwnerType(Integer.valueOf(portletpreferencesFormData.ownerType));
				portletpreferences.setPlid(Long.valueOf(portletpreferencesFormData.plid));
				portletpreferences.setPortletId(portletpreferencesFormData.portletId);
				portletpreferences.setPreferences(portletpreferencesFormData.preferences);
			}
			else {
				portletpreferences = new Portletpreferences(portletpreferencesFormData);
			}

			Ebean.save(portletpreferences);

			flash("success", "Portletpreferences instance created/edited: " + portletpreferences);

			return all();
		}
	}

	public static Result delete(Form<PortletpreferencesFormData> formData) {
		PortletpreferencesFormData portletpreferencesFormData = formData.get();

		String id = portletpreferencesFormData.portletPreferencesId;

		long portletpreferencesId = 0;

		if (id != null) {
			portletpreferencesId = Long.valueOf(id);
		}

		Portletpreferences portletpreferences;

		if (portletpreferencesId > 0) {
			portletpreferences = Portletpreferences.find.byId(portletpreferencesId);

			Ebean.delete(portletpreferences);
		}
		else {
			flash("error", "Cannot delete Portletpreferences");
		}

		return all();
	}

}
