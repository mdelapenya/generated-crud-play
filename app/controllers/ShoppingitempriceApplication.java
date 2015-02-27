
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingitemprice.ShoppingitempriceFormData;

import models.shoppingitemprice.Shoppingitemprice;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingitemprice.shoppingitemprice;
import views.html.shoppingitemprice.shoppingitemprices;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingitempriceApplication extends Controller {

	public static Result addShoppingitemprice() {
		Form<ShoppingitempriceFormData> form = Form.form(
			ShoppingitempriceFormData.class).fill(new Shoppingitemprice().toFormData());

		return ok(shoppingitemprice.render(form));
	}

	public static Result get(Long id) {
		Shoppingitemprice dbShoppingitemprice = Shoppingitemprice.find.byId(id);

		Form<ShoppingitempriceFormData> form = Form.form(
			ShoppingitempriceFormData.class).fill(dbShoppingitemprice.toFormData());

		return ok(shoppingitemprice.render(form));
	}

	public static Result all() {
		List<Shoppingitemprice> shoppingitempriceList = Shoppingitemprice.find.all();

		return ok(shoppingitemprices.render(shoppingitempriceList));
	}

	public static Result submit() {
		Form<ShoppingitempriceFormData> formData = Form.form(
			ShoppingitempriceFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingitempriceFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingitemprice();
		}
		else {
			ShoppingitempriceFormData shoppingitempriceFormData = formData.get();

			String id = shoppingitempriceFormData.itemPriceId;

			long shoppingitempriceId = 0;

			if (id != null) {
				shoppingitempriceId = Long.valueOf(id);
			}

			Shoppingitemprice shoppingitemprice;

			if (shoppingitempriceId > 0) {
				shoppingitemprice = Shoppingitemprice.find.byId(shoppingitempriceId);

				shoppingitemprice.setItemPriceId(Long.valueOf(shoppingitempriceFormData.itemPriceId));
				shoppingitemprice.setItemId(Long.valueOf(shoppingitempriceFormData.itemId));
				shoppingitemprice.setMinQuantity(Integer.valueOf(shoppingitempriceFormData.minQuantity));
				shoppingitemprice.setMaxQuantity(Integer.valueOf(shoppingitempriceFormData.maxQuantity));
				shoppingitemprice.setPrice(Double.valueOf(shoppingitempriceFormData.price));
				shoppingitemprice.setDiscount(Double.valueOf(shoppingitempriceFormData.discount));
				shoppingitemprice.setTaxable(Boolean.valueOf(shoppingitempriceFormData.taxable));
				shoppingitemprice.setShipping(Double.valueOf(shoppingitempriceFormData.shipping));
				shoppingitemprice.setUseShippingFormula(Boolean.valueOf(shoppingitempriceFormData.useShippingFormula));
				shoppingitemprice.setStatus(Integer.valueOf(shoppingitempriceFormData.status));
			}
			else {
				shoppingitemprice = new Shoppingitemprice(shoppingitempriceFormData);
			}

			Ebean.save(shoppingitemprice);

			flash("success", "Shoppingitemprice instance created/edited: " + shoppingitemprice);

			return all();
		}
	}

	public static Result delete(Form<ShoppingitempriceFormData> formData) {
		ShoppingitempriceFormData shoppingitempriceFormData = formData.get();

		String id = shoppingitempriceFormData.itemPriceId;

		long shoppingitempriceId = 0;

		if (id != null) {
			shoppingitempriceId = Long.valueOf(id);
		}

		Shoppingitemprice shoppingitemprice;

		if (shoppingitempriceId > 0) {
			shoppingitemprice = Shoppingitemprice.find.byId(shoppingitempriceId);

			Ebean.delete(shoppingitemprice);
		}
		else {
			flash("error", "Cannot delete Shoppingitemprice");
		}

		return all();
	}

}
