
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddlrecordset.DdlrecordsetFormData;

import models.ddlrecordset.Ddlrecordset;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddlrecordset.ddlrecordset;
import views.html.ddlrecordset.ddlrecordsets;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdlrecordsetApplication extends Controller {

	public static Result addDdlrecordset() {
		Form<DdlrecordsetFormData> form = Form.form(
			DdlrecordsetFormData.class).fill(new Ddlrecordset().toFormData());

		return ok(ddlrecordset.render(form));
	}

	public static Result get(Long id) {
		Ddlrecordset dbDdlrecordset = Ddlrecordset.find.byId(id);

		Form<DdlrecordsetFormData> form = Form.form(
			DdlrecordsetFormData.class).fill(dbDdlrecordset.toFormData());

		return ok(ddlrecordset.render(form));
	}

	public static Result all() {
		List<Ddlrecordset> ddlrecordsetList = Ddlrecordset.find.all();

		return ok(ddlrecordsets.render(ddlrecordsetList));
	}

	public static Result submit() {
		Form<DdlrecordsetFormData> formData = Form.form(
			DdlrecordsetFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdlrecordsetFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdlrecordset();
		}
		else {
			DdlrecordsetFormData ddlrecordsetFormData = formData.get();

			String id = ddlrecordsetFormData.recordSetId;

			long ddlrecordsetId = 0;

			if (id != null) {
				ddlrecordsetId = Long.valueOf(id);
			}

			Ddlrecordset ddlrecordset;

			if (ddlrecordsetId > 0) {
				ddlrecordset = Ddlrecordset.find.byId(ddlrecordsetId);

				ddlrecordset.setUuid(ddlrecordsetFormData.uuid);
				ddlrecordset.setRecordSetId(Long.valueOf(ddlrecordsetFormData.recordSetId));
				ddlrecordset.setGroupId(Long.valueOf(ddlrecordsetFormData.groupId));
				ddlrecordset.setCompanyId(Long.valueOf(ddlrecordsetFormData.companyId));
				ddlrecordset.setUserId(Long.valueOf(ddlrecordsetFormData.userId));
				ddlrecordset.setUserName(ddlrecordsetFormData.userName);
				ddlrecordset.setCreateDate(new Date(ddlrecordsetFormData.createDate));
				ddlrecordset.setModifiedDate(new Date(ddlrecordsetFormData.modifiedDate));
				ddlrecordset.setDDMStructureId(Long.valueOf(ddlrecordsetFormData.DDMStructureId));
				ddlrecordset.setRecordSetKey(ddlrecordsetFormData.recordSetKey);
				ddlrecordset.setName(ddlrecordsetFormData.name);
				ddlrecordset.setDescription(ddlrecordsetFormData.description);
				ddlrecordset.setMinDisplayRows(Integer.valueOf(ddlrecordsetFormData.minDisplayRows));
				ddlrecordset.setScope(Integer.valueOf(ddlrecordsetFormData.scope));
			}
			else {
				ddlrecordset = new Ddlrecordset(ddlrecordsetFormData);
			}

			Ebean.save(ddlrecordset);

			flash("success", "Ddlrecordset instance created/edited: " + ddlrecordset);

			return all();
		}
	}

	public static Result delete(Form<DdlrecordsetFormData> formData) {
		DdlrecordsetFormData ddlrecordsetFormData = formData.get();

		String id = ddlrecordsetFormData.recordSetId;

		long ddlrecordsetId = 0;

		if (id != null) {
			ddlrecordsetId = Long.valueOf(id);
		}

		Ddlrecordset ddlrecordset;

		if (ddlrecordsetId > 0) {
			ddlrecordset = Ddlrecordset.find.byId(ddlrecordsetId);

			Ebean.delete(ddlrecordset);
		}
		else {
			flash("error", "Cannot delete Ddlrecordset");
		}

		return all();
	}

}
