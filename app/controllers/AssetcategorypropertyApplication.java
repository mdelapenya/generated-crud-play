
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assetcategoryproperty.AssetcategorypropertyFormData;

import models.assetcategoryproperty.Assetcategoryproperty;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assetcategoryproperty.assetcategoryproperty;
import views.html.assetcategoryproperty.assetcategorypropertys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssetcategorypropertyApplication extends Controller {

	public static Result addAssetcategoryproperty() {
		Form<AssetcategorypropertyFormData> form = Form.form(
			AssetcategorypropertyFormData.class).fill(new Assetcategoryproperty().toFormData());

		return ok(assetcategoryproperty.render(form));
	}

	public static Result get(Long id) {
		Assetcategoryproperty dbAssetcategoryproperty = Assetcategoryproperty.find.byId(id);

		Form<AssetcategorypropertyFormData> form = Form.form(
			AssetcategorypropertyFormData.class).fill(dbAssetcategoryproperty.toFormData());

		return ok(assetcategoryproperty.render(form));
	}

	public static Result all() {
		List<Assetcategoryproperty> assetcategorypropertyList = Assetcategoryproperty.find.all();

		return ok(assetcategorypropertys.render(assetcategorypropertyList));
	}

	public static Result submit() {
		Form<AssetcategorypropertyFormData> formData = Form.form(
			AssetcategorypropertyFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssetcategorypropertyFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssetcategoryproperty();
		}
		else {
			AssetcategorypropertyFormData assetcategorypropertyFormData = formData.get();

			String id = assetcategorypropertyFormData.categoryPropertyId;

			long assetcategorypropertyId = 0;

			if (id != null) {
				assetcategorypropertyId = Long.valueOf(id);
			}

			Assetcategoryproperty assetcategoryproperty;

			if (assetcategorypropertyId > 0) {
				assetcategoryproperty = Assetcategoryproperty.find.byId(assetcategorypropertyId);

				assetcategoryproperty.setCategoryPropertyId(Long.valueOf(assetcategorypropertyFormData.categoryPropertyId));
				assetcategoryproperty.setCompanyId(Long.valueOf(assetcategorypropertyFormData.companyId));
				assetcategoryproperty.setUserId(Long.valueOf(assetcategorypropertyFormData.userId));
				assetcategoryproperty.setUserName(assetcategorypropertyFormData.userName);
				assetcategoryproperty.setCreateDate(new Date(assetcategorypropertyFormData.createDate));
				assetcategoryproperty.setModifiedDate(new Date(assetcategorypropertyFormData.modifiedDate));
				assetcategoryproperty.setCategoryId(Long.valueOf(assetcategorypropertyFormData.categoryId));
				assetcategoryproperty.setKey(assetcategorypropertyFormData.key);
				assetcategoryproperty.setValue(assetcategorypropertyFormData.value);
			}
			else {
				assetcategoryproperty = new Assetcategoryproperty(assetcategorypropertyFormData);
			}

			Ebean.save(assetcategoryproperty);

			flash("success", "Assetcategoryproperty instance created/edited: " + assetcategoryproperty);

			return all();
		}
	}

	public static Result delete(Form<AssetcategorypropertyFormData> formData) {
		AssetcategorypropertyFormData assetcategorypropertyFormData = formData.get();

		String id = assetcategorypropertyFormData.categoryPropertyId;

		long assetcategorypropertyId = 0;

		if (id != null) {
			assetcategorypropertyId = Long.valueOf(id);
		}

		Assetcategoryproperty assetcategoryproperty;

		if (assetcategorypropertyId > 0) {
			assetcategoryproperty = Assetcategoryproperty.find.byId(assetcategorypropertyId);

			Ebean.delete(assetcategoryproperty);
		}
		else {
			flash("error", "Cannot delete Assetcategoryproperty");
		}

		return all();
	}

}
