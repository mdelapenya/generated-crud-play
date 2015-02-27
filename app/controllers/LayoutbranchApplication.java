
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutbranch.LayoutbranchFormData;

import models.layoutbranch.Layoutbranch;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutbranch.layoutbranch;
import views.html.layoutbranch.layoutbranchs;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutbranchApplication extends Controller {

	public static Result addLayoutbranch() {
		Form<LayoutbranchFormData> form = Form.form(
			LayoutbranchFormData.class).fill(new Layoutbranch().toFormData());

		return ok(layoutbranch.render(form));
	}

	public static Result get(Long id) {
		Layoutbranch dbLayoutbranch = Layoutbranch.find.byId(id);

		Form<LayoutbranchFormData> form = Form.form(
			LayoutbranchFormData.class).fill(dbLayoutbranch.toFormData());

		return ok(layoutbranch.render(form));
	}

	public static Result all() {
		List<Layoutbranch> layoutbranchList = Layoutbranch.find.all();

		return ok(layoutbranchs.render(layoutbranchList));
	}

	public static Result submit() {
		Form<LayoutbranchFormData> formData = Form.form(
			LayoutbranchFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutbranchFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutbranch();
		}
		else {
			LayoutbranchFormData layoutbranchFormData = formData.get();

			String id = layoutbranchFormData.layoutBranchId;

			long layoutbranchId = 0;

			if (id != null) {
				layoutbranchId = Long.valueOf(id);
			}

			Layoutbranch layoutbranch;

			if (layoutbranchId > 0) {
				layoutbranch = Layoutbranch.find.byId(layoutbranchId);

				layoutbranch.setMvccVersion(Long.valueOf(layoutbranchFormData.mvccVersion));
				layoutbranch.setLayoutBranchId(Long.valueOf(layoutbranchFormData.layoutBranchId));
				layoutbranch.setGroupId(Long.valueOf(layoutbranchFormData.groupId));
				layoutbranch.setCompanyId(Long.valueOf(layoutbranchFormData.companyId));
				layoutbranch.setUserId(Long.valueOf(layoutbranchFormData.userId));
				layoutbranch.setUserName(layoutbranchFormData.userName);
				layoutbranch.setLayoutSetBranchId(Long.valueOf(layoutbranchFormData.layoutSetBranchId));
				layoutbranch.setPlid(Long.valueOf(layoutbranchFormData.plid));
				layoutbranch.setName(layoutbranchFormData.name);
				layoutbranch.setDescription(layoutbranchFormData.description);
				layoutbranch.setMaster(Boolean.valueOf(layoutbranchFormData.master));
			}
			else {
				layoutbranch = new Layoutbranch(layoutbranchFormData);
			}

			Ebean.save(layoutbranch);

			flash("success", "Layoutbranch instance created/edited: " + layoutbranch);

			return all();
		}
	}

	public static Result delete(Form<LayoutbranchFormData> formData) {
		LayoutbranchFormData layoutbranchFormData = formData.get();

		String id = layoutbranchFormData.layoutBranchId;

		long layoutbranchId = 0;

		if (id != null) {
			layoutbranchId = Long.valueOf(id);
		}

		Layoutbranch layoutbranch;

		if (layoutbranchId > 0) {
			layoutbranch = Layoutbranch.find.byId(layoutbranchId);

			Ebean.delete(layoutbranch);
		}
		else {
			flash("error", "Cannot delete Layoutbranch");
		}

		return all();
	}

}
