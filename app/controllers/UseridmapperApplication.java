
package controllers;

import com.avaje.ebean.Ebean;

import controllers.useridmapper.UseridmapperFormData;

import models.useridmapper.Useridmapper;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.useridmapper.useridmapper;
import views.html.useridmapper.useridmappers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UseridmapperApplication extends Controller {

	public static Result addUseridmapper() {
		Form<UseridmapperFormData> form = Form.form(
			UseridmapperFormData.class).fill(new Useridmapper().toFormData());

		return ok(useridmapper.render(form));
	}

	public static Result get(Long id) {
		Useridmapper dbUseridmapper = Useridmapper.find.byId(id);

		Form<UseridmapperFormData> form = Form.form(
			UseridmapperFormData.class).fill(dbUseridmapper.toFormData());

		return ok(useridmapper.render(form));
	}

	public static Result all() {
		List<Useridmapper> useridmapperList = Useridmapper.find.all();

		return ok(useridmappers.render(useridmapperList));
	}

	public static Result submit() {
		Form<UseridmapperFormData> formData = Form.form(
			UseridmapperFormData.class).bindFromRequest();

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

	public static Result edit(Form<UseridmapperFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUseridmapper();
		}
		else {
			UseridmapperFormData useridmapperFormData = formData.get();

			String id = useridmapperFormData.userIdMapperId;

			long useridmapperId = 0;

			if (id != null) {
				useridmapperId = Long.valueOf(id);
			}

			Useridmapper useridmapper;

			if (useridmapperId > 0) {
				useridmapper = Useridmapper.find.byId(useridmapperId);

				useridmapper.setMvccVersion(Long.valueOf(useridmapperFormData.mvccVersion));
				useridmapper.setUserIdMapperId(Long.valueOf(useridmapperFormData.userIdMapperId));
				useridmapper.setUserId(Long.valueOf(useridmapperFormData.userId));
				useridmapper.setCustomtype(useridmapperFormData.customtype);
				useridmapper.setDescription(useridmapperFormData.description);
				useridmapper.setExternalUserId(useridmapperFormData.externalUserId);
			}
			else {
				useridmapper = new Useridmapper(useridmapperFormData);
			}

			Ebean.save(useridmapper);

			flash("success", "Useridmapper instance created/edited: " + useridmapper);

			return all();
		}
	}

	public static Result delete(Form<UseridmapperFormData> formData) {
		UseridmapperFormData useridmapperFormData = formData.get();

		String id = useridmapperFormData.userIdMapperId;

		long useridmapperId = 0;

		if (id != null) {
			useridmapperId = Long.valueOf(id);
		}

		Useridmapper useridmapper;

		if (useridmapperId > 0) {
			useridmapper = Useridmapper.find.byId(useridmapperId);

			Ebean.delete(useridmapper);
		}
		else {
			flash("error", "Cannot delete Useridmapper");
		}

		return all();
	}

}
