
package controllers;

import com.avaje.ebean.Ebean;

import controllers.workflowdefinitionlink.WorkflowdefinitionlinkFormData;

import models.workflowdefinitionlink.Workflowdefinitionlink;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.workflowdefinitionlink.workflowdefinitionlink;
import views.html.workflowdefinitionlink.workflowdefinitionlinks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class WorkflowdefinitionlinkApplication extends Controller {

	public static Result addWorkflowdefinitionlink() {
		Form<WorkflowdefinitionlinkFormData> form = Form.form(
			WorkflowdefinitionlinkFormData.class).fill(new Workflowdefinitionlink().toFormData());

		return ok(workflowdefinitionlink.render(form));
	}

	public static Result get(Long id) {
		Workflowdefinitionlink dbWorkflowdefinitionlink = Workflowdefinitionlink.find.byId(id);

		Form<WorkflowdefinitionlinkFormData> form = Form.form(
			WorkflowdefinitionlinkFormData.class).fill(dbWorkflowdefinitionlink.toFormData());

		return ok(workflowdefinitionlink.render(form));
	}

	public static Result all() {
		List<Workflowdefinitionlink> workflowdefinitionlinkList = Workflowdefinitionlink.find.all();

		return ok(workflowdefinitionlinks.render(workflowdefinitionlinkList));
	}

	public static Result submit() {
		Form<WorkflowdefinitionlinkFormData> formData = Form.form(
			WorkflowdefinitionlinkFormData.class).bindFromRequest();

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

	public static Result edit(Form<WorkflowdefinitionlinkFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addWorkflowdefinitionlink();
		}
		else {
			WorkflowdefinitionlinkFormData workflowdefinitionlinkFormData = formData.get();

			String id = workflowdefinitionlinkFormData.workflowDefinitionLinkId;

			long workflowdefinitionlinkId = 0;

			if (id != null) {
				workflowdefinitionlinkId = Long.valueOf(id);
			}

			Workflowdefinitionlink workflowdefinitionlink;

			if (workflowdefinitionlinkId > 0) {
				workflowdefinitionlink = Workflowdefinitionlink.find.byId(workflowdefinitionlinkId);

				workflowdefinitionlink.setMvccVersion(Long.valueOf(workflowdefinitionlinkFormData.mvccVersion));
				workflowdefinitionlink.setWorkflowDefinitionLinkId(Long.valueOf(workflowdefinitionlinkFormData.workflowDefinitionLinkId));
				workflowdefinitionlink.setGroupId(Long.valueOf(workflowdefinitionlinkFormData.groupId));
				workflowdefinitionlink.setCompanyId(Long.valueOf(workflowdefinitionlinkFormData.companyId));
				workflowdefinitionlink.setUserId(Long.valueOf(workflowdefinitionlinkFormData.userId));
				workflowdefinitionlink.setUserName(workflowdefinitionlinkFormData.userName);
				workflowdefinitionlink.setCreateDate(new Date(workflowdefinitionlinkFormData.createDate));
				workflowdefinitionlink.setModifiedDate(new Date(workflowdefinitionlinkFormData.modifiedDate));
				workflowdefinitionlink.setClassNameId(Long.valueOf(workflowdefinitionlinkFormData.classNameId));
				workflowdefinitionlink.setClassPK(Long.valueOf(workflowdefinitionlinkFormData.classPK));
				workflowdefinitionlink.setTypePK(Long.valueOf(workflowdefinitionlinkFormData.typePK));
				workflowdefinitionlink.setWorkflowDefinitionName(workflowdefinitionlinkFormData.workflowDefinitionName);
				workflowdefinitionlink.setWorkflowDefinitionVersion(Integer.valueOf(workflowdefinitionlinkFormData.workflowDefinitionVersion));
			}
			else {
				workflowdefinitionlink = new Workflowdefinitionlink(workflowdefinitionlinkFormData);
			}

			Ebean.save(workflowdefinitionlink);

			flash("success", "Workflowdefinitionlink instance created/edited: " + workflowdefinitionlink);

			return all();
		}
	}

	public static Result delete(Form<WorkflowdefinitionlinkFormData> formData) {
		WorkflowdefinitionlinkFormData workflowdefinitionlinkFormData = formData.get();

		String id = workflowdefinitionlinkFormData.workflowDefinitionLinkId;

		long workflowdefinitionlinkId = 0;

		if (id != null) {
			workflowdefinitionlinkId = Long.valueOf(id);
		}

		Workflowdefinitionlink workflowdefinitionlink;

		if (workflowdefinitionlinkId > 0) {
			workflowdefinitionlink = Workflowdefinitionlink.find.byId(workflowdefinitionlinkId);

			Ebean.delete(workflowdefinitionlink);
		}
		else {
			flash("error", "Cannot delete Workflowdefinitionlink");
		}

		return all();
	}

}
