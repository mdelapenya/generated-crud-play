
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlcontent.DlcontentFormData;

import models.dlcontent.Dlcontent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlcontent.dlcontent;
import views.html.dlcontent.dlcontents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlcontentApplication extends Controller {

	public static Result addDlcontent() {
		Form<DlcontentFormData> form = Form.form(
			DlcontentFormData.class).fill(new Dlcontent().toFormData());

		return ok(dlcontent.render(form));
	}

	public static Result get(Long id) {
		Dlcontent dbDlcontent = Dlcontent.find.byId(id);

		Form<DlcontentFormData> form = Form.form(
			DlcontentFormData.class).fill(dbDlcontent.toFormData());

		return ok(dlcontent.render(form));
	}

	public static Result all() {
		List<Dlcontent> dlcontentList = Dlcontent.find.all();

		return ok(dlcontents.render(dlcontentList));
	}

	public static Result submit() {
		Form<DlcontentFormData> formData = Form.form(
			DlcontentFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlcontentFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlcontent();
		}
		else {
			DlcontentFormData dlcontentFormData = formData.get();

			String id = dlcontentFormData.contentId;

			long dlcontentId = 0;

			if (id != null) {
				dlcontentId = Long.valueOf(id);
			}

			Dlcontent dlcontent;

			if (dlcontentId > 0) {
				dlcontent = Dlcontent.find.byId(dlcontentId);

				dlcontent.setContentId(Long.valueOf(dlcontentFormData.contentId));
				dlcontent.setGroupId(Long.valueOf(dlcontentFormData.groupId));
				dlcontent.setCompanyId(Long.valueOf(dlcontentFormData.companyId));
				dlcontent.setRepositoryId(Long.valueOf(dlcontentFormData.repositoryId));
				dlcontent.setPath(dlcontentFormData.path);
				dlcontent.setVersion(dlcontentFormData.version);
			}
			else {
				dlcontent = new Dlcontent(dlcontentFormData);
			}

			Ebean.save(dlcontent);

			flash("success", "Dlcontent instance created/edited: " + dlcontent);

			return all();
		}
	}

	public static Result delete(Form<DlcontentFormData> formData) {
		DlcontentFormData dlcontentFormData = formData.get();

		String id = dlcontentFormData.contentId;

		long dlcontentId = 0;

		if (id != null) {
			dlcontentId = Long.valueOf(id);
		}

		Dlcontent dlcontent;

		if (dlcontentId > 0) {
			dlcontent = Dlcontent.find.byId(dlcontentId);

			Ebean.delete(dlcontent);
		}
		else {
			flash("error", "Cannot delete Dlcontent");
		}

		return all();
	}

}
