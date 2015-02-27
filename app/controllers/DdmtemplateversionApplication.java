
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmtemplateversion.DdmtemplateversionFormData;

import models.ddmtemplateversion.Ddmtemplateversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmtemplateversion.ddmtemplateversion;
import views.html.ddmtemplateversion.ddmtemplateversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmtemplateversionApplication extends Controller {

	public static Result addDdmtemplateversion() {
		Form<DdmtemplateversionFormData> form = Form.form(
			DdmtemplateversionFormData.class).fill(new Ddmtemplateversion().toFormData());

		return ok(ddmtemplateversion.render(form));
	}

	public static Result get(Long id) {
		Ddmtemplateversion dbDdmtemplateversion = Ddmtemplateversion.find.byId(id);

		Form<DdmtemplateversionFormData> form = Form.form(
			DdmtemplateversionFormData.class).fill(dbDdmtemplateversion.toFormData());

		return ok(ddmtemplateversion.render(form));
	}

	public static Result all() {
		List<Ddmtemplateversion> ddmtemplateversionList = Ddmtemplateversion.find.all();

		return ok(ddmtemplateversions.render(ddmtemplateversionList));
	}

	public static Result submit() {
		Form<DdmtemplateversionFormData> formData = Form.form(
			DdmtemplateversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmtemplateversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmtemplateversion();
		}
		else {
			DdmtemplateversionFormData ddmtemplateversionFormData = formData.get();

			String id = ddmtemplateversionFormData.templateVersionId;

			long ddmtemplateversionId = 0;

			if (id != null) {
				ddmtemplateversionId = Long.valueOf(id);
			}

			Ddmtemplateversion ddmtemplateversion;

			if (ddmtemplateversionId > 0) {
				ddmtemplateversion = Ddmtemplateversion.find.byId(ddmtemplateversionId);

				ddmtemplateversion.setTemplateVersionId(Long.valueOf(ddmtemplateversionFormData.templateVersionId));
				ddmtemplateversion.setGroupId(Long.valueOf(ddmtemplateversionFormData.groupId));
				ddmtemplateversion.setCompanyId(Long.valueOf(ddmtemplateversionFormData.companyId));
				ddmtemplateversion.setUserId(Long.valueOf(ddmtemplateversionFormData.userId));
				ddmtemplateversion.setUserName(ddmtemplateversionFormData.userName);
				ddmtemplateversion.setCreateDate(new Date(ddmtemplateversionFormData.createDate));
				ddmtemplateversion.setTemplateId(Long.valueOf(ddmtemplateversionFormData.templateId));
				ddmtemplateversion.setVersion(ddmtemplateversionFormData.version);
				ddmtemplateversion.setName(ddmtemplateversionFormData.name);
				ddmtemplateversion.setDescription(ddmtemplateversionFormData.description);
				ddmtemplateversion.setLanguage(ddmtemplateversionFormData.language);
				ddmtemplateversion.setScript(ddmtemplateversionFormData.script);
			}
			else {
				ddmtemplateversion = new Ddmtemplateversion(ddmtemplateversionFormData);
			}

			Ebean.save(ddmtemplateversion);

			flash("success", "Ddmtemplateversion instance created/edited: " + ddmtemplateversion);

			return all();
		}
	}

	public static Result delete(Form<DdmtemplateversionFormData> formData) {
		DdmtemplateversionFormData ddmtemplateversionFormData = formData.get();

		String id = ddmtemplateversionFormData.templateVersionId;

		long ddmtemplateversionId = 0;

		if (id != null) {
			ddmtemplateversionId = Long.valueOf(id);
		}

		Ddmtemplateversion ddmtemplateversion;

		if (ddmtemplateversionId > 0) {
			ddmtemplateversion = Ddmtemplateversion.find.byId(ddmtemplateversionId);

			Ebean.delete(ddmtemplateversion);
		}
		else {
			flash("error", "Cannot delete Ddmtemplateversion");
		}

		return all();
	}

}
