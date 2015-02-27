
package controllers;

import com.avaje.ebean.Ebean;

import controllers.scproductversion.ScproductversionFormData;

import models.scproductversion.Scproductversion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.scproductversion.scproductversion;
import views.html.scproductversion.scproductversions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ScproductversionApplication extends Controller {

	public static Result addScproductversion() {
		Form<ScproductversionFormData> form = Form.form(
			ScproductversionFormData.class).fill(new Scproductversion().toFormData());

		return ok(scproductversion.render(form));
	}

	public static Result get(Long id) {
		Scproductversion dbScproductversion = Scproductversion.find.byId(id);

		Form<ScproductversionFormData> form = Form.form(
			ScproductversionFormData.class).fill(dbScproductversion.toFormData());

		return ok(scproductversion.render(form));
	}

	public static Result all() {
		List<Scproductversion> scproductversionList = Scproductversion.find.all();

		return ok(scproductversions.render(scproductversionList));
	}

	public static Result submit() {
		Form<ScproductversionFormData> formData = Form.form(
			ScproductversionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ScproductversionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addScproductversion();
		}
		else {
			ScproductversionFormData scproductversionFormData = formData.get();

			String id = scproductversionFormData.productVersionId;

			long scproductversionId = 0;

			if (id != null) {
				scproductversionId = Long.valueOf(id);
			}

			Scproductversion scproductversion;

			if (scproductversionId > 0) {
				scproductversion = Scproductversion.find.byId(scproductversionId);

				scproductversion.setProductVersionId(Long.valueOf(scproductversionFormData.productVersionId));
				scproductversion.setCompanyId(Long.valueOf(scproductversionFormData.companyId));
				scproductversion.setUserId(Long.valueOf(scproductversionFormData.userId));
				scproductversion.setUserName(scproductversionFormData.userName);
				scproductversion.setCreateDate(new Date(scproductversionFormData.createDate));
				scproductversion.setModifiedDate(new Date(scproductversionFormData.modifiedDate));
				scproductversion.setProductEntryId(Long.valueOf(scproductversionFormData.productEntryId));
				scproductversion.setVersion(scproductversionFormData.version);
				scproductversion.setChangeLog(scproductversionFormData.changeLog);
				scproductversion.setDownloadPageURL(scproductversionFormData.downloadPageURL);
				scproductversion.setDirectDownloadURL(scproductversionFormData.directDownloadURL);
				scproductversion.setRepoStoreArtifact(Boolean.valueOf(scproductversionFormData.repoStoreArtifact));
			}
			else {
				scproductversion = new Scproductversion(scproductversionFormData);
			}

			Ebean.save(scproductversion);

			flash("success", "Scproductversion instance created/edited: " + scproductversion);

			return all();
		}
	}

	public static Result delete(Form<ScproductversionFormData> formData) {
		ScproductversionFormData scproductversionFormData = formData.get();

		String id = scproductversionFormData.productVersionId;

		long scproductversionId = 0;

		if (id != null) {
			scproductversionId = Long.valueOf(id);
		}

		Scproductversion scproductversion;

		if (scproductversionId > 0) {
			scproductversion = Scproductversion.find.byId(scproductversionId);

			Ebean.delete(scproductversion);
		}
		else {
			flash("error", "Cannot delete Scproductversion");
		}

		return all();
	}

}
