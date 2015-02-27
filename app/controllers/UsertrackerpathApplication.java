
package controllers;

import com.avaje.ebean.Ebean;

import controllers.usertrackerpath.UsertrackerpathFormData;

import models.usertrackerpath.Usertrackerpath;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.usertrackerpath.usertrackerpath;
import views.html.usertrackerpath.usertrackerpaths;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UsertrackerpathApplication extends Controller {

	public static Result addUsertrackerpath() {
		Form<UsertrackerpathFormData> form = Form.form(
			UsertrackerpathFormData.class).fill(new Usertrackerpath().toFormData());

		return ok(usertrackerpath.render(form));
	}

	public static Result get(Long id) {
		Usertrackerpath dbUsertrackerpath = Usertrackerpath.find.byId(id);

		Form<UsertrackerpathFormData> form = Form.form(
			UsertrackerpathFormData.class).fill(dbUsertrackerpath.toFormData());

		return ok(usertrackerpath.render(form));
	}

	public static Result all() {
		List<Usertrackerpath> usertrackerpathList = Usertrackerpath.find.all();

		return ok(usertrackerpaths.render(usertrackerpathList));
	}

	public static Result submit() {
		Form<UsertrackerpathFormData> formData = Form.form(
			UsertrackerpathFormData.class).bindFromRequest();

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

	public static Result edit(Form<UsertrackerpathFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUsertrackerpath();
		}
		else {
			UsertrackerpathFormData usertrackerpathFormData = formData.get();

			String id = usertrackerpathFormData.userTrackerPathId;

			long usertrackerpathId = 0;

			if (id != null) {
				usertrackerpathId = Long.valueOf(id);
			}

			Usertrackerpath usertrackerpath;

			if (usertrackerpathId > 0) {
				usertrackerpath = Usertrackerpath.find.byId(usertrackerpathId);

				usertrackerpath.setMvccVersion(Long.valueOf(usertrackerpathFormData.mvccVersion));
				usertrackerpath.setUserTrackerPathId(Long.valueOf(usertrackerpathFormData.userTrackerPathId));
				usertrackerpath.setUserTrackerId(Long.valueOf(usertrackerpathFormData.userTrackerId));
				usertrackerpath.setPath(usertrackerpathFormData.path);
				usertrackerpath.setPathDate(new Date(usertrackerpathFormData.pathDate));
			}
			else {
				usertrackerpath = new Usertrackerpath(usertrackerpathFormData);
			}

			Ebean.save(usertrackerpath);

			flash("success", "Usertrackerpath instance created/edited: " + usertrackerpath);

			return all();
		}
	}

	public static Result delete(Form<UsertrackerpathFormData> formData) {
		UsertrackerpathFormData usertrackerpathFormData = formData.get();

		String id = usertrackerpathFormData.userTrackerPathId;

		long usertrackerpathId = 0;

		if (id != null) {
			usertrackerpathId = Long.valueOf(id);
		}

		Usertrackerpath usertrackerpath;

		if (usertrackerpathId > 0) {
			usertrackerpath = Usertrackerpath.find.byId(usertrackerpathId);

			Ebean.delete(usertrackerpath);
		}
		else {
			flash("error", "Cannot delete Usertrackerpath");
		}

		return all();
	}

}
