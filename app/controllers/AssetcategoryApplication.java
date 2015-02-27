
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assetcategory.AssetcategoryFormData;

import models.assetcategory.Assetcategory;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assetcategory.assetcategory;
import views.html.assetcategory.assetcategorys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssetcategoryApplication extends Controller {

	public static Result addAssetcategory() {
		Form<AssetcategoryFormData> form = Form.form(
			AssetcategoryFormData.class).fill(new Assetcategory().toFormData());

		return ok(assetcategory.render(form));
	}

	public static Result get(Long id) {
		Assetcategory dbAssetcategory = Assetcategory.find.byId(id);

		Form<AssetcategoryFormData> form = Form.form(
			AssetcategoryFormData.class).fill(dbAssetcategory.toFormData());

		return ok(assetcategory.render(form));
	}

	public static Result all() {
		List<Assetcategory> assetcategoryList = Assetcategory.find.all();

		return ok(assetcategorys.render(assetcategoryList));
	}

	public static Result submit() {
		Form<AssetcategoryFormData> formData = Form.form(
			AssetcategoryFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssetcategoryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssetcategory();
		}
		else {
			AssetcategoryFormData assetcategoryFormData = formData.get();

			String id = assetcategoryFormData.categoryId;

			long assetcategoryId = 0;

			if (id != null) {
				assetcategoryId = Long.valueOf(id);
			}

			Assetcategory assetcategory;

			if (assetcategoryId > 0) {
				assetcategory = Assetcategory.find.byId(assetcategoryId);

				assetcategory.setUuid(assetcategoryFormData.uuid);
				assetcategory.setCategoryId(Long.valueOf(assetcategoryFormData.categoryId));
				assetcategory.setGroupId(Long.valueOf(assetcategoryFormData.groupId));
				assetcategory.setCompanyId(Long.valueOf(assetcategoryFormData.companyId));
				assetcategory.setUserId(Long.valueOf(assetcategoryFormData.userId));
				assetcategory.setUserName(assetcategoryFormData.userName);
				assetcategory.setCreateDate(new Date(assetcategoryFormData.createDate));
				assetcategory.setModifiedDate(new Date(assetcategoryFormData.modifiedDate));
				assetcategory.setParentCategoryId(Long.valueOf(assetcategoryFormData.parentCategoryId));
				assetcategory.setLeftCategoryId(Long.valueOf(assetcategoryFormData.leftCategoryId));
				assetcategory.setRightCategoryId(Long.valueOf(assetcategoryFormData.rightCategoryId));
				assetcategory.setName(assetcategoryFormData.name);
				assetcategory.setTitle(assetcategoryFormData.title);
				assetcategory.setDescription(assetcategoryFormData.description);
				assetcategory.setVocabularyId(Long.valueOf(assetcategoryFormData.vocabularyId));
			}
			else {
				assetcategory = new Assetcategory(assetcategoryFormData);
			}

			Ebean.save(assetcategory);

			flash("success", "Assetcategory instance created/edited: " + assetcategory);

			return all();
		}
	}

	public static Result delete(Form<AssetcategoryFormData> formData) {
		AssetcategoryFormData assetcategoryFormData = formData.get();

		String id = assetcategoryFormData.categoryId;

		long assetcategoryId = 0;

		if (id != null) {
			assetcategoryId = Long.valueOf(id);
		}

		Assetcategory assetcategory;

		if (assetcategoryId > 0) {
			assetcategory = Assetcategory.find.byId(assetcategoryId);

			Ebean.delete(assetcategory);
		}
		else {
			flash("error", "Cannot delete Assetcategory");
		}

		return all();
	}

}
