
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingorderitem.ShoppingorderitemFormData;

import models.shoppingorderitem.Shoppingorderitem;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingorderitem.shoppingorderitem;
import views.html.shoppingorderitem.shoppingorderitems;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingorderitemApplication extends Controller {

	public static Result addShoppingorderitem() {
		Form<ShoppingorderitemFormData> form = Form.form(
			ShoppingorderitemFormData.class).fill(new Shoppingorderitem().toFormData());

		return ok(shoppingorderitem.render(form));
	}

	public static Result get(Long id) {
		Shoppingorderitem dbShoppingorderitem = Shoppingorderitem.find.byId(id);

		Form<ShoppingorderitemFormData> form = Form.form(
			ShoppingorderitemFormData.class).fill(dbShoppingorderitem.toFormData());

		return ok(shoppingorderitem.render(form));
	}

	public static Result all() {
		List<Shoppingorderitem> shoppingorderitemList = Shoppingorderitem.find.all();

		return ok(shoppingorderitems.render(shoppingorderitemList));
	}

	public static Result submit() {
		Form<ShoppingorderitemFormData> formData = Form.form(
			ShoppingorderitemFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingorderitemFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingorderitem();
		}
		else {
			ShoppingorderitemFormData shoppingorderitemFormData = formData.get();

			String id = shoppingorderitemFormData.orderItemId;

			long shoppingorderitemId = 0;

			if (id != null) {
				shoppingorderitemId = Long.valueOf(id);
			}

			Shoppingorderitem shoppingorderitem;

			if (shoppingorderitemId > 0) {
				shoppingorderitem = Shoppingorderitem.find.byId(shoppingorderitemId);

				shoppingorderitem.setOrderItemId(Long.valueOf(shoppingorderitemFormData.orderItemId));
				shoppingorderitem.setOrderId(Long.valueOf(shoppingorderitemFormData.orderId));
				shoppingorderitem.setItemId(shoppingorderitemFormData.itemId);
				shoppingorderitem.setSku(shoppingorderitemFormData.sku);
				shoppingorderitem.setName(shoppingorderitemFormData.name);
				shoppingorderitem.setDescription(shoppingorderitemFormData.description);
				shoppingorderitem.setProperties(shoppingorderitemFormData.properties);
				shoppingorderitem.setPrice(Double.valueOf(shoppingorderitemFormData.price));
				shoppingorderitem.setQuantity(Integer.valueOf(shoppingorderitemFormData.quantity));
				shoppingorderitem.setShippedDate(new Date(shoppingorderitemFormData.shippedDate));
			}
			else {
				shoppingorderitem = new Shoppingorderitem(shoppingorderitemFormData);
			}

			Ebean.save(shoppingorderitem);

			flash("success", "Shoppingorderitem instance created/edited: " + shoppingorderitem);

			return all();
		}
	}

	public static Result delete(Form<ShoppingorderitemFormData> formData) {
		ShoppingorderitemFormData shoppingorderitemFormData = formData.get();

		String id = shoppingorderitemFormData.orderItemId;

		long shoppingorderitemId = 0;

		if (id != null) {
			shoppingorderitemId = Long.valueOf(id);
		}

		Shoppingorderitem shoppingorderitem;

		if (shoppingorderitemId > 0) {
			shoppingorderitem = Shoppingorderitem.find.byId(shoppingorderitemId);

			Ebean.delete(shoppingorderitem);
		}
		else {
			flash("error", "Cannot delete Shoppingorderitem");
		}

		return all();
	}

}
