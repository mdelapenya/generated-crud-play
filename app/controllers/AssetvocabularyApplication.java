
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assetvocabulary.AssetvocabularyFormData;

import models.assetvocabulary.Assetvocabulary;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assetvocabulary.assetvocabulary;
import views.html.assetvocabulary.assetvocabularys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssetvocabularyApplication extends Controller {

	public static Result addAssetvocabulary() {
		Form<AssetvocabularyFormData> form = Form.form(
			AssetvocabularyFormData.class).fill(new Assetvocabulary().toFormData());

		return ok(assetvocabulary.render(form));
	}

	public static Result get(Long id) {
		Assetvocabulary dbAssetvocabulary = Assetvocabulary.find.byId(id);

		Form<AssetvocabularyFormData> form = Form.form(
			AssetvocabularyFormData.class).fill(dbAssetvocabulary.toFormData());

		return ok(assetvocabulary.render(form));
	}

	public static Result all() {
		List<Assetvocabulary> assetvocabularyList = Assetvocabulary.find.all();

		return ok(assetvocabularys.render(assetvocabularyList));
	}

	public static Result submit() {
		Form<AssetvocabularyFormData> formData = Form.form(
			AssetvocabularyFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssetvocabularyFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssetvocabulary();
		}
		else {
			AssetvocabularyFormData assetvocabularyFormData = formData.get();

			String id = assetvocabularyFormData.vocabularyId;

			long assetvocabularyId = 0;

			if (id != null) {
				assetvocabularyId = Long.valueOf(id);
			}

			Assetvocabulary assetvocabulary;

			if (assetvocabularyId > 0) {
				assetvocabulary = Assetvocabulary.find.byId(assetvocabularyId);

				assetvocabulary.setUuid(assetvocabularyFormData.uuid);
				assetvocabulary.setVocabularyId(Long.valueOf(assetvocabularyFormData.vocabularyId));
				assetvocabulary.setGroupId(Long.valueOf(assetvocabularyFormData.groupId));
				assetvocabulary.setCompanyId(Long.valueOf(assetvocabularyFormData.companyId));
				assetvocabulary.setUserId(Long.valueOf(assetvocabularyFormData.userId));
				assetvocabulary.setUserName(assetvocabularyFormData.userName);
				assetvocabulary.setCreateDate(new Date(assetvocabularyFormData.createDate));
				assetvocabulary.setModifiedDate(new Date(assetvocabularyFormData.modifiedDate));
				assetvocabulary.setName(assetvocabularyFormData.name);
				assetvocabulary.setTitle(assetvocabularyFormData.title);
				assetvocabulary.setDescription(assetvocabularyFormData.description);
				assetvocabulary.setSettings(assetvocabularyFormData.settings);
			}
			else {
				assetvocabulary = new Assetvocabulary(assetvocabularyFormData);
			}

			Ebean.save(assetvocabulary);

			flash("success", "Assetvocabulary instance created/edited: " + assetvocabulary);

			return all();
		}
	}

	public static Result delete(Form<AssetvocabularyFormData> formData) {
		AssetvocabularyFormData assetvocabularyFormData = formData.get();

		String id = assetvocabularyFormData.vocabularyId;

		long assetvocabularyId = 0;

		if (id != null) {
			assetvocabularyId = Long.valueOf(id);
		}

		Assetvocabulary assetvocabulary;

		if (assetvocabularyId > 0) {
			assetvocabulary = Assetvocabulary.find.byId(assetvocabularyId);

			Ebean.delete(assetvocabulary);
		}
		else {
			flash("error", "Cannot delete Assetvocabulary");
		}

		return all();
	}

}
