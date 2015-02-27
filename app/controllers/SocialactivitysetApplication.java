
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialactivityset.SocialactivitysetFormData;

import models.socialactivityset.Socialactivityset;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialactivityset.socialactivityset;
import views.html.socialactivityset.socialactivitysets;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialactivitysetApplication extends Controller {

	public static Result addSocialactivityset() {
		Form<SocialactivitysetFormData> form = Form.form(
			SocialactivitysetFormData.class).fill(new Socialactivityset().toFormData());

		return ok(socialactivityset.render(form));
	}

	public static Result get(Long id) {
		Socialactivityset dbSocialactivityset = Socialactivityset.find.byId(id);

		Form<SocialactivitysetFormData> form = Form.form(
			SocialactivitysetFormData.class).fill(dbSocialactivityset.toFormData());

		return ok(socialactivityset.render(form));
	}

	public static Result all() {
		List<Socialactivityset> socialactivitysetList = Socialactivityset.find.all();

		return ok(socialactivitysets.render(socialactivitysetList));
	}

	public static Result submit() {
		Form<SocialactivitysetFormData> formData = Form.form(
			SocialactivitysetFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialactivitysetFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialactivityset();
		}
		else {
			SocialactivitysetFormData socialactivitysetFormData = formData.get();

			String id = socialactivitysetFormData.activitySetId;

			long socialactivitysetId = 0;

			if (id != null) {
				socialactivitysetId = Long.valueOf(id);
			}

			Socialactivityset socialactivityset;

			if (socialactivitysetId > 0) {
				socialactivityset = Socialactivityset.find.byId(socialactivitysetId);

				socialactivityset.setActivitySetId(Long.valueOf(socialactivitysetFormData.activitySetId));
				socialactivityset.setGroupId(Long.valueOf(socialactivitysetFormData.groupId));
				socialactivityset.setCompanyId(Long.valueOf(socialactivitysetFormData.companyId));
				socialactivityset.setUserId(Long.valueOf(socialactivitysetFormData.userId));
				socialactivityset.setCreateDate(Long.valueOf(socialactivitysetFormData.createDate));
				socialactivityset.setModifiedDate(Long.valueOf(socialactivitysetFormData.modifiedDate));
				socialactivityset.setClassNameId(Long.valueOf(socialactivitysetFormData.classNameId));
				socialactivityset.setClassPK(Long.valueOf(socialactivitysetFormData.classPK));
				socialactivityset.setCustomtype(Integer.valueOf(socialactivitysetFormData.customtype));
				socialactivityset.setExtraData(socialactivitysetFormData.extraData);
				socialactivityset.setActivityCount(Integer.valueOf(socialactivitysetFormData.activityCount));
			}
			else {
				socialactivityset = new Socialactivityset(socialactivitysetFormData);
			}

			Ebean.save(socialactivityset);

			flash("success", "Socialactivityset instance created/edited: " + socialactivityset);

			return all();
		}
	}

	public static Result delete(Form<SocialactivitysetFormData> formData) {
		SocialactivitysetFormData socialactivitysetFormData = formData.get();

		String id = socialactivitysetFormData.activitySetId;

		long socialactivitysetId = 0;

		if (id != null) {
			socialactivitysetId = Long.valueOf(id);
		}

		Socialactivityset socialactivityset;

		if (socialactivitysetId > 0) {
			socialactivityset = Socialactivityset.find.byId(socialactivitysetId);

			Ebean.delete(socialactivityset);
		}
		else {
			flash("error", "Cannot delete Socialactivityset");
		}

		return all();
	}

}
