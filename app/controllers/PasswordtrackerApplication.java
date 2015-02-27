
package controllers;

import com.avaje.ebean.Ebean;

import controllers.passwordtracker.PasswordtrackerFormData;

import models.passwordtracker.Passwordtracker;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.passwordtracker.passwordtracker;
import views.html.passwordtracker.passwordtrackers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PasswordtrackerApplication extends Controller {

	public static Result addPasswordtracker() {
		Form<PasswordtrackerFormData> form = Form.form(
			PasswordtrackerFormData.class).fill(new Passwordtracker().toFormData());

		return ok(passwordtracker.render(form));
	}

	public static Result get(Long id) {
		Passwordtracker dbPasswordtracker = Passwordtracker.find.byId(id);

		Form<PasswordtrackerFormData> form = Form.form(
			PasswordtrackerFormData.class).fill(dbPasswordtracker.toFormData());

		return ok(passwordtracker.render(form));
	}

	public static Result all() {
		List<Passwordtracker> passwordtrackerList = Passwordtracker.find.all();

		return ok(passwordtrackers.render(passwordtrackerList));
	}

	public static Result submit() {
		Form<PasswordtrackerFormData> formData = Form.form(
			PasswordtrackerFormData.class).bindFromRequest();

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

	public static Result edit(Form<PasswordtrackerFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPasswordtracker();
		}
		else {
			PasswordtrackerFormData passwordtrackerFormData = formData.get();

			String id = passwordtrackerFormData.passwordTrackerId;

			long passwordtrackerId = 0;

			if (id != null) {
				passwordtrackerId = Long.valueOf(id);
			}

			Passwordtracker passwordtracker;

			if (passwordtrackerId > 0) {
				passwordtracker = Passwordtracker.find.byId(passwordtrackerId);

				passwordtracker.setMvccVersion(Long.valueOf(passwordtrackerFormData.mvccVersion));
				passwordtracker.setPasswordTrackerId(Long.valueOf(passwordtrackerFormData.passwordTrackerId));
				passwordtracker.setUserId(Long.valueOf(passwordtrackerFormData.userId));
				passwordtracker.setCreateDate(new Date(passwordtrackerFormData.createDate));
				passwordtracker.setPassword(passwordtrackerFormData.password);
			}
			else {
				passwordtracker = new Passwordtracker(passwordtrackerFormData);
			}

			Ebean.save(passwordtracker);

			flash("success", "Passwordtracker instance created/edited: " + passwordtracker);

			return all();
		}
	}

	public static Result delete(Form<PasswordtrackerFormData> formData) {
		PasswordtrackerFormData passwordtrackerFormData = formData.get();

		String id = passwordtrackerFormData.passwordTrackerId;

		long passwordtrackerId = 0;

		if (id != null) {
			passwordtrackerId = Long.valueOf(id);
		}

		Passwordtracker passwordtracker;

		if (passwordtrackerId > 0) {
			passwordtracker = Passwordtracker.find.byId(passwordtrackerId);

			Ebean.delete(passwordtracker);
		}
		else {
			flash("error", "Cannot delete Passwordtracker");
		}

		return all();
	}

}
