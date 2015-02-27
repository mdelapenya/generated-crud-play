
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalarticleimage.JournalarticleimageFormData;

import models.journalarticleimage.Journalarticleimage;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalarticleimage.journalarticleimage;
import views.html.journalarticleimage.journalarticleimages;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalarticleimageApplication extends Controller {

	public static Result addJournalarticleimage() {
		Form<JournalarticleimageFormData> form = Form.form(
			JournalarticleimageFormData.class).fill(new Journalarticleimage().toFormData());

		return ok(journalarticleimage.render(form));
	}

	public static Result get(Long id) {
		Journalarticleimage dbJournalarticleimage = Journalarticleimage.find.byId(id);

		Form<JournalarticleimageFormData> form = Form.form(
			JournalarticleimageFormData.class).fill(dbJournalarticleimage.toFormData());

		return ok(journalarticleimage.render(form));
	}

	public static Result all() {
		List<Journalarticleimage> journalarticleimageList = Journalarticleimage.find.all();

		return ok(journalarticleimages.render(journalarticleimageList));
	}

	public static Result submit() {
		Form<JournalarticleimageFormData> formData = Form.form(
			JournalarticleimageFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalarticleimageFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalarticleimage();
		}
		else {
			JournalarticleimageFormData journalarticleimageFormData = formData.get();

			String id = journalarticleimageFormData.articleImageId;

			long journalarticleimageId = 0;

			if (id != null) {
				journalarticleimageId = Long.valueOf(id);
			}

			Journalarticleimage journalarticleimage;

			if (journalarticleimageId > 0) {
				journalarticleimage = Journalarticleimage.find.byId(journalarticleimageId);

				journalarticleimage.setArticleImageId(Long.valueOf(journalarticleimageFormData.articleImageId));
				journalarticleimage.setGroupId(Long.valueOf(journalarticleimageFormData.groupId));
				journalarticleimage.setArticleId(journalarticleimageFormData.articleId);
				journalarticleimage.setVersion(Double.valueOf(journalarticleimageFormData.version));
				journalarticleimage.setElInstanceId(journalarticleimageFormData.elInstanceId);
				journalarticleimage.setElName(journalarticleimageFormData.elName);
				journalarticleimage.setLanguageId(journalarticleimageFormData.languageId);
				journalarticleimage.setTempImage(Boolean.valueOf(journalarticleimageFormData.tempImage));
			}
			else {
				journalarticleimage = new Journalarticleimage(journalarticleimageFormData);
			}

			Ebean.save(journalarticleimage);

			flash("success", "Journalarticleimage instance created/edited: " + journalarticleimage);

			return all();
		}
	}

	public static Result delete(Form<JournalarticleimageFormData> formData) {
		JournalarticleimageFormData journalarticleimageFormData = formData.get();

		String id = journalarticleimageFormData.articleImageId;

		long journalarticleimageId = 0;

		if (id != null) {
			journalarticleimageId = Long.valueOf(id);
		}

		Journalarticleimage journalarticleimage;

		if (journalarticleimageId > 0) {
			journalarticleimage = Journalarticleimage.find.byId(journalarticleimageId);

			Ebean.delete(journalarticleimage);
		}
		else {
			flash("error", "Cannot delete Journalarticleimage");
		}

		return all();
	}

}
