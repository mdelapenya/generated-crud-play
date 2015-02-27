
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmstructurelayout.DdmstructurelayoutFormData;

import models.ddmstructurelayout.Ddmstructurelayout;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmstructurelayout.ddmstructurelayout;
import views.html.ddmstructurelayout.ddmstructurelayouts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmstructurelayoutApplication extends Controller {

	public static Result addDdmstructurelayout() {
		Form<DdmstructurelayoutFormData> form = Form.form(
			DdmstructurelayoutFormData.class).fill(new Ddmstructurelayout().toFormData());

		return ok(ddmstructurelayout.render(form));
	}

	public static Result get(Long id) {
		Ddmstructurelayout dbDdmstructurelayout = Ddmstructurelayout.find.byId(id);

		Form<DdmstructurelayoutFormData> form = Form.form(
			DdmstructurelayoutFormData.class).fill(dbDdmstructurelayout.toFormData());

		return ok(ddmstructurelayout.render(form));
	}

	public static Result all() {
		List<Ddmstructurelayout> ddmstructurelayoutList = Ddmstructurelayout.find.all();

		return ok(ddmstructurelayouts.render(ddmstructurelayoutList));
	}

	public static Result submit() {
		Form<DdmstructurelayoutFormData> formData = Form.form(
			DdmstructurelayoutFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmstructurelayoutFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmstructurelayout();
		}
		else {
			DdmstructurelayoutFormData ddmstructurelayoutFormData = formData.get();

			String id = ddmstructurelayoutFormData.structureLayoutId;

			long ddmstructurelayoutId = 0;

			if (id != null) {
				ddmstructurelayoutId = Long.valueOf(id);
			}

			Ddmstructurelayout ddmstructurelayout;

			if (ddmstructurelayoutId > 0) {
				ddmstructurelayout = Ddmstructurelayout.find.byId(ddmstructurelayoutId);

				ddmstructurelayout.setUuid(ddmstructurelayoutFormData.uuid);
				ddmstructurelayout.setStructureLayoutId(Long.valueOf(ddmstructurelayoutFormData.structureLayoutId));
				ddmstructurelayout.setGroupId(Long.valueOf(ddmstructurelayoutFormData.groupId));
				ddmstructurelayout.setCompanyId(Long.valueOf(ddmstructurelayoutFormData.companyId));
				ddmstructurelayout.setUserId(Long.valueOf(ddmstructurelayoutFormData.userId));
				ddmstructurelayout.setUserName(ddmstructurelayoutFormData.userName);
				ddmstructurelayout.setCreateDate(new Date(ddmstructurelayoutFormData.createDate));
				ddmstructurelayout.setModifiedDate(new Date(ddmstructurelayoutFormData.modifiedDate));
				ddmstructurelayout.setStructureVersionId(Long.valueOf(ddmstructurelayoutFormData.structureVersionId));
				ddmstructurelayout.setDefinition(ddmstructurelayoutFormData.definition);
			}
			else {
				ddmstructurelayout = new Ddmstructurelayout(ddmstructurelayoutFormData);
			}

			Ebean.save(ddmstructurelayout);

			flash("success", "Ddmstructurelayout instance created/edited: " + ddmstructurelayout);

			return all();
		}
	}

	public static Result delete(Form<DdmstructurelayoutFormData> formData) {
		DdmstructurelayoutFormData ddmstructurelayoutFormData = formData.get();

		String id = ddmstructurelayoutFormData.structureLayoutId;

		long ddmstructurelayoutId = 0;

		if (id != null) {
			ddmstructurelayoutId = Long.valueOf(id);
		}

		Ddmstructurelayout ddmstructurelayout;

		if (ddmstructurelayoutId > 0) {
			ddmstructurelayout = Ddmstructurelayout.find.byId(ddmstructurelayoutId);

			Ebean.delete(ddmstructurelayout);
		}
		else {
			flash("error", "Cannot delete Ddmstructurelayout");
		}

		return all();
	}

}
