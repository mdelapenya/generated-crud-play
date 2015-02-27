
package controllers;

import com.avaje.ebean.Ebean;

import controllers.backgroundtask.BackgroundtaskFormData;

import models.backgroundtask.Backgroundtask;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.backgroundtask.backgroundtask;
import views.html.backgroundtask.backgroundtasks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class BackgroundtaskApplication extends Controller {

	public static Result addBackgroundtask() {
		Form<BackgroundtaskFormData> form = Form.form(
			BackgroundtaskFormData.class).fill(new Backgroundtask().toFormData());

		return ok(backgroundtask.render(form));
	}

	public static Result get(Long id) {
		Backgroundtask dbBackgroundtask = Backgroundtask.find.byId(id);

		Form<BackgroundtaskFormData> form = Form.form(
			BackgroundtaskFormData.class).fill(dbBackgroundtask.toFormData());

		return ok(backgroundtask.render(form));
	}

	public static Result all() {
		List<Backgroundtask> backgroundtaskList = Backgroundtask.find.all();

		return ok(backgroundtasks.render(backgroundtaskList));
	}

	public static Result submit() {
		Form<BackgroundtaskFormData> formData = Form.form(
			BackgroundtaskFormData.class).bindFromRequest();

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

	public static Result edit(Form<BackgroundtaskFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addBackgroundtask();
		}
		else {
			BackgroundtaskFormData backgroundtaskFormData = formData.get();

			String id = backgroundtaskFormData.backgroundTaskId;

			long backgroundtaskId = 0;

			if (id != null) {
				backgroundtaskId = Long.valueOf(id);
			}

			Backgroundtask backgroundtask;

			if (backgroundtaskId > 0) {
				backgroundtask = Backgroundtask.find.byId(backgroundtaskId);

				backgroundtask.setMvccVersion(Long.valueOf(backgroundtaskFormData.mvccVersion));
				backgroundtask.setBackgroundTaskId(Long.valueOf(backgroundtaskFormData.backgroundTaskId));
				backgroundtask.setGroupId(Long.valueOf(backgroundtaskFormData.groupId));
				backgroundtask.setCompanyId(Long.valueOf(backgroundtaskFormData.companyId));
				backgroundtask.setUserId(Long.valueOf(backgroundtaskFormData.userId));
				backgroundtask.setUserName(backgroundtaskFormData.userName);
				backgroundtask.setCreateDate(new Date(backgroundtaskFormData.createDate));
				backgroundtask.setModifiedDate(new Date(backgroundtaskFormData.modifiedDate));
				backgroundtask.setName(backgroundtaskFormData.name);
				backgroundtask.setServletContextNames(backgroundtaskFormData.servletContextNames);
				backgroundtask.setTaskExecutorClassName(backgroundtaskFormData.taskExecutorClassName);
				backgroundtask.setTaskContextMap(backgroundtaskFormData.taskContextMap);
				backgroundtask.setCompleted(Boolean.valueOf(backgroundtaskFormData.completed));
				backgroundtask.setCompletionDate(new Date(backgroundtaskFormData.completionDate));
				backgroundtask.setStatus(Integer.valueOf(backgroundtaskFormData.status));
				backgroundtask.setStatusMessage(backgroundtaskFormData.statusMessage);
			}
			else {
				backgroundtask = new Backgroundtask(backgroundtaskFormData);
			}

			Ebean.save(backgroundtask);

			flash("success", "Backgroundtask instance created/edited: " + backgroundtask);

			return all();
		}
	}

	public static Result delete(Form<BackgroundtaskFormData> formData) {
		BackgroundtaskFormData backgroundtaskFormData = formData.get();

		String id = backgroundtaskFormData.backgroundTaskId;

		long backgroundtaskId = 0;

		if (id != null) {
			backgroundtaskId = Long.valueOf(id);
		}

		Backgroundtask backgroundtask;

		if (backgroundtaskId > 0) {
			backgroundtask = Backgroundtask.find.byId(backgroundtaskId);

			Ebean.delete(backgroundtask);
		}
		else {
			flash("error", "Cannot delete Backgroundtask");
		}

		return all();
	}

}
