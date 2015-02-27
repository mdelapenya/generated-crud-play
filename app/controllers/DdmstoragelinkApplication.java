
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmstoragelink.DdmstoragelinkFormData;

import models.ddmstoragelink.Ddmstoragelink;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmstoragelink.ddmstoragelink;
import views.html.ddmstoragelink.ddmstoragelinks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmstoragelinkApplication extends Controller {

	public static Result addDdmstoragelink() {
		Form<DdmstoragelinkFormData> form = Form.form(
			DdmstoragelinkFormData.class).fill(new Ddmstoragelink().toFormData());

		return ok(ddmstoragelink.render(form));
	}

	public static Result get(Long id) {
		Ddmstoragelink dbDdmstoragelink = Ddmstoragelink.find.byId(id);

		Form<DdmstoragelinkFormData> form = Form.form(
			DdmstoragelinkFormData.class).fill(dbDdmstoragelink.toFormData());

		return ok(ddmstoragelink.render(form));
	}

	public static Result all() {
		List<Ddmstoragelink> ddmstoragelinkList = Ddmstoragelink.find.all();

		return ok(ddmstoragelinks.render(ddmstoragelinkList));
	}

	public static Result submit() {
		Form<DdmstoragelinkFormData> formData = Form.form(
			DdmstoragelinkFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmstoragelinkFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmstoragelink();
		}
		else {
			DdmstoragelinkFormData ddmstoragelinkFormData = formData.get();

			String id = ddmstoragelinkFormData.storageLinkId;

			long ddmstoragelinkId = 0;

			if (id != null) {
				ddmstoragelinkId = Long.valueOf(id);
			}

			Ddmstoragelink ddmstoragelink;

			if (ddmstoragelinkId > 0) {
				ddmstoragelink = Ddmstoragelink.find.byId(ddmstoragelinkId);

				ddmstoragelink.setUuid(ddmstoragelinkFormData.uuid);
				ddmstoragelink.setStorageLinkId(Long.valueOf(ddmstoragelinkFormData.storageLinkId));
				ddmstoragelink.setClassNameId(Long.valueOf(ddmstoragelinkFormData.classNameId));
				ddmstoragelink.setClassPK(Long.valueOf(ddmstoragelinkFormData.classPK));
				ddmstoragelink.setStructureId(Long.valueOf(ddmstoragelinkFormData.structureId));
			}
			else {
				ddmstoragelink = new Ddmstoragelink(ddmstoragelinkFormData);
			}

			Ebean.save(ddmstoragelink);

			flash("success", "Ddmstoragelink instance created/edited: " + ddmstoragelink);

			return all();
		}
	}

	public static Result delete(Form<DdmstoragelinkFormData> formData) {
		DdmstoragelinkFormData ddmstoragelinkFormData = formData.get();

		String id = ddmstoragelinkFormData.storageLinkId;

		long ddmstoragelinkId = 0;

		if (id != null) {
			ddmstoragelinkId = Long.valueOf(id);
		}

		Ddmstoragelink ddmstoragelink;

		if (ddmstoragelinkId > 0) {
			ddmstoragelink = Ddmstoragelink.find.byId(ddmstoragelinkId);

			Ebean.delete(ddmstoragelink);
		}
		else {
			flash("error", "Cannot delete Ddmstoragelink");
		}

		return all();
	}

}
