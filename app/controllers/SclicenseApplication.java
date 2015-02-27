
package controllers;

import com.avaje.ebean.Ebean;

import controllers.sclicense.SclicenseFormData;

import models.sclicense.Sclicense;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.sclicense.sclicense;
import views.html.sclicense.sclicenses;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SclicenseApplication extends Controller {

	public static Result addSclicense() {
		Form<SclicenseFormData> form = Form.form(
			SclicenseFormData.class).fill(new Sclicense().toFormData());

		return ok(sclicense.render(form));
	}

	public static Result get(Long id) {
		Sclicense dbSclicense = Sclicense.find.byId(id);

		Form<SclicenseFormData> form = Form.form(
			SclicenseFormData.class).fill(dbSclicense.toFormData());

		return ok(sclicense.render(form));
	}

	public static Result all() {
		List<Sclicense> sclicenseList = Sclicense.find.all();

		return ok(sclicenses.render(sclicenseList));
	}

	public static Result submit() {
		Form<SclicenseFormData> formData = Form.form(
			SclicenseFormData.class).bindFromRequest();

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

	public static Result edit(Form<SclicenseFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSclicense();
		}
		else {
			SclicenseFormData sclicenseFormData = formData.get();

			String id = sclicenseFormData.licenseId;

			long sclicenseId = 0;

			if (id != null) {
				sclicenseId = Long.valueOf(id);
			}

			Sclicense sclicense;

			if (sclicenseId > 0) {
				sclicense = Sclicense.find.byId(sclicenseId);

				sclicense.setLicenseId(Long.valueOf(sclicenseFormData.licenseId));
				sclicense.setName(sclicenseFormData.name);
				sclicense.setUrl(sclicenseFormData.url);
				sclicense.setOpenSource(Boolean.valueOf(sclicenseFormData.openSource));
				sclicense.setActive(Boolean.valueOf(sclicenseFormData.active));
				sclicense.setRecommended(Boolean.valueOf(sclicenseFormData.recommended));
			}
			else {
				sclicense = new Sclicense(sclicenseFormData);
			}

			Ebean.save(sclicense);

			flash("success", "Sclicense instance created/edited: " + sclicense);

			return all();
		}
	}

	public static Result delete(Form<SclicenseFormData> formData) {
		SclicenseFormData sclicenseFormData = formData.get();

		String id = sclicenseFormData.licenseId;

		long sclicenseId = 0;

		if (id != null) {
			sclicenseId = Long.valueOf(id);
		}

		Sclicense sclicense;

		if (sclicenseId > 0) {
			sclicense = Sclicense.find.byId(sclicenseId);

			Ebean.delete(sclicense);
		}
		else {
			flash("error", "Cannot delete Sclicense");
		}

		return all();
	}

}
