
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfileentrytype.DlfileentrytypeFormData;

import models.dlfileentrytype.Dlfileentrytype;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfileentrytype.dlfileentrytype;
import views.html.dlfileentrytype.dlfileentrytypes;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileentrytypeApplication extends Controller {

	public static Result addDlfileentrytype() {
		Form<DlfileentrytypeFormData> form = Form.form(
			DlfileentrytypeFormData.class).fill(new Dlfileentrytype().toFormData());

		return ok(dlfileentrytype.render(form));
	}

	public static Result get(Long id) {
		Dlfileentrytype dbDlfileentrytype = Dlfileentrytype.find.byId(id);

		Form<DlfileentrytypeFormData> form = Form.form(
			DlfileentrytypeFormData.class).fill(dbDlfileentrytype.toFormData());

		return ok(dlfileentrytype.render(form));
	}

	public static Result all() {
		List<Dlfileentrytype> dlfileentrytypeList = Dlfileentrytype.find.all();

		return ok(dlfileentrytypes.render(dlfileentrytypeList));
	}

	public static Result submit() {
		Form<DlfileentrytypeFormData> formData = Form.form(
			DlfileentrytypeFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfileentrytypeFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfileentrytype();
		}
		else {
			DlfileentrytypeFormData dlfileentrytypeFormData = formData.get();

			String id = dlfileentrytypeFormData.fileEntryTypeId;

			long dlfileentrytypeId = 0;

			if (id != null) {
				dlfileentrytypeId = Long.valueOf(id);
			}

			Dlfileentrytype dlfileentrytype;

			if (dlfileentrytypeId > 0) {
				dlfileentrytype = Dlfileentrytype.find.byId(dlfileentrytypeId);

				dlfileentrytype.setUuid(dlfileentrytypeFormData.uuid);
				dlfileentrytype.setFileEntryTypeId(Long.valueOf(dlfileentrytypeFormData.fileEntryTypeId));
				dlfileentrytype.setGroupId(Long.valueOf(dlfileentrytypeFormData.groupId));
				dlfileentrytype.setCompanyId(Long.valueOf(dlfileentrytypeFormData.companyId));
				dlfileentrytype.setUserId(Long.valueOf(dlfileentrytypeFormData.userId));
				dlfileentrytype.setUserName(dlfileentrytypeFormData.userName);
				dlfileentrytype.setCreateDate(new Date(dlfileentrytypeFormData.createDate));
				dlfileentrytype.setModifiedDate(new Date(dlfileentrytypeFormData.modifiedDate));
				dlfileentrytype.setFileEntryTypeKey(dlfileentrytypeFormData.fileEntryTypeKey);
				dlfileentrytype.setName(dlfileentrytypeFormData.name);
				dlfileentrytype.setDescription(dlfileentrytypeFormData.description);
			}
			else {
				dlfileentrytype = new Dlfileentrytype(dlfileentrytypeFormData);
			}

			Ebean.save(dlfileentrytype);

			flash("success", "Dlfileentrytype instance created/edited: " + dlfileentrytype);

			return all();
		}
	}

	public static Result delete(Form<DlfileentrytypeFormData> formData) {
		DlfileentrytypeFormData dlfileentrytypeFormData = formData.get();

		String id = dlfileentrytypeFormData.fileEntryTypeId;

		long dlfileentrytypeId = 0;

		if (id != null) {
			dlfileentrytypeId = Long.valueOf(id);
		}

		Dlfileentrytype dlfileentrytype;

		if (dlfileentrytypeId > 0) {
			dlfileentrytype = Dlfileentrytype.find.byId(dlfileentrytypeId);

			Ebean.delete(dlfileentrytype);
		}
		else {
			flash("error", "Cannot delete Dlfileentrytype");
		}

		return all();
	}

}
