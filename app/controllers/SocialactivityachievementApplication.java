
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivityachievement.SocialactivityachievementFormData;

import models.socialactivityachievement.Socialactivityachievement;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivityachievement.socialactivityachievement;
import views.html.socialactivityachievement.socialactivityachievements;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivityachievementApplication extends Controller {

	public static Result addSocialactivityachievement() {
		Form<SocialactivityachievementFormData> form = Form.form(
			SocialactivityachievementFormData.class).fill(new Socialactivityachievement().toFormData());

		return ok(socialactivityachievement.render(form));
	}

	public static Result get(Long id) {
		Socialactivityachievement dbSocialactivityachievement = Socialactivityachievement.find.byId(id);

		Form<SocialactivityachievementFormData> form = Form.form(
			SocialactivityachievementFormData.class).fill(dbSocialactivityachievement.toFormData());

		return ok(socialactivityachievement.render(form));
	}

	public static Result all() {
		List<Socialactivityachievement> socialactivityachievementList = Socialactivityachievement.find.all();

		return ok(socialactivityachievements.render(socialactivityachievementList));
	}

	public static Result submit() {
		Form<SocialactivityachievementFormData> formData = Form.form(
			SocialactivityachievementFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivityachievementFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivityachievement();
		}
		else {
			SocialactivityachievementFormData socialactivityachievementFormData = formData.get();

			String id = socialactivityachievementFormData.activityAchievementId;

			long socialactivityachievementId = 0;

			if (id != null) {
				socialactivityachievementId = Long.valueOf(id);
			}

			Socialactivityachievement socialactivityachievement;

			if (socialactivityachievementId > 0) {
				socialactivityachievement = Socialactivityachievement.find.byId(socialactivityachievementId);

				socialactivityachievement.setActivityAchievementId(Long.valueOf(socialactivityachievementFormData.activityAchievementId));
				socialactivityachievement.setGroupId(Long.valueOf(socialactivityachievementFormData.groupId));
				socialactivityachievement.setCompanyId(Long.valueOf(socialactivityachievementFormData.companyId));
				socialactivityachievement.setUserId(Long.valueOf(socialactivityachievementFormData.userId));
				socialactivityachievement.setCreateDate(Long.valueOf(socialactivityachievementFormData.createDate));
				socialactivityachievement.setName(socialactivityachievementFormData.name);
				socialactivityachievement.setFirstInGroup(Boolean.valueOf(socialactivityachievementFormData.firstInGroup));
			}
			else {
				socialactivityachievement = new Socialactivityachievement(socialactivityachievementFormData);
			}

			Ebean.save(socialactivityachievement);

			flash("success", "Socialactivityachievement instance created/edited: " + socialactivityachievement);

			return all();
		}
	}

	public static Result delete(Form<SocialactivityachievementFormData> formData) {
		SocialactivityachievementFormData socialactivityachievementFormData = formData.get();

		String id = socialactivityachievementFormData.activityAchievementId;

		long socialactivityachievementId = 0;

		if (id != null) {
			socialactivityachievementId = Long.valueOf(id);
		}

		Socialactivityachievement socialactivityachievement;

		if (socialactivityachievementId > 0) {
			socialactivityachievement = Socialactivityachievement.find.byId(socialactivityachievementId);

			Ebean.delete(socialactivityachievement);
		}
		else {
			flash("error", "Cannot delete Socialactivityachievement");
		}

		return all();
	}

}
