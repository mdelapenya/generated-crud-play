
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assettagstats.AssettagstatsFormData;

import models.assettagstats.Assettagstats;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assettagstats.assettagstats;
import views.html.assettagstats.assettagstatss;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssettagstatsApplication extends Controller {

	public static Result addAssettagstats() {
		Form<AssettagstatsFormData> form = Form.form(
			AssettagstatsFormData.class).fill(new Assettagstats().toFormData());

		return ok(assettagstats.render(form));
	}

	public static Result get(Long id) {
		Assettagstats dbAssettagstats = Assettagstats.find.byId(id);

		Form<AssettagstatsFormData> form = Form.form(
			AssettagstatsFormData.class).fill(dbAssettagstats.toFormData());

		return ok(assettagstats.render(form));
	}

	public static Result all() {
		List<Assettagstats> assettagstatsList = Assettagstats.find.all();

		return ok(assettagstatss.render(assettagstatsList));
	}

	public static Result submit() {
		Form<AssettagstatsFormData> formData = Form.form(
			AssettagstatsFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssettagstatsFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssettagstats();
		}
		else {
			AssettagstatsFormData assettagstatsFormData = formData.get();

			String id = assettagstatsFormData.tagStatsId;

			long assettagstatsId = 0;

			if (id != null) {
				assettagstatsId = Long.valueOf(id);
			}

			Assettagstats assettagstats;

			if (assettagstatsId > 0) {
				assettagstats = Assettagstats.find.byId(assettagstatsId);

				assettagstats.setTagStatsId(Long.valueOf(assettagstatsFormData.tagStatsId));
				assettagstats.setTagId(Long.valueOf(assettagstatsFormData.tagId));
				assettagstats.setClassNameId(Long.valueOf(assettagstatsFormData.classNameId));
				assettagstats.setAssetCount(Integer.valueOf(assettagstatsFormData.assetCount));
			}
			else {
				assettagstats = new Assettagstats(assettagstatsFormData);
			}

			Ebean.save(assettagstats);

			flash("success", "Assettagstats instance created/edited: " + assettagstats);

			return all();
		}
	}

	public static Result delete(Form<AssettagstatsFormData> formData) {
		AssettagstatsFormData assettagstatsFormData = formData.get();

		String id = assettagstatsFormData.tagStatsId;

		long assettagstatsId = 0;

		if (id != null) {
			assettagstatsId = Long.valueOf(id);
		}

		Assettagstats assettagstats;

		if (assettagstatsId > 0) {
			assettagstats = Assettagstats.find.byId(assettagstatsId);

			Ebean.delete(assettagstats);
		}
		else {
			flash("error", "Cannot delete Assettagstats");
		}

		return all();
	}

}
