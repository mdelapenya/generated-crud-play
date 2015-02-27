
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingitemfield.ShoppingitemfieldFormData;

import models.shoppingitemfield.Shoppingitemfield;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingitemfield.shoppingitemfield;
import views.html.shoppingitemfield.shoppingitemfields;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingitemfieldApplication extends Controller {

	public static Result addShoppingitemfield() {
		Form<ShoppingitemfieldFormData> form = Form.form(
			ShoppingitemfieldFormData.class).fill(new Shoppingitemfield().toFormData());

		return ok(shoppingitemfield.render(form));
	}

	public static Result get(Long id) {
		Shoppingitemfield dbShoppingitemfield = Shoppingitemfield.find.byId(id);

		Form<ShoppingitemfieldFormData> form = Form.form(
			ShoppingitemfieldFormData.class).fill(dbShoppingitemfield.toFormData());

		return ok(shoppingitemfield.render(form));
	}

	public static Result all() {
		List<Shoppingitemfield> shoppingitemfieldList = Shoppingitemfield.find.all();

		return ok(shoppingitemfields.render(shoppingitemfieldList));
	}

	public static Result submit() {
		Form<ShoppingitemfieldFormData> formData = Form.form(
			ShoppingitemfieldFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingitemfieldFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingitemfield();
		}
		else {
			ShoppingitemfieldFormData shoppingitemfieldFormData = formData.get();

			String id = shoppingitemfieldFormData.itemFieldId;

			long shoppingitemfieldId = 0;

			if (id != null) {
				shoppingitemfieldId = Long.valueOf(id);
			}

			Shoppingitemfield shoppingitemfield;

			if (shoppingitemfieldId > 0) {
				shoppingitemfield = Shoppingitemfield.find.byId(shoppingitemfieldId);

				shoppingitemfield.setItemFieldId(Long.valueOf(shoppingitemfieldFormData.itemFieldId));
				shoppingitemfield.setItemId(Long.valueOf(shoppingitemfieldFormData.itemId));
				shoppingitemfield.setName(shoppingitemfieldFormData.name);
				shoppingitemfield.setValues(shoppingitemfieldFormData.values);
				shoppingitemfield.setDescription(shoppingitemfieldFormData.description);
			}
			else {
				shoppingitemfield = new Shoppingitemfield(shoppingitemfieldFormData);
			}

			Ebean.save(shoppingitemfield);

			flash("success", "Shoppingitemfield instance created/edited: " + shoppingitemfield);

			return all();
		}
	}

	public static Result delete(Form<ShoppingitemfieldFormData> formData) {
		ShoppingitemfieldFormData shoppingitemfieldFormData = formData.get();

		String id = shoppingitemfieldFormData.itemFieldId;

		long shoppingitemfieldId = 0;

		if (id != null) {
			shoppingitemfieldId = Long.valueOf(id);
		}

		Shoppingitemfield shoppingitemfield;

		if (shoppingitemfieldId > 0) {
			shoppingitemfield = Shoppingitemfield.find.byId(shoppingitemfieldId);

			Ebean.delete(shoppingitemfield);
		}
		else {
			flash("error", "Cannot delete Shoppingitemfield");
		}

		return all();
	}

}
