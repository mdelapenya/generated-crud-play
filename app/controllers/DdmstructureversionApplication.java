
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmstructureversion.DdmstructureversionFormData;

import models.ddmstructureversion.Ddmstructureversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmstructureversion.ddmstructureversion;
import views.html.ddmstructureversion.ddmstructureversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmstructureversionApplication extends Controller {

	public static Result addDdmstructureversion() {
		Form<DdmstructureversionFormData> form = Form.form(
			DdmstructureversionFormData.class).fill(new Ddmstructureversion().toFormData());

		return ok(ddmstructureversion.render(form));
	}

	public static Result get(Long id) {
		Ddmstructureversion dbDdmstructureversion = Ddmstructureversion.find.byId(id);

		Form<DdmstructureversionFormData> form = Form.form(
			DdmstructureversionFormData.class).fill(dbDdmstructureversion.toFormData());

		return ok(ddmstructureversion.render(form));
	}

	public static Result all() {
		List<Ddmstructureversion> ddmstructureversionList = Ddmstructureversion.find.all();

		return ok(ddmstructureversions.render(ddmstructureversionList));
	}

	public static Result submit() {
		Form<DdmstructureversionFormData> formData = Form.form(
			DdmstructureversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmstructureversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmstructureversion();
		}
		else {
			DdmstructureversionFormData ddmstructureversionFormData = formData.get();

			String id = ddmstructureversionFormData.structureVersionId;

			long ddmstructureversionId = 0;

			if (id != null) {
				ddmstructureversionId = Long.valueOf(id);
			}

			Ddmstructureversion ddmstructureversion;

			if (ddmstructureversionId > 0) {
				ddmstructureversion = Ddmstructureversion.find.byId(ddmstructureversionId);

				ddmstructureversion.setStructureVersionId(Long.valueOf(ddmstructureversionFormData.structureVersionId));
				ddmstructureversion.setGroupId(Long.valueOf(ddmstructureversionFormData.groupId));
				ddmstructureversion.setCompanyId(Long.valueOf(ddmstructureversionFormData.companyId));
				ddmstructureversion.setUserId(Long.valueOf(ddmstructureversionFormData.userId));
				ddmstructureversion.setUserName(ddmstructureversionFormData.userName);
				ddmstructureversion.setCreateDate(new Date(ddmstructureversionFormData.createDate));
				ddmstructureversion.setStructureId(Long.valueOf(ddmstructureversionFormData.structureId));
				ddmstructureversion.setVersion(ddmstructureversionFormData.version);
				ddmstructureversion.setName(ddmstructureversionFormData.name);
				ddmstructureversion.setDescription(ddmstructureversionFormData.description);
				ddmstructureversion.setDefinition(ddmstructureversionFormData.definition);
				ddmstructureversion.setStorageType(ddmstructureversionFormData.storageType);
				ddmstructureversion.setCustomtype(Integer.valueOf(ddmstructureversionFormData.customtype));
			}
			else {
				ddmstructureversion = new Ddmstructureversion(ddmstructureversionFormData);
			}

			Ebean.save(ddmstructureversion);

			flash("success", "Ddmstructureversion instance created/edited: " + ddmstructureversion);

			return all();
		}
	}

	public static Result delete(Form<DdmstructureversionFormData> formData) {
		DdmstructureversionFormData ddmstructureversionFormData = formData.get();

		String id = ddmstructureversionFormData.structureVersionId;

		long ddmstructureversionId = 0;

		if (id != null) {
			ddmstructureversionId = Long.valueOf(id);
		}

		Ddmstructureversion ddmstructureversion;

		if (ddmstructureversionId > 0) {
			ddmstructureversion = Ddmstructureversion.find.byId(ddmstructureversionId);

			Ebean.delete(ddmstructureversion);
		}
		else {
			flash("error", "Cannot delete Ddmstructureversion");
		}

		return all();
	}

}
