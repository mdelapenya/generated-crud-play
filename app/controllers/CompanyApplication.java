
package controllers;

import com.avaje.ebean.Ebean;

import controllers.company.CompanyFormData;

import models.company.Company;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.company.company;
import views.html.company.companys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class CompanyApplication extends Controller {

	public static Result addCompany() {
		Form<CompanyFormData> form = Form.form(
			CompanyFormData.class).fill(new Company().toFormData());

		return ok(company.render(form));
	}

	public static Result get(Long id) {
		Company dbCompany = Company.find.byId(id);

		Form<CompanyFormData> form = Form.form(
			CompanyFormData.class).fill(dbCompany.toFormData());

		return ok(company.render(form));
	}

	public static Result all() {
		List<Company> companyList = Company.find.all();

		return ok(companys.render(companyList));
	}

	public static Result submit() {
		Form<CompanyFormData> formData = Form.form(
			CompanyFormData.class).bindFromRequest();

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

	public static Result edit(Form<CompanyFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addCompany();
		}
		else {
			CompanyFormData companyFormData = formData.get();

			String id = companyFormData.companyId;

			long companyId = 0;

			if (id != null) {
				companyId = Long.valueOf(id);
			}

			Company company;

			if (companyId > 0) {
				company = Company.find.byId(companyId);

				company.setMvccVersion(Long.valueOf(companyFormData.mvccVersion));
				company.setCompanyId(Long.valueOf(companyFormData.companyId));
				company.setAccountId(Long.valueOf(companyFormData.accountId));
				company.setWebId(companyFormData.webId);
				company.setKey(companyFormData.key);
				company.setMx(companyFormData.mx);
				company.setHomeURL(companyFormData.homeURL);
				company.setLogoId(Long.valueOf(companyFormData.logoId));
				company.setSystem(Boolean.valueOf(companyFormData.system));
				company.setMaxUsers(Integer.valueOf(companyFormData.maxUsers));
				company.setActive(Boolean.valueOf(companyFormData.active));
			}
			else {
				company = new Company(companyFormData);
			}

			Ebean.save(company);

			flash("success", "Company instance created/edited: " + company);

			return all();
		}
	}

	public static Result delete(Form<CompanyFormData> formData) {
		CompanyFormData companyFormData = formData.get();

		String id = companyFormData.companyId;

		long companyId = 0;

		if (id != null) {
			companyId = Long.valueOf(id);
		}

		Company company;

		if (companyId > 0) {
			company = Company.find.byId(companyId);

			Ebean.delete(company);
		}
		else {
			flash("error", "Cannot delete Company");
		}

		return all();
	}

}
