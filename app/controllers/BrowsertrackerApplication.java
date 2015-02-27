
package controllers;

import com.avaje.ebean.Ebean;

import controllers.browsertracker.BrowsertrackerFormData;

import models.browsertracker.Browsertracker;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.browsertracker.browsertracker;
import views.html.browsertracker.browsertrackers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class BrowsertrackerApplication extends Controller {

	public static Result addBrowsertracker() {
		Form<BrowsertrackerFormData> form = Form.form(
			BrowsertrackerFormData.class).fill(new Browsertracker().toFormData());

		return ok(browsertracker.render(form));
	}

	public static Result get(Long id) {
		Browsertracker dbBrowsertracker = Browsertracker.find.byId(id);

		Form<BrowsertrackerFormData> form = Form.form(
			BrowsertrackerFormData.class).fill(dbBrowsertracker.toFormData());

		return ok(browsertracker.render(form));
	}

	public static Result all() {
		List<Browsertracker> browsertrackerList = Browsertracker.find.all();

		return ok(browsertrackers.render(browsertrackerList));
	}

	public static Result submit() {
		Form<BrowsertrackerFormData> formData = Form.form(
			BrowsertrackerFormData.class).bindFromRequest();

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

	public static Result edit(Form<BrowsertrackerFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addBrowsertracker();
		}
		else {
			BrowsertrackerFormData browsertrackerFormData = formData.get();

			String id = browsertrackerFormData.browserTrackerId;

			long browsertrackerId = 0;

			if (id != null) {
				browsertrackerId = Long.valueOf(id);
			}

			Browsertracker browsertracker;

			if (browsertrackerId > 0) {
				browsertracker = Browsertracker.find.byId(browsertrackerId);

				browsertracker.setMvccVersion(Long.valueOf(browsertrackerFormData.mvccVersion));
				browsertracker.setBrowserTrackerId(Long.valueOf(browsertrackerFormData.browserTrackerId));
				browsertracker.setUserId(Long.valueOf(browsertrackerFormData.userId));
				browsertracker.setBrowserKey(Long.valueOf(browsertrackerFormData.browserKey));
			}
			else {
				browsertracker = new Browsertracker(browsertrackerFormData);
			}

			Ebean.save(browsertracker);

			flash("success", "Browsertracker instance created/edited: " + browsertracker);

			return all();
		}
	}

	public static Result delete(Form<BrowsertrackerFormData> formData) {
		BrowsertrackerFormData browsertrackerFormData = formData.get();

		String id = browsertrackerFormData.browserTrackerId;

		long browsertrackerId = 0;

		if (id != null) {
			browsertrackerId = Long.valueOf(id);
		}

		Browsertracker browsertracker;

		if (browsertrackerId > 0) {
			browsertracker = Browsertracker.find.byId(browsertrackerId);

			Ebean.delete(browsertracker);
		}
		else {
			flash("error", "Cannot delete Browsertracker");
		}

		return all();
	}

}
