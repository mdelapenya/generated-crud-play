
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbban.MbbanFormData;

import models.mbban.Mbban;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbban.mbban;
import views.html.mbban.mbbans;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbbanApplication extends Controller {

	public static Result addMbban() {
		Form<MbbanFormData> form = Form.form(
			MbbanFormData.class).fill(new Mbban().toFormData());

		return ok(mbban.render(form));
	}

	public static Result get(Long id) {
		Mbban dbMbban = Mbban.find.byId(id);

		Form<MbbanFormData> form = Form.form(
			MbbanFormData.class).fill(dbMbban.toFormData());

		return ok(mbban.render(form));
	}

	public static Result all() {
		List<Mbban> mbbanList = Mbban.find.all();

		return ok(mbbans.render(mbbanList));
	}

	public static Result submit() {
		Form<MbbanFormData> formData = Form.form(
			MbbanFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbbanFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbban();
		}
		else {
			MbbanFormData mbbanFormData = formData.get();

			String id = mbbanFormData.banId;

			long mbbanId = 0;

			if (id != null) {
				mbbanId = Long.valueOf(id);
			}

			Mbban mbban;

			if (mbbanId > 0) {
				mbban = Mbban.find.byId(mbbanId);

				mbban.setUuid(mbbanFormData.uuid);
				mbban.setBanId(Long.valueOf(mbbanFormData.banId));
				mbban.setGroupId(Long.valueOf(mbbanFormData.groupId));
				mbban.setCompanyId(Long.valueOf(mbbanFormData.companyId));
				mbban.setUserId(Long.valueOf(mbbanFormData.userId));
				mbban.setUserName(mbbanFormData.userName);
				mbban.setCreateDate(new Date(mbbanFormData.createDate));
				mbban.setModifiedDate(new Date(mbbanFormData.modifiedDate));
				mbban.setBanUserId(Long.valueOf(mbbanFormData.banUserId));
			}
			else {
				mbban = new Mbban(mbbanFormData);
			}

			Ebean.save(mbban);

			flash("success", "Mbban instance created/edited: " + mbban);

			return all();
		}
	}

	public static Result delete(Form<MbbanFormData> formData) {
		MbbanFormData mbbanFormData = formData.get();

		String id = mbbanFormData.banId;

		long mbbanId = 0;

		if (id != null) {
			mbbanId = Long.valueOf(id);
		}

		Mbban mbban;

		if (mbbanId > 0) {
			mbban = Mbban.find.byId(mbbanId);

			Ebean.delete(mbban);
		}
		else {
			flash("error", "Cannot delete Mbban");
		}

		return all();
	}

}
