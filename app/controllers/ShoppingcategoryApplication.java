
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingcategory.ShoppingcategoryFormData;

import models.shoppingcategory.Shoppingcategory;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingcategory.shoppingcategory;
import views.html.shoppingcategory.shoppingcategorys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingcategoryApplication extends Controller {

	public static Result addShoppingcategory() {
		Form<ShoppingcategoryFormData> form = Form.form(
			ShoppingcategoryFormData.class).fill(new Shoppingcategory().toFormData());

		return ok(shoppingcategory.render(form));
	}

	public static Result get(Long id) {
		Shoppingcategory dbShoppingcategory = Shoppingcategory.find.byId(id);

		Form<ShoppingcategoryFormData> form = Form.form(
			ShoppingcategoryFormData.class).fill(dbShoppingcategory.toFormData());

		return ok(shoppingcategory.render(form));
	}

	public static Result all() {
		List<Shoppingcategory> shoppingcategoryList = Shoppingcategory.find.all();

		return ok(shoppingcategorys.render(shoppingcategoryList));
	}

	public static Result submit() {
		Form<ShoppingcategoryFormData> formData = Form.form(
			ShoppingcategoryFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingcategoryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingcategory();
		}
		else {
			ShoppingcategoryFormData shoppingcategoryFormData = formData.get();

			String id = shoppingcategoryFormData.categoryId;

			long shoppingcategoryId = 0;

			if (id != null) {
				shoppingcategoryId = Long.valueOf(id);
			}

			Shoppingcategory shoppingcategory;

			if (shoppingcategoryId > 0) {
				shoppingcategory = Shoppingcategory.find.byId(shoppingcategoryId);

				shoppingcategory.setCategoryId(Long.valueOf(shoppingcategoryFormData.categoryId));
				shoppingcategory.setGroupId(Long.valueOf(shoppingcategoryFormData.groupId));
				shoppingcategory.setCompanyId(Long.valueOf(shoppingcategoryFormData.companyId));
				shoppingcategory.setUserId(Long.valueOf(shoppingcategoryFormData.userId));
				shoppingcategory.setUserName(shoppingcategoryFormData.userName);
				shoppingcategory.setCreateDate(new Date(shoppingcategoryFormData.createDate));
				shoppingcategory.setModifiedDate(new Date(shoppingcategoryFormData.modifiedDate));
				shoppingcategory.setParentCategoryId(Long.valueOf(shoppingcategoryFormData.parentCategoryId));
				shoppingcategory.setName(shoppingcategoryFormData.name);
				shoppingcategory.setDescription(shoppingcategoryFormData.description);
			}
			else {
				shoppingcategory = new Shoppingcategory(shoppingcategoryFormData);
			}

			Ebean.save(shoppingcategory);

			flash("success", "Shoppingcategory instance created/edited: " + shoppingcategory);

			return all();
		}
	}

	public static Result delete(Form<ShoppingcategoryFormData> formData) {
		ShoppingcategoryFormData shoppingcategoryFormData = formData.get();

		String id = shoppingcategoryFormData.categoryId;

		long shoppingcategoryId = 0;

		if (id != null) {
			shoppingcategoryId = Long.valueOf(id);
		}

		Shoppingcategory shoppingcategory;

		if (shoppingcategoryId > 0) {
			shoppingcategory = Shoppingcategory.find.byId(shoppingcategoryId);

			Ebean.delete(shoppingcategory);
		}
		else {
			flash("error", "Cannot delete Shoppingcategory");
		}

		return all();
	}

}
