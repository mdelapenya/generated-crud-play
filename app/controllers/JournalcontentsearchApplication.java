
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalcontentsearch.JournalcontentsearchFormData;

import models.journalcontentsearch.Journalcontentsearch;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalcontentsearch.journalcontentsearch;
import views.html.journalcontentsearch.journalcontentsearchs;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalcontentsearchApplication extends Controller {

	public static Result addJournalcontentsearch() {
		Form<JournalcontentsearchFormData> form = Form.form(
			JournalcontentsearchFormData.class).fill(new Journalcontentsearch().toFormData());

		return ok(journalcontentsearch.render(form));
	}

	public static Result get(Long id) {
		Journalcontentsearch dbJournalcontentsearch = Journalcontentsearch.find.byId(id);

		Form<JournalcontentsearchFormData> form = Form.form(
			JournalcontentsearchFormData.class).fill(dbJournalcontentsearch.toFormData());

		return ok(journalcontentsearch.render(form));
	}

	public static Result all() {
		List<Journalcontentsearch> journalcontentsearchList = Journalcontentsearch.find.all();

		return ok(journalcontentsearchs.render(journalcontentsearchList));
	}

	public static Result submit() {
		Form<JournalcontentsearchFormData> formData = Form.form(
			JournalcontentsearchFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalcontentsearchFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalcontentsearch();
		}
		else {
			JournalcontentsearchFormData journalcontentsearchFormData = formData.get();

			String id = journalcontentsearchFormData.contentSearchId;

			long journalcontentsearchId = 0;

			if (id != null) {
				journalcontentsearchId = Long.valueOf(id);
			}

			Journalcontentsearch journalcontentsearch;

			if (journalcontentsearchId > 0) {
				journalcontentsearch = Journalcontentsearch.find.byId(journalcontentsearchId);

				journalcontentsearch.setContentSearchId(Long.valueOf(journalcontentsearchFormData.contentSearchId));
				journalcontentsearch.setGroupId(Long.valueOf(journalcontentsearchFormData.groupId));
				journalcontentsearch.setCompanyId(Long.valueOf(journalcontentsearchFormData.companyId));
				journalcontentsearch.setPrivateLayout(Boolean.valueOf(journalcontentsearchFormData.privateLayout));
				journalcontentsearch.setLayoutId(Long.valueOf(journalcontentsearchFormData.layoutId));
				journalcontentsearch.setPortletId(journalcontentsearchFormData.portletId);
				journalcontentsearch.setArticleId(journalcontentsearchFormData.articleId);
			}
			else {
				journalcontentsearch = new Journalcontentsearch(journalcontentsearchFormData);
			}

			Ebean.save(journalcontentsearch);

			flash("success", "Journalcontentsearch instance created/edited: " + journalcontentsearch);

			return all();
		}
	}

	public static Result delete(Form<JournalcontentsearchFormData> formData) {
		JournalcontentsearchFormData journalcontentsearchFormData = formData.get();

		String id = journalcontentsearchFormData.contentSearchId;

		long journalcontentsearchId = 0;

		if (id != null) {
			journalcontentsearchId = Long.valueOf(id);
		}

		Journalcontentsearch journalcontentsearch;

		if (journalcontentsearchId > 0) {
			journalcontentsearch = Journalcontentsearch.find.byId(journalcontentsearchId);

			Ebean.delete(journalcontentsearch);
		}
		else {
			flash("error", "Cannot delete Journalcontentsearch");
		}

		return all();
	}

}
