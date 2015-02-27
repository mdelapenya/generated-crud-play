
package controllers;

import com.avaje.ebean.Ebean;

import controllers.usernotificationdelivery.UsernotificationdeliveryFormData;

import models.usernotificationdelivery.Usernotificationdelivery;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.usernotificationdelivery.usernotificationdelivery;
import views.html.usernotificationdelivery.usernotificationdeliverys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UsernotificationdeliveryApplication extends Controller {

	public static Result addUsernotificationdelivery() {
		Form<UsernotificationdeliveryFormData> form = Form.form(
			UsernotificationdeliveryFormData.class).fill(new Usernotificationdelivery().toFormData());

		return ok(usernotificationdelivery.render(form));
	}

	public static Result get(Long id) {
		Usernotificationdelivery dbUsernotificationdelivery = Usernotificationdelivery.find.byId(id);

		Form<UsernotificationdeliveryFormData> form = Form.form(
			UsernotificationdeliveryFormData.class).fill(dbUsernotificationdelivery.toFormData());

		return ok(usernotificationdelivery.render(form));
	}

	public static Result all() {
		List<Usernotificationdelivery> usernotificationdeliveryList = Usernotificationdelivery.find.all();

		return ok(usernotificationdeliverys.render(usernotificationdeliveryList));
	}

	public static Result submit() {
		Form<UsernotificationdeliveryFormData> formData = Form.form(
			UsernotificationdeliveryFormData.class).bindFromRequest();

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

	public static Result edit(Form<UsernotificationdeliveryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUsernotificationdelivery();
		}
		else {
			UsernotificationdeliveryFormData usernotificationdeliveryFormData = formData.get();

			String id = usernotificationdeliveryFormData.userNotificationDeliveryId;

			long usernotificationdeliveryId = 0;

			if (id != null) {
				usernotificationdeliveryId = Long.valueOf(id);
			}

			Usernotificationdelivery usernotificationdelivery;

			if (usernotificationdeliveryId > 0) {
				usernotificationdelivery = Usernotificationdelivery.find.byId(usernotificationdeliveryId);

				usernotificationdelivery.setMvccVersion(Long.valueOf(usernotificationdeliveryFormData.mvccVersion));
				usernotificationdelivery.setUserNotificationDeliveryId(Long.valueOf(usernotificationdeliveryFormData.userNotificationDeliveryId));
				usernotificationdelivery.setCompanyId(Long.valueOf(usernotificationdeliveryFormData.companyId));
				usernotificationdelivery.setUserId(Long.valueOf(usernotificationdeliveryFormData.userId));
				usernotificationdelivery.setPortletId(usernotificationdeliveryFormData.portletId);
				usernotificationdelivery.setClassNameId(Long.valueOf(usernotificationdeliveryFormData.classNameId));
				usernotificationdelivery.setNotificationType(Integer.valueOf(usernotificationdeliveryFormData.notificationType));
				usernotificationdelivery.setDeliveryType(Integer.valueOf(usernotificationdeliveryFormData.deliveryType));
				usernotificationdelivery.setDeliver(Boolean.valueOf(usernotificationdeliveryFormData.deliver));
			}
			else {
				usernotificationdelivery = new Usernotificationdelivery(usernotificationdeliveryFormData);
			}

			Ebean.save(usernotificationdelivery);

			flash("success", "Usernotificationdelivery instance created/edited: " + usernotificationdelivery);

			return all();
		}
	}

	public static Result delete(Form<UsernotificationdeliveryFormData> formData) {
		UsernotificationdeliveryFormData usernotificationdeliveryFormData = formData.get();

		String id = usernotificationdeliveryFormData.userNotificationDeliveryId;

		long usernotificationdeliveryId = 0;

		if (id != null) {
			usernotificationdeliveryId = Long.valueOf(id);
		}

		Usernotificationdelivery usernotificationdelivery;

		if (usernotificationdeliveryId > 0) {
			usernotificationdelivery = Usernotificationdelivery.find.byId(usernotificationdeliveryId);

			Ebean.delete(usernotificationdelivery);
		}
		else {
			flash("error", "Cannot delete Usernotificationdelivery");
		}

		return all();
	}

}
