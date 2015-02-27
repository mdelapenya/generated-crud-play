
package controllers;

import com.avaje.ebean.Ebean;

import controllers.workflowinstancelink.WorkflowinstancelinkFormData;

import models.workflowinstancelink.Workflowinstancelink;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.workflowinstancelink.workflowinstancelink;
import views.html.workflowinstancelink.workflowinstancelinks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class WorkflowinstancelinkApplication extends Controller {

	public static Result addWorkflowinstancelink() {
		Form<WorkflowinstancelinkFormData> form = Form.form(
			WorkflowinstancelinkFormData.class).fill(new Workflowinstancelink().toFormData());

		return ok(workflowinstancelink.render(form));
	}

	public static Result get(Long id) {
		Workflowinstancelink dbWorkflowinstancelink = Workflowinstancelink.find.byId(id);

		Form<WorkflowinstancelinkFormData> form = Form.form(
			WorkflowinstancelinkFormData.class).fill(dbWorkflowinstancelink.toFormData());

		return ok(workflowinstancelink.render(form));
	}

	public static Result all() {
		List<Workflowinstancelink> workflowinstancelinkList = Workflowinstancelink.find.all();

		return ok(workflowinstancelinks.render(workflowinstancelinkList));
	}

	public static Result submit() {
		Form<WorkflowinstancelinkFormData> formData = Form.form(
			WorkflowinstancelinkFormData.class).bindFromRequest();

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

	public static Result edit(Form<WorkflowinstancelinkFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addWorkflowinstancelink();
		}
		else {
			WorkflowinstancelinkFormData workflowinstancelinkFormData = formData.get();

			String id = workflowinstancelinkFormData.workflowInstanceLinkId;

			long workflowinstancelinkId = 0;

			if (id != null) {
				workflowinstancelinkId = Long.valueOf(id);
			}

			Workflowinstancelink workflowinstancelink;

			if (workflowinstancelinkId > 0) {
				workflowinstancelink = Workflowinstancelink.find.byId(workflowinstancelinkId);

				workflowinstancelink.setMvccVersion(Long.valueOf(workflowinstancelinkFormData.mvccVersion));
				workflowinstancelink.setWorkflowInstanceLinkId(Long.valueOf(workflowinstancelinkFormData.workflowInstanceLinkId));
				workflowinstancelink.setGroupId(Long.valueOf(workflowinstancelinkFormData.groupId));
				workflowinstancelink.setCompanyId(Long.valueOf(workflowinstancelinkFormData.companyId));
				workflowinstancelink.setUserId(Long.valueOf(workflowinstancelinkFormData.userId));
				workflowinstancelink.setUserName(workflowinstancelinkFormData.userName);
				workflowinstancelink.setCreateDate(new Date(workflowinstancelinkFormData.createDate));
				workflowinstancelink.setModifiedDate(new Date(workflowinstancelinkFormData.modifiedDate));
				workflowinstancelink.setClassNameId(Long.valueOf(workflowinstancelinkFormData.classNameId));
				workflowinstancelink.setClassPK(Long.valueOf(workflowinstancelinkFormData.classPK));
				workflowinstancelink.setWorkflowInstanceId(Long.valueOf(workflowinstancelinkFormData.workflowInstanceId));
			}
			else {
				workflowinstancelink = new Workflowinstancelink(workflowinstancelinkFormData);
			}

			Ebean.save(workflowinstancelink);

			flash("success", "Workflowinstancelink instance created/edited: " + workflowinstancelink);

			return all();
		}
	}

	public static Result delete(Form<WorkflowinstancelinkFormData> formData) {
		WorkflowinstancelinkFormData workflowinstancelinkFormData = formData.get();

		String id = workflowinstancelinkFormData.workflowInstanceLinkId;

		long workflowinstancelinkId = 0;

		if (id != null) {
			workflowinstancelinkId = Long.valueOf(id);
		}

		Workflowinstancelink workflowinstancelink;

		if (workflowinstancelinkId > 0) {
			workflowinstancelink = Workflowinstancelink.find.byId(workflowinstancelinkId);

			Ebean.delete(workflowinstancelink);
		}
		else {
			flash("error", "Cannot delete Workflowinstancelink");
		}

		return all();
	}

}
