
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutsetbranch.LayoutsetbranchFormData;

import models.layoutsetbranch.Layoutsetbranch;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutsetbranch.layoutsetbranch;
import views.html.layoutsetbranch.layoutsetbranchs;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutsetbranchApplication extends Controller {

	public static Result addLayoutsetbranch() {
		Form<LayoutsetbranchFormData> form = Form.form(
			LayoutsetbranchFormData.class).fill(new Layoutsetbranch().toFormData());

		return ok(layoutsetbranch.render(form));
	}

	public static Result get(Long id) {
		Layoutsetbranch dbLayoutsetbranch = Layoutsetbranch.find.byId(id);

		Form<LayoutsetbranchFormData> form = Form.form(
			LayoutsetbranchFormData.class).fill(dbLayoutsetbranch.toFormData());

		return ok(layoutsetbranch.render(form));
	}

	public static Result all() {
		List<Layoutsetbranch> layoutsetbranchList = Layoutsetbranch.find.all();

		return ok(layoutsetbranchs.render(layoutsetbranchList));
	}

	public static Result submit() {
		Form<LayoutsetbranchFormData> formData = Form.form(
			LayoutsetbranchFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutsetbranchFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutsetbranch();
		}
		else {
			LayoutsetbranchFormData layoutsetbranchFormData = formData.get();

			String id = layoutsetbranchFormData.layoutSetBranchId;

			long layoutsetbranchId = 0;

			if (id != null) {
				layoutsetbranchId = Long.valueOf(id);
			}

			Layoutsetbranch layoutsetbranch;

			if (layoutsetbranchId > 0) {
				layoutsetbranch = Layoutsetbranch.find.byId(layoutsetbranchId);

				layoutsetbranch.setMvccVersion(Long.valueOf(layoutsetbranchFormData.mvccVersion));
				layoutsetbranch.setLayoutSetBranchId(Long.valueOf(layoutsetbranchFormData.layoutSetBranchId));
				layoutsetbranch.setGroupId(Long.valueOf(layoutsetbranchFormData.groupId));
				layoutsetbranch.setCompanyId(Long.valueOf(layoutsetbranchFormData.companyId));
				layoutsetbranch.setUserId(Long.valueOf(layoutsetbranchFormData.userId));
				layoutsetbranch.setUserName(layoutsetbranchFormData.userName);
				layoutsetbranch.setCreateDate(new Date(layoutsetbranchFormData.createDate));
				layoutsetbranch.setModifiedDate(new Date(layoutsetbranchFormData.modifiedDate));
				layoutsetbranch.setPrivateLayout(Boolean.valueOf(layoutsetbranchFormData.privateLayout));
				layoutsetbranch.setName(layoutsetbranchFormData.name);
				layoutsetbranch.setDescription(layoutsetbranchFormData.description);
				layoutsetbranch.setMaster(Boolean.valueOf(layoutsetbranchFormData.master));
				layoutsetbranch.setLogoId(Long.valueOf(layoutsetbranchFormData.logoId));
				layoutsetbranch.setThemeId(layoutsetbranchFormData.themeId);
				layoutsetbranch.setColorSchemeId(layoutsetbranchFormData.colorSchemeId);
				layoutsetbranch.setWapThemeId(layoutsetbranchFormData.wapThemeId);
				layoutsetbranch.setWapColorSchemeId(layoutsetbranchFormData.wapColorSchemeId);
				layoutsetbranch.setCss(layoutsetbranchFormData.css);
				layoutsetbranch.setSettings(layoutsetbranchFormData.settings);
				layoutsetbranch.setLayoutSetPrototypeUuid(layoutsetbranchFormData.layoutSetPrototypeUuid);
				layoutsetbranch.setLayoutSetPrototypeLinkEnabled(Boolean.valueOf(layoutsetbranchFormData.layoutSetPrototypeLinkEnabled));
			}
			else {
				layoutsetbranch = new Layoutsetbranch(layoutsetbranchFormData);
			}

			Ebean.save(layoutsetbranch);

			flash("success", "Layoutsetbranch instance created/edited: " + layoutsetbranch);

			return all();
		}
	}

	public static Result delete(Form<LayoutsetbranchFormData> formData) {
		LayoutsetbranchFormData layoutsetbranchFormData = formData.get();

		String id = layoutsetbranchFormData.layoutSetBranchId;

		long layoutsetbranchId = 0;

		if (id != null) {
			layoutsetbranchId = Long.valueOf(id);
		}

		Layoutsetbranch layoutsetbranch;

		if (layoutsetbranchId > 0) {
			layoutsetbranch = Layoutsetbranch.find.byId(layoutsetbranchId);

			Ebean.delete(layoutsetbranch);
		}
		else {
			flash("error", "Cannot delete Layoutsetbranch");
		}

		return all();
	}

}
