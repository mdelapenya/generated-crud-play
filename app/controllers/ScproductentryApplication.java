
package controllers;

import com.avaje.ebean.Ebean;

import controllers.scproductentry.ScproductentryFormData;

import models.scproductentry.Scproductentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.scproductentry.scproductentry;
import views.html.scproductentry.scproductentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ScproductentryApplication extends Controller {

	public static Result addScproductentry() {
		Form<ScproductentryFormData> form = Form.form(
			ScproductentryFormData.class).fill(new Scproductentry().toFormData());

		return ok(scproductentry.render(form));
	}

	public static Result get(Long id) {
		Scproductentry dbScproductentry = Scproductentry.find.byId(id);

		Form<ScproductentryFormData> form = Form.form(
			ScproductentryFormData.class).fill(dbScproductentry.toFormData());

		return ok(scproductentry.render(form));
	}

	public static Result all() {
		List<Scproductentry> scproductentryList = Scproductentry.find.all();

		return ok(scproductentrys.render(scproductentryList));
	}

	public static Result submit() {
		Form<ScproductentryFormData> formData = Form.form(
			ScproductentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<ScproductentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addScproductentry();
		}
		else {
			ScproductentryFormData scproductentryFormData = formData.get();

			String id = scproductentryFormData.productEntryId;

			long scproductentryId = 0;

			if (id != null) {
				scproductentryId = Long.valueOf(id);
			}

			Scproductentry scproductentry;

			if (scproductentryId > 0) {
				scproductentry = Scproductentry.find.byId(scproductentryId);

				scproductentry.setProductEntryId(Long.valueOf(scproductentryFormData.productEntryId));
				scproductentry.setGroupId(Long.valueOf(scproductentryFormData.groupId));
				scproductentry.setCompanyId(Long.valueOf(scproductentryFormData.companyId));
				scproductentry.setUserId(Long.valueOf(scproductentryFormData.userId));
				scproductentry.setUserName(scproductentryFormData.userName);
				scproductentry.setCreateDate(new Date(scproductentryFormData.createDate));
				scproductentry.setModifiedDate(new Date(scproductentryFormData.modifiedDate));
				scproductentry.setName(scproductentryFormData.name);
				scproductentry.setCustomtype(scproductentryFormData.customtype);
				scproductentry.setTags(scproductentryFormData.tags);
				scproductentry.setShortDescription(scproductentryFormData.shortDescription);
				scproductentry.setLongDescription(scproductentryFormData.longDescription);
				scproductentry.setPageURL(scproductentryFormData.pageURL);
				scproductentry.setAuthor(scproductentryFormData.author);
				scproductentry.setRepoGroupId(scproductentryFormData.repoGroupId);
				scproductentry.setRepoArtifactId(scproductentryFormData.repoArtifactId);
			}
			else {
				scproductentry = new Scproductentry(scproductentryFormData);
			}

			Ebean.save(scproductentry);

			flash("success", "Scproductentry instance created/edited: " + scproductentry);

			return all();
		}
	}

	public static Result delete(Form<ScproductentryFormData> formData) {
		ScproductentryFormData scproductentryFormData = formData.get();

		String id = scproductentryFormData.productEntryId;

		long scproductentryId = 0;

		if (id != null) {
			scproductentryId = Long.valueOf(id);
		}

		Scproductentry scproductentry;

		if (scproductentryId > 0) {
			scproductentry = Scproductentry.find.byId(scproductentryId);

			Ebean.delete(scproductentry);
		}
		else {
			flash("error", "Cannot delete Scproductentry");
		}

		return all();
	}

}
