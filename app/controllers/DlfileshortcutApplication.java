
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfileshortcut.DlfileshortcutFormData;

import models.dlfileshortcut.Dlfileshortcut;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfileshortcut.dlfileshortcut;
import views.html.dlfileshortcut.dlfileshortcuts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileshortcutApplication extends Controller {

	public static Result addDlfileshortcut() {
		Form<DlfileshortcutFormData> form = Form.form(
			DlfileshortcutFormData.class).fill(new Dlfileshortcut().toFormData());

		return ok(dlfileshortcut.render(form));
	}

	public static Result get(Long id) {
		Dlfileshortcut dbDlfileshortcut = Dlfileshortcut.find.byId(id);

		Form<DlfileshortcutFormData> form = Form.form(
			DlfileshortcutFormData.class).fill(dbDlfileshortcut.toFormData());

		return ok(dlfileshortcut.render(form));
	}

	public static Result all() {
		List<Dlfileshortcut> dlfileshortcutList = Dlfileshortcut.find.all();

		return ok(dlfileshortcuts.render(dlfileshortcutList));
	}

	public static Result submit() {
		Form<DlfileshortcutFormData> formData = Form.form(
			DlfileshortcutFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfileshortcutFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfileshortcut();
		}
		else {
			DlfileshortcutFormData dlfileshortcutFormData = formData.get();

			String id = dlfileshortcutFormData.fileShortcutId;

			long dlfileshortcutId = 0;

			if (id != null) {
				dlfileshortcutId = Long.valueOf(id);
			}

			Dlfileshortcut dlfileshortcut;

			if (dlfileshortcutId > 0) {
				dlfileshortcut = Dlfileshortcut.find.byId(dlfileshortcutId);

				dlfileshortcut.setUuid(dlfileshortcutFormData.uuid);
				dlfileshortcut.setFileShortcutId(Long.valueOf(dlfileshortcutFormData.fileShortcutId));
				dlfileshortcut.setGroupId(Long.valueOf(dlfileshortcutFormData.groupId));
				dlfileshortcut.setCompanyId(Long.valueOf(dlfileshortcutFormData.companyId));
				dlfileshortcut.setUserId(Long.valueOf(dlfileshortcutFormData.userId));
				dlfileshortcut.setUserName(dlfileshortcutFormData.userName);
				dlfileshortcut.setCreateDate(new Date(dlfileshortcutFormData.createDate));
				dlfileshortcut.setModifiedDate(new Date(dlfileshortcutFormData.modifiedDate));
				dlfileshortcut.setRepositoryId(Long.valueOf(dlfileshortcutFormData.repositoryId));
				dlfileshortcut.setFolderId(Long.valueOf(dlfileshortcutFormData.folderId));
				dlfileshortcut.setToFileEntryId(Long.valueOf(dlfileshortcutFormData.toFileEntryId));
				dlfileshortcut.setTreePath(dlfileshortcutFormData.treePath);
				dlfileshortcut.setActive(Boolean.valueOf(dlfileshortcutFormData.active));
				dlfileshortcut.setStatus(Integer.valueOf(dlfileshortcutFormData.status));
				dlfileshortcut.setStatusByUserId(Long.valueOf(dlfileshortcutFormData.statusByUserId));
				dlfileshortcut.setStatusByUserName(dlfileshortcutFormData.statusByUserName);
				dlfileshortcut.setStatusDate(new Date(dlfileshortcutFormData.statusDate));
			}
			else {
				dlfileshortcut = new Dlfileshortcut(dlfileshortcutFormData);
			}

			Ebean.save(dlfileshortcut);

			flash("success", "Dlfileshortcut instance created/edited: " + dlfileshortcut);

			return all();
		}
	}

	public static Result delete(Form<DlfileshortcutFormData> formData) {
		DlfileshortcutFormData dlfileshortcutFormData = formData.get();

		String id = dlfileshortcutFormData.fileShortcutId;

		long dlfileshortcutId = 0;

		if (id != null) {
			dlfileshortcutId = Long.valueOf(id);
		}

		Dlfileshortcut dlfileshortcut;

		if (dlfileshortcutId > 0) {
			dlfileshortcut = Dlfileshortcut.find.byId(dlfileshortcutId);

			Ebean.delete(dlfileshortcut);
		}
		else {
			flash("error", "Cannot delete Dlfileshortcut");
		}

		return all();
	}

}
