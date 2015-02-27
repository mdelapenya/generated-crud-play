
package controllers;

import com.avaje.ebean.Ebean;

import controllers.emailaddress.EmailaddressFormData;

import models.emailaddress.Emailaddress;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.emailaddress.emailaddress;
import views.html.emailaddress.emailaddresss;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class EmailaddressApplication extends Controller {

	public static Result addEmailaddress() {
		Form<EmailaddressFormData> form = Form.form(
			EmailaddressFormData.class).fill(new Emailaddress().toFormData());

		return ok(emailaddress.render(form));
	}

	public static Result get(Long id) {
		Emailaddress dbEmailaddress = Emailaddress.find.byId(id);

		Form<EmailaddressFormData> form = Form.form(
			EmailaddressFormData.class).fill(dbEmailaddress.toFormData());

		return ok(emailaddress.render(form));
	}

	public static Result all() {
		List<Emailaddress> emailaddressList = Emailaddress.find.all();

		return ok(emailaddresss.render(emailaddressList));
	}

	public static Result submit() {
		Form<EmailaddressFormData> formData = Form.form(
			EmailaddressFormData.class).bindFromRequest();

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

	public static Result edit(Form<EmailaddressFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addEmailaddress();
		}
		else {
			EmailaddressFormData emailaddressFormData = formData.get();

			String id = emailaddressFormData.emailAddressId;

			long emailaddressId = 0;

			if (id != null) {
				emailaddressId = Long.valueOf(id);
			}

			Emailaddress emailaddress;

			if (emailaddressId > 0) {
				emailaddress = Emailaddress.find.byId(emailaddressId);

				emailaddress.setMvccVersion(Long.valueOf(emailaddressFormData.mvccVersion));
				emailaddress.setUuid(emailaddressFormData.uuid);
				emailaddress.setEmailAddressId(Long.valueOf(emailaddressFormData.emailAddressId));
				emailaddress.setCompanyId(Long.valueOf(emailaddressFormData.companyId));
				emailaddress.setUserId(Long.valueOf(emailaddressFormData.userId));
				emailaddress.setUserName(emailaddressFormData.userName);
				emailaddress.setCreateDate(new Date(emailaddressFormData.createDate));
				emailaddress.setModifiedDate(new Date(emailaddressFormData.modifiedDate));
				emailaddress.setClassNameId(Long.valueOf(emailaddressFormData.classNameId));
				emailaddress.setClassPK(Long.valueOf(emailaddressFormData.classPK));
				emailaddress.setAddress(emailaddressFormData.address);
				emailaddress.setTypeId(Long.valueOf(emailaddressFormData.typeId));
				emailaddress.setCustomprimary(Boolean.valueOf(emailaddressFormData.customprimary));
			}
			else {
				emailaddress = new Emailaddress(emailaddressFormData);
			}

			Ebean.save(emailaddress);

			flash("success", "Emailaddress instance created/edited: " + emailaddress);

			return all();
		}
	}

	public static Result delete(Form<EmailaddressFormData> formData) {
		EmailaddressFormData emailaddressFormData = formData.get();

		String id = emailaddressFormData.emailAddressId;

		long emailaddressId = 0;

		if (id != null) {
			emailaddressId = Long.valueOf(id);
		}

		Emailaddress emailaddress;

		if (emailaddressId > 0) {
			emailaddress = Emailaddress.find.byId(emailaddressId);

			Ebean.delete(emailaddress);
		}
		else {
			flash("error", "Cannot delete Emailaddress");
		}

		return all();
	}

}
