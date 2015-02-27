
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mdrrulegroup.MdrrulegroupFormData;

import models.mdrrulegroup.Mdrrulegroup;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mdrrulegroup.mdrrulegroup;
import views.html.mdrrulegroup.mdrrulegroups;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MdrrulegroupApplication extends Controller {

	public static Result addMdrrulegroup() {
		Form<MdrrulegroupFormData> form = Form.form(
			MdrrulegroupFormData.class).fill(new Mdrrulegroup().toFormData());

		return ok(mdrrulegroup.render(form));
	}

	public static Result get(Long id) {
		Mdrrulegroup dbMdrrulegroup = Mdrrulegroup.find.byId(id);

		Form<MdrrulegroupFormData> form = Form.form(
			MdrrulegroupFormData.class).fill(dbMdrrulegroup.toFormData());

		return ok(mdrrulegroup.render(form));
	}

	public static Result all() {
		List<Mdrrulegroup> mdrrulegroupList = Mdrrulegroup.find.all();

		return ok(mdrrulegroups.render(mdrrulegroupList));
	}

	public static Result submit() {
		Form<MdrrulegroupFormData> formData = Form.form(
			MdrrulegroupFormData.class).bindFromRequest();

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

	public static Result edit(Form<MdrrulegroupFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMdrrulegroup();
		}
		else {
			MdrrulegroupFormData mdrrulegroupFormData = formData.get();

			String id = mdrrulegroupFormData.ruleGroupId;

			long mdrrulegroupId = 0;

			if (id != null) {
				mdrrulegroupId = Long.valueOf(id);
			}

			Mdrrulegroup mdrrulegroup;

			if (mdrrulegroupId > 0) {
				mdrrulegroup = Mdrrulegroup.find.byId(mdrrulegroupId);

				mdrrulegroup.setUuid(mdrrulegroupFormData.uuid);
				mdrrulegroup.setRuleGroupId(Long.valueOf(mdrrulegroupFormData.ruleGroupId));
				mdrrulegroup.setGroupId(Long.valueOf(mdrrulegroupFormData.groupId));
				mdrrulegroup.setCompanyId(Long.valueOf(mdrrulegroupFormData.companyId));
				mdrrulegroup.setUserId(Long.valueOf(mdrrulegroupFormData.userId));
				mdrrulegroup.setUserName(mdrrulegroupFormData.userName);
				mdrrulegroup.setCreateDate(new Date(mdrrulegroupFormData.createDate));
				mdrrulegroup.setModifiedDate(new Date(mdrrulegroupFormData.modifiedDate));
				mdrrulegroup.setName(mdrrulegroupFormData.name);
				mdrrulegroup.setDescription(mdrrulegroupFormData.description);
			}
			else {
				mdrrulegroup = new Mdrrulegroup(mdrrulegroupFormData);
			}

			Ebean.save(mdrrulegroup);

			flash("success", "Mdrrulegroup instance created/edited: " + mdrrulegroup);

			return all();
		}
	}

	public static Result delete(Form<MdrrulegroupFormData> formData) {
		MdrrulegroupFormData mdrrulegroupFormData = formData.get();

		String id = mdrrulegroupFormData.ruleGroupId;

		long mdrrulegroupId = 0;

		if (id != null) {
			mdrrulegroupId = Long.valueOf(id);
		}

		Mdrrulegroup mdrrulegroup;

		if (mdrrulegroupId > 0) {
			mdrrulegroup = Mdrrulegroup.find.byId(mdrrulegroupId);

			Ebean.delete(mdrrulegroup);
		}
		else {
			flash("error", "Cannot delete Mdrrulegroup");
		}

		return all();
	}

}
