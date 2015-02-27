
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shoppingorder.ShoppingorderFormData;

import models.shoppingorder.Shoppingorder;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shoppingorder.shoppingorder;
import views.html.shoppingorder.shoppingorders;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingorderApplication extends Controller {

	public static Result addShoppingorder() {
		Form<ShoppingorderFormData> form = Form.form(
			ShoppingorderFormData.class).fill(new Shoppingorder().toFormData());

		return ok(shoppingorder.render(form));
	}

	public static Result get(Long id) {
		Shoppingorder dbShoppingorder = Shoppingorder.find.byId(id);

		Form<ShoppingorderFormData> form = Form.form(
			ShoppingorderFormData.class).fill(dbShoppingorder.toFormData());

		return ok(shoppingorder.render(form));
	}

	public static Result all() {
		List<Shoppingorder> shoppingorderList = Shoppingorder.find.all();

		return ok(shoppingorders.render(shoppingorderList));
	}

	public static Result submit() {
		Form<ShoppingorderFormData> formData = Form.form(
			ShoppingorderFormData.class).bindFromRequest();

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

	public static Result edit(Form<ShoppingorderFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShoppingorder();
		}
		else {
			ShoppingorderFormData shoppingorderFormData = formData.get();

			String id = shoppingorderFormData.orderId;

			long shoppingorderId = 0;

			if (id != null) {
				shoppingorderId = Long.valueOf(id);
			}

			Shoppingorder shoppingorder;

			if (shoppingorderId > 0) {
				shoppingorder = Shoppingorder.find.byId(shoppingorderId);

				shoppingorder.setOrderId(Long.valueOf(shoppingorderFormData.orderId));
				shoppingorder.setGroupId(Long.valueOf(shoppingorderFormData.groupId));
				shoppingorder.setCompanyId(Long.valueOf(shoppingorderFormData.companyId));
				shoppingorder.setUserId(Long.valueOf(shoppingorderFormData.userId));
				shoppingorder.setUserName(shoppingorderFormData.userName);
				shoppingorder.setCreateDate(new Date(shoppingorderFormData.createDate));
				shoppingorder.setModifiedDate(new Date(shoppingorderFormData.modifiedDate));
				shoppingorder.setNumber(shoppingorderFormData.number);
				shoppingorder.setTax(Double.valueOf(shoppingorderFormData.tax));
				shoppingorder.setShipping(Double.valueOf(shoppingorderFormData.shipping));
				shoppingorder.setAltShipping(shoppingorderFormData.altShipping);
				shoppingorder.setRequiresShipping(Boolean.valueOf(shoppingorderFormData.requiresShipping));
				shoppingorder.setInsure(Boolean.valueOf(shoppingorderFormData.insure));
				shoppingorder.setInsurance(Double.valueOf(shoppingorderFormData.insurance));
				shoppingorder.setCouponCodes(shoppingorderFormData.couponCodes);
				shoppingorder.setCouponDiscount(Double.valueOf(shoppingorderFormData.couponDiscount));
				shoppingorder.setBillingFirstName(shoppingorderFormData.billingFirstName);
				shoppingorder.setBillingLastName(shoppingorderFormData.billingLastName);
				shoppingorder.setBillingEmailAddress(shoppingorderFormData.billingEmailAddress);
				shoppingorder.setBillingCompany(shoppingorderFormData.billingCompany);
				shoppingorder.setBillingStreet(shoppingorderFormData.billingStreet);
				shoppingorder.setBillingCity(shoppingorderFormData.billingCity);
				shoppingorder.setBillingState(shoppingorderFormData.billingState);
				shoppingorder.setBillingZip(shoppingorderFormData.billingZip);
				shoppingorder.setBillingCountry(shoppingorderFormData.billingCountry);
				shoppingorder.setBillingPhone(shoppingorderFormData.billingPhone);
				shoppingorder.setShipToBilling(Boolean.valueOf(shoppingorderFormData.shipToBilling));
				shoppingorder.setShippingFirstName(shoppingorderFormData.shippingFirstName);
				shoppingorder.setShippingLastName(shoppingorderFormData.shippingLastName);
				shoppingorder.setShippingEmailAddress(shoppingorderFormData.shippingEmailAddress);
				shoppingorder.setShippingCompany(shoppingorderFormData.shippingCompany);
				shoppingorder.setShippingStreet(shoppingorderFormData.shippingStreet);
				shoppingorder.setShippingCity(shoppingorderFormData.shippingCity);
				shoppingorder.setShippingState(shoppingorderFormData.shippingState);
				shoppingorder.setShippingZip(shoppingorderFormData.shippingZip);
				shoppingorder.setShippingCountry(shoppingorderFormData.shippingCountry);
				shoppingorder.setShippingPhone(shoppingorderFormData.shippingPhone);
				shoppingorder.setCcName(shoppingorderFormData.ccName);
				shoppingorder.setCcType(shoppingorderFormData.ccType);
				shoppingorder.setCcNumber(shoppingorderFormData.ccNumber);
				shoppingorder.setCcExpMonth(Integer.valueOf(shoppingorderFormData.ccExpMonth));
				shoppingorder.setCcExpYear(Integer.valueOf(shoppingorderFormData.ccExpYear));
				shoppingorder.setCcVerNumber(shoppingorderFormData.ccVerNumber);
				shoppingorder.setComments(shoppingorderFormData.comments);
				shoppingorder.setPpTxnId(shoppingorderFormData.ppTxnId);
				shoppingorder.setPpPaymentStatus(shoppingorderFormData.ppPaymentStatus);
				shoppingorder.setPpPaymentGross(Double.valueOf(shoppingorderFormData.ppPaymentGross));
				shoppingorder.setPpReceiverEmail(shoppingorderFormData.ppReceiverEmail);
				shoppingorder.setPpPayerEmail(shoppingorderFormData.ppPayerEmail);
				shoppingorder.setSendOrderEmail(Boolean.valueOf(shoppingorderFormData.sendOrderEmail));
				shoppingorder.setSendShippingEmail(Boolean.valueOf(shoppingorderFormData.sendShippingEmail));
			}
			else {
				shoppingorder = new Shoppingorder(shoppingorderFormData);
			}

			Ebean.save(shoppingorder);

			flash("success", "Shoppingorder instance created/edited: " + shoppingorder);

			return all();
		}
	}

	public static Result delete(Form<ShoppingorderFormData> formData) {
		ShoppingorderFormData shoppingorderFormData = formData.get();

		String id = shoppingorderFormData.orderId;

		long shoppingorderId = 0;

		if (id != null) {
			shoppingorderId = Long.valueOf(id);
		}

		Shoppingorder shoppingorder;

		if (shoppingorderId > 0) {
			shoppingorder = Shoppingorder.find.byId(shoppingorderId);

			Ebean.delete(shoppingorder);
		}
		else {
			flash("error", "Cannot delete Shoppingorder");
		}

		return all();
	}

}
