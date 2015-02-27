
package controllers;

import com.avaje.ebean.Ebean;

import controllers.usergroup.UsergroupFormData;

import models.usergroup.Usergroup;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.usergroup.usergroup;
import views.html.usergroup.usergroups;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UsergroupApplication extends Controller {

	public static Result addUsergroup() {
		Form<UsergroupFormData> form = Form.form(
			UsergroupFormData.class).fill(new Usergroup().toFormData());

		return ok(usergroup.render(form));
	}

	public static Result get(Long id) {
		Usergroup dbUsergroup = Usergroup.find.byId(id);

		Form<UsergroupFormData> form = Form.form(
			UsergroupFormData.class).fill(dbUsergroup.toFormData());

		return ok(usergroup.render(form));
	}

	public static Result all() {
		List<Usergroup> usergroupList = Usergroup.find.all();

		return ok(usergroups.render(usergroupList));
	}

	public static Result submit() {
		Form<UsergroupFormData> formData = Form.form(
			UsergroupFormData.class).bindFromRequest();

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

	public static Result edit(Form<UsergroupFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUsergroup();
		}
		else {
			UsergroupFormData usergroupFormData = formData.get();

			String id = usergroupFormData.userGroupId;

			long usergroupId = 0;

			if (id != null) {
				usergroupId = Long.valueOf(id);
			}

			Usergroup usergroup;

			if (usergroupId > 0) {
				usergroup = Usergroup.find.byId(usergroupId);

				usergroup.setMvccVersion(Long.valueOf(usergroupFormData.mvccVersion));
				usergroup.setUuid(usergroupFormData.uuid);
				usergroup.setUserGroupId(Long.valueOf(usergroupFormData.userGroupId));
				usergroup.setCompanyId(Long.valueOf(usergroupFormData.companyId));
				usergroup.setUserId(Long.valueOf(usergroupFormData.userId));
				usergroup.setUserName(usergroupFormData.userName);
				usergroup.setCreateDate(new Date(usergroupFormData.createDate));
				usergroup.setModifiedDate(new Date(usergroupFormData.modifiedDate));
				usergroup.setParentUserGroupId(Long.valueOf(usergroupFormData.parentUserGroupId));
				usergroup.setName(usergroupFormData.name);
				usergroup.setDescription(usergroupFormData.description);
				usergroup.setAddedByLDAPImport(Boolean.valueOf(usergroupFormData.addedByLDAPImport));
			}
			else {
				usergroup = new Usergroup(usergroupFormData);
			}

			Ebean.save(usergroup);

			flash("success", "Usergroup instance created/edited: " + usergroup);

			return all();
		}
	}

	public static Result delete(Form<UsergroupFormData> formData) {
		UsergroupFormData usergroupFormData = formData.get();

		String id = usergroupFormData.userGroupId;

		long usergroupId = 0;

		if (id != null) {
			usergroupId = Long.valueOf(id);
		}

		Usergroup usergroup;

		if (usergroupId > 0) {
			usergroup = Usergroup.find.byId(usergroupId);

			Ebean.delete(usergroup);
		}
		else {
			flash("error", "Cannot delete Usergroup");
		}

		return all();
	}

}
