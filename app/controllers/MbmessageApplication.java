
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbmessage.MbmessageFormData;

import models.mbmessage.Mbmessage;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbmessage.mbmessage;
import views.html.mbmessage.mbmessages;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbmessageApplication extends Controller {

	public static Result addMbmessage() {
		Form<MbmessageFormData> form = Form.form(
			MbmessageFormData.class).fill(new Mbmessage().toFormData());

		return ok(mbmessage.render(form));
	}

	public static Result get(Long id) {
		Mbmessage dbMbmessage = Mbmessage.find.byId(id);

		Form<MbmessageFormData> form = Form.form(
			MbmessageFormData.class).fill(dbMbmessage.toFormData());

		return ok(mbmessage.render(form));
	}

	public static Result all() {
		List<Mbmessage> mbmessageList = Mbmessage.find.all();

		return ok(mbmessages.render(mbmessageList));
	}

	public static Result submit() {
		Form<MbmessageFormData> formData = Form.form(
			MbmessageFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbmessageFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbmessage();
		}
		else {
			MbmessageFormData mbmessageFormData = formData.get();

			String id = mbmessageFormData.messageId;

			long mbmessageId = 0;

			if (id != null) {
				mbmessageId = Long.valueOf(id);
			}

			Mbmessage mbmessage;

			if (mbmessageId > 0) {
				mbmessage = Mbmessage.find.byId(mbmessageId);

				mbmessage.setUuid(mbmessageFormData.uuid);
				mbmessage.setMessageId(Long.valueOf(mbmessageFormData.messageId));
				mbmessage.setGroupId(Long.valueOf(mbmessageFormData.groupId));
				mbmessage.setCompanyId(Long.valueOf(mbmessageFormData.companyId));
				mbmessage.setUserId(Long.valueOf(mbmessageFormData.userId));
				mbmessage.setUserName(mbmessageFormData.userName);
				mbmessage.setCreateDate(new Date(mbmessageFormData.createDate));
				mbmessage.setModifiedDate(new Date(mbmessageFormData.modifiedDate));
				mbmessage.setClassNameId(Long.valueOf(mbmessageFormData.classNameId));
				mbmessage.setClassPK(Long.valueOf(mbmessageFormData.classPK));
				mbmessage.setCategoryId(Long.valueOf(mbmessageFormData.categoryId));
				mbmessage.setThreadId(Long.valueOf(mbmessageFormData.threadId));
				mbmessage.setRootMessageId(Long.valueOf(mbmessageFormData.rootMessageId));
				mbmessage.setParentMessageId(Long.valueOf(mbmessageFormData.parentMessageId));
				mbmessage.setSubject(mbmessageFormData.subject);
				mbmessage.setBody(mbmessageFormData.body);
				mbmessage.setFormat(mbmessageFormData.format);
				mbmessage.setAnonymous(Boolean.valueOf(mbmessageFormData.anonymous));
				mbmessage.setPriority(Double.valueOf(mbmessageFormData.priority));
				mbmessage.setAllowPingbacks(Boolean.valueOf(mbmessageFormData.allowPingbacks));
				mbmessage.setAnswer(Boolean.valueOf(mbmessageFormData.answer));
				mbmessage.setStatus(Integer.valueOf(mbmessageFormData.status));
				mbmessage.setStatusByUserId(Long.valueOf(mbmessageFormData.statusByUserId));
				mbmessage.setStatusByUserName(mbmessageFormData.statusByUserName);
				mbmessage.setStatusDate(new Date(mbmessageFormData.statusDate));
			}
			else {
				mbmessage = new Mbmessage(mbmessageFormData);
			}

			Ebean.save(mbmessage);

			flash("success", "Mbmessage instance created/edited: " + mbmessage);

			return all();
		}
	}

	public static Result delete(Form<MbmessageFormData> formData) {
		MbmessageFormData mbmessageFormData = formData.get();

		String id = mbmessageFormData.messageId;

		long mbmessageId = 0;

		if (id != null) {
			mbmessageId = Long.valueOf(id);
		}

		Mbmessage mbmessage;

		if (mbmessageId > 0) {
			mbmessage = Mbmessage.find.byId(mbmessageId);

			Ebean.delete(mbmessage);
		}
		else {
			flash("error", "Cannot delete Mbmessage");
		}

		return all();
	}

}
