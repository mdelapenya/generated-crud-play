
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialrelation.SocialrelationFormData;

import models.socialrelation.Socialrelation;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialrelation.socialrelation;
import views.html.socialrelation.socialrelations;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialrelationApplication extends Controller {

	public static Result addSocialrelation() {
		Form<SocialrelationFormData> form = Form.form(
			SocialrelationFormData.class).fill(new Socialrelation().toFormData());

		return ok(socialrelation.render(form));
	}

	public static Result get(Long id) {
		Socialrelation dbSocialrelation = Socialrelation.find.byId(id);

		Form<SocialrelationFormData> form = Form.form(
			SocialrelationFormData.class).fill(dbSocialrelation.toFormData());

		return ok(socialrelation.render(form));
	}

	public static Result all() {
		List<Socialrelation> socialrelationList = Socialrelation.find.all();

		return ok(socialrelations.render(socialrelationList));
	}

	public static Result submit() {
		Form<SocialrelationFormData> formData = Form.form(
			SocialrelationFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialrelationFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialrelation();
		}
		else {
			SocialrelationFormData socialrelationFormData = formData.get();

			String id = socialrelationFormData.relationId;

			long socialrelationId = 0;

			if (id != null) {
				socialrelationId = Long.valueOf(id);
			}

			Socialrelation socialrelation;

			if (socialrelationId > 0) {
				socialrelation = Socialrelation.find.byId(socialrelationId);

				socialrelation.setUuid(socialrelationFormData.uuid);
				socialrelation.setRelationId(Long.valueOf(socialrelationFormData.relationId));
				socialrelation.setCompanyId(Long.valueOf(socialrelationFormData.companyId));
				socialrelation.setCreateDate(Long.valueOf(socialrelationFormData.createDate));
				socialrelation.setUserId1(Long.valueOf(socialrelationFormData.userId1));
				socialrelation.setUserId2(Long.valueOf(socialrelationFormData.userId2));
				socialrelation.setCustomtype(Integer.valueOf(socialrelationFormData.customtype));
			}
			else {
				socialrelation = new Socialrelation(socialrelationFormData);
			}

			Ebean.save(socialrelation);

			flash("success", "Socialrelation instance created/edited: " + socialrelation);

			return all();
		}
	}

	public static Result delete(Form<SocialrelationFormData> formData) {
		SocialrelationFormData socialrelationFormData = formData.get();

		String id = socialrelationFormData.relationId;

		long socialrelationId = 0;

		if (id != null) {
			socialrelationId = Long.valueOf(id);
		}

		Socialrelation socialrelation;

		if (socialrelationId > 0) {
			socialrelation = Socialrelation.find.byId(socialrelationId);

			Ebean.delete(socialrelation);
		}
		else {
			flash("error", "Cannot delete Socialrelation");
		}

		return all();
	}

}
