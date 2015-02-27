
package controllers;

import com.avaje.ebean.Ebean;

import controllers.expandorow.ExpandorowFormData;

import models.expandorow.Expandorow;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.expandorow.expandorow;
import views.html.expandorow.expandorows;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ExpandorowApplication extends Controller {

	public static Result addExpandorow() {
		Form<ExpandorowFormData> form = Form.form(
			ExpandorowFormData.class).fill(new Expandorow().toFormData());

		return ok(expandorow.render(form));
	}

	public static Result get(Long id) {
		Expandorow dbExpandorow = Expandorow.find.byId(id);

		Form<ExpandorowFormData> form = Form.form(
			ExpandorowFormData.class).fill(dbExpandorow.toFormData());

		return ok(expandorow.render(form));
	}

	public static Result all() {
		List<Expandorow> expandorowList = Expandorow.find.all();

		return ok(expandorows.render(expandorowList));
	}

	public static Result submit() {
		Form<ExpandorowFormData> formData = Form.form(
			ExpandorowFormData.class).bindFromRequest();

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

	public static Result edit(Form<ExpandorowFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addExpandorow();
		}
		else {
			ExpandorowFormData expandorowFormData = formData.get();

			String id = expandorowFormData.rowId;

			long expandorowId = 0;

			if (id != null) {
				expandorowId = Long.valueOf(id);
			}

			Expandorow expandorow;

			if (expandorowId > 0) {
				expandorow = Expandorow.find.byId(expandorowId);

				expandorow.setRowId(Long.valueOf(expandorowFormData.rowId));
				expandorow.setCompanyId(Long.valueOf(expandorowFormData.companyId));
				expandorow.setModifiedDate(new Date(expandorowFormData.modifiedDate));
				expandorow.setTableId(Long.valueOf(expandorowFormData.tableId));
				expandorow.setClassPK(Long.valueOf(expandorowFormData.classPK));
			}
			else {
				expandorow = new Expandorow(expandorowFormData);
			}

			Ebean.save(expandorow);

			flash("success", "Expandorow instance created/edited: " + expandorow);

			return all();
		}
	}

	public static Result delete(Form<ExpandorowFormData> formData) {
		ExpandorowFormData expandorowFormData = formData.get();

		String id = expandorowFormData.rowId;

		long expandorowId = 0;

		if (id != null) {
			expandorowId = Long.valueOf(id);
		}

		Expandorow expandorow;

		if (expandorowId > 0) {
			expandorow = Expandorow.find.byId(expandorowId);

			Ebean.delete(expandorow);
		}
		else {
			flash("error", "Cannot delete Expandorow");
		}

		return all();
	}

}
