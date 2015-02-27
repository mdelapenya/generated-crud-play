
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assettag.AssettagFormData;

import models.assettag.Assettag;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assettag.assettag;
import views.html.assettag.assettags;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssettagApplication extends Controller {

	public static Result addAssettag() {
		Form<AssettagFormData> form = Form.form(
			AssettagFormData.class).fill(new Assettag().toFormData());

		return ok(assettag.render(form));
	}

	public static Result get(Long id) {
		Assettag dbAssettag = Assettag.find.byId(id);

		Form<AssettagFormData> form = Form.form(
			AssettagFormData.class).fill(dbAssettag.toFormData());

		return ok(assettag.render(form));
	}

	public static Result all() {
		List<Assettag> assettagList = Assettag.find.all();

		return ok(assettags.render(assettagList));
	}

	public static Result submit() {
		Form<AssettagFormData> formData = Form.form(
			AssettagFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssettagFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssettag();
		}
		else {
			AssettagFormData assettagFormData = formData.get();

			String id = assettagFormData.tagId;

			long assettagId = 0;

			if (id != null) {
				assettagId = Long.valueOf(id);
			}

			Assettag assettag;

			if (assettagId > 0) {
				assettag = Assettag.find.byId(assettagId);

				assettag.setTagId(Long.valueOf(assettagFormData.tagId));
				assettag.setGroupId(Long.valueOf(assettagFormData.groupId));
				assettag.setCompanyId(Long.valueOf(assettagFormData.companyId));
				assettag.setUserId(Long.valueOf(assettagFormData.userId));
				assettag.setUserName(assettagFormData.userName);
				assettag.setCreateDate(new Date(assettagFormData.createDate));
				assettag.setModifiedDate(new Date(assettagFormData.modifiedDate));
				assettag.setName(assettagFormData.name);
				assettag.setAssetCount(Integer.valueOf(assettagFormData.assetCount));
			}
			else {
				assettag = new Assettag(assettagFormData);
			}

			Ebean.save(assettag);

			flash("success", "Assettag instance created/edited: " + assettag);

			return all();
		}
	}

	public static Result delete(Form<AssettagFormData> formData) {
		AssettagFormData assettagFormData = formData.get();

		String id = assettagFormData.tagId;

		long assettagId = 0;

		if (id != null) {
			assettagId = Long.valueOf(id);
		}

		Assettag assettag;

		if (assettagId > 0) {
			assettag = Assettag.find.byId(assettagId);

			Ebean.delete(assettag);
		}
		else {
			flash("error", "Cannot delete Assettag");
		}

		return all();
	}

}
