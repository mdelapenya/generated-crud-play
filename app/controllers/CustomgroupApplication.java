
package controllers;

import com.avaje.ebean.Ebean;

import controllers.customgroup.CustomgroupFormData;

import models.customgroup.Customgroup;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.customgroup.customgroup;
import views.html.customgroup.customgroups;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class CustomgroupApplication extends Controller {

	public static Result addCustomgroup() {
		Form<CustomgroupFormData> form = Form.form(
			CustomgroupFormData.class).fill(new Customgroup().toFormData());

		return ok(customgroup.render(form));
	}

	public static Result get(Long id) {
		Customgroup dbCustomgroup = Customgroup.find.byId(id);

		Form<CustomgroupFormData> form = Form.form(
			CustomgroupFormData.class).fill(dbCustomgroup.toFormData());

		return ok(customgroup.render(form));
	}

	public static Result all() {
		List<Customgroup> customgroupList = Customgroup.find.all();

		return ok(customgroups.render(customgroupList));
	}

	public static Result submit() {
		Form<CustomgroupFormData> formData = Form.form(
			CustomgroupFormData.class).bindFromRequest();

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

	public static Result edit(Form<CustomgroupFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addCustomgroup();
		}
		else {
			CustomgroupFormData customgroupFormData = formData.get();

			String id = customgroupFormData.groupId;

			long customgroupId = 0;

			if (id != null) {
				customgroupId = Long.valueOf(id);
			}

			Customgroup customgroup;

			if (customgroupId > 0) {
				customgroup = Customgroup.find.byId(customgroupId);

				customgroup.setMvccVersion(Long.valueOf(customgroupFormData.mvccVersion));
				customgroup.setUuid(customgroupFormData.uuid);
				customgroup.setGroupId(Long.valueOf(customgroupFormData.groupId));
				customgroup.setCompanyId(Long.valueOf(customgroupFormData.companyId));
				customgroup.setCreatorUserId(Long.valueOf(customgroupFormData.creatorUserId));
				customgroup.setClassNameId(Long.valueOf(customgroupFormData.classNameId));
				customgroup.setClassPK(Long.valueOf(customgroupFormData.classPK));
				customgroup.setParentGroupId(Long.valueOf(customgroupFormData.parentGroupId));
				customgroup.setLiveGroupId(Long.valueOf(customgroupFormData.liveGroupId));
				customgroup.setTreePath(customgroupFormData.treePath);
				customgroup.setGroupKey(customgroupFormData.groupKey);
				customgroup.setName(customgroupFormData.name);
				customgroup.setDescription(customgroupFormData.description);
				customgroup.setCustomtype(Integer.valueOf(customgroupFormData.customtype));
				customgroup.setTypeSettings(customgroupFormData.typeSettings);
				customgroup.setManualMembership(Boolean.valueOf(customgroupFormData.manualMembership));
				customgroup.setMembershipRestriction(Integer.valueOf(customgroupFormData.membershipRestriction));
				customgroup.setFriendlyURL(customgroupFormData.friendlyURL);
				customgroup.setSite(Boolean.valueOf(customgroupFormData.site));
				customgroup.setRemoteStagingGroupCount(Integer.valueOf(customgroupFormData.remoteStagingGroupCount));
				customgroup.setInheritContent(Boolean.valueOf(customgroupFormData.inheritContent));
				customgroup.setActive(Boolean.valueOf(customgroupFormData.active));
			}
			else {
				customgroup = new Customgroup(customgroupFormData);
			}

			Ebean.save(customgroup);

			flash("success", "Customgroup instance created/edited: " + customgroup);

			return all();
		}
	}

	public static Result delete(Form<CustomgroupFormData> formData) {
		CustomgroupFormData customgroupFormData = formData.get();

		String id = customgroupFormData.groupId;

		long customgroupId = 0;

		if (id != null) {
			customgroupId = Long.valueOf(id);
		}

		Customgroup customgroup;

		if (customgroupId > 0) {
			customgroup = Customgroup.find.byId(customgroupId);

			Ebean.delete(customgroup);
		}
		else {
			flash("error", "Cannot delete Customgroup");
		}

		return all();
	}

}
