
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfolder.DlfolderFormData;

import models.dlfolder.Dlfolder;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfolder.dlfolder;
import views.html.dlfolder.dlfolders;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfolderApplication extends Controller {

	public static Result addDlfolder() {
		Form<DlfolderFormData> form = Form.form(
			DlfolderFormData.class).fill(new Dlfolder().toFormData());

		return ok(dlfolder.render(form));
	}

	public static Result get(Long id) {
		Dlfolder dbDlfolder = Dlfolder.find.byId(id);

		Form<DlfolderFormData> form = Form.form(
			DlfolderFormData.class).fill(dbDlfolder.toFormData());

		return ok(dlfolder.render(form));
	}

	public static Result all() {
		List<Dlfolder> dlfolderList = Dlfolder.find.all();

		return ok(dlfolders.render(dlfolderList));
	}

	public static Result submit() {
		Form<DlfolderFormData> formData = Form.form(
			DlfolderFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfolderFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfolder();
		}
		else {
			DlfolderFormData dlfolderFormData = formData.get();

			String id = dlfolderFormData.folderId;

			long dlfolderId = 0;

			if (id != null) {
				dlfolderId = Long.valueOf(id);
			}

			Dlfolder dlfolder;

			if (dlfolderId > 0) {
				dlfolder = Dlfolder.find.byId(dlfolderId);

				dlfolder.setUuid(dlfolderFormData.uuid);
				dlfolder.setFolderId(Long.valueOf(dlfolderFormData.folderId));
				dlfolder.setGroupId(Long.valueOf(dlfolderFormData.groupId));
				dlfolder.setCompanyId(Long.valueOf(dlfolderFormData.companyId));
				dlfolder.setUserId(Long.valueOf(dlfolderFormData.userId));
				dlfolder.setUserName(dlfolderFormData.userName);
				dlfolder.setCreateDate(new Date(dlfolderFormData.createDate));
				dlfolder.setModifiedDate(new Date(dlfolderFormData.modifiedDate));
				dlfolder.setRepositoryId(Long.valueOf(dlfolderFormData.repositoryId));
				dlfolder.setMountPoint(Boolean.valueOf(dlfolderFormData.mountPoint));
				dlfolder.setParentFolderId(Long.valueOf(dlfolderFormData.parentFolderId));
				dlfolder.setTreePath(dlfolderFormData.treePath);
				dlfolder.setName(dlfolderFormData.name);
				dlfolder.setDescription(dlfolderFormData.description);
				dlfolder.setLastPostDate(new Date(dlfolderFormData.lastPostDate));
				dlfolder.setDefaultFileEntryTypeId(Long.valueOf(dlfolderFormData.defaultFileEntryTypeId));
				dlfolder.setHidden(Boolean.valueOf(dlfolderFormData.hidden));
				dlfolder.setRestrictionType(Integer.valueOf(dlfolderFormData.restrictionType));
				dlfolder.setStatus(Integer.valueOf(dlfolderFormData.status));
				dlfolder.setStatusByUserId(Long.valueOf(dlfolderFormData.statusByUserId));
				dlfolder.setStatusByUserName(dlfolderFormData.statusByUserName);
				dlfolder.setStatusDate(new Date(dlfolderFormData.statusDate));
			}
			else {
				dlfolder = new Dlfolder(dlfolderFormData);
			}

			Ebean.save(dlfolder);

			flash("success", "Dlfolder instance created/edited: " + dlfolder);

			return all();
		}
	}

	public static Result delete(Form<DlfolderFormData> formData) {
		DlfolderFormData dlfolderFormData = formData.get();

		String id = dlfolderFormData.folderId;

		long dlfolderId = 0;

		if (id != null) {
			dlfolderId = Long.valueOf(id);
		}

		Dlfolder dlfolder;

		if (dlfolderId > 0) {
			dlfolder = Dlfolder.find.byId(dlfolderId);

			Ebean.delete(dlfolder);
		}
		else {
			flash("error", "Cannot delete Dlfolder");
		}

		return all();
	}

}
