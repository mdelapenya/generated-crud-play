
package controllers;

import com.avaje.ebean.Ebean;

import controllers.release.ReleaseFormData;

import models.release.Release;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.release.release;
import views.html.release.releases;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ReleaseApplication extends Controller {

	public static Result addRelease() {
		Form<ReleaseFormData> form = Form.form(
			ReleaseFormData.class).fill(new Release().toFormData());

		return ok(release.render(form));
	}

	public static Result get(Long id) {
		Release dbRelease = Release.find.byId(id);

		Form<ReleaseFormData> form = Form.form(
			ReleaseFormData.class).fill(dbRelease.toFormData());

		return ok(release.render(form));
	}

	public static Result all() {
		List<Release> releaseList = Release.find.all();

		return ok(releases.render(releaseList));
	}

	public static Result submit() {
		Form<ReleaseFormData> formData = Form.form(
			ReleaseFormData.class).bindFromRequest();

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

	public static Result edit(Form<ReleaseFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRelease();
		}
		else {
			ReleaseFormData releaseFormData = formData.get();

			String id = releaseFormData.releaseId;

			long releaseId = 0;

			if (id != null) {
				releaseId = Long.valueOf(id);
			}

			Release release;

			if (releaseId > 0) {
				release = Release.find.byId(releaseId);

				release.setMvccVersion(Long.valueOf(releaseFormData.mvccVersion));
				release.setReleaseId(Long.valueOf(releaseFormData.releaseId));
				release.setCreateDate(new Date(releaseFormData.createDate));
				release.setModifiedDate(new Date(releaseFormData.modifiedDate));
				release.setServletContextName(releaseFormData.servletContextName);
				release.setBuildNumber(Integer.valueOf(releaseFormData.buildNumber));
				release.setBuildDate(new Date(releaseFormData.buildDate));
				release.setVerified(Boolean.valueOf(releaseFormData.verified));
				release.setState(Integer.valueOf(releaseFormData.state));
				release.setTestString(releaseFormData.testString);
			}
			else {
				release = new Release(releaseFormData);
			}

			Ebean.save(release);

			flash("success", "Release instance created/edited: " + release);

			return all();
		}
	}

	public static Result delete(Form<ReleaseFormData> formData) {
		ReleaseFormData releaseFormData = formData.get();

		String id = releaseFormData.releaseId;

		long releaseId = 0;

		if (id != null) {
			releaseId = Long.valueOf(id);
		}

		Release release;

		if (releaseId > 0) {
			release = Release.find.byId(releaseId);

			Ebean.delete(release);
		}
		else {
			flash("error", "Cannot delete Release");
		}

		return all();
	}

}
