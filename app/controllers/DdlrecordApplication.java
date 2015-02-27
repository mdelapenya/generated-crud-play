
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddlrecord.DdlrecordFormData;

import models.ddlrecord.Ddlrecord;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddlrecord.ddlrecord;
import views.html.ddlrecord.ddlrecords;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdlrecordApplication extends Controller {

	public static Result addDdlrecord() {
		Form<DdlrecordFormData> form = Form.form(
			DdlrecordFormData.class).fill(new Ddlrecord().toFormData());

		return ok(ddlrecord.render(form));
	}

	public static Result get(Long id) {
		Ddlrecord dbDdlrecord = Ddlrecord.find.byId(id);

		Form<DdlrecordFormData> form = Form.form(
			DdlrecordFormData.class).fill(dbDdlrecord.toFormData());

		return ok(ddlrecord.render(form));
	}

	public static Result all() {
		List<Ddlrecord> ddlrecordList = Ddlrecord.find.all();

		return ok(ddlrecords.render(ddlrecordList));
	}

	public static Result submit() {
		Form<DdlrecordFormData> formData = Form.form(
			DdlrecordFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdlrecordFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdlrecord();
		}
		else {
			DdlrecordFormData ddlrecordFormData = formData.get();

			String id = ddlrecordFormData.recordId;

			long ddlrecordId = 0;

			if (id != null) {
				ddlrecordId = Long.valueOf(id);
			}

			Ddlrecord ddlrecord;

			if (ddlrecordId > 0) {
				ddlrecord = Ddlrecord.find.byId(ddlrecordId);

				ddlrecord.setUuid(ddlrecordFormData.uuid);
				ddlrecord.setRecordId(Long.valueOf(ddlrecordFormData.recordId));
				ddlrecord.setGroupId(Long.valueOf(ddlrecordFormData.groupId));
				ddlrecord.setCompanyId(Long.valueOf(ddlrecordFormData.companyId));
				ddlrecord.setUserId(Long.valueOf(ddlrecordFormData.userId));
				ddlrecord.setUserName(ddlrecordFormData.userName);
				ddlrecord.setVersionUserId(Long.valueOf(ddlrecordFormData.versionUserId));
				ddlrecord.setVersionUserName(ddlrecordFormData.versionUserName);
				ddlrecord.setCreateDate(new Date(ddlrecordFormData.createDate));
				ddlrecord.setModifiedDate(new Date(ddlrecordFormData.modifiedDate));
				ddlrecord.setDDMStorageId(Long.valueOf(ddlrecordFormData.DDMStorageId));
				ddlrecord.setRecordSetId(Long.valueOf(ddlrecordFormData.recordSetId));
				ddlrecord.setVersion(ddlrecordFormData.version);
				ddlrecord.setDisplayIndex(Integer.valueOf(ddlrecordFormData.displayIndex));
			}
			else {
				ddlrecord = new Ddlrecord(ddlrecordFormData);
			}

			Ebean.save(ddlrecord);

			flash("success", "Ddlrecord instance created/edited: " + ddlrecord);

			return all();
		}
	}

	public static Result delete(Form<DdlrecordFormData> formData) {
		DdlrecordFormData ddlrecordFormData = formData.get();

		String id = ddlrecordFormData.recordId;

		long ddlrecordId = 0;

		if (id != null) {
			ddlrecordId = Long.valueOf(id);
		}

		Ddlrecord ddlrecord;

		if (ddlrecordId > 0) {
			ddlrecord = Ddlrecord.find.byId(ddlrecordId);

			Ebean.delete(ddlrecord);
		}
		else {
			flash("error", "Cannot delete Ddlrecord");
		}

		return all();
	}

}
