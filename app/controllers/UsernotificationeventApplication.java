
package controllers;

import com.avaje.ebean.Ebean;

import controllers.usernotificationevent.UsernotificationeventFormData;

import models.usernotificationevent.Usernotificationevent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.usernotificationevent.usernotificationevent;
import views.html.usernotificationevent.usernotificationevents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UsernotificationeventApplication extends Controller {

	public static Result addUsernotificationevent() {
		Form<UsernotificationeventFormData> form = Form.form(
			UsernotificationeventFormData.class).fill(new Usernotificationevent().toFormData());

		return ok(usernotificationevent.render(form));
	}

	public static Result get(Long id) {
		Usernotificationevent dbUsernotificationevent = Usernotificationevent.find.byId(id);

		Form<UsernotificationeventFormData> form = Form.form(
			UsernotificationeventFormData.class).fill(dbUsernotificationevent.toFormData());

		return ok(usernotificationevent.render(form));
	}

	public static Result all() {
		List<Usernotificationevent> usernotificationeventList = Usernotificationevent.find.all();

		return ok(usernotificationevents.render(usernotificationeventList));
	}

	public static Result submit() {
		Form<UsernotificationeventFormData> formData = Form.form(
			UsernotificationeventFormData.class).bindFromRequest();

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

	public static Result edit(Form<UsernotificationeventFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUsernotificationevent();
		}
		else {
			UsernotificationeventFormData usernotificationeventFormData = formData.get();

			String id = usernotificationeventFormData.userNotificationEventId;

			long usernotificationeventId = 0;

			if (id != null) {
				usernotificationeventId = Long.valueOf(id);
			}

			Usernotificationevent usernotificationevent;

			if (usernotificationeventId > 0) {
				usernotificationevent = Usernotificationevent.find.byId(usernotificationeventId);

				usernotificationevent.setMvccVersion(Long.valueOf(usernotificationeventFormData.mvccVersion));
				usernotificationevent.setUuid(usernotificationeventFormData.uuid);
				usernotificationevent.setUserNotificationEventId(Long.valueOf(usernotificationeventFormData.userNotificationEventId));
				usernotificationevent.setCompanyId(Long.valueOf(usernotificationeventFormData.companyId));
				usernotificationevent.setUserId(Long.valueOf(usernotificationeventFormData.userId));
				usernotificationevent.setCustomtype(usernotificationeventFormData.customtype);
				usernotificationevent.setTimestamp(Long.valueOf(usernotificationeventFormData.timestamp));
				usernotificationevent.setDeliveryType(Integer.valueOf(usernotificationeventFormData.deliveryType));
				usernotificationevent.setDeliverBy(Long.valueOf(usernotificationeventFormData.deliverBy));
				usernotificationevent.setDelivered(Boolean.valueOf(usernotificationeventFormData.delivered));
				usernotificationevent.setPayload(usernotificationeventFormData.payload);
				usernotificationevent.setActionRequired(Boolean.valueOf(usernotificationeventFormData.actionRequired));
				usernotificationevent.setArchived(Boolean.valueOf(usernotificationeventFormData.archived));
			}
			else {
				usernotificationevent = new Usernotificationevent(usernotificationeventFormData);
			}

			Ebean.save(usernotificationevent);

			flash("success", "Usernotificationevent instance created/edited: " + usernotificationevent);

			return all();
		}
	}

	public static Result delete(Form<UsernotificationeventFormData> formData) {
		UsernotificationeventFormData usernotificationeventFormData = formData.get();

		String id = usernotificationeventFormData.userNotificationEventId;

		long usernotificationeventId = 0;

		if (id != null) {
			usernotificationeventId = Long.valueOf(id);
		}

		Usernotificationevent usernotificationevent;

		if (usernotificationeventId > 0) {
			usernotificationevent = Usernotificationevent.find.byId(usernotificationeventId);

			Ebean.delete(usernotificationevent);
		}
		else {
			flash("error", "Cannot delete Usernotificationevent");
		}

		return all();
	}

}
