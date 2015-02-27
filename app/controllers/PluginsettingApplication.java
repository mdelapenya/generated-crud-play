
package controllers;

import com.avaje.ebean.Ebean;

import controllers.pluginsetting.PluginsettingFormData;

import models.pluginsetting.Pluginsetting;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.pluginsetting.pluginsetting;
import views.html.pluginsetting.pluginsettings;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class PluginsettingApplication extends Controller {

	public static Result addPluginsetting() {
		Form<PluginsettingFormData> form = Form.form(
			PluginsettingFormData.class).fill(new Pluginsetting().toFormData());

		return ok(pluginsetting.render(form));
	}

	public static Result get(Long id) {
		Pluginsetting dbPluginsetting = Pluginsetting.find.byId(id);

		Form<PluginsettingFormData> form = Form.form(
			PluginsettingFormData.class).fill(dbPluginsetting.toFormData());

		return ok(pluginsetting.render(form));
	}

	public static Result all() {
		List<Pluginsetting> pluginsettingList = Pluginsetting.find.all();

		return ok(pluginsettings.render(pluginsettingList));
	}

	public static Result submit() {
		Form<PluginsettingFormData> formData = Form.form(
			PluginsettingFormData.class).bindFromRequest();

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

	public static Result edit(Form<PluginsettingFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addPluginsetting();
		}
		else {
			PluginsettingFormData pluginsettingFormData = formData.get();

			String id = pluginsettingFormData.pluginSettingId;

			long pluginsettingId = 0;

			if (id != null) {
				pluginsettingId = Long.valueOf(id);
			}

			Pluginsetting pluginsetting;

			if (pluginsettingId > 0) {
				pluginsetting = Pluginsetting.find.byId(pluginsettingId);

				pluginsetting.setMvccVersion(Long.valueOf(pluginsettingFormData.mvccVersion));
				pluginsetting.setPluginSettingId(Long.valueOf(pluginsettingFormData.pluginSettingId));
				pluginsetting.setCompanyId(Long.valueOf(pluginsettingFormData.companyId));
				pluginsetting.setPluginId(pluginsettingFormData.pluginId);
				pluginsetting.setPluginType(pluginsettingFormData.pluginType);
				pluginsetting.setRoles(pluginsettingFormData.roles);
				pluginsetting.setActive(Boolean.valueOf(pluginsettingFormData.active));
			}
			else {
				pluginsetting = new Pluginsetting(pluginsettingFormData);
			}

			Ebean.save(pluginsetting);

			flash("success", "Pluginsetting instance created/edited: " + pluginsetting);

			return all();
		}
	}

	public static Result delete(Form<PluginsettingFormData> formData) {
		PluginsettingFormData pluginsettingFormData = formData.get();

		String id = pluginsettingFormData.pluginSettingId;

		long pluginsettingId = 0;

		if (id != null) {
			pluginsettingId = Long.valueOf(id);
		}

		Pluginsetting pluginsetting;

		if (pluginsettingId > 0) {
			pluginsetting = Pluginsetting.find.byId(pluginsettingId);

			Ebean.delete(pluginsetting);
		}
		else {
			flash("error", "Cannot delete Pluginsetting");
		}

		return all();
	}

}
