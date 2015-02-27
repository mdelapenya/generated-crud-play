
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmtemplate.DdmtemplateFormData;

import models.ddmtemplate.Ddmtemplate;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmtemplate.ddmtemplate;
import views.html.ddmtemplate.ddmtemplates;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmtemplateApplication extends Controller {

	public static Result addDdmtemplate() {
		Form<DdmtemplateFormData> form = Form.form(
			DdmtemplateFormData.class).fill(new Ddmtemplate().toFormData());

		return ok(ddmtemplate.render(form));
	}

	public static Result get(Long id) {
		Ddmtemplate dbDdmtemplate = Ddmtemplate.find.byId(id);

		Form<DdmtemplateFormData> form = Form.form(
			DdmtemplateFormData.class).fill(dbDdmtemplate.toFormData());

		return ok(ddmtemplate.render(form));
	}

	public static Result all() {
		List<Ddmtemplate> ddmtemplateList = Ddmtemplate.find.all();

		return ok(ddmtemplates.render(ddmtemplateList));
	}

	public static Result submit() {
		Form<DdmtemplateFormData> formData = Form.form(
			DdmtemplateFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmtemplateFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmtemplate();
		}
		else {
			DdmtemplateFormData ddmtemplateFormData = formData.get();

			String id = ddmtemplateFormData.templateId;

			long ddmtemplateId = 0;

			if (id != null) {
				ddmtemplateId = Long.valueOf(id);
			}

			Ddmtemplate ddmtemplate;

			if (ddmtemplateId > 0) {
				ddmtemplate = Ddmtemplate.find.byId(ddmtemplateId);

				ddmtemplate.setUuid(ddmtemplateFormData.uuid);
				ddmtemplate.setTemplateId(Long.valueOf(ddmtemplateFormData.templateId));
				ddmtemplate.setGroupId(Long.valueOf(ddmtemplateFormData.groupId));
				ddmtemplate.setCompanyId(Long.valueOf(ddmtemplateFormData.companyId));
				ddmtemplate.setUserId(Long.valueOf(ddmtemplateFormData.userId));
				ddmtemplate.setUserName(ddmtemplateFormData.userName);
				ddmtemplate.setCreateDate(new Date(ddmtemplateFormData.createDate));
				ddmtemplate.setModifiedDate(new Date(ddmtemplateFormData.modifiedDate));
				ddmtemplate.setClassNameId(Long.valueOf(ddmtemplateFormData.classNameId));
				ddmtemplate.setClassPK(Long.valueOf(ddmtemplateFormData.classPK));
				ddmtemplate.setSourceClassNameId(Long.valueOf(ddmtemplateFormData.sourceClassNameId));
				ddmtemplate.setTemplateKey(ddmtemplateFormData.templateKey);
				ddmtemplate.setVersion(ddmtemplateFormData.version);
				ddmtemplate.setName(ddmtemplateFormData.name);
				ddmtemplate.setDescription(ddmtemplateFormData.description);
				ddmtemplate.setCustomtype(ddmtemplateFormData.customtype);
				ddmtemplate.setMode(ddmtemplateFormData.mode);
				ddmtemplate.setLanguage(ddmtemplateFormData.language);
				ddmtemplate.setScript(ddmtemplateFormData.script);
				ddmtemplate.setCacheable(Boolean.valueOf(ddmtemplateFormData.cacheable));
				ddmtemplate.setSmallImage(Boolean.valueOf(ddmtemplateFormData.smallImage));
				ddmtemplate.setSmallImageId(Long.valueOf(ddmtemplateFormData.smallImageId));
				ddmtemplate.setSmallImageURL(ddmtemplateFormData.smallImageURL);
			}
			else {
				ddmtemplate = new Ddmtemplate(ddmtemplateFormData);
			}

			Ebean.save(ddmtemplate);

			flash("success", "Ddmtemplate instance created/edited: " + ddmtemplate);

			return all();
		}
	}

	public static Result delete(Form<DdmtemplateFormData> formData) {
		DdmtemplateFormData ddmtemplateFormData = formData.get();

		String id = ddmtemplateFormData.templateId;

		long ddmtemplateId = 0;

		if (id != null) {
			ddmtemplateId = Long.valueOf(id);
		}

		Ddmtemplate ddmtemplate;

		if (ddmtemplateId > 0) {
			ddmtemplate = Ddmtemplate.find.byId(ddmtemplateId);

			Ebean.delete(ddmtemplate);
		}
		else {
			flash("error", "Cannot delete Ddmtemplate");
		}

		return all();
	}

}
