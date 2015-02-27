
package controllers;

import com.avaje.ebean.Ebean;

import controllers.passwordpolicyrel.PasswordpolicyrelFormData;

import models.passwordpolicyrel.Passwordpolicyrel;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.passwordpolicyrel.passwordpolicyrel;
import views.html.passwordpolicyrel.passwordpolicyrels;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PasswordpolicyrelApplication extends Controller {

	public static Result addPasswordpolicyrel() {
		Form<PasswordpolicyrelFormData> form = Form.form(
			PasswordpolicyrelFormData.class).fill(new Passwordpolicyrel().toFormData());

		return ok(passwordpolicyrel.render(form));
	}

	public static Result get(Long id) {
		Passwordpolicyrel dbPasswordpolicyrel = Passwordpolicyrel.find.byId(id);

		Form<PasswordpolicyrelFormData> form = Form.form(
			PasswordpolicyrelFormData.class).fill(dbPasswordpolicyrel.toFormData());

		return ok(passwordpolicyrel.render(form));
	}

	public static Result all() {
		List<Passwordpolicyrel> passwordpolicyrelList = Passwordpolicyrel.find.all();

		return ok(passwordpolicyrels.render(passwordpolicyrelList));
	}

	public static Result submit() {
		Form<PasswordpolicyrelFormData> formData = Form.form(
			PasswordpolicyrelFormData.class).bindFromRequest();

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

	public static Result edit(Form<PasswordpolicyrelFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPasswordpolicyrel();
		}
		else {
			PasswordpolicyrelFormData passwordpolicyrelFormData = formData.get();

			String id = passwordpolicyrelFormData.passwordPolicyRelId;

			long passwordpolicyrelId = 0;

			if (id != null) {
				passwordpolicyrelId = Long.valueOf(id);
			}

			Passwordpolicyrel passwordpolicyrel;

			if (passwordpolicyrelId > 0) {
				passwordpolicyrel = Passwordpolicyrel.find.byId(passwordpolicyrelId);

				passwordpolicyrel.setMvccVersion(Long.valueOf(passwordpolicyrelFormData.mvccVersion));
				passwordpolicyrel.setPasswordPolicyRelId(Long.valueOf(passwordpolicyrelFormData.passwordPolicyRelId));
				passwordpolicyrel.setPasswordPolicyId(Long.valueOf(passwordpolicyrelFormData.passwordPolicyId));
				passwordpolicyrel.setClassNameId(Long.valueOf(passwordpolicyrelFormData.classNameId));
				passwordpolicyrel.setClassPK(Long.valueOf(passwordpolicyrelFormData.classPK));
			}
			else {
				passwordpolicyrel = new Passwordpolicyrel(passwordpolicyrelFormData);
			}

			Ebean.save(passwordpolicyrel);

			flash("success", "Passwordpolicyrel instance created/edited: " + passwordpolicyrel);

			return all();
		}
	}

	public static Result delete(Form<PasswordpolicyrelFormData> formData) {
		PasswordpolicyrelFormData passwordpolicyrelFormData = formData.get();

		String id = passwordpolicyrelFormData.passwordPolicyRelId;

		long passwordpolicyrelId = 0;

		if (id != null) {
			passwordpolicyrelId = Long.valueOf(id);
		}

		Passwordpolicyrel passwordpolicyrel;

		if (passwordpolicyrelId > 0) {
			passwordpolicyrel = Passwordpolicyrel.find.byId(passwordpolicyrelId);

			Ebean.delete(passwordpolicyrel);
		}
		else {
			flash("error", "Cannot delete Passwordpolicyrel");
		}

		return all();
	}

}
