
package controllers;

import com.avaje.ebean.Ebean;

import controllers.trashentry.TrashentryFormData;

import models.trashentry.Trashentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.trashentry.trashentry;
import views.html.trashentry.trashentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class TrashentryApplication extends Controller {

	public static Result addTrashentry() {
		Form<TrashentryFormData> form = Form.form(
			TrashentryFormData.class).fill(new Trashentry().toFormData());

		return ok(trashentry.render(form));
	}

	public static Result get(Long id) {
		Trashentry dbTrashentry = Trashentry.find.byId(id);

		Form<TrashentryFormData> form = Form.form(
			TrashentryFormData.class).fill(dbTrashentry.toFormData());

		return ok(trashentry.render(form));
	}

	public static Result all() {
		List<Trashentry> trashentryList = Trashentry.find.all();

		return ok(trashentrys.render(trashentryList));
	}

	public static Result submit() {
		Form<TrashentryFormData> formData = Form.form(
			TrashentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<TrashentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addTrashentry();
		}
		else {
			TrashentryFormData trashentryFormData = formData.get();

			String id = trashentryFormData.entryId;

			long trashentryId = 0;

			if (id != null) {
				trashentryId = Long.valueOf(id);
			}

			Trashentry trashentry;

			if (trashentryId > 0) {
				trashentry = Trashentry.find.byId(trashentryId);

				trashentry.setEntryId(Long.valueOf(trashentryFormData.entryId));
				trashentry.setGroupId(Long.valueOf(trashentryFormData.groupId));
				trashentry.setCompanyId(Long.valueOf(trashentryFormData.companyId));
				trashentry.setUserId(Long.valueOf(trashentryFormData.userId));
				trashentry.setUserName(trashentryFormData.userName);
				trashentry.setCreateDate(new Date(trashentryFormData.createDate));
				trashentry.setClassNameId(Long.valueOf(trashentryFormData.classNameId));
				trashentry.setClassPK(Long.valueOf(trashentryFormData.classPK));
				trashentry.setSystemEventSetKey(Long.valueOf(trashentryFormData.systemEventSetKey));
				trashentry.setTypeSettings(trashentryFormData.typeSettings);
				trashentry.setStatus(Integer.valueOf(trashentryFormData.status));
			}
			else {
				trashentry = new Trashentry(trashentryFormData);
			}

			Ebean.save(trashentry);

			flash("success", "Trashentry instance created/edited: " + trashentry);

			return all();
		}
	}

	public static Result delete(Form<TrashentryFormData> formData) {
		TrashentryFormData trashentryFormData = formData.get();

		String id = trashentryFormData.entryId;

		long trashentryId = 0;

		if (id != null) {
			trashentryId = Long.valueOf(id);
		}

		Trashentry trashentry;

		if (trashentryId > 0) {
			trashentry = Trashentry.find.byId(trashentryId);

			Ebean.delete(trashentry);
		}
		else {
			flash("error", "Cannot delete Trashentry");
		}

		return all();
	}

}
