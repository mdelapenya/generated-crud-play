
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivitysetting.SocialactivitysettingFormData;

import models.socialactivitysetting.Socialactivitysetting;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivitysetting.socialactivitysetting;
import views.html.socialactivitysetting.socialactivitysettings;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivitysettingApplication extends Controller {

	public static Result addSocialactivitysetting() {
		Form<SocialactivitysettingFormData> form = Form.form(
			SocialactivitysettingFormData.class).fill(new Socialactivitysetting().toFormData());

		return ok(socialactivitysetting.render(form));
	}

	public static Result get(Long id) {
		Socialactivitysetting dbSocialactivitysetting = Socialactivitysetting.find.byId(id);

		Form<SocialactivitysettingFormData> form = Form.form(
			SocialactivitysettingFormData.class).fill(dbSocialactivitysetting.toFormData());

		return ok(socialactivitysetting.render(form));
	}

	public static Result all() {
		List<Socialactivitysetting> socialactivitysettingList = Socialactivitysetting.find.all();

		return ok(socialactivitysettings.render(socialactivitysettingList));
	}

	public static Result submit() {
		Form<SocialactivitysettingFormData> formData = Form.form(
			SocialactivitysettingFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivitysettingFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivitysetting();
		}
		else {
			SocialactivitysettingFormData socialactivitysettingFormData = formData.get();

			String id = socialactivitysettingFormData.activitySettingId;

			long socialactivitysettingId = 0;

			if (id != null) {
				socialactivitysettingId = Long.valueOf(id);
			}

			Socialactivitysetting socialactivitysetting;

			if (socialactivitysettingId > 0) {
				socialactivitysetting = Socialactivitysetting.find.byId(socialactivitysettingId);

				socialactivitysetting.setActivitySettingId(Long.valueOf(socialactivitysettingFormData.activitySettingId));
				socialactivitysetting.setGroupId(Long.valueOf(socialactivitysettingFormData.groupId));
				socialactivitysetting.setCompanyId(Long.valueOf(socialactivitysettingFormData.companyId));
				socialactivitysetting.setClassNameId(Long.valueOf(socialactivitysettingFormData.classNameId));
				socialactivitysetting.setActivityType(Integer.valueOf(socialactivitysettingFormData.activityType));
				socialactivitysetting.setName(socialactivitysettingFormData.name);
				socialactivitysetting.setValue(socialactivitysettingFormData.value);
			}
			else {
				socialactivitysetting = new Socialactivitysetting(socialactivitysettingFormData);
			}

			Ebean.save(socialactivitysetting);

			flash("success", "Socialactivitysetting instance created/edited: " + socialactivitysetting);

			return all();
		}
	}

	public static Result delete(Form<SocialactivitysettingFormData> formData) {
		SocialactivitysettingFormData socialactivitysettingFormData = formData.get();

		String id = socialactivitysettingFormData.activitySettingId;

		long socialactivitysettingId = 0;

		if (id != null) {
			socialactivitysettingId = Long.valueOf(id);
		}

		Socialactivitysetting socialactivitysetting;

		if (socialactivitysettingId > 0) {
			socialactivitysetting = Socialactivitysetting.find.byId(socialactivitysettingId);

			Ebean.delete(socialactivitysetting);
		}
		else {
			flash("error", "Cannot delete Socialactivitysetting");
		}

		return all();
	}

}
