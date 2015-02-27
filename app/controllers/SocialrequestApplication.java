
package controllers;

import com.avaje.ebean.Ebean;

import controllers.socialrequest.SocialrequestFormData;

import models.socialrequest.Socialrequest;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.socialrequest.socialrequest;
import views.html.socialrequest.socialrequests;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SocialrequestApplication extends Controller {

	public static Result addSocialrequest() {
		Form<SocialrequestFormData> form = Form.form(
			SocialrequestFormData.class).fill(new Socialrequest().toFormData());

		return ok(socialrequest.render(form));
	}

	public static Result get(Long id) {
		Socialrequest dbSocialrequest = Socialrequest.find.byId(id);

		Form<SocialrequestFormData> form = Form.form(
			SocialrequestFormData.class).fill(dbSocialrequest.toFormData());

		return ok(socialrequest.render(form));
	}

	public static Result all() {
		List<Socialrequest> socialrequestList = Socialrequest.find.all();

		return ok(socialrequests.render(socialrequestList));
	}

	public static Result submit() {
		Form<SocialrequestFormData> formData = Form.form(
			SocialrequestFormData.class).bindFromRequest();

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

	public static Result edit(Form<SocialrequestFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSocialrequest();
		}
		else {
			SocialrequestFormData socialrequestFormData = formData.get();

			String id = socialrequestFormData.requestId;

			long socialrequestId = 0;

			if (id != null) {
				socialrequestId = Long.valueOf(id);
			}

			Socialrequest socialrequest;

			if (socialrequestId > 0) {
				socialrequest = Socialrequest.find.byId(socialrequestId);

				socialrequest.setUuid(socialrequestFormData.uuid);
				socialrequest.setRequestId(Long.valueOf(socialrequestFormData.requestId));
				socialrequest.setGroupId(Long.valueOf(socialrequestFormData.groupId));
				socialrequest.setCompanyId(Long.valueOf(socialrequestFormData.companyId));
				socialrequest.setUserId(Long.valueOf(socialrequestFormData.userId));
				socialrequest.setCreateDate(Long.valueOf(socialrequestFormData.createDate));
				socialrequest.setModifiedDate(Long.valueOf(socialrequestFormData.modifiedDate));
				socialrequest.setClassNameId(Long.valueOf(socialrequestFormData.classNameId));
				socialrequest.setClassPK(Long.valueOf(socialrequestFormData.classPK));
				socialrequest.setCustomtype(Integer.valueOf(socialrequestFormData.customtype));
				socialrequest.setExtraData(socialrequestFormData.extraData);
				socialrequest.setReceiverUserId(Long.valueOf(socialrequestFormData.receiverUserId));
				socialrequest.setStatus(Integer.valueOf(socialrequestFormData.status));
			}
			else {
				socialrequest = new Socialrequest(socialrequestFormData);
			}

			Ebean.save(socialrequest);

			flash("success", "Socialrequest instance created/edited: " + socialrequest);

			return all();
		}
	}

	public static Result delete(Form<SocialrequestFormData> formData) {
		SocialrequestFormData socialrequestFormData = formData.get();

		String id = socialrequestFormData.requestId;

		long socialrequestId = 0;

		if (id != null) {
			socialrequestId = Long.valueOf(id);
		}

		Socialrequest socialrequest;

		if (socialrequestId > 0) {
			socialrequest = Socialrequest.find.byId(socialrequestId);

			Ebean.delete(socialrequest);
		}
		else {
			flash("error", "Cannot delete Socialrequest");
		}

		return all();
	}

}
