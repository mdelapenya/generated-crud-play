
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivitycounter.SocialactivitycounterFormData;

import models.socialactivitycounter.Socialactivitycounter;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivitycounter.socialactivitycounter;
import views.html.socialactivitycounter.socialactivitycounters;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivitycounterApplication extends Controller {

	public static Result addSocialactivitycounter() {
		Form<SocialactivitycounterFormData> form = Form.form(
			SocialactivitycounterFormData.class).fill(new Socialactivitycounter().toFormData());

		return ok(socialactivitycounter.render(form));
	}

	public static Result get(Long id) {
		Socialactivitycounter dbSocialactivitycounter = Socialactivitycounter.find.byId(id);

		Form<SocialactivitycounterFormData> form = Form.form(
			SocialactivitycounterFormData.class).fill(dbSocialactivitycounter.toFormData());

		return ok(socialactivitycounter.render(form));
	}

	public static Result all() {
		List<Socialactivitycounter> socialactivitycounterList = Socialactivitycounter.find.all();

		return ok(socialactivitycounters.render(socialactivitycounterList));
	}

	public static Result submit() {
		Form<SocialactivitycounterFormData> formData = Form.form(
			SocialactivitycounterFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivitycounterFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivitycounter();
		}
		else {
			SocialactivitycounterFormData socialactivitycounterFormData = formData.get();

			String id = socialactivitycounterFormData.activityCounterId;

			long socialactivitycounterId = 0;

			if (id != null) {
				socialactivitycounterId = Long.valueOf(id);
			}

			Socialactivitycounter socialactivitycounter;

			if (socialactivitycounterId > 0) {
				socialactivitycounter = Socialactivitycounter.find.byId(socialactivitycounterId);

				socialactivitycounter.setActivityCounterId(Long.valueOf(socialactivitycounterFormData.activityCounterId));
				socialactivitycounter.setGroupId(Long.valueOf(socialactivitycounterFormData.groupId));
				socialactivitycounter.setCompanyId(Long.valueOf(socialactivitycounterFormData.companyId));
				socialactivitycounter.setClassNameId(Long.valueOf(socialactivitycounterFormData.classNameId));
				socialactivitycounter.setClassPK(Long.valueOf(socialactivitycounterFormData.classPK));
				socialactivitycounter.setName(socialactivitycounterFormData.name);
				socialactivitycounter.setOwnerType(Integer.valueOf(socialactivitycounterFormData.ownerType));
				socialactivitycounter.setCurrentValue(Integer.valueOf(socialactivitycounterFormData.currentValue));
				socialactivitycounter.setTotalValue(Integer.valueOf(socialactivitycounterFormData.totalValue));
				socialactivitycounter.setGraceValue(Integer.valueOf(socialactivitycounterFormData.graceValue));
				socialactivitycounter.setStartPeriod(Integer.valueOf(socialactivitycounterFormData.startPeriod));
				socialactivitycounter.setEndPeriod(Integer.valueOf(socialactivitycounterFormData.endPeriod));
				socialactivitycounter.setActive(Boolean.valueOf(socialactivitycounterFormData.active));
			}
			else {
				socialactivitycounter = new Socialactivitycounter(socialactivitycounterFormData);
			}

			Ebean.save(socialactivitycounter);

			flash("success", "Socialactivitycounter instance created/edited: " + socialactivitycounter);

			return all();
		}
	}

	public static Result delete(Form<SocialactivitycounterFormData> formData) {
		SocialactivitycounterFormData socialactivitycounterFormData = formData.get();

		String id = socialactivitycounterFormData.activityCounterId;

		long socialactivitycounterId = 0;

		if (id != null) {
			socialactivitycounterId = Long.valueOf(id);
		}

		Socialactivitycounter socialactivitycounter;

		if (socialactivitycounterId > 0) {
			socialactivitycounter = Socialactivitycounter.find.byId(socialactivitycounterId);

			Ebean.delete(socialactivitycounter);
		}
		else {
			flash("error", "Cannot delete Socialactivitycounter");
		}

		return all();
	}

}
