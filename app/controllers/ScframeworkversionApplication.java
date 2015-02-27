
package controllers;

import com.avaje.ebean.Ebean;

import controllers.scframeworkversion.ScframeworkversionFormData;

import models.scframeworkversion.Scframeworkversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.scframeworkversion.scframeworkversion;
import views.html.scframeworkversion.scframeworkversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ScframeworkversionApplication extends Controller {

	public static Result addScframeworkversion() {
		Form<ScframeworkversionFormData> form = Form.form(
			ScframeworkversionFormData.class).fill(new Scframeworkversion().toFormData());

		return ok(scframeworkversion.render(form));
	}

	public static Result get(Long id) {
		Scframeworkversion dbScframeworkversion = Scframeworkversion.find.byId(id);

		Form<ScframeworkversionFormData> form = Form.form(
			ScframeworkversionFormData.class).fill(dbScframeworkversion.toFormData());

		return ok(scframeworkversion.render(form));
	}

	public static Result all() {
		List<Scframeworkversion> scframeworkversionList = Scframeworkversion.find.all();

		return ok(scframeworkversions.render(scframeworkversionList));
	}

	public static Result submit() {
		Form<ScframeworkversionFormData> formData = Form.form(
			ScframeworkversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ScframeworkversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addScframeworkversion();
		}
		else {
			ScframeworkversionFormData scframeworkversionFormData = formData.get();

			String id = scframeworkversionFormData.frameworkVersionId;

			long scframeworkversionId = 0;

			if (id != null) {
				scframeworkversionId = Long.valueOf(id);
			}

			Scframeworkversion scframeworkversion;

			if (scframeworkversionId > 0) {
				scframeworkversion = Scframeworkversion.find.byId(scframeworkversionId);

				scframeworkversion.setFrameworkVersionId(Long.valueOf(scframeworkversionFormData.frameworkVersionId));
				scframeworkversion.setGroupId(Long.valueOf(scframeworkversionFormData.groupId));
				scframeworkversion.setCompanyId(Long.valueOf(scframeworkversionFormData.companyId));
				scframeworkversion.setUserId(Long.valueOf(scframeworkversionFormData.userId));
				scframeworkversion.setUserName(scframeworkversionFormData.userName);
				scframeworkversion.setCreateDate(new Date(scframeworkversionFormData.createDate));
				scframeworkversion.setModifiedDate(new Date(scframeworkversionFormData.modifiedDate));
				scframeworkversion.setName(scframeworkversionFormData.name);
				scframeworkversion.setUrl(scframeworkversionFormData.url);
				scframeworkversion.setActive(Boolean.valueOf(scframeworkversionFormData.active));
				scframeworkversion.setPriority(Integer.valueOf(scframeworkversionFormData.priority));
			}
			else {
				scframeworkversion = new Scframeworkversion(scframeworkversionFormData);
			}

			Ebean.save(scframeworkversion);

			flash("success", "Scframeworkversion instance created/edited: " + scframeworkversion);

			return all();
		}
	}

	public static Result delete(Form<ScframeworkversionFormData> formData) {
		ScframeworkversionFormData scframeworkversionFormData = formData.get();

		String id = scframeworkversionFormData.frameworkVersionId;

		long scframeworkversionId = 0;

		if (id != null) {
			scframeworkversionId = Long.valueOf(id);
		}

		Scframeworkversion scframeworkversion;

		if (scframeworkversionId > 0) {
			scframeworkversion = Scframeworkversion.find.byId(scframeworkversionId);

			Ebean.delete(scframeworkversion);
		}
		else {
			flash("error", "Cannot delete Scframeworkversion");
		}

		return all();
	}

}
