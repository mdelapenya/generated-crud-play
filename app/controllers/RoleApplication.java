
package controllers;

import com.avaje.ebean.Ebean;

import controllers.role.RoleFormData;

import models.role.Role;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.role.role;
import views.html.role.roles;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class RoleApplication extends Controller {

	public static Result addRole() {
		Form<RoleFormData> form = Form.form(
			RoleFormData.class).fill(new Role().toFormData());

		return ok(role.render(form));
	}

	public static Result get(Long id) {
		Role dbRole = Role.find.byId(id);

		Form<RoleFormData> form = Form.form(
			RoleFormData.class).fill(dbRole.toFormData());

		return ok(role.render(form));
	}

	public static Result all() {
		List<Role> roleList = Role.find.all();

		return ok(roles.render(roleList));
	}

	public static Result submit() {
		Form<RoleFormData> formData = Form.form(
			RoleFormData.class).bindFromRequest();

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

	public static Result edit(Form<RoleFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRole();
		}
		else {
			RoleFormData roleFormData = formData.get();

			String id = roleFormData.roleId;

			long roleId = 0;

			if (id != null) {
				roleId = Long.valueOf(id);
			}

			Role role;

			if (roleId > 0) {
				role = Role.find.byId(roleId);

				role.setMvccVersion(Long.valueOf(roleFormData.mvccVersion));
				role.setUuid(roleFormData.uuid);
				role.setRoleId(Long.valueOf(roleFormData.roleId));
				role.setCompanyId(Long.valueOf(roleFormData.companyId));
				role.setUserId(Long.valueOf(roleFormData.userId));
				role.setUserName(roleFormData.userName);
				role.setCreateDate(new Date(roleFormData.createDate));
				role.setModifiedDate(new Date(roleFormData.modifiedDate));
				role.setClassNameId(Long.valueOf(roleFormData.classNameId));
				role.setClassPK(Long.valueOf(roleFormData.classPK));
				role.setName(roleFormData.name);
				role.setTitle(roleFormData.title);
				role.setDescription(roleFormData.description);
				role.setCustomtype(Integer.valueOf(roleFormData.customtype));
				role.setSubtype(roleFormData.subtype);
			}
			else {
				role = new Role(roleFormData);
			}

			Ebean.save(role);

			flash("success", "Role instance created/edited: " + role);

			return all();
		}
	}

	public static Result delete(Form<RoleFormData> formData) {
		RoleFormData roleFormData = formData.get();

		String id = roleFormData.roleId;

		long roleId = 0;

		if (id != null) {
			roleId = Long.valueOf(id);
		}

		Role role;

		if (roleId > 0) {
			role = Role.find.byId(roleId);

			Ebean.delete(role);
		}
		else {
			flash("error", "Cannot delete Role");
		}

		return all();
	}

}
