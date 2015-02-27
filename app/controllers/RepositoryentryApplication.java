
package controllers;

import com.avaje.ebean.Ebean;

import controllers.repositoryentry.RepositoryentryFormData;

import models.repositoryentry.Repositoryentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.repositoryentry.repositoryentry;
import views.html.repositoryentry.repositoryentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class RepositoryentryApplication extends Controller {

	public static Result addRepositoryentry() {
		Form<RepositoryentryFormData> form = Form.form(
			RepositoryentryFormData.class).fill(new Repositoryentry().toFormData());

		return ok(repositoryentry.render(form));
	}

	public static Result get(Long id) {
		Repositoryentry dbRepositoryentry = Repositoryentry.find.byId(id);

		Form<RepositoryentryFormData> form = Form.form(
			RepositoryentryFormData.class).fill(dbRepositoryentry.toFormData());

		return ok(repositoryentry.render(form));
	}

	public static Result all() {
		List<Repositoryentry> repositoryentryList = Repositoryentry.find.all();

		return ok(repositoryentrys.render(repositoryentryList));
	}

	public static Result submit() {
		Form<RepositoryentryFormData> formData = Form.form(
			RepositoryentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<RepositoryentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRepositoryentry();
		}
		else {
			RepositoryentryFormData repositoryentryFormData = formData.get();

			String id = repositoryentryFormData.repositoryEntryId;

			long repositoryentryId = 0;

			if (id != null) {
				repositoryentryId = Long.valueOf(id);
			}

			Repositoryentry repositoryentry;

			if (repositoryentryId > 0) {
				repositoryentry = Repositoryentry.find.byId(repositoryentryId);

				repositoryentry.setMvccVersion(Long.valueOf(repositoryentryFormData.mvccVersion));
				repositoryentry.setUuid(repositoryentryFormData.uuid);
				repositoryentry.setRepositoryEntryId(Long.valueOf(repositoryentryFormData.repositoryEntryId));
				repositoryentry.setGroupId(Long.valueOf(repositoryentryFormData.groupId));
				repositoryentry.setCompanyId(Long.valueOf(repositoryentryFormData.companyId));
				repositoryentry.setUserId(Long.valueOf(repositoryentryFormData.userId));
				repositoryentry.setUserName(repositoryentryFormData.userName);
				repositoryentry.setCreateDate(new Date(repositoryentryFormData.createDate));
				repositoryentry.setModifiedDate(new Date(repositoryentryFormData.modifiedDate));
				repositoryentry.setRepositoryId(Long.valueOf(repositoryentryFormData.repositoryId));
				repositoryentry.setMappedId(repositoryentryFormData.mappedId);
				repositoryentry.setManualCheckInRequired(Boolean.valueOf(repositoryentryFormData.manualCheckInRequired));
			}
			else {
				repositoryentry = new Repositoryentry(repositoryentryFormData);
			}

			Ebean.save(repositoryentry);

			flash("success", "Repositoryentry instance created/edited: " + repositoryentry);

			return all();
		}
	}

	public static Result delete(Form<RepositoryentryFormData> formData) {
		RepositoryentryFormData repositoryentryFormData = formData.get();

		String id = repositoryentryFormData.repositoryEntryId;

		long repositoryentryId = 0;

		if (id != null) {
			repositoryentryId = Long.valueOf(id);
		}

		Repositoryentry repositoryentry;

		if (repositoryentryId > 0) {
			repositoryentry = Repositoryentry.find.byId(repositoryentryId);

			Ebean.delete(repositoryentry);
		}
		else {
			flash("error", "Cannot delete Repositoryentry");
		}

		return all();
	}

}
