
package controllers;

import com.avaje.ebean.Ebean;

import controllers.account.AccountFormData;

import models.account.Account;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.account.account;
import views.html.account.accounts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AccountApplication extends Controller {

	public static Result addAccount() {
		Form<AccountFormData> form = Form.form(
			AccountFormData.class).fill(new Account().toFormData());

		return ok(account.render(form));
	}

	public static Result get(Long id) {
		Account dbAccount = Account.find.byId(id);

		Form<AccountFormData> form = Form.form(
			AccountFormData.class).fill(dbAccount.toFormData());

		return ok(account.render(form));
	}

	public static Result all() {
		List<Account> accountList = Account.find.all();

		return ok(accounts.render(accountList));
	}

	public static Result submit() {
		Form<AccountFormData> formData = Form.form(
			AccountFormData.class).bindFromRequest();

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

	public static Result edit(Form<AccountFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAccount();
		}
		else {
			AccountFormData accountFormData = formData.get();

			String id = accountFormData.accountId;

			long accountId = 0;

			if (id != null) {
				accountId = Long.valueOf(id);
			}

			Account account;

			if (accountId > 0) {
				account = Account.find.byId(accountId);

				account.setMvccVersion(Long.valueOf(accountFormData.mvccVersion));
				account.setAccountId(Long.valueOf(accountFormData.accountId));
				account.setCompanyId(Long.valueOf(accountFormData.companyId));
				account.setUserId(Long.valueOf(accountFormData.userId));
				account.setUserName(accountFormData.userName);
				account.setCreateDate(new Date(accountFormData.createDate));
				account.setModifiedDate(new Date(accountFormData.modifiedDate));
				account.setParentAccountId(Long.valueOf(accountFormData.parentAccountId));
				account.setName(accountFormData.name);
				account.setLegalName(accountFormData.legalName);
				account.setLegalId(accountFormData.legalId);
				account.setLegalType(accountFormData.legalType);
				account.setSicCode(accountFormData.sicCode);
				account.setTickerSymbol(accountFormData.tickerSymbol);
				account.setIndustry(accountFormData.industry);
				account.setCustomtype(accountFormData.customtype);
				account.setSize(accountFormData.size);
			}
			else {
				account = new Account(accountFormData);
			}

			Ebean.save(account);

			flash("success", "Account instance created/edited: " + account);

			return all();
		}
	}

	public static Result delete(Form<AccountFormData> formData) {
		AccountFormData accountFormData = formData.get();

		String id = accountFormData.accountId;

		long accountId = 0;

		if (id != null) {
			accountId = Long.valueOf(id);
		}

		Account account;

		if (accountId > 0) {
			account = Account.find.byId(accountId);

			Ebean.delete(account);
		}
		else {
			flash("error", "Cannot delete Account");
		}

		return all();
	}

}
