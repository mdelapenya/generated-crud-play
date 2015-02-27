
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivitylimit.SocialactivitylimitFormData;

import models.socialactivitylimit.Socialactivitylimit;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivitylimit.socialactivitylimit;
import views.html.socialactivitylimit.socialactivitylimits;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivitylimitApplication extends Controller {

	public static Result addSocialactivitylimit() {
		Form<SocialactivitylimitFormData> form = Form.form(
			SocialactivitylimitFormData.class).fill(new Socialactivitylimit().toFormData());

		return ok(socialactivitylimit.render(form));
	}

	public static Result get(Long id) {
		Socialactivitylimit dbSocialactivitylimit = Socialactivitylimit.find.byId(id);

		Form<SocialactivitylimitFormData> form = Form.form(
			SocialactivitylimitFormData.class).fill(dbSocialactivitylimit.toFormData());

		return ok(socialactivitylimit.render(form));
	}

	public static Result all() {
		List<Socialactivitylimit> socialactivitylimitList = Socialactivitylimit.find.all();

		return ok(socialactivitylimits.render(socialactivitylimitList));
	}

	public static Result submit() {
		Form<SocialactivitylimitFormData> formData = Form.form(
			SocialactivitylimitFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivitylimitFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivitylimit();
		}
		else {
			SocialactivitylimitFormData socialactivitylimitFormData = formData.get();

			String id = socialactivitylimitFormData.activityLimitId;

			long socialactivitylimitId = 0;

			if (id != null) {
				socialactivitylimitId = Long.valueOf(id);
			}

			Socialactivitylimit socialactivitylimit;

			if (socialactivitylimitId > 0) {
				socialactivitylimit = Socialactivitylimit.find.byId(socialactivitylimitId);

				socialactivitylimit.setActivityLimitId(Long.valueOf(socialactivitylimitFormData.activityLimitId));
				socialactivitylimit.setGroupId(Long.valueOf(socialactivitylimitFormData.groupId));
				socialactivitylimit.setCompanyId(Long.valueOf(socialactivitylimitFormData.companyId));
				socialactivitylimit.setUserId(Long.valueOf(socialactivitylimitFormData.userId));
				socialactivitylimit.setClassNameId(Long.valueOf(socialactivitylimitFormData.classNameId));
				socialactivitylimit.setClassPK(Long.valueOf(socialactivitylimitFormData.classPK));
				socialactivitylimit.setActivityType(Integer.valueOf(socialactivitylimitFormData.activityType));
				socialactivitylimit.setActivityCounterName(socialactivitylimitFormData.activityCounterName);
				socialactivitylimit.setValue(socialactivitylimitFormData.value);
			}
			else {
				socialactivitylimit = new Socialactivitylimit(socialactivitylimitFormData);
			}

			Ebean.save(socialactivitylimit);

			flash("success", "Socialactivitylimit instance created/edited: " + socialactivitylimit);

			return all();
		}
	}

	public static Result delete(Form<SocialactivitylimitFormData> formData) {
		SocialactivitylimitFormData socialactivitylimitFormData = formData.get();

		String id = socialactivitylimitFormData.activityLimitId;

		long socialactivitylimitId = 0;

		if (id != null) {
			socialactivitylimitId = Long.valueOf(id);
		}

		Socialactivitylimit socialactivitylimit;

		if (socialactivitylimitId > 0) {
			socialactivitylimit = Socialactivitylimit.find.byId(socialactivitylimitId);

			Ebean.delete(socialactivitylimit);
		}
		else {
			flash("error", "Cannot delete Socialactivitylimit");
		}

		return all();
	}

}
