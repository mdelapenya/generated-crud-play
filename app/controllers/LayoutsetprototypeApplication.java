
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutsetprototype.LayoutsetprototypeFormData;

import models.layoutsetprototype.Layoutsetprototype;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutsetprototype.layoutsetprototype;
import views.html.layoutsetprototype.layoutsetprototypes;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutsetprototypeApplication extends Controller {

	public static Result addLayoutsetprototype() {
		Form<LayoutsetprototypeFormData> form = Form.form(
			LayoutsetprototypeFormData.class).fill(new Layoutsetprototype().toFormData());

		return ok(layoutsetprototype.render(form));
	}

	public static Result get(Long id) {
		Layoutsetprototype dbLayoutsetprototype = Layoutsetprototype.find.byId(id);

		Form<LayoutsetprototypeFormData> form = Form.form(
			LayoutsetprototypeFormData.class).fill(dbLayoutsetprototype.toFormData());

		return ok(layoutsetprototype.render(form));
	}

	public static Result all() {
		List<Layoutsetprototype> layoutsetprototypeList = Layoutsetprototype.find.all();

		return ok(layoutsetprototypes.render(layoutsetprototypeList));
	}

	public static Result submit() {
		Form<LayoutsetprototypeFormData> formData = Form.form(
			LayoutsetprototypeFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutsetprototypeFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutsetprototype();
		}
		else {
			LayoutsetprototypeFormData layoutsetprototypeFormData = formData.get();

			String id = layoutsetprototypeFormData.layoutSetPrototypeId;

			long layoutsetprototypeId = 0;

			if (id != null) {
				layoutsetprototypeId = Long.valueOf(id);
			}

			Layoutsetprototype layoutsetprototype;

			if (layoutsetprototypeId > 0) {
				layoutsetprototype = Layoutsetprototype.find.byId(layoutsetprototypeId);

				layoutsetprototype.setMvccVersion(Long.valueOf(layoutsetprototypeFormData.mvccVersion));
				layoutsetprototype.setUuid(layoutsetprototypeFormData.uuid);
				layoutsetprototype.setLayoutSetPrototypeId(Long.valueOf(layoutsetprototypeFormData.layoutSetPrototypeId));
				layoutsetprototype.setCompanyId(Long.valueOf(layoutsetprototypeFormData.companyId));
				layoutsetprototype.setUserId(Long.valueOf(layoutsetprototypeFormData.userId));
				layoutsetprototype.setUserName(layoutsetprototypeFormData.userName);
				layoutsetprototype.setCreateDate(new Date(layoutsetprototypeFormData.createDate));
				layoutsetprototype.setModifiedDate(new Date(layoutsetprototypeFormData.modifiedDate));
				layoutsetprototype.setName(layoutsetprototypeFormData.name);
				layoutsetprototype.setDescription(layoutsetprototypeFormData.description);
				layoutsetprototype.setSettings(layoutsetprototypeFormData.settings);
				layoutsetprototype.setActive(Boolean.valueOf(layoutsetprototypeFormData.active));
			}
			else {
				layoutsetprototype = new Layoutsetprototype(layoutsetprototypeFormData);
			}

			Ebean.save(layoutsetprototype);

			flash("success", "Layoutsetprototype instance created/edited: " + layoutsetprototype);

			return all();
		}
	}

	public static Result delete(Form<LayoutsetprototypeFormData> formData) {
		LayoutsetprototypeFormData layoutsetprototypeFormData = formData.get();

		String id = layoutsetprototypeFormData.layoutSetPrototypeId;

		long layoutsetprototypeId = 0;

		if (id != null) {
			layoutsetprototypeId = Long.valueOf(id);
		}

		Layoutsetprototype layoutsetprototype;

		if (layoutsetprototypeId > 0) {
			layoutsetprototype = Layoutsetprototype.find.byId(layoutsetprototypeId);

			Ebean.delete(layoutsetprototype);
		}
		else {
			flash("error", "Cannot delete Layoutsetprototype");
		}

		return all();
	}

}
