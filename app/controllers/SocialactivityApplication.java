
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivity.SocialactivityFormData;

import models.socialactivity.Socialactivity;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivity.socialactivity;
import views.html.socialactivity.socialactivitys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivityApplication extends Controller {

	public static Result addSocialactivity() {
		Form<SocialactivityFormData> form = Form.form(
			SocialactivityFormData.class).fill(new Socialactivity().toFormData());

		return ok(socialactivity.render(form));
	}

	public static Result get(Long id) {
		Socialactivity dbSocialactivity = Socialactivity.find.byId(id);

		Form<SocialactivityFormData> form = Form.form(
			SocialactivityFormData.class).fill(dbSocialactivity.toFormData());

		return ok(socialactivity.render(form));
	}

	public static Result all() {
		List<Socialactivity> socialactivityList = Socialactivity.find.all();

		return ok(socialactivitys.render(socialactivityList));
	}

	public static Result submit() {
		Form<SocialactivityFormData> formData = Form.form(
			SocialactivityFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivityFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivity();
		}
		else {
			SocialactivityFormData socialactivityFormData = formData.get();

			String id = socialactivityFormData.activityId;

			long socialactivityId = 0;

			if (id != null) {
				socialactivityId = Long.valueOf(id);
			}

			Socialactivity socialactivity;

			if (socialactivityId > 0) {
				socialactivity = Socialactivity.find.byId(socialactivityId);

				socialactivity.setActivityId(Long.valueOf(socialactivityFormData.activityId));
				socialactivity.setGroupId(Long.valueOf(socialactivityFormData.groupId));
				socialactivity.setCompanyId(Long.valueOf(socialactivityFormData.companyId));
				socialactivity.setUserId(Long.valueOf(socialactivityFormData.userId));
				socialactivity.setCreateDate(Long.valueOf(socialactivityFormData.createDate));
				socialactivity.setActivitySetId(Long.valueOf(socialactivityFormData.activitySetId));
				socialactivity.setMirrorActivityId(Long.valueOf(socialactivityFormData.mirrorActivityId));
				socialactivity.setClassNameId(Long.valueOf(socialactivityFormData.classNameId));
				socialactivity.setClassPK(Long.valueOf(socialactivityFormData.classPK));
				socialactivity.setParentClassNameId(Long.valueOf(socialactivityFormData.parentClassNameId));
				socialactivity.setParentClassPK(Long.valueOf(socialactivityFormData.parentClassPK));
				socialactivity.setCustomtype(Integer.valueOf(socialactivityFormData.customtype));
				socialactivity.setExtraData(socialactivityFormData.extraData);
				socialactivity.setReceiverUserId(Long.valueOf(socialactivityFormData.receiverUserId));
			}
			else {
				socialactivity = new Socialactivity(socialactivityFormData);
			}

			Ebean.save(socialactivity);

			flash("success", "Socialactivity instance created/edited: " + socialactivity);

			return all();
		}
	}

	public static Result delete(Form<SocialactivityFormData> formData) {
		SocialactivityFormData socialactivityFormData = formData.get();

		String id = socialactivityFormData.activityId;

		long socialactivityId = 0;

		if (id != null) {
			socialactivityId = Long.valueOf(id);
		}

		Socialactivity socialactivity;

		if (socialactivityId > 0) {
			socialactivity = Socialactivity.find.byId(socialactivityId);

			Ebean.delete(socialactivity);
		}
		else {
			flash("error", "Cannot delete Socialactivity");
		}

		return all();
	}

}
