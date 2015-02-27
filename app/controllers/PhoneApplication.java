
package controllers;

import com.avaje.ebean.Ebean;

import controllers.phone.PhoneFormData;

import models.phone.Phone;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.phone.phone;
import views.html.phone.phones;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PhoneApplication extends Controller {

	public static Result addPhone() {
		Form<PhoneFormData> form = Form.form(
			PhoneFormData.class).fill(new Phone().toFormData());

		return ok(phone.render(form));
	}

	public static Result get(Long id) {
		Phone dbPhone = Phone.find.byId(id);

		Form<PhoneFormData> form = Form.form(
			PhoneFormData.class).fill(dbPhone.toFormData());

		return ok(phone.render(form));
	}

	public static Result all() {
		List<Phone> phoneList = Phone.find.all();

		return ok(phones.render(phoneList));
	}

	public static Result submit() {
		Form<PhoneFormData> formData = Form.form(
			PhoneFormData.class).bindFromRequest();

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

	public static Result edit(Form<PhoneFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPhone();
		}
		else {
			PhoneFormData phoneFormData = formData.get();

			String id = phoneFormData.phoneId;

			long phoneId = 0;

			if (id != null) {
				phoneId = Long.valueOf(id);
			}

			Phone phone;

			if (phoneId > 0) {
				phone = Phone.find.byId(phoneId);

				phone.setMvccVersion(Long.valueOf(phoneFormData.mvccVersion));
				phone.setUuid(phoneFormData.uuid);
				phone.setPhoneId(Long.valueOf(phoneFormData.phoneId));
				phone.setCompanyId(Long.valueOf(phoneFormData.companyId));
				phone.setUserId(Long.valueOf(phoneFormData.userId));
				phone.setUserName(phoneFormData.userName);
				phone.setCreateDate(new Date(phoneFormData.createDate));
				phone.setModifiedDate(new Date(phoneFormData.modifiedDate));
				phone.setClassNameId(Long.valueOf(phoneFormData.classNameId));
				phone.setClassPK(Long.valueOf(phoneFormData.classPK));
				phone.setNumber(phoneFormData.number);
				phone.setExtension(phoneFormData.extension);
				phone.setTypeId(Long.valueOf(phoneFormData.typeId));
				phone.setCustomprimary(Boolean.valueOf(phoneFormData.customprimary));
			}
			else {
				phone = new Phone(phoneFormData);
			}

			Ebean.save(phone);

			flash("success", "Phone instance created/edited: " + phone);

			return all();
		}
	}

	public static Result delete(Form<PhoneFormData> formData) {
		PhoneFormData phoneFormData = formData.get();

		String id = phoneFormData.phoneId;

		long phoneId = 0;

		if (id != null) {
			phoneId = Long.valueOf(id);
		}

		Phone phone;

		if (phoneId > 0) {
			phone = Phone.find.byId(phoneId);

			Ebean.delete(phone);
		}
		else {
			flash("error", "Cannot delete Phone");
		}

		return all();
	}

}
