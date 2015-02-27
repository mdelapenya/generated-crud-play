
package controllers;

import com.avaje.ebean.Ebean;

import controllers.usertracker.UsertrackerFormData;

import models.usertracker.Usertracker;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.usertracker.usertracker;
import views.html.usertracker.usertrackers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UsertrackerApplication extends Controller {

	public static Result addUsertracker() {
		Form<UsertrackerFormData> form = Form.form(
			UsertrackerFormData.class).fill(new Usertracker().toFormData());

		return ok(usertracker.render(form));
	}

	public static Result get(Long id) {
		Usertracker dbUsertracker = Usertracker.find.byId(id);

		Form<UsertrackerFormData> form = Form.form(
			UsertrackerFormData.class).fill(dbUsertracker.toFormData());

		return ok(usertracker.render(form));
	}

	public static Result all() {
		List<Usertracker> usertrackerList = Usertracker.find.all();

		return ok(usertrackers.render(usertrackerList));
	}

	public static Result submit() {
		Form<UsertrackerFormData> formData = Form.form(
			UsertrackerFormData.class).bindFromRequest();

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

	public static Result edit(Form<UsertrackerFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUsertracker();
		}
		else {
			UsertrackerFormData usertrackerFormData = formData.get();

			String id = usertrackerFormData.userTrackerId;

			long usertrackerId = 0;

			if (id != null) {
				usertrackerId = Long.valueOf(id);
			}

			Usertracker usertracker;

			if (usertrackerId > 0) {
				usertracker = Usertracker.find.byId(usertrackerId);

				usertracker.setMvccVersion(Long.valueOf(usertrackerFormData.mvccVersion));
				usertracker.setUserTrackerId(Long.valueOf(usertrackerFormData.userTrackerId));
				usertracker.setCompanyId(Long.valueOf(usertrackerFormData.companyId));
				usertracker.setUserId(Long.valueOf(usertrackerFormData.userId));
				usertracker.setModifiedDate(new Date(usertrackerFormData.modifiedDate));
				usertracker.setSessionId(usertrackerFormData.sessionId);
				usertracker.setRemoteAddr(usertrackerFormData.remoteAddr);
				usertracker.setRemoteHost(usertrackerFormData.remoteHost);
				usertracker.setUserAgent(usertrackerFormData.userAgent);
			}
			else {
				usertracker = new Usertracker(usertrackerFormData);
			}

			Ebean.save(usertracker);

			flash("success", "Usertracker instance created/edited: " + usertracker);

			return all();
		}
	}

	public static Result delete(Form<UsertrackerFormData> formData) {
		UsertrackerFormData usertrackerFormData = formData.get();

		String id = usertrackerFormData.userTrackerId;

		long usertrackerId = 0;

		if (id != null) {
			usertrackerId = Long.valueOf(id);
		}

		Usertracker usertracker;

		if (usertrackerId > 0) {
			usertracker = Usertracker.find.byId(usertrackerId);

			Ebean.delete(usertracker);
		}
		else {
			flash("error", "Cannot delete Usertracker");
		}

		return all();
	}

}
