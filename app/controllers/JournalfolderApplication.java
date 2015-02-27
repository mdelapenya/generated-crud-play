
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalfolder.JournalfolderFormData;

import models.journalfolder.Journalfolder;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalfolder.journalfolder;
import views.html.journalfolder.journalfolders;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalfolderApplication extends Controller {

	public static Result addJournalfolder() {
		Form<JournalfolderFormData> form = Form.form(
			JournalfolderFormData.class).fill(new Journalfolder().toFormData());

		return ok(journalfolder.render(form));
	}

	public static Result get(Long id) {
		Journalfolder dbJournalfolder = Journalfolder.find.byId(id);

		Form<JournalfolderFormData> form = Form.form(
			JournalfolderFormData.class).fill(dbJournalfolder.toFormData());

		return ok(journalfolder.render(form));
	}

	public static Result all() {
		List<Journalfolder> journalfolderList = Journalfolder.find.all();

		return ok(journalfolders.render(journalfolderList));
	}

	public static Result submit() {
		Form<JournalfolderFormData> formData = Form.form(
			JournalfolderFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalfolderFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalfolder();
		}
		else {
			JournalfolderFormData journalfolderFormData = formData.get();

			String id = journalfolderFormData.folderId;

			long journalfolderId = 0;

			if (id != null) {
				journalfolderId = Long.valueOf(id);
			}

			Journalfolder journalfolder;

			if (journalfolderId > 0) {
				journalfolder = Journalfolder.find.byId(journalfolderId);

				journalfolder.setUuid(journalfolderFormData.uuid);
				journalfolder.setFolderId(Long.valueOf(journalfolderFormData.folderId));
				journalfolder.setGroupId(Long.valueOf(journalfolderFormData.groupId));
				journalfolder.setCompanyId(Long.valueOf(journalfolderFormData.companyId));
				journalfolder.setUserId(Long.valueOf(journalfolderFormData.userId));
				journalfolder.setUserName(journalfolderFormData.userName);
				journalfolder.setCreateDate(new Date(journalfolderFormData.createDate));
				journalfolder.setModifiedDate(new Date(journalfolderFormData.modifiedDate));
				journalfolder.setParentFolderId(Long.valueOf(journalfolderFormData.parentFolderId));
				journalfolder.setTreePath(journalfolderFormData.treePath);
				journalfolder.setName(journalfolderFormData.name);
				journalfolder.setDescription(journalfolderFormData.description);
				journalfolder.setRestrictionType(Integer.valueOf(journalfolderFormData.restrictionType));
				journalfolder.setStatus(Integer.valueOf(journalfolderFormData.status));
				journalfolder.setStatusByUserId(Long.valueOf(journalfolderFormData.statusByUserId));
				journalfolder.setStatusByUserName(journalfolderFormData.statusByUserName);
				journalfolder.setStatusDate(new Date(journalfolderFormData.statusDate));
			}
			else {
				journalfolder = new Journalfolder(journalfolderFormData);
			}

			Ebean.save(journalfolder);

			flash("success", "Journalfolder instance created/edited: " + journalfolder);

			return all();
		}
	}

	public static Result delete(Form<JournalfolderFormData> formData) {
		JournalfolderFormData journalfolderFormData = formData.get();

		String id = journalfolderFormData.folderId;

		long journalfolderId = 0;

		if (id != null) {
			journalfolderId = Long.valueOf(id);
		}

		Journalfolder journalfolder;

		if (journalfolderId > 0) {
			journalfolder = Journalfolder.find.byId(journalfolderId);

			Ebean.delete(journalfolder);
		}
		else {
			flash("error", "Cannot delete Journalfolder");
		}

		return all();
	}

}
