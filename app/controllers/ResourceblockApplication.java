
package controllers;

import com.avaje.ebean.Ebean;

import controllers.resourceblock.ResourceblockFormData;

import models.resourceblock.Resourceblock;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.resourceblock.resourceblock;
import views.html.resourceblock.resourceblocks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ResourceblockApplication extends Controller {

	public static Result addResourceblock() {
		Form<ResourceblockFormData> form = Form.form(
			ResourceblockFormData.class).fill(new Resourceblock().toFormData());

		return ok(resourceblock.render(form));
	}

	public static Result get(Long id) {
		Resourceblock dbResourceblock = Resourceblock.find.byId(id);

		Form<ResourceblockFormData> form = Form.form(
			ResourceblockFormData.class).fill(dbResourceblock.toFormData());

		return ok(resourceblock.render(form));
	}

	public static Result all() {
		List<Resourceblock> resourceblockList = Resourceblock.find.all();

		return ok(resourceblocks.render(resourceblockList));
	}

	public static Result submit() {
		Form<ResourceblockFormData> formData = Form.form(
			ResourceblockFormData.class).bindFromRequest();

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

	public static Result edit(Form<ResourceblockFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addResourceblock();
		}
		else {
			ResourceblockFormData resourceblockFormData = formData.get();

			String id = resourceblockFormData.resourceBlockId;

			long resourceblockId = 0;

			if (id != null) {
				resourceblockId = Long.valueOf(id);
			}

			Resourceblock resourceblock;

			if (resourceblockId > 0) {
				resourceblock = Resourceblock.find.byId(resourceblockId);

				resourceblock.setMvccVersion(Long.valueOf(resourceblockFormData.mvccVersion));
				resourceblock.setResourceBlockId(Long.valueOf(resourceblockFormData.resourceBlockId));
				resourceblock.setCompanyId(Long.valueOf(resourceblockFormData.companyId));
				resourceblock.setGroupId(Long.valueOf(resourceblockFormData.groupId));
				resourceblock.setName(resourceblockFormData.name);
				resourceblock.setPermissionsHash(resourceblockFormData.permissionsHash);
				resourceblock.setReferenceCount(Long.valueOf(resourceblockFormData.referenceCount));
			}
			else {
				resourceblock = new Resourceblock(resourceblockFormData);
			}

			Ebean.save(resourceblock);

			flash("success", "Resourceblock instance created/edited: " + resourceblock);

			return all();
		}
	}

	public static Result delete(Form<ResourceblockFormData> formData) {
		ResourceblockFormData resourceblockFormData = formData.get();

		String id = resourceblockFormData.resourceBlockId;

		long resourceblockId = 0;

		if (id != null) {
			resourceblockId = Long.valueOf(id);
		}

		Resourceblock resourceblock;

		if (resourceblockId > 0) {
			resourceblock = Resourceblock.find.byId(resourceblockId);

			Ebean.delete(resourceblock);
		}
		else {
			flash("error", "Cannot delete Resourceblock");
		}

		return all();
	}

}
