
package controllers;

import com.avaje.ebean.Ebean;

import controllers.membershiprequest.MembershiprequestFormData;

import models.membershiprequest.Membershiprequest;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.membershiprequest.membershiprequest;
import views.html.membershiprequest.membershiprequests;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MembershiprequestApplication extends Controller {

	public static Result addMembershiprequest() {
		Form<MembershiprequestFormData> form = Form.form(
			MembershiprequestFormData.class).fill(new Membershiprequest().toFormData());

		return ok(membershiprequest.render(form));
	}

	public static Result get(Long id) {
		Membershiprequest dbMembershiprequest = Membershiprequest.find.byId(id);

		Form<MembershiprequestFormData> form = Form.form(
			MembershiprequestFormData.class).fill(dbMembershiprequest.toFormData());

		return ok(membershiprequest.render(form));
	}

	public static Result all() {
		List<Membershiprequest> membershiprequestList = Membershiprequest.find.all();

		return ok(membershiprequests.render(membershiprequestList));
	}

	public static Result submit() {
		Form<MembershiprequestFormData> formData = Form.form(
			MembershiprequestFormData.class).bindFromRequest();

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

	public static Result edit(Form<MembershiprequestFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMembershiprequest();
		}
		else {
			MembershiprequestFormData membershiprequestFormData = formData.get();

			String id = membershiprequestFormData.membershipRequestId;

			long membershiprequestId = 0;

			if (id != null) {
				membershiprequestId = Long.valueOf(id);
			}

			Membershiprequest membershiprequest;

			if (membershiprequestId > 0) {
				membershiprequest = Membershiprequest.find.byId(membershiprequestId);

				membershiprequest.setMvccVersion(Long.valueOf(membershiprequestFormData.mvccVersion));
				membershiprequest.setMembershipRequestId(Long.valueOf(membershiprequestFormData.membershipRequestId));
				membershiprequest.setGroupId(Long.valueOf(membershiprequestFormData.groupId));
				membershiprequest.setCompanyId(Long.valueOf(membershiprequestFormData.companyId));
				membershiprequest.setUserId(Long.valueOf(membershiprequestFormData.userId));
				membershiprequest.setCreateDate(new Date(membershiprequestFormData.createDate));
				membershiprequest.setComments(membershiprequestFormData.comments);
				membershiprequest.setReplyComments(membershiprequestFormData.replyComments);
				membershiprequest.setReplyDate(new Date(membershiprequestFormData.replyDate));
				membershiprequest.setReplierUserId(Long.valueOf(membershiprequestFormData.replierUserId));
				membershiprequest.setStatusId(Long.valueOf(membershiprequestFormData.statusId));
			}
			else {
				membershiprequest = new Membershiprequest(membershiprequestFormData);
			}

			Ebean.save(membershiprequest);

			flash("success", "Membershiprequest instance created/edited: " + membershiprequest);

			return all();
		}
	}

	public static Result delete(Form<MembershiprequestFormData> formData) {
		MembershiprequestFormData membershiprequestFormData = formData.get();

		String id = membershiprequestFormData.membershipRequestId;

		long membershiprequestId = 0;

		if (id != null) {
			membershiprequestId = Long.valueOf(id);
		}

		Membershiprequest membershiprequest;

		if (membershiprequestId > 0) {
			membershiprequest = Membershiprequest.find.byId(membershiprequestId);

			Ebean.delete(membershiprequest);
		}
		else {
			flash("error", "Cannot delete Membershiprequest");
		}

		return all();
	}

}
