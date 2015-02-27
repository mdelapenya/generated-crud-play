
package controllers;

import com.avaje.ebean.Ebean;

import controllers.announcementsflag.AnnouncementsflagFormData;

import models.announcementsflag.Announcementsflag;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.announcementsflag.announcementsflag;
import views.html.announcementsflag.announcementsflags;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AnnouncementsflagApplication extends Controller {

	public static Result addAnnouncementsflag() {
		Form<AnnouncementsflagFormData> form = Form.form(
			AnnouncementsflagFormData.class).fill(new Announcementsflag().toFormData());

		return ok(announcementsflag.render(form));
	}

	public static Result get(Long id) {
		Announcementsflag dbAnnouncementsflag = Announcementsflag.find.byId(id);

		Form<AnnouncementsflagFormData> form = Form.form(
			AnnouncementsflagFormData.class).fill(dbAnnouncementsflag.toFormData());

		return ok(announcementsflag.render(form));
	}

	public static Result all() {
		List<Announcementsflag> announcementsflagList = Announcementsflag.find.all();

		return ok(announcementsflags.render(announcementsflagList));
	}

	public static Result submit() {
		Form<AnnouncementsflagFormData> formData = Form.form(
			AnnouncementsflagFormData.class).bindFromRequest();

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

	public static Result edit(Form<AnnouncementsflagFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAnnouncementsflag();
		}
		else {
			AnnouncementsflagFormData announcementsflagFormData = formData.get();

			String id = announcementsflagFormData.flagId;

			long announcementsflagId = 0;

			if (id != null) {
				announcementsflagId = Long.valueOf(id);
			}

			Announcementsflag announcementsflag;

			if (announcementsflagId > 0) {
				announcementsflag = Announcementsflag.find.byId(announcementsflagId);

				announcementsflag.setFlagId(Long.valueOf(announcementsflagFormData.flagId));
				announcementsflag.setUserId(Long.valueOf(announcementsflagFormData.userId));
				announcementsflag.setCreateDate(new Date(announcementsflagFormData.createDate));
				announcementsflag.setEntryId(Long.valueOf(announcementsflagFormData.entryId));
				announcementsflag.setValue(Integer.valueOf(announcementsflagFormData.value));
			}
			else {
				announcementsflag = new Announcementsflag(announcementsflagFormData);
			}

			Ebean.save(announcementsflag);

			flash("success", "Announcementsflag instance created/edited: " + announcementsflag);

			return all();
		}
	}

	public static Result delete(Form<AnnouncementsflagFormData> formData) {
		AnnouncementsflagFormData announcementsflagFormData = formData.get();

		String id = announcementsflagFormData.flagId;

		long announcementsflagId = 0;

		if (id != null) {
			announcementsflagId = Long.valueOf(id);
		}

		Announcementsflag announcementsflag;

		if (announcementsflagId > 0) {
			announcementsflag = Announcementsflag.find.byId(announcementsflagId);

			Ebean.delete(announcementsflag);
		}
		else {
			flash("error", "Cannot delete Announcementsflag");
		}

		return all();
	}

}
