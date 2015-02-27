
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlsyncevent.DlsynceventFormData;

import models.dlsyncevent.Dlsyncevent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlsyncevent.dlsyncevent;
import views.html.dlsyncevent.dlsyncevents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlsynceventApplication extends Controller {

	public static Result addDlsyncevent() {
		Form<DlsynceventFormData> form = Form.form(
			DlsynceventFormData.class).fill(new Dlsyncevent().toFormData());

		return ok(dlsyncevent.render(form));
	}

	public static Result get(Long id) {
		Dlsyncevent dbDlsyncevent = Dlsyncevent.find.byId(id);

		Form<DlsynceventFormData> form = Form.form(
			DlsynceventFormData.class).fill(dbDlsyncevent.toFormData());

		return ok(dlsyncevent.render(form));
	}

	public static Result all() {
		List<Dlsyncevent> dlsynceventList = Dlsyncevent.find.all();

		return ok(dlsyncevents.render(dlsynceventList));
	}

	public static Result submit() {
		Form<DlsynceventFormData> formData = Form.form(
			DlsynceventFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlsynceventFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlsyncevent();
		}
		else {
			DlsynceventFormData dlsynceventFormData = formData.get();

			String id = dlsynceventFormData.syncEventId;

			long dlsynceventId = 0;

			if (id != null) {
				dlsynceventId = Long.valueOf(id);
			}

			Dlsyncevent dlsyncevent;

			if (dlsynceventId > 0) {
				dlsyncevent = Dlsyncevent.find.byId(dlsynceventId);

				dlsyncevent.setSyncEventId(Long.valueOf(dlsynceventFormData.syncEventId));
				dlsyncevent.setModifiedTime(Long.valueOf(dlsynceventFormData.modifiedTime));
				dlsyncevent.setEvent(dlsynceventFormData.event);
				dlsyncevent.setCustomtype(dlsynceventFormData.customtype);
				dlsyncevent.setTypePK(Long.valueOf(dlsynceventFormData.typePK));
			}
			else {
				dlsyncevent = new Dlsyncevent(dlsynceventFormData);
			}

			Ebean.save(dlsyncevent);

			flash("success", "Dlsyncevent instance created/edited: " + dlsyncevent);

			return all();
		}
	}

	public static Result delete(Form<DlsynceventFormData> formData) {
		DlsynceventFormData dlsynceventFormData = formData.get();

		String id = dlsynceventFormData.syncEventId;

		long dlsynceventId = 0;

		if (id != null) {
			dlsynceventId = Long.valueOf(id);
		}

		Dlsyncevent dlsyncevent;

		if (dlsynceventId > 0) {
			dlsyncevent = Dlsyncevent.find.byId(dlsynceventId);

			Ebean.delete(dlsyncevent);
		}
		else {
			flash("error", "Cannot delete Dlsyncevent");
		}

		return all();
	}

}
