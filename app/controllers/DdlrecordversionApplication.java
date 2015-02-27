
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddlrecordversion.DdlrecordversionFormData;

import models.ddlrecordversion.Ddlrecordversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddlrecordversion.ddlrecordversion;
import views.html.ddlrecordversion.ddlrecordversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdlrecordversionApplication extends Controller {

	public static Result addDdlrecordversion() {
		Form<DdlrecordversionFormData> form = Form.form(
			DdlrecordversionFormData.class).fill(new Ddlrecordversion().toFormData());

		return ok(ddlrecordversion.render(form));
	}

	public static Result get(Long id) {
		Ddlrecordversion dbDdlrecordversion = Ddlrecordversion.find.byId(id);

		Form<DdlrecordversionFormData> form = Form.form(
			DdlrecordversionFormData.class).fill(dbDdlrecordversion.toFormData());

		return ok(ddlrecordversion.render(form));
	}

	public static Result all() {
		List<Ddlrecordversion> ddlrecordversionList = Ddlrecordversion.find.all();

		return ok(ddlrecordversions.render(ddlrecordversionList));
	}

	public static Result submit() {
		Form<DdlrecordversionFormData> formData = Form.form(
			DdlrecordversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdlrecordversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdlrecordversion();
		}
		else {
			DdlrecordversionFormData ddlrecordversionFormData = formData.get();

			String id = ddlrecordversionFormData.recordVersionId;

			long ddlrecordversionId = 0;

			if (id != null) {
				ddlrecordversionId = Long.valueOf(id);
			}

			Ddlrecordversion ddlrecordversion;

			if (ddlrecordversionId > 0) {
				ddlrecordversion = Ddlrecordversion.find.byId(ddlrecordversionId);

				ddlrecordversion.setRecordVersionId(Long.valueOf(ddlrecordversionFormData.recordVersionId));
				ddlrecordversion.setGroupId(Long.valueOf(ddlrecordversionFormData.groupId));
				ddlrecordversion.setCompanyId(Long.valueOf(ddlrecordversionFormData.companyId));
				ddlrecordversion.setUserId(Long.valueOf(ddlrecordversionFormData.userId));
				ddlrecordversion.setUserName(ddlrecordversionFormData.userName);
				ddlrecordversion.setCreateDate(new Date(ddlrecordversionFormData.createDate));
				ddlrecordversion.setDDMStorageId(Long.valueOf(ddlrecordversionFormData.DDMStorageId));
				ddlrecordversion.setRecordSetId(Long.valueOf(ddlrecordversionFormData.recordSetId));
				ddlrecordversion.setRecordId(Long.valueOf(ddlrecordversionFormData.recordId));
				ddlrecordversion.setVersion(ddlrecordversionFormData.version);
				ddlrecordversion.setDisplayIndex(Integer.valueOf(ddlrecordversionFormData.displayIndex));
				ddlrecordversion.setStatus(Integer.valueOf(ddlrecordversionFormData.status));
				ddlrecordversion.setStatusByUserId(Long.valueOf(ddlrecordversionFormData.statusByUserId));
				ddlrecordversion.setStatusByUserName(ddlrecordversionFormData.statusByUserName);
				ddlrecordversion.setStatusDate(new Date(ddlrecordversionFormData.statusDate));
			}
			else {
				ddlrecordversion = new Ddlrecordversion(ddlrecordversionFormData);
			}

			Ebean.save(ddlrecordversion);

			flash("success", "Ddlrecordversion instance created/edited: " + ddlrecordversion);

			return all();
		}
	}

	public static Result delete(Form<DdlrecordversionFormData> formData) {
		DdlrecordversionFormData ddlrecordversionFormData = formData.get();

		String id = ddlrecordversionFormData.recordVersionId;

		long ddlrecordversionId = 0;

		if (id != null) {
			ddlrecordversionId = Long.valueOf(id);
		}

		Ddlrecordversion ddlrecordversion;

		if (ddlrecordversionId > 0) {
			ddlrecordversion = Ddlrecordversion.find.byId(ddlrecordversionId);

			Ebean.delete(ddlrecordversion);
		}
		else {
			flash("error", "Cannot delete Ddlrecordversion");
		}

		return all();
	}

}
