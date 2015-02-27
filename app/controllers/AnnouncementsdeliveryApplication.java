
package controllers;

import com.avaje.ebean.Ebean;

import controllers.announcementsdelivery.AnnouncementsdeliveryFormData;

import models.announcementsdelivery.Announcementsdelivery;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.announcementsdelivery.announcementsdelivery;
import views.html.announcementsdelivery.announcementsdeliverys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AnnouncementsdeliveryApplication extends Controller {

	public static Result addAnnouncementsdelivery() {
		Form<AnnouncementsdeliveryFormData> form = Form.form(
			AnnouncementsdeliveryFormData.class).fill(new Announcementsdelivery().toFormData());

		return ok(announcementsdelivery.render(form));
	}

	public static Result get(Long id) {
		Announcementsdelivery dbAnnouncementsdelivery = Announcementsdelivery.find.byId(id);

		Form<AnnouncementsdeliveryFormData> form = Form.form(
			AnnouncementsdeliveryFormData.class).fill(dbAnnouncementsdelivery.toFormData());

		return ok(announcementsdelivery.render(form));
	}

	public static Result all() {
		List<Announcementsdelivery> announcementsdeliveryList = Announcementsdelivery.find.all();

		return ok(announcementsdeliverys.render(announcementsdeliveryList));
	}

	public static Result submit() {
		Form<AnnouncementsdeliveryFormData> formData = Form.form(
			AnnouncementsdeliveryFormData.class).bindFromRequest();

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

	public static Result edit(Form<AnnouncementsdeliveryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAnnouncementsdelivery();
		}
		else {
			AnnouncementsdeliveryFormData announcementsdeliveryFormData = formData.get();

			String id = announcementsdeliveryFormData.deliveryId;

			long announcementsdeliveryId = 0;

			if (id != null) {
				announcementsdeliveryId = Long.valueOf(id);
			}

			Announcementsdelivery announcementsdelivery;

			if (announcementsdeliveryId > 0) {
				announcementsdelivery = Announcementsdelivery.find.byId(announcementsdeliveryId);

				announcementsdelivery.setDeliveryId(Long.valueOf(announcementsdeliveryFormData.deliveryId));
				announcementsdelivery.setCompanyId(Long.valueOf(announcementsdeliveryFormData.companyId));
				announcementsdelivery.setUserId(Long.valueOf(announcementsdeliveryFormData.userId));
				announcementsdelivery.setCustomtype(announcementsdeliveryFormData.customtype);
				announcementsdelivery.setEmail(Boolean.valueOf(announcementsdeliveryFormData.email));
				announcementsdelivery.setSms(Boolean.valueOf(announcementsdeliveryFormData.sms));
				announcementsdelivery.setWebsite(Boolean.valueOf(announcementsdeliveryFormData.website));
			}
			else {
				announcementsdelivery = new Announcementsdelivery(announcementsdeliveryFormData);
			}

			Ebean.save(announcementsdelivery);

			flash("success", "Announcementsdelivery instance created/edited: " + announcementsdelivery);

			return all();
		}
	}

	public static Result delete(Form<AnnouncementsdeliveryFormData> formData) {
		AnnouncementsdeliveryFormData announcementsdeliveryFormData = formData.get();

		String id = announcementsdeliveryFormData.deliveryId;

		long announcementsdeliveryId = 0;

		if (id != null) {
			announcementsdeliveryId = Long.valueOf(id);
		}

		Announcementsdelivery announcementsdelivery;

		if (announcementsdeliveryId > 0) {
			announcementsdelivery = Announcementsdelivery.find.byId(announcementsdeliveryId);

			Ebean.delete(announcementsdelivery);
		}
		else {
			flash("error", "Cannot delete Announcementsdelivery");
		}

		return all();
	}

}
