
package controllers;

import com.avaje.ebean.Ebean;

import controllers.servicecomponent.ServicecomponentFormData;

import models.servicecomponent.Servicecomponent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.servicecomponent.servicecomponent;
import views.html.servicecomponent.servicecomponents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ServicecomponentApplication extends Controller {

	public static Result addServicecomponent() {
		Form<ServicecomponentFormData> form = Form.form(
			ServicecomponentFormData.class).fill(new Servicecomponent().toFormData());

		return ok(servicecomponent.render(form));
	}

	public static Result get(Long id) {
		Servicecomponent dbServicecomponent = Servicecomponent.find.byId(id);

		Form<ServicecomponentFormData> form = Form.form(
			ServicecomponentFormData.class).fill(dbServicecomponent.toFormData());

		return ok(servicecomponent.render(form));
	}

	public static Result all() {
		List<Servicecomponent> servicecomponentList = Servicecomponent.find.all();

		return ok(servicecomponents.render(servicecomponentList));
	}

	public static Result submit() {
		Form<ServicecomponentFormData> formData = Form.form(
			ServicecomponentFormData.class).bindFromRequest();

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

	public static Result edit(Form<ServicecomponentFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addServicecomponent();
		}
		else {
			ServicecomponentFormData servicecomponentFormData = formData.get();

			String id = servicecomponentFormData.serviceComponentId;

			long servicecomponentId = 0;

			if (id != null) {
				servicecomponentId = Long.valueOf(id);
			}

			Servicecomponent servicecomponent;

			if (servicecomponentId > 0) {
				servicecomponent = Servicecomponent.find.byId(servicecomponentId);

				servicecomponent.setMvccVersion(Long.valueOf(servicecomponentFormData.mvccVersion));
				servicecomponent.setServiceComponentId(Long.valueOf(servicecomponentFormData.serviceComponentId));
				servicecomponent.setBuildNamespace(servicecomponentFormData.buildNamespace);
				servicecomponent.setBuildNumber(Long.valueOf(servicecomponentFormData.buildNumber));
				servicecomponent.setBuildDate(Long.valueOf(servicecomponentFormData.buildDate));
				servicecomponent.setData(servicecomponentFormData.data);
			}
			else {
				servicecomponent = new Servicecomponent(servicecomponentFormData);
			}

			Ebean.save(servicecomponent);

			flash("success", "Servicecomponent instance created/edited: " + servicecomponent);

			return all();
		}
	}

	public static Result delete(Form<ServicecomponentFormData> formData) {
		ServicecomponentFormData servicecomponentFormData = formData.get();

		String id = servicecomponentFormData.serviceComponentId;

		long servicecomponentId = 0;

		if (id != null) {
			servicecomponentId = Long.valueOf(id);
		}

		Servicecomponent servicecomponent;

		if (servicecomponentId > 0) {
			servicecomponent = Servicecomponent.find.byId(servicecomponentId);

			Ebean.delete(servicecomponent);
		}
		else {
			flash("error", "Cannot delete Servicecomponent");
		}

		return all();
	}

}
