
package controllers;

import com.avaje.ebean.Ebean;

import controllers.subscription.SubscriptionFormData;

import models.subscription.Subscription;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.subscription.subscription;
import views.html.subscription.subscriptions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SubscriptionApplication extends Controller {

	public static Result addSubscription() {
		Form<SubscriptionFormData> form = Form.form(
			SubscriptionFormData.class).fill(new Subscription().toFormData());

		return ok(subscription.render(form));
	}

	public static Result get(Long id) {
		Subscription dbSubscription = Subscription.find.byId(id);

		Form<SubscriptionFormData> form = Form.form(
			SubscriptionFormData.class).fill(dbSubscription.toFormData());

		return ok(subscription.render(form));
	}

	public static Result all() {
		List<Subscription> subscriptionList = Subscription.find.all();

		return ok(subscriptions.render(subscriptionList));
	}

	public static Result submit() {
		Form<SubscriptionFormData> formData = Form.form(
			SubscriptionFormData.class).bindFromRequest();

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

	public static Result edit(Form<SubscriptionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSubscription();
		}
		else {
			SubscriptionFormData subscriptionFormData = formData.get();

			String id = subscriptionFormData.subscriptionId;

			long subscriptionId = 0;

			if (id != null) {
				subscriptionId = Long.valueOf(id);
			}

			Subscription subscription;

			if (subscriptionId > 0) {
				subscription = Subscription.find.byId(subscriptionId);

				subscription.setMvccVersion(Long.valueOf(subscriptionFormData.mvccVersion));
				subscription.setSubscriptionId(Long.valueOf(subscriptionFormData.subscriptionId));
				subscription.setGroupId(Long.valueOf(subscriptionFormData.groupId));
				subscription.setCompanyId(Long.valueOf(subscriptionFormData.companyId));
				subscription.setUserId(Long.valueOf(subscriptionFormData.userId));
				subscription.setUserName(subscriptionFormData.userName);
				subscription.setCreateDate(new Date(subscriptionFormData.createDate));
				subscription.setModifiedDate(new Date(subscriptionFormData.modifiedDate));
				subscription.setClassNameId(Long.valueOf(subscriptionFormData.classNameId));
				subscription.setClassPK(Long.valueOf(subscriptionFormData.classPK));
				subscription.setFrequency(subscriptionFormData.frequency);
			}
			else {
				subscription = new Subscription(subscriptionFormData);
			}

			Ebean.save(subscription);

			flash("success", "Subscription instance created/edited: " + subscription);

			return all();
		}
	}

	public static Result delete(Form<SubscriptionFormData> formData) {
		SubscriptionFormData subscriptionFormData = formData.get();

		String id = subscriptionFormData.subscriptionId;

		long subscriptionId = 0;

		if (id != null) {
			subscriptionId = Long.valueOf(id);
		}

		Subscription subscription;

		if (subscriptionId > 0) {
			subscription = Subscription.find.byId(subscriptionId);

			Ebean.delete(subscription);
		}
		else {
			flash("error", "Cannot delete Subscription");
		}

		return all();
	}

}
