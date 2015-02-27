
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingitem.ShoppingitemFormData;

import models.shoppingitem.Shoppingitem;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingitem.shoppingitem;
import views.html.shoppingitem.shoppingitems;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingitemApplication extends Controller {

	public static Result addShoppingitem() {
		Form<ShoppingitemFormData> form = Form.form(
			ShoppingitemFormData.class).fill(new Shoppingitem().toFormData());

		return ok(shoppingitem.render(form));
	}

	public static Result get(Long id) {
		Shoppingitem dbShoppingitem = Shoppingitem.find.byId(id);

		Form<ShoppingitemFormData> form = Form.form(
			ShoppingitemFormData.class).fill(dbShoppingitem.toFormData());

		return ok(shoppingitem.render(form));
	}

	public static Result all() {
		List<Shoppingitem> shoppingitemList = Shoppingitem.find.all();

		return ok(shoppingitems.render(shoppingitemList));
	}

	public static Result submit() {
		Form<ShoppingitemFormData> formData = Form.form(
			ShoppingitemFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingitemFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingitem();
		}
		else {
			ShoppingitemFormData shoppingitemFormData = formData.get();

			String id = shoppingitemFormData.itemId;

			long shoppingitemId = 0;

			if (id != null) {
				shoppingitemId = Long.valueOf(id);
			}

			Shoppingitem shoppingitem;

			if (shoppingitemId > 0) {
				shoppingitem = Shoppingitem.find.byId(shoppingitemId);

				shoppingitem.setItemId(Long.valueOf(shoppingitemFormData.itemId));
				shoppingitem.setGroupId(Long.valueOf(shoppingitemFormData.groupId));
				shoppingitem.setCompanyId(Long.valueOf(shoppingitemFormData.companyId));
				shoppingitem.setUserId(Long.valueOf(shoppingitemFormData.userId));
				shoppingitem.setUserName(shoppingitemFormData.userName);
				shoppingitem.setCreateDate(new Date(shoppingitemFormData.createDate));
				shoppingitem.setModifiedDate(new Date(shoppingitemFormData.modifiedDate));
				shoppingitem.setCategoryId(Long.valueOf(shoppingitemFormData.categoryId));
				shoppingitem.setSku(shoppingitemFormData.sku);
				shoppingitem.setName(shoppingitemFormData.name);
				shoppingitem.setDescription(shoppingitemFormData.description);
				shoppingitem.setProperties(shoppingitemFormData.properties);
				shoppingitem.setFields(Boolean.valueOf(shoppingitemFormData.fields));
				shoppingitem.setFieldsQuantities(shoppingitemFormData.fieldsQuantities);
				shoppingitem.setMinQuantity(Integer.valueOf(shoppingitemFormData.minQuantity));
				shoppingitem.setMaxQuantity(Integer.valueOf(shoppingitemFormData.maxQuantity));
				shoppingitem.setPrice(Double.valueOf(shoppingitemFormData.price));
				shoppingitem.setDiscount(Double.valueOf(shoppingitemFormData.discount));
				shoppingitem.setTaxable(Boolean.valueOf(shoppingitemFormData.taxable));
				shoppingitem.setShipping(Double.valueOf(shoppingitemFormData.shipping));
				shoppingitem.setUseShippingFormula(Boolean.valueOf(shoppingitemFormData.useShippingFormula));
				shoppingitem.setRequiresShipping(Boolean.valueOf(shoppingitemFormData.requiresShipping));
				shoppingitem.setStockQuantity(Integer.valueOf(shoppingitemFormData.stockQuantity));
				shoppingitem.setFeatured(Boolean.valueOf(shoppingitemFormData.featured));
				shoppingitem.setSale(Boolean.valueOf(shoppingitemFormData.sale));
				shoppingitem.setSmallImage(Boolean.valueOf(shoppingitemFormData.smallImage));
				shoppingitem.setSmallImageId(Long.valueOf(shoppingitemFormData.smallImageId));
				shoppingitem.setSmallImageURL(shoppingitemFormData.smallImageURL);
				shoppingitem.setMediumImage(Boolean.valueOf(shoppingitemFormData.mediumImage));
				shoppingitem.setMediumImageId(Long.valueOf(shoppingitemFormData.mediumImageId));
				shoppingitem.setMediumImageURL(shoppingitemFormData.mediumImageURL);
				shoppingitem.setLargeImage(Boolean.valueOf(shoppingitemFormData.largeImage));
				shoppingitem.setLargeImageId(Long.valueOf(shoppingitemFormData.largeImageId));
				shoppingitem.setLargeImageURL(shoppingitemFormData.largeImageURL);
			}
			else {
				shoppingitem = new Shoppingitem(shoppingitemFormData);
			}

			Ebean.save(shoppingitem);

			flash("success", "Shoppingitem instance created/edited: " + shoppingitem);

			return all();
		}
	}

	public static Result delete(Form<ShoppingitemFormData> formData) {
		ShoppingitemFormData shoppingitemFormData = formData.get();

		String id = shoppingitemFormData.itemId;

		long shoppingitemId = 0;

		if (id != null) {
			shoppingitemId = Long.valueOf(id);
		}

		Shoppingitem shoppingitem;

		if (shoppingitemId > 0) {
			shoppingitem = Shoppingitem.find.byId(shoppingitemId);

			Ebean.delete(shoppingitem);
		}
		else {
			flash("error", "Cannot delete Shoppingitem");
		}

		return all();
	}

}
