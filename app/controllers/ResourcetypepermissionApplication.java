
package controllers;

import com.avaje.ebean.Ebean;

import controllers.resourcetypepermission.ResourcetypepermissionFormData;

import models.resourcetypepermission.Resourcetypepermission;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.resourcetypepermission.resourcetypepermission;
import views.html.resourcetypepermission.resourcetypepermissions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ResourcetypepermissionApplication extends Controller {

	public static Result addResourcetypepermission() {
		Form<ResourcetypepermissionFormData> form = Form.form(
			ResourcetypepermissionFormData.class).fill(new Resourcetypepermission().toFormData());

		return ok(resourcetypepermission.render(form));
	}

	public static Result get(Long id) {
		Resourcetypepermission dbResourcetypepermission = Resourcetypepermission.find.byId(id);

		Form<ResourcetypepermissionFormData> form = Form.form(
			ResourcetypepermissionFormData.class).fill(dbResourcetypepermission.toFormData());

		return ok(resourcetypepermission.render(form));
	}

	public static Result all() {
		List<Resourcetypepermission> resourcetypepermissionList = Resourcetypepermission.find.all();

		return ok(resourcetypepermissions.render(resourcetypepermissionList));
	}

	public static Result submit() {
		Form<ResourcetypepermissionFormData> formData = Form.form(
			ResourcetypepermissionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ResourcetypepermissionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addResourcetypepermission();
		}
		else {
			ResourcetypepermissionFormData resourcetypepermissionFormData = formData.get();

			String id = resourcetypepermissionFormData.resourceTypePermissionId;

			long resourcetypepermissionId = 0;

			if (id != null) {
				resourcetypepermissionId = Long.valueOf(id);
			}

			Resourcetypepermission resourcetypepermission;

			if (resourcetypepermissionId > 0) {
				resourcetypepermission = Resourcetypepermission.find.byId(resourcetypepermissionId);

				resourcetypepermission.setMvccVersion(Long.valueOf(resourcetypepermissionFormData.mvccVersion));
				resourcetypepermission.setResourceTypePermissionId(Long.valueOf(resourcetypepermissionFormData.resourceTypePermissionId));
				resourcetypepermission.setCompanyId(Long.valueOf(resourcetypepermissionFormData.companyId));
				resourcetypepermission.setGroupId(Long.valueOf(resourcetypepermissionFormData.groupId));
				resourcetypepermission.setName(resourcetypepermissionFormData.name);
				resourcetypepermission.setRoleId(Long.valueOf(resourcetypepermissionFormData.roleId));
				resourcetypepermission.setActionIds(Long.valueOf(resourcetypepermissionFormData.actionIds));
			}
			else {
				resourcetypepermission = new Resourcetypepermission(resourcetypepermissionFormData);
			}

			Ebean.save(resourcetypepermission);

			flash("success", "Resourcetypepermission instance created/edited: " + resourcetypepermission);

			return all();
		}
	}

	public static Result delete(Form<ResourcetypepermissionFormData> formData) {
		ResourcetypepermissionFormData resourcetypepermissionFormData = formData.get();

		String id = resourcetypepermissionFormData.resourceTypePermissionId;

		long resourcetypepermissionId = 0;

		if (id != null) {
			resourcetypepermissionId = Long.valueOf(id);
		}

		Resourcetypepermission resourcetypepermission;

		if (resourcetypepermissionId > 0) {
			resourcetypepermission = Resourcetypepermission.find.byId(resourcetypepermissionId);

			Ebean.delete(resourcetypepermission);
		}
		else {
			flash("error", "Cannot delete Resourcetypepermission");
		}

		return all();
	}

}
