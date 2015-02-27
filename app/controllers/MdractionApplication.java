
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mdraction.MdractionFormData;

import models.mdraction.Mdraction;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mdraction.mdraction;
import views.html.mdraction.mdractions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MdractionApplication extends Controller {

	public static Result addMdraction() {
		Form<MdractionFormData> form = Form.form(
			MdractionFormData.class).fill(new Mdraction().toFormData());

		return ok(mdraction.render(form));
	}

	public static Result get(Long id) {
		Mdraction dbMdraction = Mdraction.find.byId(id);

		Form<MdractionFormData> form = Form.form(
			MdractionFormData.class).fill(dbMdraction.toFormData());

		return ok(mdraction.render(form));
	}

	public static Result all() {
		List<Mdraction> mdractionList = Mdraction.find.all();

		return ok(mdractions.render(mdractionList));
	}

	public static Result submit() {
		Form<MdractionFormData> formData = Form.form(
			MdractionFormData.class).bindFromRequest();

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

	public static Result edit(Form<MdractionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMdraction();
		}
		else {
			MdractionFormData mdractionFormData = formData.get();

			String id = mdractionFormData.actionId;

			long mdractionId = 0;

			if (id != null) {
				mdractionId = Long.valueOf(id);
			}

			Mdraction mdraction;

			if (mdractionId > 0) {
				mdraction = Mdraction.find.byId(mdractionId);

				mdraction.setUuid(mdractionFormData.uuid);
				mdraction.setActionId(Long.valueOf(mdractionFormData.actionId));
				mdraction.setGroupId(Long.valueOf(mdractionFormData.groupId));
				mdraction.setCompanyId(Long.valueOf(mdractionFormData.companyId));
				mdraction.setUserId(Long.valueOf(mdractionFormData.userId));
				mdraction.setUserName(mdractionFormData.userName);
				mdraction.setCreateDate(new Date(mdractionFormData.createDate));
				mdraction.setModifiedDate(new Date(mdractionFormData.modifiedDate));
				mdraction.setClassNameId(Long.valueOf(mdractionFormData.classNameId));
				mdraction.setClassPK(Long.valueOf(mdractionFormData.classPK));
				mdraction.setRuleGroupInstanceId(Long.valueOf(mdractionFormData.ruleGroupInstanceId));
				mdraction.setName(mdractionFormData.name);
				mdraction.setDescription(mdractionFormData.description);
				mdraction.setCustomtype(mdractionFormData.customtype);
				mdraction.setTypeSettings(mdractionFormData.typeSettings);
			}
			else {
				mdraction = new Mdraction(mdractionFormData);
			}

			Ebean.save(mdraction);

			flash("success", "Mdraction instance created/edited: " + mdraction);

			return all();
		}
	}

	public static Result delete(Form<MdractionFormData> formData) {
		MdractionFormData mdractionFormData = formData.get();

		String id = mdractionFormData.actionId;

		long mdractionId = 0;

		if (id != null) {
			mdractionId = Long.valueOf(id);
		}

		Mdraction mdraction;

		if (mdractionId > 0) {
			mdraction = Mdraction.find.byId(mdractionId);

			Ebean.delete(mdraction);
		}
		else {
			flash("error", "Cannot delete Mdraction");
		}

		return all();
	}

}
