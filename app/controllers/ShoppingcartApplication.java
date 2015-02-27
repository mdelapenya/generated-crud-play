
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingcart.ShoppingcartFormData;

import models.shoppingcart.Shoppingcart;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingcart.shoppingcart;
import views.html.shoppingcart.shoppingcarts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingcartApplication extends Controller {

	public static Result addShoppingcart() {
		Form<ShoppingcartFormData> form = Form.form(
			ShoppingcartFormData.class).fill(new Shoppingcart().toFormData());

		return ok(shoppingcart.render(form));
	}

	public static Result get(Long id) {
		Shoppingcart dbShoppingcart = Shoppingcart.find.byId(id);

		Form<ShoppingcartFormData> form = Form.form(
			ShoppingcartFormData.class).fill(dbShoppingcart.toFormData());

		return ok(shoppingcart.render(form));
	}

	public static Result all() {
		List<Shoppingcart> shoppingcartList = Shoppingcart.find.all();

		return ok(shoppingcarts.render(shoppingcartList));
	}

	public static Result submit() {
		Form<ShoppingcartFormData> formData = Form.form(
			ShoppingcartFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingcartFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingcart();
		}
		else {
			ShoppingcartFormData shoppingcartFormData = formData.get();

			String id = shoppingcartFormData.cartId;

			long shoppingcartId = 0;

			if (id != null) {
				shoppingcartId = Long.valueOf(id);
			}

			Shoppingcart shoppingcart;

			if (shoppingcartId > 0) {
				shoppingcart = Shoppingcart.find.byId(shoppingcartId);

				shoppingcart.setCartId(Long.valueOf(shoppingcartFormData.cartId));
				shoppingcart.setGroupId(Long.valueOf(shoppingcartFormData.groupId));
				shoppingcart.setCompanyId(Long.valueOf(shoppingcartFormData.companyId));
				shoppingcart.setUserId(Long.valueOf(shoppingcartFormData.userId));
				shoppingcart.setUserName(shoppingcartFormData.userName);
				shoppingcart.setCreateDate(new Date(shoppingcartFormData.createDate));
				shoppingcart.setModifiedDate(new Date(shoppingcartFormData.modifiedDate));
				shoppingcart.setItemIds(shoppingcartFormData.itemIds);
				shoppingcart.setCouponCodes(shoppingcartFormData.couponCodes);
				shoppingcart.setAltShipping(Integer.valueOf(shoppingcartFormData.altShipping));
				shoppingcart.setInsure(Boolean.valueOf(shoppingcartFormData.insure));
			}
			else {
				shoppingcart = new Shoppingcart(shoppingcartFormData);
			}

			Ebean.save(shoppingcart);

			flash("success", "Shoppingcart instance created/edited: " + shoppingcart);

			return all();
		}
	}

	public static Result delete(Form<ShoppingcartFormData> formData) {
		ShoppingcartFormData shoppingcartFormData = formData.get();

		String id = shoppingcartFormData.cartId;

		long shoppingcartId = 0;

		if (id != null) {
			shoppingcartId = Long.valueOf(id);
		}

		Shoppingcart shoppingcart;

		if (shoppingcartId > 0) {
			shoppingcart = Shoppingcart.find.byId(shoppingcartId);

			Ebean.delete(shoppingcart);
		}
		else {
			flash("error", "Cannot delete Shoppingcart");
		}

		return all();
	}

}
