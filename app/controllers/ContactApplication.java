
package controllers;

import com.avaje.ebean.Ebean;

import controllers.contact.ContactFormData;

import models.contact.Contact;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.contact.contact;
import views.html.contact.contacts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ContactApplication extends Controller {

	public static Result addContact() {
		Form<ContactFormData> form = Form.form(
			ContactFormData.class).fill(new Contact().toFormData());

		return ok(contact.render(form));
	}

	public static Result get(Long id) {
		Contact dbContact = Contact.find.byId(id);

		Form<ContactFormData> form = Form.form(
			ContactFormData.class).fill(dbContact.toFormData());

		return ok(contact.render(form));
	}

	public static Result all() {
		List<Contact> contactList = Contact.find.all();

		return ok(contacts.render(contactList));
	}

	public static Result submit() {
		Form<ContactFormData> formData = Form.form(
			ContactFormData.class).bindFromRequest();

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

	public static Result edit(Form<ContactFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addContact();
		}
		else {
			ContactFormData contactFormData = formData.get();

			String id = contactFormData.contactId;

			long contactId = 0;

			if (id != null) {
				contactId = Long.valueOf(id);
			}

			Contact contact;

			if (contactId > 0) {
				contact = Contact.find.byId(contactId);

				contact.setMvccVersion(Long.valueOf(contactFormData.mvccVersion));
				contact.setContactId(Long.valueOf(contactFormData.contactId));
				contact.setCompanyId(Long.valueOf(contactFormData.companyId));
				contact.setUserId(Long.valueOf(contactFormData.userId));
				contact.setUserName(contactFormData.userName);
				contact.setCreateDate(new Date(contactFormData.createDate));
				contact.setModifiedDate(new Date(contactFormData.modifiedDate));
				contact.setClassNameId(Long.valueOf(contactFormData.classNameId));
				contact.setClassPK(Long.valueOf(contactFormData.classPK));
				contact.setAccountId(Long.valueOf(contactFormData.accountId));
				contact.setParentContactId(Long.valueOf(contactFormData.parentContactId));
				contact.setEmailAddress(contactFormData.emailAddress);
				contact.setFirstName(contactFormData.firstName);
				contact.setMiddleName(contactFormData.middleName);
				contact.setLastName(contactFormData.lastName);
				contact.setPrefixId(Long.valueOf(contactFormData.prefixId));
				contact.setSuffixId(Long.valueOf(contactFormData.suffixId));
				contact.setMale(Boolean.valueOf(contactFormData.male));
				contact.setBirthday(new Date(contactFormData.birthday));
				contact.setSmsSn(contactFormData.smsSn);
				contact.setAimSn(contactFormData.aimSn);
				contact.setFacebookSn(contactFormData.facebookSn);
				contact.setIcqSn(contactFormData.icqSn);
				contact.setJabberSn(contactFormData.jabberSn);
				contact.setMsnSn(contactFormData.msnSn);
				contact.setMySpaceSn(contactFormData.mySpaceSn);
				contact.setSkypeSn(contactFormData.skypeSn);
				contact.setTwitterSn(contactFormData.twitterSn);
				contact.setYmSn(contactFormData.ymSn);
				contact.setEmployeeStatusId(contactFormData.employeeStatusId);
				contact.setEmployeeNumber(contactFormData.employeeNumber);
				contact.setJobTitle(contactFormData.jobTitle);
				contact.setJobClass(contactFormData.jobClass);
				contact.setHoursOfOperation(contactFormData.hoursOfOperation);
			}
			else {
				contact = new Contact(contactFormData);
			}

			Ebean.save(contact);

			flash("success", "Contact instance created/edited: " + contact);

			return all();
		}
	}

	public static Result delete(Form<ContactFormData> formData) {
		ContactFormData contactFormData = formData.get();

		String id = contactFormData.contactId;

		long contactId = 0;

		if (id != null) {
			contactId = Long.valueOf(id);
		}

		Contact contact;

		if (contactId > 0) {
			contact = Contact.find.byId(contactId);

			Ebean.delete(contact);
		}
		else {
			flash("error", "Cannot delete Contact");
		}

		return all();
	}

}
