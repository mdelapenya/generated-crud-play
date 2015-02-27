
package controllers;

import com.avaje.ebean.Ebean;

import controllers.scproductscreenshot.ScproductscreenshotFormData;

import models.scproductscreenshot.Scproductscreenshot;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.scproductscreenshot.scproductscreenshot;
import views.html.scproductscreenshot.scproductscreenshots;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ScproductscreenshotApplication extends Controller {

	public static Result addScproductscreenshot() {
		Form<ScproductscreenshotFormData> form = Form.form(
			ScproductscreenshotFormData.class).fill(new Scproductscreenshot().toFormData());

		return ok(scproductscreenshot.render(form));
	}

	public static Result get(Long id) {
		Scproductscreenshot dbScproductscreenshot = Scproductscreenshot.find.byId(id);

		Form<ScproductscreenshotFormData> form = Form.form(
			ScproductscreenshotFormData.class).fill(dbScproductscreenshot.toFormData());

		return ok(scproductscreenshot.render(form));
	}

	public static Result all() {
		List<Scproductscreenshot> scproductscreenshotList = Scproductscreenshot.find.all();

		return ok(scproductscreenshots.render(scproductscreenshotList));
	}

	public static Result submit() {
		Form<ScproductscreenshotFormData> formData = Form.form(
			ScproductscreenshotFormData.class).bindFromRequest();

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

	public static Result edit(Form<ScproductscreenshotFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addScproductscreenshot();
		}
		else {
			ScproductscreenshotFormData scproductscreenshotFormData = formData.get();

			String id = scproductscreenshotFormData.productScreenshotId;

			long scproductscreenshotId = 0;

			if (id != null) {
				scproductscreenshotId = Long.valueOf(id);
			}

			Scproductscreenshot scproductscreenshot;

			if (scproductscreenshotId > 0) {
				scproductscreenshot = Scproductscreenshot.find.byId(scproductscreenshotId);

				scproductscreenshot.setProductScreenshotId(Long.valueOf(scproductscreenshotFormData.productScreenshotId));
				scproductscreenshot.setCompanyId(Long.valueOf(scproductscreenshotFormData.companyId));
				scproductscreenshot.setGroupId(Long.valueOf(scproductscreenshotFormData.groupId));
				scproductscreenshot.setProductEntryId(Long.valueOf(scproductscreenshotFormData.productEntryId));
				scproductscreenshot.setThumbnailId(Long.valueOf(scproductscreenshotFormData.thumbnailId));
				scproductscreenshot.setFullImageId(Long.valueOf(scproductscreenshotFormData.fullImageId));
				scproductscreenshot.setPriority(Integer.valueOf(scproductscreenshotFormData.priority));
			}
			else {
				scproductscreenshot = new Scproductscreenshot(scproductscreenshotFormData);
			}

			Ebean.save(scproductscreenshot);

			flash("success", "Scproductscreenshot instance created/edited: " + scproductscreenshot);

			return all();
		}
	}

	public static Result delete(Form<ScproductscreenshotFormData> formData) {
		ScproductscreenshotFormData scproductscreenshotFormData = formData.get();

		String id = scproductscreenshotFormData.productScreenshotId;

		long scproductscreenshotId = 0;

		if (id != null) {
			scproductscreenshotId = Long.valueOf(id);
		}

		Scproductscreenshot scproductscreenshot;

		if (scproductscreenshotId > 0) {
			scproductscreenshot = Scproductscreenshot.find.byId(scproductscreenshotId);

			Ebean.delete(scproductscreenshot);
		}
		else {
			flash("error", "Cannot delete Scproductscreenshot");
		}

		return all();
	}

}
