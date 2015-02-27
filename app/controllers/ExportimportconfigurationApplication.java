
package controllers;

import com.avaje.ebean.Ebean;

import controllers.exportimportconfiguration.ExportimportconfigurationFormData;

import models.exportimportconfiguration.Exportimportconfiguration;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.exportimportconfiguration.exportimportconfiguration;
import views.html.exportimportconfiguration.exportimportconfigurations;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ExportimportconfigurationApplication extends Controller {

	public static Result addExportimportconfiguration() {
		Form<ExportimportconfigurationFormData> form = Form.form(
			ExportimportconfigurationFormData.class).fill(new Exportimportconfiguration().toFormData());

		return ok(exportimportconfiguration.render(form));
	}

	public static Result get(Long id) {
		Exportimportconfiguration dbExportimportconfiguration = Exportimportconfiguration.find.byId(id);

		Form<ExportimportconfigurationFormData> form = Form.form(
			ExportimportconfigurationFormData.class).fill(dbExportimportconfiguration.toFormData());

		return ok(exportimportconfiguration.render(form));
	}

	public static Result all() {
		List<Exportimportconfiguration> exportimportconfigurationList = Exportimportconfiguration.find.all();

		return ok(exportimportconfigurations.render(exportimportconfigurationList));
	}

	public static Result submit() {
		Form<ExportimportconfigurationFormData> formData = Form.form(
			ExportimportconfigurationFormData.class).bindFromRequest();

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

	public static Result edit(Form<ExportimportconfigurationFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addExportimportconfiguration();
		}
		else {
			ExportimportconfigurationFormData exportimportconfigurationFormData = formData.get();

			String id = exportimportconfigurationFormData.exportImportConfigurationId;

			long exportimportconfigurationId = 0;

			if (id != null) {
				exportimportconfigurationId = Long.valueOf(id);
			}

			Exportimportconfiguration exportimportconfiguration;

			if (exportimportconfigurationId > 0) {
				exportimportconfiguration = Exportimportconfiguration.find.byId(exportimportconfigurationId);

				exportimportconfiguration.setMvccVersion(Long.valueOf(exportimportconfigurationFormData.mvccVersion));
				exportimportconfiguration.setExportImportConfigurationId(Long.valueOf(exportimportconfigurationFormData.exportImportConfigurationId));
				exportimportconfiguration.setGroupId(Long.valueOf(exportimportconfigurationFormData.groupId));
				exportimportconfiguration.setCompanyId(Long.valueOf(exportimportconfigurationFormData.companyId));
				exportimportconfiguration.setUserId(Long.valueOf(exportimportconfigurationFormData.userId));
				exportimportconfiguration.setUserName(exportimportconfigurationFormData.userName);
				exportimportconfiguration.setCreateDate(new Date(exportimportconfigurationFormData.createDate));
				exportimportconfiguration.setModifiedDate(new Date(exportimportconfigurationFormData.modifiedDate));
				exportimportconfiguration.setName(exportimportconfigurationFormData.name);
				exportimportconfiguration.setDescription(exportimportconfigurationFormData.description);
				exportimportconfiguration.setCustomtype(Integer.valueOf(exportimportconfigurationFormData.customtype));
				exportimportconfiguration.setSettings(exportimportconfigurationFormData.settings);
				exportimportconfiguration.setStatus(Integer.valueOf(exportimportconfigurationFormData.status));
				exportimportconfiguration.setStatusByUserId(Long.valueOf(exportimportconfigurationFormData.statusByUserId));
				exportimportconfiguration.setStatusByUserName(exportimportconfigurationFormData.statusByUserName);
				exportimportconfiguration.setStatusDate(new Date(exportimportconfigurationFormData.statusDate));
			}
			else {
				exportimportconfiguration = new Exportimportconfiguration(exportimportconfigurationFormData);
			}

			Ebean.save(exportimportconfiguration);

			flash("success", "Exportimportconfiguration instance created/edited: " + exportimportconfiguration);

			return all();
		}
	}

	public static Result delete(Form<ExportimportconfigurationFormData> formData) {
		ExportimportconfigurationFormData exportimportconfigurationFormData = formData.get();

		String id = exportimportconfigurationFormData.exportImportConfigurationId;

		long exportimportconfigurationId = 0;

		if (id != null) {
			exportimportconfigurationId = Long.valueOf(id);
		}

		Exportimportconfiguration exportimportconfiguration;

		if (exportimportconfigurationId > 0) {
			exportimportconfiguration = Exportimportconfiguration.find.byId(exportimportconfigurationId);

			Ebean.delete(exportimportconfiguration);
		}
		else {
			flash("error", "Cannot delete Exportimportconfiguration");
		}

		return all();
	}

}
