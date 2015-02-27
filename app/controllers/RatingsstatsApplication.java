
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ratingsstats.RatingsstatsFormData;

import models.ratingsstats.Ratingsstats;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ratingsstats.ratingsstats;
import views.html.ratingsstats.ratingsstatss;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class RatingsstatsApplication extends Controller {

	public static Result addRatingsstats() {
		Form<RatingsstatsFormData> form = Form.form(
			RatingsstatsFormData.class).fill(new Ratingsstats().toFormData());

		return ok(ratingsstats.render(form));
	}

	public static Result get(Long id) {
		Ratingsstats dbRatingsstats = Ratingsstats.find.byId(id);

		Form<RatingsstatsFormData> form = Form.form(
			RatingsstatsFormData.class).fill(dbRatingsstats.toFormData());

		return ok(ratingsstats.render(form));
	}

	public static Result all() {
		List<Ratingsstats> ratingsstatsList = Ratingsstats.find.all();

		return ok(ratingsstatss.render(ratingsstatsList));
	}

	public static Result submit() {
		Form<RatingsstatsFormData> formData = Form.form(
			RatingsstatsFormData.class).bindFromRequest();

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

	public static Result edit(Form<RatingsstatsFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRatingsstats();
		}
		else {
			RatingsstatsFormData ratingsstatsFormData = formData.get();

			String id = ratingsstatsFormData.statsId;

			long ratingsstatsId = 0;

			if (id != null) {
				ratingsstatsId = Long.valueOf(id);
			}

			Ratingsstats ratingsstats;

			if (ratingsstatsId > 0) {
				ratingsstats = Ratingsstats.find.byId(ratingsstatsId);

				ratingsstats.setStatsId(Long.valueOf(ratingsstatsFormData.statsId));
				ratingsstats.setClassNameId(Long.valueOf(ratingsstatsFormData.classNameId));
				ratingsstats.setClassPK(Long.valueOf(ratingsstatsFormData.classPK));
				ratingsstats.setTotalEntries(Integer.valueOf(ratingsstatsFormData.totalEntries));
				ratingsstats.setTotalScore(Double.valueOf(ratingsstatsFormData.totalScore));
				ratingsstats.setAverageScore(Double.valueOf(ratingsstatsFormData.averageScore));
			}
			else {
				ratingsstats = new Ratingsstats(ratingsstatsFormData);
			}

			Ebean.save(ratingsstats);

			flash("success", "Ratingsstats instance created/edited: " + ratingsstats);

			return all();
		}
	}

	public static Result delete(Form<RatingsstatsFormData> formData) {
		RatingsstatsFormData ratingsstatsFormData = formData.get();

		String id = ratingsstatsFormData.statsId;

		long ratingsstatsId = 0;

		if (id != null) {
			ratingsstatsId = Long.valueOf(id);
		}

		Ratingsstats ratingsstats;

		if (ratingsstatsId > 0) {
			ratingsstats = Ratingsstats.find.byId(ratingsstatsId);

			Ebean.delete(ratingsstats);
		}
		else {
			flash("error", "Cannot delete Ratingsstats");
		}

		return all();
	}

}
