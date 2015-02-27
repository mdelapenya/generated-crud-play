
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbthreadflag.MbthreadflagFormData;

import models.mbthreadflag.Mbthreadflag;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbthreadflag.mbthreadflag;
import views.html.mbthreadflag.mbthreadflags;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbthreadflagApplication extends Controller {

	public static Result addMbthreadflag() {
		Form<MbthreadflagFormData> form = Form.form(
			MbthreadflagFormData.class).fill(new Mbthreadflag().toFormData());

		return ok(mbthreadflag.render(form));
	}

	public static Result get(Long id) {
		Mbthreadflag dbMbthreadflag = Mbthreadflag.find.byId(id);

		Form<MbthreadflagFormData> form = Form.form(
			MbthreadflagFormData.class).fill(dbMbthreadflag.toFormData());

		return ok(mbthreadflag.render(form));
	}

	public static Result all() {
		List<Mbthreadflag> mbthreadflagList = Mbthreadflag.find.all();

		return ok(mbthreadflags.render(mbthreadflagList));
	}

	public static Result submit() {
		Form<MbthreadflagFormData> formData = Form.form(
			MbthreadflagFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbthreadflagFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbthreadflag();
		}
		else {
			MbthreadflagFormData mbthreadflagFormData = formData.get();

			String id = mbthreadflagFormData.threadFlagId;

			long mbthreadflagId = 0;

			if (id != null) {
				mbthreadflagId = Long.valueOf(id);
			}

			Mbthreadflag mbthreadflag;

			if (mbthreadflagId > 0) {
				mbthreadflag = Mbthreadflag.find.byId(mbthreadflagId);

				mbthreadflag.setUuid(mbthreadflagFormData.uuid);
				mbthreadflag.setThreadFlagId(Long.valueOf(mbthreadflagFormData.threadFlagId));
				mbthreadflag.setGroupId(Long.valueOf(mbthreadflagFormData.groupId));
				mbthreadflag.setCompanyId(Long.valueOf(mbthreadflagFormData.companyId));
				mbthreadflag.setUserId(Long.valueOf(mbthreadflagFormData.userId));
				mbthreadflag.setUserName(mbthreadflagFormData.userName);
				mbthreadflag.setCreateDate(new Date(mbthreadflagFormData.createDate));
				mbthreadflag.setModifiedDate(new Date(mbthreadflagFormData.modifiedDate));
				mbthreadflag.setThreadId(Long.valueOf(mbthreadflagFormData.threadId));
			}
			else {
				mbthreadflag = new Mbthreadflag(mbthreadflagFormData);
			}

			Ebean.save(mbthreadflag);

			flash("success", "Mbthreadflag instance created/edited: " + mbthreadflag);

			return all();
		}
	}

	public static Result delete(Form<MbthreadflagFormData> formData) {
		MbthreadflagFormData mbthreadflagFormData = formData.get();

		String id = mbthreadflagFormData.threadFlagId;

		long mbthreadflagId = 0;

		if (id != null) {
			mbthreadflagId = Long.valueOf(id);
		}

		Mbthreadflag mbthreadflag;

		if (mbthreadflagId > 0) {
			mbthreadflag = Mbthreadflag.find.byId(mbthreadflagId);

			Ebean.delete(mbthreadflag);
		}
		else {
			flash("error", "Cannot delete Mbthreadflag");
		}

		return all();
	}

}
