
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfileentry.DlfileentryFormData;

import models.dlfileentry.Dlfileentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfileentry.dlfileentry;
import views.html.dlfileentry.dlfileentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileentryApplication extends Controller {

	public static Result addDlfileentry() {
		Form<DlfileentryFormData> form = Form.form(
			DlfileentryFormData.class).fill(new Dlfileentry().toFormData());

		return ok(dlfileentry.render(form));
	}

	public static Result get(Long id) {
		Dlfileentry dbDlfileentry = Dlfileentry.find.byId(id);

		Form<DlfileentryFormData> form = Form.form(
			DlfileentryFormData.class).fill(dbDlfileentry.toFormData());

		return ok(dlfileentry.render(form));
	}

	public static Result all() {
		List<Dlfileentry> dlfileentryList = Dlfileentry.find.all();

		return ok(dlfileentrys.render(dlfileentryList));
	}

	public static Result submit() {
		Form<DlfileentryFormData> formData = Form.form(
			DlfileentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfileentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfileentry();
		}
		else {
			DlfileentryFormData dlfileentryFormData = formData.get();

			String id = dlfileentryFormData.fileEntryId;

			long dlfileentryId = 0;

			if (id != null) {
				dlfileentryId = Long.valueOf(id);
			}

			Dlfileentry dlfileentry;

			if (dlfileentryId > 0) {
				dlfileentry = Dlfileentry.find.byId(dlfileentryId);

				dlfileentry.setUuid(dlfileentryFormData.uuid);
				dlfileentry.setFileEntryId(Long.valueOf(dlfileentryFormData.fileEntryId));
				dlfileentry.setGroupId(Long.valueOf(dlfileentryFormData.groupId));
				dlfileentry.setCompanyId(Long.valueOf(dlfileentryFormData.companyId));
				dlfileentry.setUserId(Long.valueOf(dlfileentryFormData.userId));
				dlfileentry.setUserName(dlfileentryFormData.userName);
				dlfileentry.setCreateDate(new Date(dlfileentryFormData.createDate));
				dlfileentry.setModifiedDate(new Date(dlfileentryFormData.modifiedDate));
				dlfileentry.setClassNameId(Long.valueOf(dlfileentryFormData.classNameId));
				dlfileentry.setClassPK(Long.valueOf(dlfileentryFormData.classPK));
				dlfileentry.setRepositoryId(Long.valueOf(dlfileentryFormData.repositoryId));
				dlfileentry.setFolderId(Long.valueOf(dlfileentryFormData.folderId));
				dlfileentry.setTreePath(dlfileentryFormData.treePath);
				dlfileentry.setName(dlfileentryFormData.name);
				dlfileentry.setFileName(dlfileentryFormData.fileName);
				dlfileentry.setExtension(dlfileentryFormData.extension);
				dlfileentry.setMimeType(dlfileentryFormData.mimeType);
				dlfileentry.setTitle(dlfileentryFormData.title);
				dlfileentry.setDescription(dlfileentryFormData.description);
				dlfileentry.setExtraSettings(dlfileentryFormData.extraSettings);
				dlfileentry.setFileEntryTypeId(Long.valueOf(dlfileentryFormData.fileEntryTypeId));
				dlfileentry.setVersion(dlfileentryFormData.version);
				dlfileentry.setSize(Long.valueOf(dlfileentryFormData.size));
				dlfileentry.setReadCount(Integer.valueOf(dlfileentryFormData.readCount));
				dlfileentry.setSmallImageId(Long.valueOf(dlfileentryFormData.smallImageId));
				dlfileentry.setLargeImageId(Long.valueOf(dlfileentryFormData.largeImageId));
				dlfileentry.setCustom1ImageId(Long.valueOf(dlfileentryFormData.custom1ImageId));
				dlfileentry.setCustom2ImageId(Long.valueOf(dlfileentryFormData.custom2ImageId));
				dlfileentry.setManualCheckInRequired(Boolean.valueOf(dlfileentryFormData.manualCheckInRequired));
			}
			else {
				dlfileentry = new Dlfileentry(dlfileentryFormData);
			}

			Ebean.save(dlfileentry);

			flash("success", "Dlfileentry instance created/edited: " + dlfileentry);

			return all();
		}
	}

	public static Result delete(Form<DlfileentryFormData> formData) {
		DlfileentryFormData dlfileentryFormData = formData.get();

		String id = dlfileentryFormData.fileEntryId;

		long dlfileentryId = 0;

		if (id != null) {
			dlfileentryId = Long.valueOf(id);
		}

		Dlfileentry dlfileentry;

		if (dlfileentryId > 0) {
			dlfileentry = Dlfileentry.find.byId(dlfileentryId);

			Ebean.delete(dlfileentry);
		}
		else {
			flash("error", "Cannot delete Dlfileentry");
		}

		return all();
	}

}
