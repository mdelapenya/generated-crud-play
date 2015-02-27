
package controllers;

import com.avaje.ebean.Ebean;

import controllers.expandotable.ExpandotableFormData;

import models.expandotable.Expandotable;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.expandotable.expandotable;
import views.html.expandotable.expandotables;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ExpandotableApplication extends Controller {

	public static Result addExpandotable() {
		Form<ExpandotableFormData> form = Form.form(
			ExpandotableFormData.class).fill(new Expandotable().toFormData());

		return ok(expandotable.render(form));
	}

	public static Result get(Long id) {
		Expandotable dbExpandotable = Expandotable.find.byId(id);

		Form<ExpandotableFormData> form = Form.form(
			ExpandotableFormData.class).fill(dbExpandotable.toFormData());

		return ok(expandotable.render(form));
	}

	public static Result all() {
		List<Expandotable> expandotableList = Expandotable.find.all();

		return ok(expandotables.render(expandotableList));
	}

	public static Result submit() {
		Form<ExpandotableFormData> formData = Form.form(
			ExpandotableFormData.class).bindFromRequest();

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

	public static Result edit(Form<ExpandotableFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addExpandotable();
		}
		else {
			ExpandotableFormData expandotableFormData = formData.get();

			String id = expandotableFormData.tableId;

			long expandotableId = 0;

			if (id != null) {
				expandotableId = Long.valueOf(id);
			}

			Expandotable expandotable;

			if (expandotableId > 0) {
				expandotable = Expandotable.find.byId(expandotableId);

				expandotable.setTableId(Long.valueOf(expandotableFormData.tableId));
				expandotable.setCompanyId(Long.valueOf(expandotableFormData.companyId));
				expandotable.setClassNameId(Long.valueOf(expandotableFormData.classNameId));
				expandotable.setName(expandotableFormData.name);
			}
			else {
				expandotable = new Expandotable(expandotableFormData);
			}

			Ebean.save(expandotable);

			flash("success", "Expandotable instance created/edited: " + expandotable);

			return all();
		}
	}

	public static Result delete(Form<ExpandotableFormData> formData) {
		ExpandotableFormData expandotableFormData = formData.get();

		String id = expandotableFormData.tableId;

		long expandotableId = 0;

		if (id != null) {
			expandotableId = Long.valueOf(id);
		}

		Expandotable expandotable;

		if (expandotableId > 0) {
			expandotable = Expandotable.find.byId(expandotableId);

			Ebean.delete(expandotable);
		}
		else {
			flash("error", "Cannot delete Expandotable");
		}

		return all();
	}

}
