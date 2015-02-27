
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutset.LayoutsetFormData;

import models.layoutset.Layoutset;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutset.layoutset;
import views.html.layoutset.layoutsets;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutsetApplication extends Controller {

	public static Result addLayoutset() {
		Form<LayoutsetFormData> form = Form.form(
			LayoutsetFormData.class).fill(new Layoutset().toFormData());

		return ok(layoutset.render(form));
	}

	public static Result get(Long id) {
		Layoutset dbLayoutset = Layoutset.find.byId(id);

		Form<LayoutsetFormData> form = Form.form(
			LayoutsetFormData.class).fill(dbLayoutset.toFormData());

		return ok(layoutset.render(form));
	}

	public static Result all() {
		List<Layoutset> layoutsetList = Layoutset.find.all();

		return ok(layoutsets.render(layoutsetList));
	}

	public static Result submit() {
		Form<LayoutsetFormData> formData = Form.form(
			LayoutsetFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutsetFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutset();
		}
		else {
			LayoutsetFormData layoutsetFormData = formData.get();

			String id = layoutsetFormData.layoutSetId;

			long layoutsetId = 0;

			if (id != null) {
				layoutsetId = Long.valueOf(id);
			}

			Layoutset layoutset;

			if (layoutsetId > 0) {
				layoutset = Layoutset.find.byId(layoutsetId);

				layoutset.setMvccVersion(Long.valueOf(layoutsetFormData.mvccVersion));
				layoutset.setLayoutSetId(Long.valueOf(layoutsetFormData.layoutSetId));
				layoutset.setGroupId(Long.valueOf(layoutsetFormData.groupId));
				layoutset.setCompanyId(Long.valueOf(layoutsetFormData.companyId));
				layoutset.setCreateDate(new Date(layoutsetFormData.createDate));
				layoutset.setModifiedDate(new Date(layoutsetFormData.modifiedDate));
				layoutset.setPrivateLayout(Boolean.valueOf(layoutsetFormData.privateLayout));
				layoutset.setLogoId(Long.valueOf(layoutsetFormData.logoId));
				layoutset.setThemeId(layoutsetFormData.themeId);
				layoutset.setColorSchemeId(layoutsetFormData.colorSchemeId);
				layoutset.setWapThemeId(layoutsetFormData.wapThemeId);
				layoutset.setWapColorSchemeId(layoutsetFormData.wapColorSchemeId);
				layoutset.setCss(layoutsetFormData.css);
				layoutset.setPageCount(Integer.valueOf(layoutsetFormData.pageCount));
				layoutset.setSettings(layoutsetFormData.settings);
				layoutset.setLayoutSetPrototypeUuid(layoutsetFormData.layoutSetPrototypeUuid);
				layoutset.setLayoutSetPrototypeLinkEnabled(Boolean.valueOf(layoutsetFormData.layoutSetPrototypeLinkEnabled));
			}
			else {
				layoutset = new Layoutset(layoutsetFormData);
			}

			Ebean.save(layoutset);

			flash("success", "Layoutset instance created/edited: " + layoutset);

			return all();
		}
	}

	public static Result delete(Form<LayoutsetFormData> formData) {
		LayoutsetFormData layoutsetFormData = formData.get();

		String id = layoutsetFormData.layoutSetId;

		long layoutsetId = 0;

		if (id != null) {
			layoutsetId = Long.valueOf(id);
		}

		Layoutset layoutset;

		if (layoutsetId > 0) {
			layoutset = Layoutset.find.byId(layoutsetId);

			Ebean.delete(layoutset);
		}
		else {
			flash("error", "Cannot delete Layoutset");
		}

		return all();
	}

}
