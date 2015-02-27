
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmstructure.DdmstructureFormData;

import models.ddmstructure.Ddmstructure;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmstructure.ddmstructure;
import views.html.ddmstructure.ddmstructures;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmstructureApplication extends Controller {

	public static Result addDdmstructure() {
		Form<DdmstructureFormData> form = Form.form(
			DdmstructureFormData.class).fill(new Ddmstructure().toFormData());

		return ok(ddmstructure.render(form));
	}

	public static Result get(Long id) {
		Ddmstructure dbDdmstructure = Ddmstructure.find.byId(id);

		Form<DdmstructureFormData> form = Form.form(
			DdmstructureFormData.class).fill(dbDdmstructure.toFormData());

		return ok(ddmstructure.render(form));
	}

	public static Result all() {
		List<Ddmstructure> ddmstructureList = Ddmstructure.find.all();

		return ok(ddmstructures.render(ddmstructureList));
	}

	public static Result submit() {
		Form<DdmstructureFormData> formData = Form.form(
			DdmstructureFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmstructureFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmstructure();
		}
		else {
			DdmstructureFormData ddmstructureFormData = formData.get();

			String id = ddmstructureFormData.structureId;

			long ddmstructureId = 0;

			if (id != null) {
				ddmstructureId = Long.valueOf(id);
			}

			Ddmstructure ddmstructure;

			if (ddmstructureId > 0) {
				ddmstructure = Ddmstructure.find.byId(ddmstructureId);

				ddmstructure.setUuid(ddmstructureFormData.uuid);
				ddmstructure.setStructureId(Long.valueOf(ddmstructureFormData.structureId));
				ddmstructure.setGroupId(Long.valueOf(ddmstructureFormData.groupId));
				ddmstructure.setCompanyId(Long.valueOf(ddmstructureFormData.companyId));
				ddmstructure.setUserId(Long.valueOf(ddmstructureFormData.userId));
				ddmstructure.setUserName(ddmstructureFormData.userName);
				ddmstructure.setCreateDate(new Date(ddmstructureFormData.createDate));
				ddmstructure.setModifiedDate(new Date(ddmstructureFormData.modifiedDate));
				ddmstructure.setParentStructureId(Long.valueOf(ddmstructureFormData.parentStructureId));
				ddmstructure.setClassNameId(Long.valueOf(ddmstructureFormData.classNameId));
				ddmstructure.setStructureKey(ddmstructureFormData.structureKey);
				ddmstructure.setVersion(ddmstructureFormData.version);
				ddmstructure.setName(ddmstructureFormData.name);
				ddmstructure.setDescription(ddmstructureFormData.description);
				ddmstructure.setDefinition(ddmstructureFormData.definition);
				ddmstructure.setStorageType(ddmstructureFormData.storageType);
				ddmstructure.setCustomtype(Integer.valueOf(ddmstructureFormData.customtype));
			}
			else {
				ddmstructure = new Ddmstructure(ddmstructureFormData);
			}

			Ebean.save(ddmstructure);

			flash("success", "Ddmstructure instance created/edited: " + ddmstructure);

			return all();
		}
	}

	public static Result delete(Form<DdmstructureFormData> formData) {
		DdmstructureFormData ddmstructureFormData = formData.get();

		String id = ddmstructureFormData.structureId;

		long ddmstructureId = 0;

		if (id != null) {
			ddmstructureId = Long.valueOf(id);
		}

		Ddmstructure ddmstructure;

		if (ddmstructureId > 0) {
			ddmstructure = Ddmstructure.find.byId(ddmstructureId);

			Ebean.delete(ddmstructure);
		}
		else {
			flash("error", "Cannot delete Ddmstructure");
		}

		return all();
	}

}
