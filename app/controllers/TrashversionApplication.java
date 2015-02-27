
package controllers;

import com.avaje.ebean.Ebean;

import controllers.trashversion.TrashversionFormData;

import models.trashversion.Trashversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.trashversion.trashversion;
import views.html.trashversion.trashversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class TrashversionApplication extends Controller {

	public static Result addTrashversion() {
		Form<TrashversionFormData> form = Form.form(
			TrashversionFormData.class).fill(new Trashversion().toFormData());

		return ok(trashversion.render(form));
	}

	public static Result get(Long id) {
		Trashversion dbTrashversion = Trashversion.find.byId(id);

		Form<TrashversionFormData> form = Form.form(
			TrashversionFormData.class).fill(dbTrashversion.toFormData());

		return ok(trashversion.render(form));
	}

	public static Result all() {
		List<Trashversion> trashversionList = Trashversion.find.all();

		return ok(trashversions.render(trashversionList));
	}

	public static Result submit() {
		Form<TrashversionFormData> formData = Form.form(
			TrashversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<TrashversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addTrashversion();
		}
		else {
			TrashversionFormData trashversionFormData = formData.get();

			String id = trashversionFormData.versionId;

			long trashversionId = 0;

			if (id != null) {
				trashversionId = Long.valueOf(id);
			}

			Trashversion trashversion;

			if (trashversionId > 0) {
				trashversion = Trashversion.find.byId(trashversionId);

				trashversion.setVersionId(Long.valueOf(trashversionFormData.versionId));
				trashversion.setEntryId(Long.valueOf(trashversionFormData.entryId));
				trashversion.setClassNameId(Long.valueOf(trashversionFormData.classNameId));
				trashversion.setClassPK(Long.valueOf(trashversionFormData.classPK));
				trashversion.setTypeSettings(trashversionFormData.typeSettings);
				trashversion.setStatus(Integer.valueOf(trashversionFormData.status));
			}
			else {
				trashversion = new Trashversion(trashversionFormData);
			}

			Ebean.save(trashversion);

			flash("success", "Trashversion instance created/edited: " + trashversion);

			return all();
		}
	}

	public static Result delete(Form<TrashversionFormData> formData) {
		TrashversionFormData trashversionFormData = formData.get();

		String id = trashversionFormData.versionId;

		long trashversionId = 0;

		if (id != null) {
			trashversionId = Long.valueOf(id);
		}

		Trashversion trashversion;

		if (trashversionId > 0) {
			trashversion = Trashversion.find.byId(trashversionId);

			Ebean.delete(trashversion);
		}
		else {
			flash("error", "Cannot delete Trashversion");
		}

		return all();
	}

}
