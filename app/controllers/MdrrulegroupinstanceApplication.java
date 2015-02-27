
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mdrrulegroupinstance.MdrrulegroupinstanceFormData;

import models.mdrrulegroupinstance.Mdrrulegroupinstance;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mdrrulegroupinstance.mdrrulegroupinstance;
import views.html.mdrrulegroupinstance.mdrrulegroupinstances;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MdrrulegroupinstanceApplication extends Controller {

	public static Result addMdrrulegroupinstance() {
		Form<MdrrulegroupinstanceFormData> form = Form.form(
			MdrrulegroupinstanceFormData.class).fill(new Mdrrulegroupinstance().toFormData());

		return ok(mdrrulegroupinstance.render(form));
	}

	public static Result get(Long id) {
		Mdrrulegroupinstance dbMdrrulegroupinstance = Mdrrulegroupinstance.find.byId(id);

		Form<MdrrulegroupinstanceFormData> form = Form.form(
			MdrrulegroupinstanceFormData.class).fill(dbMdrrulegroupinstance.toFormData());

		return ok(mdrrulegroupinstance.render(form));
	}

	public static Result all() {
		List<Mdrrulegroupinstance> mdrrulegroupinstanceList = Mdrrulegroupinstance.find.all();

		return ok(mdrrulegroupinstances.render(mdrrulegroupinstanceList));
	}

	public static Result submit() {
		Form<MdrrulegroupinstanceFormData> formData = Form.form(
			MdrrulegroupinstanceFormData.class).bindFromRequest();

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

	public static Result edit(Form<MdrrulegroupinstanceFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMdrrulegroupinstance();
		}
		else {
			MdrrulegroupinstanceFormData mdrrulegroupinstanceFormData = formData.get();

			String id = mdrrulegroupinstanceFormData.ruleGroupInstanceId;

			long mdrrulegroupinstanceId = 0;

			if (id != null) {
				mdrrulegroupinstanceId = Long.valueOf(id);
			}

			Mdrrulegroupinstance mdrrulegroupinstance;

			if (mdrrulegroupinstanceId > 0) {
				mdrrulegroupinstance = Mdrrulegroupinstance.find.byId(mdrrulegroupinstanceId);

				mdrrulegroupinstance.setUuid(mdrrulegroupinstanceFormData.uuid);
				mdrrulegroupinstance.setRuleGroupInstanceId(Long.valueOf(mdrrulegroupinstanceFormData.ruleGroupInstanceId));
				mdrrulegroupinstance.setGroupId(Long.valueOf(mdrrulegroupinstanceFormData.groupId));
				mdrrulegroupinstance.setCompanyId(Long.valueOf(mdrrulegroupinstanceFormData.companyId));
				mdrrulegroupinstance.setUserId(Long.valueOf(mdrrulegroupinstanceFormData.userId));
				mdrrulegroupinstance.setUserName(mdrrulegroupinstanceFormData.userName);
				mdrrulegroupinstance.setCreateDate(new Date(mdrrulegroupinstanceFormData.createDate));
				mdrrulegroupinstance.setModifiedDate(new Date(mdrrulegroupinstanceFormData.modifiedDate));
				mdrrulegroupinstance.setClassNameId(Long.valueOf(mdrrulegroupinstanceFormData.classNameId));
				mdrrulegroupinstance.setClassPK(Long.valueOf(mdrrulegroupinstanceFormData.classPK));
				mdrrulegroupinstance.setRuleGroupId(Long.valueOf(mdrrulegroupinstanceFormData.ruleGroupId));
				mdrrulegroupinstance.setPriority(Integer.valueOf(mdrrulegroupinstanceFormData.priority));
			}
			else {
				mdrrulegroupinstance = new Mdrrulegroupinstance(mdrrulegroupinstanceFormData);
			}

			Ebean.save(mdrrulegroupinstance);

			flash("success", "Mdrrulegroupinstance instance created/edited: " + mdrrulegroupinstance);

			return all();
		}
	}

	public static Result delete(Form<MdrrulegroupinstanceFormData> formData) {
		MdrrulegroupinstanceFormData mdrrulegroupinstanceFormData = formData.get();

		String id = mdrrulegroupinstanceFormData.ruleGroupInstanceId;

		long mdrrulegroupinstanceId = 0;

		if (id != null) {
			mdrrulegroupinstanceId = Long.valueOf(id);
		}

		Mdrrulegroupinstance mdrrulegroupinstance;

		if (mdrrulegroupinstanceId > 0) {
			mdrrulegroupinstance = Mdrrulegroupinstance.find.byId(mdrrulegroupinstanceId);

			Ebean.delete(mdrrulegroupinstance);
		}
		else {
			flash("error", "Cannot delete Mdrrulegroupinstance");
		}

		return all();
	}

}
