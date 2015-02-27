
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbthread.MbthreadFormData;

import models.mbthread.Mbthread;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbthread.mbthread;
import views.html.mbthread.mbthreads;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbthreadApplication extends Controller {

	public static Result addMbthread() {
		Form<MbthreadFormData> form = Form.form(
			MbthreadFormData.class).fill(new Mbthread().toFormData());

		return ok(mbthread.render(form));
	}

	public static Result get(Long id) {
		Mbthread dbMbthread = Mbthread.find.byId(id);

		Form<MbthreadFormData> form = Form.form(
			MbthreadFormData.class).fill(dbMbthread.toFormData());

		return ok(mbthread.render(form));
	}

	public static Result all() {
		List<Mbthread> mbthreadList = Mbthread.find.all();

		return ok(mbthreads.render(mbthreadList));
	}

	public static Result submit() {
		Form<MbthreadFormData> formData = Form.form(
			MbthreadFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbthreadFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbthread();
		}
		else {
			MbthreadFormData mbthreadFormData = formData.get();

			String id = mbthreadFormData.threadId;

			long mbthreadId = 0;

			if (id != null) {
				mbthreadId = Long.valueOf(id);
			}

			Mbthread mbthread;

			if (mbthreadId > 0) {
				mbthread = Mbthread.find.byId(mbthreadId);

				mbthread.setUuid(mbthreadFormData.uuid);
				mbthread.setThreadId(Long.valueOf(mbthreadFormData.threadId));
				mbthread.setGroupId(Long.valueOf(mbthreadFormData.groupId));
				mbthread.setCompanyId(Long.valueOf(mbthreadFormData.companyId));
				mbthread.setUserId(Long.valueOf(mbthreadFormData.userId));
				mbthread.setUserName(mbthreadFormData.userName);
				mbthread.setCreateDate(new Date(mbthreadFormData.createDate));
				mbthread.setModifiedDate(new Date(mbthreadFormData.modifiedDate));
				mbthread.setCategoryId(Long.valueOf(mbthreadFormData.categoryId));
				mbthread.setRootMessageId(Long.valueOf(mbthreadFormData.rootMessageId));
				mbthread.setRootMessageUserId(Long.valueOf(mbthreadFormData.rootMessageUserId));
				mbthread.setMessageCount(Integer.valueOf(mbthreadFormData.messageCount));
				mbthread.setViewCount(Integer.valueOf(mbthreadFormData.viewCount));
				mbthread.setLastPostByUserId(Long.valueOf(mbthreadFormData.lastPostByUserId));
				mbthread.setLastPostDate(new Date(mbthreadFormData.lastPostDate));
				mbthread.setPriority(Double.valueOf(mbthreadFormData.priority));
				mbthread.setQuestion(Boolean.valueOf(mbthreadFormData.question));
				mbthread.setStatus(Integer.valueOf(mbthreadFormData.status));
				mbthread.setStatusByUserId(Long.valueOf(mbthreadFormData.statusByUserId));
				mbthread.setStatusByUserName(mbthreadFormData.statusByUserName);
				mbthread.setStatusDate(new Date(mbthreadFormData.statusDate));
			}
			else {
				mbthread = new Mbthread(mbthreadFormData);
			}

			Ebean.save(mbthread);

			flash("success", "Mbthread instance created/edited: " + mbthread);

			return all();
		}
	}

	public static Result delete(Form<MbthreadFormData> formData) {
		MbthreadFormData mbthreadFormData = formData.get();

		String id = mbthreadFormData.threadId;

		long mbthreadId = 0;

		if (id != null) {
			mbthreadId = Long.valueOf(id);
		}

		Mbthread mbthread;

		if (mbthreadId > 0) {
			mbthread = Mbthread.find.byId(mbthreadId);

			Ebean.delete(mbthread);
		}
		else {
			flash("error", "Cannot delete Mbthread");
		}

		return all();
	}

}
