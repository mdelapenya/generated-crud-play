
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmstructurelink.DdmstructurelinkFormData;

import models.ddmstructurelink.Ddmstructurelink;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmstructurelink.ddmstructurelink;
import views.html.ddmstructurelink.ddmstructurelinks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmstructurelinkApplication extends Controller {

	public static Result addDdmstructurelink() {
		Form<DdmstructurelinkFormData> form = Form.form(
			DdmstructurelinkFormData.class).fill(new Ddmstructurelink().toFormData());

		return ok(ddmstructurelink.render(form));
	}

	public static Result get(Long id) {
		Ddmstructurelink dbDdmstructurelink = Ddmstructurelink.find.byId(id);

		Form<DdmstructurelinkFormData> form = Form.form(
			DdmstructurelinkFormData.class).fill(dbDdmstructurelink.toFormData());

		return ok(ddmstructurelink.render(form));
	}

	public static Result all() {
		List<Ddmstructurelink> ddmstructurelinkList = Ddmstructurelink.find.all();

		return ok(ddmstructurelinks.render(ddmstructurelinkList));
	}

	public static Result submit() {
		Form<DdmstructurelinkFormData> formData = Form.form(
			DdmstructurelinkFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmstructurelinkFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmstructurelink();
		}
		else {
			DdmstructurelinkFormData ddmstructurelinkFormData = formData.get();

			String id = ddmstructurelinkFormData.structureLinkId;

			long ddmstructurelinkId = 0;

			if (id != null) {
				ddmstructurelinkId = Long.valueOf(id);
			}

			Ddmstructurelink ddmstructurelink;

			if (ddmstructurelinkId > 0) {
				ddmstructurelink = Ddmstructurelink.find.byId(ddmstructurelinkId);

				ddmstructurelink.setStructureLinkId(Long.valueOf(ddmstructurelinkFormData.structureLinkId));
				ddmstructurelink.setClassNameId(Long.valueOf(ddmstructurelinkFormData.classNameId));
				ddmstructurelink.setClassPK(Long.valueOf(ddmstructurelinkFormData.classPK));
				ddmstructurelink.setStructureId(Long.valueOf(ddmstructurelinkFormData.structureId));
			}
			else {
				ddmstructurelink = new Ddmstructurelink(ddmstructurelinkFormData);
			}

			Ebean.save(ddmstructurelink);

			flash("success", "Ddmstructurelink instance created/edited: " + ddmstructurelink);

			return all();
		}
	}

	public static Result delete(Form<DdmstructurelinkFormData> formData) {
		DdmstructurelinkFormData ddmstructurelinkFormData = formData.get();

		String id = ddmstructurelinkFormData.structureLinkId;

		long ddmstructurelinkId = 0;

		if (id != null) {
			ddmstructurelinkId = Long.valueOf(id);
		}

		Ddmstructurelink ddmstructurelink;

		if (ddmstructurelinkId > 0) {
			ddmstructurelink = Ddmstructurelink.find.byId(ddmstructurelinkId);

			Ebean.delete(ddmstructurelink);
		}
		else {
			flash("error", "Cannot delete Ddmstructurelink");
		}

		return all();
	}

}
