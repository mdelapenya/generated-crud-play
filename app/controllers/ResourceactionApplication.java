
package controllers;

import com.avaje.ebean.Ebean;

import controllers.resourceaction.ResourceactionFormData;

import models.resourceaction.Resourceaction;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.resourceaction.resourceaction;
import views.html.resourceaction.resourceactions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ResourceactionApplication extends Controller {

	public static Result addResourceaction() {
		Form<ResourceactionFormData> form = Form.form(
			ResourceactionFormData.class).fill(new Resourceaction().toFormData());

		return ok(resourceaction.render(form));
	}

	public static Result get(Long id) {
		Resourceaction dbResourceaction = Resourceaction.find.byId(id);

		Form<ResourceactionFormData> form = Form.form(
			ResourceactionFormData.class).fill(dbResourceaction.toFormData());

		return ok(resourceaction.render(form));
	}

	public static Result all() {
		List<Resourceaction> resourceactionList = Resourceaction.find.all();

		return ok(resourceactions.render(resourceactionList));
	}

	public static Result submit() {
		Form<ResourceactionFormData> formData = Form.form(
			ResourceactionFormData.class).bindFromRequest();

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

	public static Result edit(Form<ResourceactionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addResourceaction();
		}
		else {
			ResourceactionFormData resourceactionFormData = formData.get();

			String id = resourceactionFormData.resourceActionId;

			long resourceactionId = 0;

			if (id != null) {
				resourceactionId = Long.valueOf(id);
			}

			Resourceaction resourceaction;

			if (resourceactionId > 0) {
				resourceaction = Resourceaction.find.byId(resourceactionId);

				resourceaction.setMvccVersion(Long.valueOf(resourceactionFormData.mvccVersion));
				resourceaction.setResourceActionId(Long.valueOf(resourceactionFormData.resourceActionId));
				resourceaction.setName(resourceactionFormData.name);
				resourceaction.setActionId(resourceactionFormData.actionId);
				resourceaction.setBitwiseValue(Long.valueOf(resourceactionFormData.bitwiseValue));
			}
			else {
				resourceaction = new Resourceaction(resourceactionFormData);
			}

			Ebean.save(resourceaction);

			flash("success", "Resourceaction instance created/edited: " + resourceaction);

			return all();
		}
	}

	public static Result delete(Form<ResourceactionFormData> formData) {
		ResourceactionFormData resourceactionFormData = formData.get();

		String id = resourceactionFormData.resourceActionId;

		long resourceactionId = 0;

		if (id != null) {
			resourceactionId = Long.valueOf(id);
		}

		Resourceaction resourceaction;

		if (resourceactionId > 0) {
			resourceaction = Resourceaction.find.byId(resourceactionId);

			Ebean.delete(resourceaction);
		}
		else {
			flash("error", "Cannot delete Resourceaction");
		}

		return all();
	}

}
