
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalarticleresource.JournalarticleresourceFormData;

import models.journalarticleresource.Journalarticleresource;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalarticleresource.journalarticleresource;
import views.html.journalarticleresource.journalarticleresources;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalarticleresourceApplication extends Controller {

	public static Result addJournalarticleresource() {
		Form<JournalarticleresourceFormData> form = Form.form(
			JournalarticleresourceFormData.class).fill(new Journalarticleresource().toFormData());

		return ok(journalarticleresource.render(form));
	}

	public static Result get(Long id) {
		Journalarticleresource dbJournalarticleresource = Journalarticleresource.find.byId(id);

		Form<JournalarticleresourceFormData> form = Form.form(
			JournalarticleresourceFormData.class).fill(dbJournalarticleresource.toFormData());

		return ok(journalarticleresource.render(form));
	}

	public static Result all() {
		List<Journalarticleresource> journalarticleresourceList = Journalarticleresource.find.all();

		return ok(journalarticleresources.render(journalarticleresourceList));
	}

	public static Result submit() {
		Form<JournalarticleresourceFormData> formData = Form.form(
			JournalarticleresourceFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalarticleresourceFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalarticleresource();
		}
		else {
			JournalarticleresourceFormData journalarticleresourceFormData = formData.get();

			String id = journalarticleresourceFormData.resourcePrimKey;

			long journalarticleresourceId = 0;

			if (id != null) {
				journalarticleresourceId = Long.valueOf(id);
			}

			Journalarticleresource journalarticleresource;

			if (journalarticleresourceId > 0) {
				journalarticleresource = Journalarticleresource.find.byId(journalarticleresourceId);

				journalarticleresource.setUuid(journalarticleresourceFormData.uuid);
				journalarticleresource.setResourcePrimKey(Long.valueOf(journalarticleresourceFormData.resourcePrimKey));
				journalarticleresource.setGroupId(Long.valueOf(journalarticleresourceFormData.groupId));
				journalarticleresource.setArticleId(journalarticleresourceFormData.articleId);
			}
			else {
				journalarticleresource = new Journalarticleresource(journalarticleresourceFormData);
			}

			Ebean.save(journalarticleresource);

			flash("success", "Journalarticleresource instance created/edited: " + journalarticleresource);

			return all();
		}
	}

	public static Result delete(Form<JournalarticleresourceFormData> formData) {
		JournalarticleresourceFormData journalarticleresourceFormData = formData.get();

		String id = journalarticleresourceFormData.resourcePrimKey;

		long journalarticleresourceId = 0;

		if (id != null) {
			journalarticleresourceId = Long.valueOf(id);
		}

		Journalarticleresource journalarticleresource;

		if (journalarticleresourceId > 0) {
			journalarticleresource = Journalarticleresource.find.byId(journalarticleresourceId);

			Ebean.delete(journalarticleresource);
		}
		else {
			flash("error", "Cannot delete Journalarticleresource");
		}

		return all();
	}

}
