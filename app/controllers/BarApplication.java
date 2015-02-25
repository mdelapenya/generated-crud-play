package controllers;

import com.avaje.ebean.Ebean;

import controllers.bar.BarFormData;

import models.bar.Bar;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.bar.bar;
import views.html.bar.bars;

import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class BarApplication extends Controller {

	public static Result addBar() {
		Form<BarFormData> form = Form.form(
			BarFormData.class).fill(new Bar().toFormData());

		return ok(bar.render(form));
	}

	public static Result get(Long id) {
		Bar dbBar = Bar.find.byId(id);

		Form<BarFormData> form = Form.form(
			BarFormData.class).fill(dbBar.toFormData());

		return ok(bar.render(form));
	}

	public static Result all() {
		List<Bar> barList = Bar.find.all();

		return ok(bars.render(barList));
	}

	public static Result submit() {
		Form<BarFormData> formData = Form.form(
			BarFormData.class).bindFromRequest();

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

	public static Result edit(Form<BarFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addBar();
		}
		else {
			BarFormData barFormData = formData.get();

			String id = barFormData.id;

			long barId = 0;

			if (id != null) {
				barId = Long.valueOf(id);
			}

			Bar bar;

			if (barId > 0) {
				bar = Bar.find.byId(barId);

				bar.setId(Long.valueOf(barFormData.id));
				bar.setCampo2(barFormData.campo2);
			}
			else {
				bar = new Bar(barFormData);
			}

			Ebean.save(bar);

			flash("success", "Bar instance created/edited: " + bar);

			return all();
		}
	}

	public static Result delete(Form<BarFormData> formData) {
		BarFormData barFormData = formData.get();

		String id = barFormData.id;

		long barId = 0;

		if (id != null) {
			barId = Long.valueOf(id);
		}

		Bar bar;

		if (barId > 0) {
			bar = Bar.find.byId(barId);

			Ebean.delete(bar);
		}
		else {
			flash("error", "Cannot delete Bar");
		}

		return all();
	}

}
