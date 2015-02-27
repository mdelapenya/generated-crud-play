
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbdiscussion.MbdiscussionFormData;

import models.mbdiscussion.Mbdiscussion;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbdiscussion.mbdiscussion;
import views.html.mbdiscussion.mbdiscussions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbdiscussionApplication extends Controller {

	public static Result addMbdiscussion() {
		Form<MbdiscussionFormData> form = Form.form(
			MbdiscussionFormData.class).fill(new Mbdiscussion().toFormData());

		return ok(mbdiscussion.render(form));
	}

	public static Result get(Long id) {
		Mbdiscussion dbMbdiscussion = Mbdiscussion.find.byId(id);

		Form<MbdiscussionFormData> form = Form.form(
			MbdiscussionFormData.class).fill(dbMbdiscussion.toFormData());

		return ok(mbdiscussion.render(form));
	}

	public static Result all() {
		List<Mbdiscussion> mbdiscussionList = Mbdiscussion.find.all();

		return ok(mbdiscussions.render(mbdiscussionList));
	}

	public static Result submit() {
		Form<MbdiscussionFormData> formData = Form.form(
			MbdiscussionFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbdiscussionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbdiscussion();
		}
		else {
			MbdiscussionFormData mbdiscussionFormData = formData.get();

			String id = mbdiscussionFormData.discussionId;

			long mbdiscussionId = 0;

			if (id != null) {
				mbdiscussionId = Long.valueOf(id);
			}

			Mbdiscussion mbdiscussion;

			if (mbdiscussionId > 0) {
				mbdiscussion = Mbdiscussion.find.byId(mbdiscussionId);

				mbdiscussion.setUuid(mbdiscussionFormData.uuid);
				mbdiscussion.setDiscussionId(Long.valueOf(mbdiscussionFormData.discussionId));
				mbdiscussion.setGroupId(Long.valueOf(mbdiscussionFormData.groupId));
				mbdiscussion.setCompanyId(Long.valueOf(mbdiscussionFormData.companyId));
				mbdiscussion.setUserId(Long.valueOf(mbdiscussionFormData.userId));
				mbdiscussion.setUserName(mbdiscussionFormData.userName);
				mbdiscussion.setCreateDate(new Date(mbdiscussionFormData.createDate));
				mbdiscussion.setModifiedDate(new Date(mbdiscussionFormData.modifiedDate));
				mbdiscussion.setClassNameId(Long.valueOf(mbdiscussionFormData.classNameId));
				mbdiscussion.setClassPK(Long.valueOf(mbdiscussionFormData.classPK));
				mbdiscussion.setThreadId(Long.valueOf(mbdiscussionFormData.threadId));
			}
			else {
				mbdiscussion = new Mbdiscussion(mbdiscussionFormData);
			}

			Ebean.save(mbdiscussion);

			flash("success", "Mbdiscussion instance created/edited: " + mbdiscussion);

			return all();
		}
	}

	public static Result delete(Form<MbdiscussionFormData> formData) {
		MbdiscussionFormData mbdiscussionFormData = formData.get();

		String id = mbdiscussionFormData.discussionId;

		long mbdiscussionId = 0;

		if (id != null) {
			mbdiscussionId = Long.valueOf(id);
		}

		Mbdiscussion mbdiscussion;

		if (mbdiscussionId > 0) {
			mbdiscussion = Mbdiscussion.find.byId(mbdiscussionId);

			Ebean.delete(mbdiscussion);
		}
		else {
			flash("error", "Cannot delete Mbdiscussion");
		}

		return all();
	}

}
