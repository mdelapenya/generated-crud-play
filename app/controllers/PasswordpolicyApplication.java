
package controllers;

import com.avaje.ebean.Ebean;

import controllers.passwordpolicy.PasswordpolicyFormData;

import models.passwordpolicy.Passwordpolicy;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.passwordpolicy.passwordpolicy;
import views.html.passwordpolicy.passwordpolicys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PasswordpolicyApplication extends Controller {

	public static Result addPasswordpolicy() {
		Form<PasswordpolicyFormData> form = Form.form(
			PasswordpolicyFormData.class).fill(new Passwordpolicy().toFormData());

		return ok(passwordpolicy.render(form));
	}

	public static Result get(Long id) {
		Passwordpolicy dbPasswordpolicy = Passwordpolicy.find.byId(id);

		Form<PasswordpolicyFormData> form = Form.form(
			PasswordpolicyFormData.class).fill(dbPasswordpolicy.toFormData());

		return ok(passwordpolicy.render(form));
	}

	public static Result all() {
		List<Passwordpolicy> passwordpolicyList = Passwordpolicy.find.all();

		return ok(passwordpolicys.render(passwordpolicyList));
	}

	public static Result submit() {
		Form<PasswordpolicyFormData> formData = Form.form(
			PasswordpolicyFormData.class).bindFromRequest();

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

	public static Result edit(Form<PasswordpolicyFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPasswordpolicy();
		}
		else {
			PasswordpolicyFormData passwordpolicyFormData = formData.get();

			String id = passwordpolicyFormData.passwordPolicyId;

			long passwordpolicyId = 0;

			if (id != null) {
				passwordpolicyId = Long.valueOf(id);
			}

			Passwordpolicy passwordpolicy;

			if (passwordpolicyId > 0) {
				passwordpolicy = Passwordpolicy.find.byId(passwordpolicyId);

				passwordpolicy.setMvccVersion(Long.valueOf(passwordpolicyFormData.mvccVersion));
				passwordpolicy.setUuid(passwordpolicyFormData.uuid);
				passwordpolicy.setPasswordPolicyId(Long.valueOf(passwordpolicyFormData.passwordPolicyId));
				passwordpolicy.setCompanyId(Long.valueOf(passwordpolicyFormData.companyId));
				passwordpolicy.setUserId(Long.valueOf(passwordpolicyFormData.userId));
				passwordpolicy.setUserName(passwordpolicyFormData.userName);
				passwordpolicy.setCreateDate(new Date(passwordpolicyFormData.createDate));
				passwordpolicy.setModifiedDate(new Date(passwordpolicyFormData.modifiedDate));
				passwordpolicy.setDefaultPolicy(Boolean.valueOf(passwordpolicyFormData.defaultPolicy));
				passwordpolicy.setName(passwordpolicyFormData.name);
				passwordpolicy.setDescription(passwordpolicyFormData.description);
				passwordpolicy.setChangeable(Boolean.valueOf(passwordpolicyFormData.changeable));
				passwordpolicy.setChangeRequired(Boolean.valueOf(passwordpolicyFormData.changeRequired));
				passwordpolicy.setMinAge(Long.valueOf(passwordpolicyFormData.minAge));
				passwordpolicy.setCheckSyntax(Boolean.valueOf(passwordpolicyFormData.checkSyntax));
				passwordpolicy.setAllowDictionaryWords(Boolean.valueOf(passwordpolicyFormData.allowDictionaryWords));
				passwordpolicy.setMinAlphanumeric(Integer.valueOf(passwordpolicyFormData.minAlphanumeric));
				passwordpolicy.setMinLength(Integer.valueOf(passwordpolicyFormData.minLength));
				passwordpolicy.setMinLowerCase(Integer.valueOf(passwordpolicyFormData.minLowerCase));
				passwordpolicy.setMinNumbers(Integer.valueOf(passwordpolicyFormData.minNumbers));
				passwordpolicy.setMinSymbols(Integer.valueOf(passwordpolicyFormData.minSymbols));
				passwordpolicy.setMinUpperCase(Integer.valueOf(passwordpolicyFormData.minUpperCase));
				passwordpolicy.setRegex(passwordpolicyFormData.regex);
				passwordpolicy.setHistory(Boolean.valueOf(passwordpolicyFormData.history));
				passwordpolicy.setHistoryCount(Integer.valueOf(passwordpolicyFormData.historyCount));
				passwordpolicy.setExpireable(Boolean.valueOf(passwordpolicyFormData.expireable));
				passwordpolicy.setMaxAge(Long.valueOf(passwordpolicyFormData.maxAge));
				passwordpolicy.setWarningTime(Long.valueOf(passwordpolicyFormData.warningTime));
				passwordpolicy.setGraceLimit(Integer.valueOf(passwordpolicyFormData.graceLimit));
				passwordpolicy.setLockout(Boolean.valueOf(passwordpolicyFormData.lockout));
				passwordpolicy.setMaxFailure(Integer.valueOf(passwordpolicyFormData.maxFailure));
				passwordpolicy.setLockoutDuration(Long.valueOf(passwordpolicyFormData.lockoutDuration));
				passwordpolicy.setRequireUnlock(Boolean.valueOf(passwordpolicyFormData.requireUnlock));
				passwordpolicy.setResetFailureCount(Long.valueOf(passwordpolicyFormData.resetFailureCount));
				passwordpolicy.setResetTicketMaxAge(Long.valueOf(passwordpolicyFormData.resetTicketMaxAge));
			}
			else {
				passwordpolicy = new Passwordpolicy(passwordpolicyFormData);
			}

			Ebean.save(passwordpolicy);

			flash("success", "Passwordpolicy instance created/edited: " + passwordpolicy);

			return all();
		}
	}

	public static Result delete(Form<PasswordpolicyFormData> formData) {
		PasswordpolicyFormData passwordpolicyFormData = formData.get();

		String id = passwordpolicyFormData.passwordPolicyId;

		long passwordpolicyId = 0;

		if (id != null) {
			passwordpolicyId = Long.valueOf(id);
		}

		Passwordpolicy passwordpolicy;

		if (passwordpolicyId > 0) {
			passwordpolicy = Passwordpolicy.find.byId(passwordpolicyId);

			Ebean.delete(passwordpolicy);
		}
		else {
			flash("error", "Cannot delete Passwordpolicy");
		}

		return all();
	}

}
