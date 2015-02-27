
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingcoupon.ShoppingcouponFormData;

import models.shoppingcoupon.Shoppingcoupon;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingcoupon.shoppingcoupon;
import views.html.shoppingcoupon.shoppingcoupons;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingcouponApplication extends Controller {

	public static Result addShoppingcoupon() {
		Form<ShoppingcouponFormData> form = Form.form(
			ShoppingcouponFormData.class).fill(new Shoppingcoupon().toFormData());

		return ok(shoppingcoupon.render(form));
	}

	public static Result get(Long id) {
		Shoppingcoupon dbShoppingcoupon = Shoppingcoupon.find.byId(id);

		Form<ShoppingcouponFormData> form = Form.form(
			ShoppingcouponFormData.class).fill(dbShoppingcoupon.toFormData());

		return ok(shoppingcoupon.render(form));
	}

	public static Result all() {
		List<Shoppingcoupon> shoppingcouponList = Shoppingcoupon.find.all();

		return ok(shoppingcoupons.render(shoppingcouponList));
	}

	public static Result submit() {
		Form<ShoppingcouponFormData> formData = Form.form(
			ShoppingcouponFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingcouponFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingcoupon();
		}
		else {
			ShoppingcouponFormData shoppingcouponFormData = formData.get();

			String id = shoppingcouponFormData.couponId;

			long shoppingcouponId = 0;

			if (id != null) {
				shoppingcouponId = Long.valueOf(id);
			}

			Shoppingcoupon shoppingcoupon;

			if (shoppingcouponId > 0) {
				shoppingcoupon = Shoppingcoupon.find.byId(shoppingcouponId);

				shoppingcoupon.setCouponId(Long.valueOf(shoppingcouponFormData.couponId));
				shoppingcoupon.setGroupId(Long.valueOf(shoppingcouponFormData.groupId));
				shoppingcoupon.setCompanyId(Long.valueOf(shoppingcouponFormData.companyId));
				shoppingcoupon.setUserId(Long.valueOf(shoppingcouponFormData.userId));
				shoppingcoupon.setUserName(shoppingcouponFormData.userName);
				shoppingcoupon.setCreateDate(new Date(shoppingcouponFormData.createDate));
				shoppingcoupon.setModifiedDate(new Date(shoppingcouponFormData.modifiedDate));
				shoppingcoupon.setCode(shoppingcouponFormData.code);
				shoppingcoupon.setName(shoppingcouponFormData.name);
				shoppingcoupon.setDescription(shoppingcouponFormData.description);
				shoppingcoupon.setStartDate(new Date(shoppingcouponFormData.startDate));
				shoppingcoupon.setEndDate(new Date(shoppingcouponFormData.endDate));
				shoppingcoupon.setActive(Boolean.valueOf(shoppingcouponFormData.active));
				shoppingcoupon.setLimitCategories(shoppingcouponFormData.limitCategories);
				shoppingcoupon.setLimitSkus(shoppingcouponFormData.limitSkus);
				shoppingcoupon.setMinOrder(Double.valueOf(shoppingcouponFormData.minOrder));
				shoppingcoupon.setDiscount(Double.valueOf(shoppingcouponFormData.discount));
				shoppingcoupon.setDiscountType(shoppingcouponFormData.discountType);
			}
			else {
				shoppingcoupon = new Shoppingcoupon(shoppingcouponFormData);
			}

			Ebean.save(shoppingcoupon);

			flash("success", "Shoppingcoupon instance created/edited: " + shoppingcoupon);

			return all();
		}
	}

	public static Result delete(Form<ShoppingcouponFormData> formData) {
		ShoppingcouponFormData shoppingcouponFormData = formData.get();

		String id = shoppingcouponFormData.couponId;

		long shoppingcouponId = 0;

		if (id != null) {
			shoppingcouponId = Long.valueOf(id);
		}

		Shoppingcoupon shoppingcoupon;

		if (shoppingcouponId > 0) {
			shoppingcoupon = Shoppingcoupon.find.byId(shoppingcouponId);

			Ebean.delete(shoppingcoupon);
		}
		else {
			flash("error", "Cannot delete Shoppingcoupon");
		}

		return all();
	}

}
