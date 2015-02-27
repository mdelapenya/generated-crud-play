
package controllers;

import com.avaje.ebean.Ebean;

import controllers.resourceblockpermission.ResourceblockpermissionFormData;

import models.resourceblockpermission.Resourceblockpermission;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.resourceblockpermission.resourceblockpermission;
import views.html.resourceblockpermission.resourceblockpermissions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ResourceblockpermissionApplication extends Controller {

	public static Result addResourceblockpermission() {
		Form<ResourceblockpermissionFormData> form = Form.form(
			ResourceblockpermissionFormData.class).fill(new Resourceblockpermission().toFormData());

		return ok(resourceblockpermission.render(form));
	}

	public static Result get(Long id) {
		Resourceblockpermission dbResourceblockpermission = Resourceblockpermission.find.byId(id);

		Form<ResourceblockpermissionFormData> form = Form.form(
			ResourceblockpermissionFormData.class).fill(dbResourceblockpermission.toFormData());

		return ok(resourceblockpermission.render(form));
	}

	public static Result all() {
		List<Resourceblockpermission> resourceblockpermissionList = Resourceblockpermission.find.all();

		return ok(resourceblockpermissions.render(resourceblockpermissionList));
	}

	public static Result submit() {
		Form<ResourceblockpermissionFormData> formData = Form.form(
			ResourceblockpermissionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ResourceblockpermissionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addResourceblockpermission();
		}
		else {
			ResourceblockpermissionFormData resourceblockpermissionFormData = formData.get();

			String id = resourceblockpermissionFormData.resourceBlockPermissionId;

			long resourceblockpermissionId = 0;

			if (id != null) {
				resourceblockpermissionId = Long.valueOf(id);
			}

			Resourceblockpermission resourceblockpermission;

			if (resourceblockpermissionId > 0) {
				resourceblockpermission = Resourceblockpermission.find.byId(resourceblockpermissionId);

				resourceblockpermission.setMvccVersion(Long.valueOf(resourceblockpermissionFormData.mvccVersion));
				resourceblockpermission.setResourceBlockPermissionId(Long.valueOf(resourceblockpermissionFormData.resourceBlockPermissionId));
				resourceblockpermission.setResourceBlockId(Long.valueOf(resourceblockpermissionFormData.resourceBlockId));
				resourceblockpermission.setRoleId(Long.valueOf(resourceblockpermissionFormData.roleId));
				resourceblockpermission.setActionIds(Long.valueOf(resourceblockpermissionFormData.actionIds));
			}
			else {
				resourceblockpermission = new Resourceblockpermission(resourceblockpermissionFormData);
			}

			Ebean.save(resourceblockpermission);

			flash("success", "Resourceblockpermission instance created/edited: " + resourceblockpermission);

			return all();
		}
	}

	public static Result delete(Form<ResourceblockpermissionFormData> formData) {
		ResourceblockpermissionFormData resourceblockpermissionFormData = formData.get();

		String id = resourceblockpermissionFormData.resourceBlockPermissionId;

		long resourceblockpermissionId = 0;

		if (id != null) {
			resourceblockpermissionId = Long.valueOf(id);
		}

		Resourceblockpermission resourceblockpermission;

		if (resourceblockpermissionId > 0) {
			resourceblockpermission = Resourceblockpermission.find.byId(resourceblockpermissionId);

			Ebean.delete(resourceblockpermission);
		}
		else {
			flash("error", "Cannot delete Resourceblockpermission");
		}

		return all();
	}

}
