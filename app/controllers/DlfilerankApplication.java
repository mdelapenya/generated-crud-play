
package controllers;

import com.avaje.ebean.Ebean;

import controllers.dlfilerank.DlfilerankFormData;

import models.dlfilerank.Dlfilerank;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dlfilerank.dlfilerank;
import views.html.dlfilerank.dlfileranks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DlfilerankApplication extends Controller {

	public static Result addDlfilerank() {
		Form<DlfilerankFormData> form = Form.form(
			DlfilerankFormData.class).fill(new Dlfilerank().toFormData());

		return ok(dlfilerank.render(form));
	}

	public static Result get(Long id) {
		Dlfilerank dbDlfilerank = Dlfilerank.find.byId(id);

		Form<DlfilerankFormData> form = Form.form(
			DlfilerankFormData.class).fill(dbDlfilerank.toFormData());

		return ok(dlfilerank.render(form));
	}

	public static Result all() {
		List<Dlfilerank> dlfilerankList = Dlfilerank.find.all();

		return ok(dlfileranks.render(dlfilerankList));
	}

	public static Result submit() {
		Form<DlfilerankFormData> formData = Form.form(
			DlfilerankFormData.class).bindFromRequest();

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

	public static Result edit(Form<DlfilerankFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDlfilerank();
		}
		else {
			DlfilerankFormData dlfilerankFormData = formData.get();

			String id = dlfilerankFormData.fileRankId;

			long dlfilerankId = 0;

			if (id != null) {
				dlfilerankId = Long.valueOf(id);
			}

			Dlfilerank dlfilerank;

			if (dlfilerankId > 0) {
				dlfilerank = Dlfilerank.find.byId(dlfilerankId);

				dlfilerank.setFileRankId(Long.valueOf(dlfilerankFormData.fileRankId));
				dlfilerank.setGroupId(Long.valueOf(dlfilerankFormData.groupId));
				dlfilerank.setCompanyId(Long.valueOf(dlfilerankFormData.companyId));
				dlfilerank.setUserId(Long.valueOf(dlfilerankFormData.userId));
				dlfilerank.setCreateDate(new Date(dlfilerankFormData.createDate));
				dlfilerank.setFileEntryId(Long.valueOf(dlfilerankFormData.fileEntryId));
				dlfilerank.setActive(Boolean.valueOf(dlfilerankFormData.active));
			}
			else {
				dlfilerank = new Dlfilerank(dlfilerankFormData);
			}

			Ebean.save(dlfilerank);

			flash("success", "Dlfilerank instance created/edited: " + dlfilerank);

			return all();
		}
	}

	public static Result delete(Form<DlfilerankFormData> formData) {
		DlfilerankFormData dlfilerankFormData = formData.get();

		String id = dlfilerankFormData.fileRankId;

		long dlfilerankId = 0;

		if (id != null) {
			dlfilerankId = Long.valueOf(id);
		}

		Dlfilerank dlfilerank;

		if (dlfilerankId > 0) {
			dlfilerank = Dlfilerank.find.byId(dlfilerankId);

			Ebean.delete(dlfilerank);
		}
		else {
			flash("error", "Cannot delete Dlfilerank");
		}

		return all();
	}

}
