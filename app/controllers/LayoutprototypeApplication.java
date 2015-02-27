
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutprototype.LayoutprototypeFormData;

import models.layoutprototype.Layoutprototype;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutprototype.layoutprototype;
import views.html.layoutprototype.layoutprototypes;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutprototypeApplication extends Controller {

	public static Result addLayoutprototype() {
		Form<LayoutprototypeFormData> form = Form.form(
			LayoutprototypeFormData.class).fill(new Layoutprototype().toFormData());

		return ok(layoutprototype.render(form));
	}

	public static Result get(Long id) {
		Layoutprototype dbLayoutprototype = Layoutprototype.find.byId(id);

		Form<LayoutprototypeFormData> form = Form.form(
			LayoutprototypeFormData.class).fill(dbLayoutprototype.toFormData());

		return ok(layoutprototype.render(form));
	}

	public static Result all() {
		List<Layoutprototype> layoutprototypeList = Layoutprototype.find.all();

		return ok(layoutprototypes.render(layoutprototypeList));
	}

	public static Result submit() {
		Form<LayoutprototypeFormData> formData = Form.form(
			LayoutprototypeFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutprototypeFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutprototype();
		}
		else {
			LayoutprototypeFormData layoutprototypeFormData = formData.get();

			String id = layoutprototypeFormData.layoutPrototypeId;

			long layoutprototypeId = 0;

			if (id != null) {
				layoutprototypeId = Long.valueOf(id);
			}

			Layoutprototype layoutprototype;

			if (layoutprototypeId > 0) {
				layoutprototype = Layoutprototype.find.byId(layoutprototypeId);

				layoutprototype.setMvccVersion(Long.valueOf(layoutprototypeFormData.mvccVersion));
				layoutprototype.setUuid(layoutprototypeFormData.uuid);
				layoutprototype.setLayoutPrototypeId(Long.valueOf(layoutprototypeFormData.layoutPrototypeId));
				layoutprototype.setCompanyId(Long.valueOf(layoutprototypeFormData.companyId));
				layoutprototype.setUserId(Long.valueOf(layoutprototypeFormData.userId));
				layoutprototype.setUserName(layoutprototypeFormData.userName);
				layoutprototype.setCreateDate(new Date(layoutprototypeFormData.createDate));
				layoutprototype.setModifiedDate(new Date(layoutprototypeFormData.modifiedDate));
				layoutprototype.setName(layoutprototypeFormData.name);
				layoutprototype.setDescription(layoutprototypeFormData.description);
				layoutprototype.setSettings(layoutprototypeFormData.settings);
				layoutprototype.setActive(Boolean.valueOf(layoutprototypeFormData.active));
			}
			else {
				layoutprototype = new Layoutprototype(layoutprototypeFormData);
			}

			Ebean.save(layoutprototype);

			flash("success", "Layoutprototype instance created/edited: " + layoutprototype);

			return all();
		}
	}

	public static Result delete(Form<LayoutprototypeFormData> formData) {
		LayoutprototypeFormData layoutprototypeFormData = formData.get();

		String id = layoutprototypeFormData.layoutPrototypeId;

		long layoutprototypeId = 0;

		if (id != null) {
			layoutprototypeId = Long.valueOf(id);
		}

		Layoutprototype layoutprototype;

		if (layoutprototypeId > 0) {
			layoutprototype = Layoutprototype.find.byId(layoutprototypeId);

			Ebean.delete(layoutprototype);
		}
		else {
			flash("error", "Cannot delete Layoutprototype");
		}

		return all();
	}

}
