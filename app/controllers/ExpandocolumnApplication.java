
package controllers;

import com.avaje.ebean.Ebean;

import controllers.expandocolumn.ExpandocolumnFormData;

import models.expandocolumn.Expandocolumn;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.expandocolumn.expandocolumn;
import views.html.expandocolumn.expandocolumns;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ExpandocolumnApplication extends Controller {

	public static Result addExpandocolumn() {
		Form<ExpandocolumnFormData> form = Form.form(
			ExpandocolumnFormData.class).fill(new Expandocolumn().toFormData());

		return ok(expandocolumn.render(form));
	}

	public static Result get(Long id) {
		Expandocolumn dbExpandocolumn = Expandocolumn.find.byId(id);

		Form<ExpandocolumnFormData> form = Form.form(
			ExpandocolumnFormData.class).fill(dbExpandocolumn.toFormData());

		return ok(expandocolumn.render(form));
	}

	public static Result all() {
		List<Expandocolumn> expandocolumnList = Expandocolumn.find.all();

		return ok(expandocolumns.render(expandocolumnList));
	}

	public static Result submit() {
		Form<ExpandocolumnFormData> formData = Form.form(
			ExpandocolumnFormData.class).bindFromRequest();

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

	public static Result edit(Form<ExpandocolumnFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addExpandocolumn();
		}
		else {
			ExpandocolumnFormData expandocolumnFormData = formData.get();

			String id = expandocolumnFormData.columnId;

			long expandocolumnId = 0;

			if (id != null) {
				expandocolumnId = Long.valueOf(id);
			}

			Expandocolumn expandocolumn;

			if (expandocolumnId > 0) {
				expandocolumn = Expandocolumn.find.byId(expandocolumnId);

				expandocolumn.setColumnId(Long.valueOf(expandocolumnFormData.columnId));
				expandocolumn.setCompanyId(Long.valueOf(expandocolumnFormData.companyId));
				expandocolumn.setTableId(Long.valueOf(expandocolumnFormData.tableId));
				expandocolumn.setName(expandocolumnFormData.name);
				expandocolumn.setCustomtype(Integer.valueOf(expandocolumnFormData.customtype));
				expandocolumn.setDefaultData(expandocolumnFormData.defaultData);
				expandocolumn.setTypeSettings(expandocolumnFormData.typeSettings);
			}
			else {
				expandocolumn = new Expandocolumn(expandocolumnFormData);
			}

			Ebean.save(expandocolumn);

			flash("success", "Expandocolumn instance created/edited: " + expandocolumn);

			return all();
		}
	}

	public static Result delete(Form<ExpandocolumnFormData> formData) {
		ExpandocolumnFormData expandocolumnFormData = formData.get();

		String id = expandocolumnFormData.columnId;

		long expandocolumnId = 0;

		if (id != null) {
			expandocolumnId = Long.valueOf(id);
		}

		Expandocolumn expandocolumn;

		if (expandocolumnId > 0) {
			expandocolumn = Expandocolumn.find.byId(expandocolumnId);

			Ebean.delete(expandocolumn);
		}
		else {
			flash("error", "Cannot delete Expandocolumn");
		}

		return all();
	}

}
