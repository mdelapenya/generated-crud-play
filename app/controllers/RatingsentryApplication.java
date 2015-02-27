
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ratingsentry.RatingsentryFormData;

import models.ratingsentry.Ratingsentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ratingsentry.ratingsentry;
import views.html.ratingsentry.ratingsentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class RatingsentryApplication extends Controller {

	public static Result addRatingsentry() {
		Form<RatingsentryFormData> form = Form.form(
			RatingsentryFormData.class).fill(new Ratingsentry().toFormData());

		return ok(ratingsentry.render(form));
	}

	public static Result get(Long id) {
		Ratingsentry dbRatingsentry = Ratingsentry.find.byId(id);

		Form<RatingsentryFormData> form = Form.form(
			RatingsentryFormData.class).fill(dbRatingsentry.toFormData());

		return ok(ratingsentry.render(form));
	}

	public static Result all() {
		List<Ratingsentry> ratingsentryList = Ratingsentry.find.all();

		return ok(ratingsentrys.render(ratingsentryList));
	}

	public static Result submit() {
		Form<RatingsentryFormData> formData = Form.form(
			RatingsentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<RatingsentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRatingsentry();
		}
		else {
			RatingsentryFormData ratingsentryFormData = formData.get();

			String id = ratingsentryFormData.entryId;

			long ratingsentryId = 0;

			if (id != null) {
				ratingsentryId = Long.valueOf(id);
			}

			Ratingsentry ratingsentry;

			if (ratingsentryId > 0) {
				ratingsentry = Ratingsentry.find.byId(ratingsentryId);

				ratingsentry.setUuid(ratingsentryFormData.uuid);
				ratingsentry.setEntryId(Long.valueOf(ratingsentryFormData.entryId));
				ratingsentry.setCompanyId(Long.valueOf(ratingsentryFormData.companyId));
				ratingsentry.setUserId(Long.valueOf(ratingsentryFormData.userId));
				ratingsentry.setUserName(ratingsentryFormData.userName);
				ratingsentry.setCreateDate(new Date(ratingsentryFormData.createDate));
				ratingsentry.setModifiedDate(new Date(ratingsentryFormData.modifiedDate));
				ratingsentry.setClassNameId(Long.valueOf(ratingsentryFormData.classNameId));
				ratingsentry.setClassPK(Long.valueOf(ratingsentryFormData.classPK));
				ratingsentry.setScore(Double.valueOf(ratingsentryFormData.score));
			}
			else {
				ratingsentry = new Ratingsentry(ratingsentryFormData);
			}

			Ebean.save(ratingsentry);

			flash("success", "Ratingsentry instance created/edited: " + ratingsentry);

			return all();
		}
	}

	public static Result delete(Form<RatingsentryFormData> formData) {
		RatingsentryFormData ratingsentryFormData = formData.get();

		String id = ratingsentryFormData.entryId;

		long ratingsentryId = 0;

		if (id != null) {
			ratingsentryId = Long.valueOf(id);
		}

		Ratingsentry ratingsentry;

		if (ratingsentryId > 0) {
			ratingsentry = Ratingsentry.find.byId(ratingsentryId);

			Ebean.delete(ratingsentry);
		}
		else {
			flash("error", "Cannot delete Ratingsentry");
		}

		return all();
	}

}
