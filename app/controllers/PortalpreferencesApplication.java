
package controllers;

import com.avaje.ebean.Ebean;

import controllers.portalpreferences.PortalpreferencesFormData;

import models.portalpreferences.Portalpreferences;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.portalpreferences.portalpreferences;
import views.html.portalpreferences.portalpreferencess;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PortalpreferencesApplication extends Controller {

	public static Result addPortalpreferences() {
		Form<PortalpreferencesFormData> form = Form.form(
			PortalpreferencesFormData.class).fill(new Portalpreferences().toFormData());

		return ok(portalpreferences.render(form));
	}

	public static Result get(Long id) {
		Portalpreferences dbPortalpreferences = Portalpreferences.find.byId(id);

		Form<PortalpreferencesFormData> form = Form.form(
			PortalpreferencesFormData.class).fill(dbPortalpreferences.toFormData());

		return ok(portalpreferences.render(form));
	}

	public static Result all() {
		List<Portalpreferences> portalpreferencesList = Portalpreferences.find.all();

		return ok(portalpreferencess.render(portalpreferencesList));
	}

	public static Result submit() {
		Form<PortalpreferencesFormData> formData = Form.form(
			PortalpreferencesFormData.class).bindFromRequest();

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

	public static Result edit(Form<PortalpreferencesFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPortalpreferences();
		}
		else {
			PortalpreferencesFormData portalpreferencesFormData = formData.get();

			String id = portalpreferencesFormData.portalPreferencesId;

			long portalpreferencesId = 0;

			if (id != null) {
				portalpreferencesId = Long.valueOf(id);
			}

			Portalpreferences portalpreferences;

			if (portalpreferencesId > 0) {
				portalpreferences = Portalpreferences.find.byId(portalpreferencesId);

				portalpreferences.setMvccVersion(Long.valueOf(portalpreferencesFormData.mvccVersion));
				portalpreferences.setPortalPreferencesId(Long.valueOf(portalpreferencesFormData.portalPreferencesId));
				portalpreferences.setOwnerId(Long.valueOf(portalpreferencesFormData.ownerId));
				portalpreferences.setOwnerType(Integer.valueOf(portalpreferencesFormData.ownerType));
				portalpreferences.setPreferences(portalpreferencesFormData.preferences);
			}
			else {
				portalpreferences = new Portalpreferences(portalpreferencesFormData);
			}

			Ebean.save(portalpreferences);

			flash("success", "Portalpreferences instance created/edited: " + portalpreferences);

			return all();
		}
	}

	public static Result delete(Form<PortalpreferencesFormData> formData) {
		PortalpreferencesFormData portalpreferencesFormData = formData.get();

		String id = portalpreferencesFormData.portalPreferencesId;

		long portalpreferencesId = 0;

		if (id != null) {
			portalpreferencesId = Long.valueOf(id);
		}

		Portalpreferences portalpreferences;

		if (portalpreferencesId > 0) {
			portalpreferences = Portalpreferences.find.byId(portalpreferencesId);

			Ebean.delete(portalpreferences);
		}
		else {
			flash("error", "Cannot delete Portalpreferences");
		}

		return all();
	}

}
