
package controllers;

import com.avaje.ebean.Ebean;

import controllers.user.UserFormData;

import models.user.User;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.user.user;
import views.html.user.users;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class UserApplication extends Controller {

	public static Result addUser() {
		Form<UserFormData> form = Form.form(
			UserFormData.class).fill(new User().toFormData());

		return ok(user.render(form));
	}

	public static Result get(Long id) {
		User dbUser = User.find.byId(id);

		Form<UserFormData> form = Form.form(
			UserFormData.class).fill(dbUser.toFormData());

		return ok(user.render(form));
	}

	public static Result all() {
		List<User> userList = User.find.all();

		return ok(users.render(userList));
	}

	public static Result submit() {
		Form<UserFormData> formData = Form.form(
			UserFormData.class).bindFromRequest();

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

	public static Result edit(Form<UserFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addUser();
		}
		else {
			UserFormData userFormData = formData.get();

			String id = userFormData.userId;

			long userId = 0;

			if (id != null) {
				userId = Long.valueOf(id);
			}

			User user;

			if (userId > 0) {
				user = User.find.byId(userId);

				user.setMvccVersion(Long.valueOf(userFormData.mvccVersion));
				user.setUuid(userFormData.uuid);
				user.setUserId(Long.valueOf(userFormData.userId));
				user.setCompanyId(Long.valueOf(userFormData.companyId));
				user.setCreateDate(new Date(userFormData.createDate));
				user.setModifiedDate(new Date(userFormData.modifiedDate));
				user.setDefaultUser(Boolean.valueOf(userFormData.defaultUser));
				user.setContactId(Long.valueOf(userFormData.contactId));
				user.setPassword(userFormData.password);
				user.setPasswordEncrypted(Boolean.valueOf(userFormData.passwordEncrypted));
				user.setPasswordReset(Boolean.valueOf(userFormData.passwordReset));
				user.setPasswordModifiedDate(new Date(userFormData.passwordModifiedDate));
				user.setDigest(userFormData.digest);
				user.setReminderQueryQuestion(userFormData.reminderQueryQuestion);
				user.setReminderQueryAnswer(userFormData.reminderQueryAnswer);
				user.setGraceLoginCount(Integer.valueOf(userFormData.graceLoginCount));
				user.setScreenName(userFormData.screenName);
				user.setEmailAddress(userFormData.emailAddress);
				user.setFacebookId(Long.valueOf(userFormData.facebookId));
				user.setLdapServerId(Long.valueOf(userFormData.ldapServerId));
				user.setOpenId(userFormData.openId);
				user.setPortraitId(Long.valueOf(userFormData.portraitId));
				user.setLanguageId(userFormData.languageId);
				user.setTimeZoneId(userFormData.timeZoneId);
				user.setGreeting(userFormData.greeting);
				user.setComments(userFormData.comments);
				user.setFirstName(userFormData.firstName);
				user.setMiddleName(userFormData.middleName);
				user.setLastName(userFormData.lastName);
				user.setJobTitle(userFormData.jobTitle);
				user.setLoginDate(new Date(userFormData.loginDate));
				user.setLoginIP(userFormData.loginIP);
				user.setLastLoginDate(new Date(userFormData.lastLoginDate));
				user.setLastLoginIP(userFormData.lastLoginIP);
				user.setLastFailedLoginDate(new Date(userFormData.lastFailedLoginDate));
				user.setFailedLoginAttempts(Integer.valueOf(userFormData.failedLoginAttempts));
				user.setLockout(Boolean.valueOf(userFormData.lockout));
				user.setLockoutDate(new Date(userFormData.lockoutDate));
				user.setAgreedToTermsOfUse(Boolean.valueOf(userFormData.agreedToTermsOfUse));
				user.setEmailAddressVerified(Boolean.valueOf(userFormData.emailAddressVerified));
				user.setStatus(Integer.valueOf(userFormData.status));
			}
			else {
				user = new User(userFormData);
			}

			Ebean.save(user);

			flash("success", "User instance created/edited: " + user);

			return all();
		}
	}

	public static Result delete(Form<UserFormData> formData) {
		UserFormData userFormData = formData.get();

		String id = userFormData.userId;

		long userId = 0;

		if (id != null) {
			userId = Long.valueOf(id);
		}

		User user;

		if (userId > 0) {
			user = User.find.byId(userId);

			Ebean.delete(user);
		}
		else {
			flash("error", "Cannot delete User");
		}

		return all();
	}

}
