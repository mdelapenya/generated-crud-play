
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mdrrule.MdrruleFormData;

import models.mdrrule.Mdrrule;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mdrrule.mdrrule;
import views.html.mdrrule.mdrrules;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MdrruleApplication extends Controller {

	public static Result addMdrrule() {
		Form<MdrruleFormData> form = Form.form(
			MdrruleFormData.class).fill(new Mdrrule().toFormData());

		return ok(mdrrule.render(form));
	}

	public static Result get(Long id) {
		Mdrrule dbMdrrule = Mdrrule.find.byId(id);

		Form<MdrruleFormData> form = Form.form(
			MdrruleFormData.class).fill(dbMdrrule.toFormData());

		return ok(mdrrule.render(form));
	}

	public static Result all() {
		List<Mdrrule> mdrruleList = Mdrrule.find.all();

		return ok(mdrrules.render(mdrruleList));
	}

	public static Result submit() {
		Form<MdrruleFormData> formData = Form.form(
			MdrruleFormData.class).bindFromRequest();

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

	public static Result edit(Form<MdrruleFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMdrrule();
		}
		else {
			MdrruleFormData mdrruleFormData = formData.get();

			String id = mdrruleFormData.ruleId;

			long mdrruleId = 0;

			if (id != null) {
				mdrruleId = Long.valueOf(id);
			}

			Mdrrule mdrrule;

			if (mdrruleId > 0) {
				mdrrule = Mdrrule.find.byId(mdrruleId);

				mdrrule.setUuid(mdrruleFormData.uuid);
				mdrrule.setRuleId(Long.valueOf(mdrruleFormData.ruleId));
				mdrrule.setGroupId(Long.valueOf(mdrruleFormData.groupId));
				mdrrule.setCompanyId(Long.valueOf(mdrruleFormData.companyId));
				mdrrule.setUserId(Long.valueOf(mdrruleFormData.userId));
				mdrrule.setUserName(mdrruleFormData.userName);
				mdrrule.setCreateDate(new Date(mdrruleFormData.createDate));
				mdrrule.setModifiedDate(new Date(mdrruleFormData.modifiedDate));
				mdrrule.setRuleGroupId(Long.valueOf(mdrruleFormData.ruleGroupId));
				mdrrule.setName(mdrruleFormData.name);
				mdrrule.setDescription(mdrruleFormData.description);
				mdrrule.setCustomtype(mdrruleFormData.customtype);
				mdrrule.setTypeSettings(mdrruleFormData.typeSettings);
			}
			else {
				mdrrule = new Mdrrule(mdrruleFormData);
			}

			Ebean.save(mdrrule);

			flash("success", "Mdrrule instance created/edited: " + mdrrule);

			return all();
		}
	}

	public static Result delete(Form<MdrruleFormData> formData) {
		MdrruleFormData mdrruleFormData = formData.get();

		String id = mdrruleFormData.ruleId;

		long mdrruleId = 0;

		if (id != null) {
			mdrruleId = Long.valueOf(id);
		}

		Mdrrule mdrrule;

		if (mdrruleId > 0) {
			mdrrule = Mdrrule.find.byId(mdrruleId);

			Ebean.delete(mdrrule);
		}
		else {
			flash("error", "Cannot delete Mdrrule");
		}

		return all();
	}

}
