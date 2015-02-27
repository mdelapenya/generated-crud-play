
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfileentrymetadata.DlfileentrymetadataFormData;

import models.dlfileentrymetadata.Dlfileentrymetadata;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfileentrymetadata.dlfileentrymetadata;
import views.html.dlfileentrymetadata.dlfileentrymetadatas;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileentrymetadataApplication extends Controller {

	public static Result addDlfileentrymetadata() {
		Form<DlfileentrymetadataFormData> form = Form.form(
			DlfileentrymetadataFormData.class).fill(new Dlfileentrymetadata().toFormData());

		return ok(dlfileentrymetadata.render(form));
	}

	public static Result get(Long id) {
		Dlfileentrymetadata dbDlfileentrymetadata = Dlfileentrymetadata.find.byId(id);

		Form<DlfileentrymetadataFormData> form = Form.form(
			DlfileentrymetadataFormData.class).fill(dbDlfileentrymetadata.toFormData());

		return ok(dlfileentrymetadata.render(form));
	}

	public static Result all() {
		List<Dlfileentrymetadata> dlfileentrymetadataList = Dlfileentrymetadata.find.all();

		return ok(dlfileentrymetadatas.render(dlfileentrymetadataList));
	}

	public static Result submit() {
		Form<DlfileentrymetadataFormData> formData = Form.form(
			DlfileentrymetadataFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfileentrymetadataFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfileentrymetadata();
		}
		else {
			DlfileentrymetadataFormData dlfileentrymetadataFormData = formData.get();

			String id = dlfileentrymetadataFormData.fileEntryMetadataId;

			long dlfileentrymetadataId = 0;

			if (id != null) {
				dlfileentrymetadataId = Long.valueOf(id);
			}

			Dlfileentrymetadata dlfileentrymetadata;

			if (dlfileentrymetadataId > 0) {
				dlfileentrymetadata = Dlfileentrymetadata.find.byId(dlfileentrymetadataId);

				dlfileentrymetadata.setUuid(dlfileentrymetadataFormData.uuid);
				dlfileentrymetadata.setFileEntryMetadataId(Long.valueOf(dlfileentrymetadataFormData.fileEntryMetadataId));
				dlfileentrymetadata.setDDMStorageId(Long.valueOf(dlfileentrymetadataFormData.DDMStorageId));
				dlfileentrymetadata.setDDMStructureId(Long.valueOf(dlfileentrymetadataFormData.DDMStructureId));
				dlfileentrymetadata.setFileEntryTypeId(Long.valueOf(dlfileentrymetadataFormData.fileEntryTypeId));
				dlfileentrymetadata.setFileEntryId(Long.valueOf(dlfileentrymetadataFormData.fileEntryId));
				dlfileentrymetadata.setFileVersionId(Long.valueOf(dlfileentrymetadataFormData.fileVersionId));
			}
			else {
				dlfileentrymetadata = new Dlfileentrymetadata(dlfileentrymetadataFormData);
			}

			Ebean.save(dlfileentrymetadata);

			flash("success", "Dlfileentrymetadata instance created/edited: " + dlfileentrymetadata);

			return all();
		}
	}

	public static Result delete(Form<DlfileentrymetadataFormData> formData) {
		DlfileentrymetadataFormData dlfileentrymetadataFormData = formData.get();

		String id = dlfileentrymetadataFormData.fileEntryMetadataId;

		long dlfileentrymetadataId = 0;

		if (id != null) {
			dlfileentrymetadataId = Long.valueOf(id);
		}

		Dlfileentrymetadata dlfileentrymetadata;

		if (dlfileentrymetadataId > 0) {
			dlfileentrymetadata = Dlfileentrymetadata.find.byId(dlfileentrymetadataId);

			Ebean.delete(dlfileentrymetadata);
		}
		else {
			flash("error", "Cannot delete Dlfileentrymetadata");
		}

		return all();
	}

}
