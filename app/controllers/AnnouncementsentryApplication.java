
package controllers;

import com.avaje.ebean.Ebean;

import controllers.announcementsentry.AnnouncementsentryFormData;

import models.announcementsentry.Announcementsentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.announcementsentry.announcementsentry;
import views.html.announcementsentry.announcementsentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AnnouncementsentryApplication extends Controller {

	public static Result addAnnouncementsentry() {
		Form<AnnouncementsentryFormData> form = Form.form(
			AnnouncementsentryFormData.class).fill(new Announcementsentry().toFormData());

		return ok(announcementsentry.render(form));
	}

	public static Result get(Long id) {
		Announcementsentry dbAnnouncementsentry = Announcementsentry.find.byId(id);

		Form<AnnouncementsentryFormData> form = Form.form(
			AnnouncementsentryFormData.class).fill(dbAnnouncementsentry.toFormData());

		return ok(announcementsentry.render(form));
	}

	public static Result all() {
		List<Announcementsentry> announcementsentryList = Announcementsentry.find.all();

		return ok(announcementsentrys.render(announcementsentryList));
	}

	public static Result submit() {
		Form<AnnouncementsentryFormData> formData = Form.form(
			AnnouncementsentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<AnnouncementsentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAnnouncementsentry();
		}
		else {
			AnnouncementsentryFormData announcementsentryFormData = formData.get();

			String id = announcementsentryFormData.entryId;

			long announcementsentryId = 0;

			if (id != null) {
				announcementsentryId = Long.valueOf(id);
			}

			Announcementsentry announcementsentry;

			if (announcementsentryId > 0) {
				announcementsentry = Announcementsentry.find.byId(announcementsentryId);

				announcementsentry.setUuid(announcementsentryFormData.uuid);
				announcementsentry.setEntryId(Long.valueOf(announcementsentryFormData.entryId));
				announcementsentry.setCompanyId(Long.valueOf(announcementsentryFormData.companyId));
				announcementsentry.setUserId(Long.valueOf(announcementsentryFormData.userId));
				announcementsentry.setUserName(announcementsentryFormData.userName);
				announcementsentry.setCreateDate(new Date(announcementsentryFormData.createDate));
				announcementsentry.setModifiedDate(new Date(announcementsentryFormData.modifiedDate));
				announcementsentry.setClassNameId(Long.valueOf(announcementsentryFormData.classNameId));
				announcementsentry.setClassPK(Long.valueOf(announcementsentryFormData.classPK));
				announcementsentry.setTitle(announcementsentryFormData.title);
				announcementsentry.setContent(announcementsentryFormData.content);
				announcementsentry.setUrl(announcementsentryFormData.url);
				announcementsentry.setCustomtype(announcementsentryFormData.customtype);
				announcementsentry.setDisplayDate(new Date(announcementsentryFormData.displayDate));
				announcementsentry.setExpirationDate(new Date(announcementsentryFormData.expirationDate));
				announcementsentry.setPriority(Integer.valueOf(announcementsentryFormData.priority));
				announcementsentry.setAlert(Boolean.valueOf(announcementsentryFormData.alert));
			}
			else {
				announcementsentry = new Announcementsentry(announcementsentryFormData);
			}

			Ebean.save(announcementsentry);

			flash("success", "Announcementsentry instance created/edited: " + announcementsentry);

			return all();
		}
	}

	public static Result delete(Form<AnnouncementsentryFormData> formData) {
		AnnouncementsentryFormData announcementsentryFormData = formData.get();

		String id = announcementsentryFormData.entryId;

		long announcementsentryId = 0;

		if (id != null) {
			announcementsentryId = Long.valueOf(id);
		}

		Announcementsentry announcementsentry;

		if (announcementsentryId > 0) {
			announcementsentry = Announcementsentry.find.byId(announcementsentryId);

			Ebean.delete(announcementsentry);
		}
		else {
			flash("error", "Cannot delete Announcementsentry");
		}

		return all();
	}

}
