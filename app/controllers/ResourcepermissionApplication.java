
package controllers;

import com.avaje.ebean.Ebean;

import controllers.resourcepermission.ResourcepermissionFormData;

import models.resourcepermission.Resourcepermission;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.resourcepermission.resourcepermission;
import views.html.resourcepermission.resourcepermissions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ResourcepermissionApplication extends Controller {

	public static Result addResourcepermission() {
		Form<ResourcepermissionFormData> form = Form.form(
			ResourcepermissionFormData.class).fill(new Resourcepermission().toFormData());

		return ok(resourcepermission.render(form));
	}

	public static Result get(Long id) {
		Resourcepermission dbResourcepermission = Resourcepermission.find.byId(id);

		Form<ResourcepermissionFormData> form = Form.form(
			ResourcepermissionFormData.class).fill(dbResourcepermission.toFormData());

		return ok(resourcepermission.render(form));
	}

	public static Result all() {
		List<Resourcepermission> resourcepermissionList = Resourcepermission.find.all();

		return ok(resourcepermissions.render(resourcepermissionList));
	}

	public static Result submit() {
		Form<ResourcepermissionFormData> formData = Form.form(
			ResourcepermissionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ResourcepermissionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addResourcepermission();
		}
		else {
			ResourcepermissionFormData resourcepermissionFormData = formData.get();

			String id = resourcepermissionFormData.resourcePermissionId;

			long resourcepermissionId = 0;

			if (id != null) {
				resourcepermissionId = Long.valueOf(id);
			}

			Resourcepermission resourcepermission;

			if (resourcepermissionId > 0) {
				resourcepermission = Resourcepermission.find.byId(resourcepermissionId);

				resourcepermission.setMvccVersion(Long.valueOf(resourcepermissionFormData.mvccVersion));
				resourcepermission.setResourcePermissionId(Long.valueOf(resourcepermissionFormData.resourcePermissionId));
				resourcepermission.setCompanyId(Long.valueOf(resourcepermissionFormData.companyId));
				resourcepermission.setName(resourcepermissionFormData.name);
				resourcepermission.setScope(Integer.valueOf(resourcepermissionFormData.scope));
				resourcepermission.setPrimKey(resourcepermissionFormData.primKey);
				resourcepermission.setRoleId(Long.valueOf(resourcepermissionFormData.roleId));
				resourcepermission.setOwnerId(Long.valueOf(resourcepermissionFormData.ownerId));
				resourcepermission.setActionIds(Long.valueOf(resourcepermissionFormData.actionIds));
			}
			else {
				resourcepermission = new Resourcepermission(resourcepermissionFormData);
			}

			Ebean.save(resourcepermission);

			flash("success", "Resourcepermission instance created/edited: " + resourcepermission);

			return all();
		}
	}

	public static Result delete(Form<ResourcepermissionFormData> formData) {
		ResourcepermissionFormData resourcepermissionFormData = formData.get();

		String id = resourcepermissionFormData.resourcePermissionId;

		long resourcepermissionId = 0;

		if (id != null) {
			resourcepermissionId = Long.valueOf(id);
		}

		Resourcepermission resourcepermission;

		if (resourcepermissionId > 0) {
			resourcepermission = Resourcepermission.find.byId(resourcepermissionId);

			Ebean.delete(resourcepermission);
		}
		else {
			flash("error", "Cannot delete Resourcepermission");
		}

		return all();
	}

}
