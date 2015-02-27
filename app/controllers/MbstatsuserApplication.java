
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbstatsuser.MbstatsuserFormData;

import models.mbstatsuser.Mbstatsuser;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbstatsuser.mbstatsuser;
import views.html.mbstatsuser.mbstatsusers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbstatsuserApplication extends Controller {

	public static Result addMbstatsuser() {
		Form<MbstatsuserFormData> form = Form.form(
			MbstatsuserFormData.class).fill(new Mbstatsuser().toFormData());

		return ok(mbstatsuser.render(form));
	}

	public static Result get(Long id) {
		Mbstatsuser dbMbstatsuser = Mbstatsuser.find.byId(id);

		Form<MbstatsuserFormData> form = Form.form(
			MbstatsuserFormData.class).fill(dbMbstatsuser.toFormData());

		return ok(mbstatsuser.render(form));
	}

	public static Result all() {
		List<Mbstatsuser> mbstatsuserList = Mbstatsuser.find.all();

		return ok(mbstatsusers.render(mbstatsuserList));
	}

	public static Result submit() {
		Form<MbstatsuserFormData> formData = Form.form(
			MbstatsuserFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbstatsuserFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbstatsuser();
		}
		else {
			MbstatsuserFormData mbstatsuserFormData = formData.get();

			String id = mbstatsuserFormData.statsUserId;

			long mbstatsuserId = 0;

			if (id != null) {
				mbstatsuserId = Long.valueOf(id);
			}

			Mbstatsuser mbstatsuser;

			if (mbstatsuserId > 0) {
				mbstatsuser = Mbstatsuser.find.byId(mbstatsuserId);

				mbstatsuser.setStatsUserId(Long.valueOf(mbstatsuserFormData.statsUserId));
				mbstatsuser.setGroupId(Long.valueOf(mbstatsuserFormData.groupId));
				mbstatsuser.setUserId(Long.valueOf(mbstatsuserFormData.userId));
				mbstatsuser.setMessageCount(Integer.valueOf(mbstatsuserFormData.messageCount));
				mbstatsuser.setLastPostDate(new Date(mbstatsuserFormData.lastPostDate));
			}
			else {
				mbstatsuser = new Mbstatsuser(mbstatsuserFormData);
			}

			Ebean.save(mbstatsuser);

			flash("success", "Mbstatsuser instance created/edited: " + mbstatsuser);

			return all();
		}
	}

	public static Result delete(Form<MbstatsuserFormData> formData) {
		MbstatsuserFormData mbstatsuserFormData = formData.get();

		String id = mbstatsuserFormData.statsUserId;

		long mbstatsuserId = 0;

		if (id != null) {
			mbstatsuserId = Long.valueOf(id);
		}

		Mbstatsuser mbstatsuser;

		if (mbstatsuserId > 0) {
			mbstatsuser = Mbstatsuser.find.byId(mbstatsuserId);

			Ebean.delete(mbstatsuser);
		}
		else {
			flash("error", "Cannot delete Mbstatsuser");
		}

		return all();
	}

}
