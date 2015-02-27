
package controllers;

import com.avaje.ebean.Ebean;

import controllers.expandovalue.ExpandovalueFormData;

import models.expandovalue.Expandovalue;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.expandovalue.expandovalue;
import views.html.expandovalue.expandovalues;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ExpandovalueApplication extends Controller {

	public static Result addExpandovalue() {
		Form<ExpandovalueFormData> form = Form.form(
			ExpandovalueFormData.class).fill(new Expandovalue().toFormData());

		return ok(expandovalue.render(form));
	}

	public static Result get(Long id) {
		Expandovalue dbExpandovalue = Expandovalue.find.byId(id);

		Form<ExpandovalueFormData> form = Form.form(
			ExpandovalueFormData.class).fill(dbExpandovalue.toFormData());

		return ok(expandovalue.render(form));
	}

	public static Result all() {
		List<Expandovalue> expandovalueList = Expandovalue.find.all();

		return ok(expandovalues.render(expandovalueList));
	}

	public static Result submit() {
		Form<ExpandovalueFormData> formData = Form.form(
			ExpandovalueFormData.class).bindFromRequest();

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

	public static Result edit(Form<ExpandovalueFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addExpandovalue();
		}
		else {
			ExpandovalueFormData expandovalueFormData = formData.get();

			String id = expandovalueFormData.valueId;

			long expandovalueId = 0;

			if (id != null) {
				expandovalueId = Long.valueOf(id);
			}

			Expandovalue expandovalue;

			if (expandovalueId > 0) {
				expandovalue = Expandovalue.find.byId(expandovalueId);

				expandovalue.setValueId(Long.valueOf(expandovalueFormData.valueId));
				expandovalue.setCompanyId(Long.valueOf(expandovalueFormData.companyId));
				expandovalue.setTableId(Long.valueOf(expandovalueFormData.tableId));
				expandovalue.setColumnId(Long.valueOf(expandovalueFormData.columnId));
				expandovalue.setRowId(Long.valueOf(expandovalueFormData.rowId));
				expandovalue.setClassNameId(Long.valueOf(expandovalueFormData.classNameId));
				expandovalue.setClassPK(Long.valueOf(expandovalueFormData.classPK));
				expandovalue.setData(expandovalueFormData.data);
			}
			else {
				expandovalue = new Expandovalue(expandovalueFormData);
			}

			Ebean.save(expandovalue);

			flash("success", "Expandovalue instance created/edited: " + expandovalue);

			return all();
		}
	}

	public static Result delete(Form<ExpandovalueFormData> formData) {
		ExpandovalueFormData expandovalueFormData = formData.get();

		String id = expandovalueFormData.valueId;

		long expandovalueId = 0;

		if (id != null) {
			expandovalueId = Long.valueOf(id);
		}

		Expandovalue expandovalue;

		if (expandovalueId > 0) {
			expandovalue = Expandovalue.find.byId(expandovalueId);

			Ebean.delete(expandovalue);
		}
		else {
			flash("error", "Cannot delete Expandovalue");
		}

		return all();
	}

}
