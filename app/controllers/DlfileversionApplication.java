
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfileversion.DlfileversionFormData;

import models.dlfileversion.Dlfileversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfileversion.dlfileversion;
import views.html.dlfileversion.dlfileversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileversionApplication extends Controller {

	public static Result addDlfileversion() {
		Form<DlfileversionFormData> form = Form.form(
			DlfileversionFormData.class).fill(new Dlfileversion().toFormData());

		return ok(dlfileversion.render(form));
	}

	public static Result get(Long id) {
		Dlfileversion dbDlfileversion = Dlfileversion.find.byId(id);

		Form<DlfileversionFormData> form = Form.form(
			DlfileversionFormData.class).fill(dbDlfileversion.toFormData());

		return ok(dlfileversion.render(form));
	}

	public static Result all() {
		List<Dlfileversion> dlfileversionList = Dlfileversion.find.all();

		return ok(dlfileversions.render(dlfileversionList));
	}

	public static Result submit() {
		Form<DlfileversionFormData> formData = Form.form(
			DlfileversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfileversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfileversion();
		}
		else {
			DlfileversionFormData dlfileversionFormData = formData.get();

			String id = dlfileversionFormData.fileVersionId;

			long dlfileversionId = 0;

			if (id != null) {
				dlfileversionId = Long.valueOf(id);
			}

			Dlfileversion dlfileversion;

			if (dlfileversionId > 0) {
				dlfileversion = Dlfileversion.find.byId(dlfileversionId);

				dlfileversion.setUuid(dlfileversionFormData.uuid);
				dlfileversion.setFileVersionId(Long.valueOf(dlfileversionFormData.fileVersionId));
				dlfileversion.setGroupId(Long.valueOf(dlfileversionFormData.groupId));
				dlfileversion.setCompanyId(Long.valueOf(dlfileversionFormData.companyId));
				dlfileversion.setUserId(Long.valueOf(dlfileversionFormData.userId));
				dlfileversion.setUserName(dlfileversionFormData.userName);
				dlfileversion.setCreateDate(new Date(dlfileversionFormData.createDate));
				dlfileversion.setModifiedDate(new Date(dlfileversionFormData.modifiedDate));
				dlfileversion.setRepositoryId(Long.valueOf(dlfileversionFormData.repositoryId));
				dlfileversion.setFolderId(Long.valueOf(dlfileversionFormData.folderId));
				dlfileversion.setFileEntryId(Long.valueOf(dlfileversionFormData.fileEntryId));
				dlfileversion.setTreePath(dlfileversionFormData.treePath);
				dlfileversion.setFileName(dlfileversionFormData.fileName);
				dlfileversion.setExtension(dlfileversionFormData.extension);
				dlfileversion.setMimeType(dlfileversionFormData.mimeType);
				dlfileversion.setTitle(dlfileversionFormData.title);
				dlfileversion.setDescription(dlfileversionFormData.description);
				dlfileversion.setChangeLog(dlfileversionFormData.changeLog);
				dlfileversion.setExtraSettings(dlfileversionFormData.extraSettings);
				dlfileversion.setFileEntryTypeId(Long.valueOf(dlfileversionFormData.fileEntryTypeId));
				dlfileversion.setVersion(dlfileversionFormData.version);
				dlfileversion.setSize(Long.valueOf(dlfileversionFormData.size));
				dlfileversion.setChecksum(dlfileversionFormData.checksum);
				dlfileversion.setStatus(Integer.valueOf(dlfileversionFormData.status));
				dlfileversion.setStatusByUserId(Long.valueOf(dlfileversionFormData.statusByUserId));
				dlfileversion.setStatusByUserName(dlfileversionFormData.statusByUserName);
				dlfileversion.setStatusDate(new Date(dlfileversionFormData.statusDate));
			}
			else {
				dlfileversion = new Dlfileversion(dlfileversionFormData);
			}

			Ebean.save(dlfileversion);

			flash("success", "Dlfileversion instance created/edited: " + dlfileversion);

			return all();
		}
	}

	public static Result delete(Form<DlfileversionFormData> formData) {
		DlfileversionFormData dlfileversionFormData = formData.get();

		String id = dlfileversionFormData.fileVersionId;

		long dlfileversionId = 0;

		if (id != null) {
			dlfileversionId = Long.valueOf(id);
		}

		Dlfileversion dlfileversion;

		if (dlfileversionId > 0) {
			dlfileversion = Dlfileversion.find.byId(dlfileversionId);

			Ebean.delete(dlfileversion);
		}
		else {
			flash("error", "Cannot delete Dlfileversion");
		}

		return all();
	}

}
