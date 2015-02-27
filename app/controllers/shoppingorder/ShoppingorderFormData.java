package controllers.shoppingorder;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingorder data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class ShoppingorderFormData {

	public String orderId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String number;
	public String tax;
	public String shipping;
	public String altShipping;
	public String requiresShipping;
	public String insure;
	public String insurance;
	public String couponCodes;
	public String couponDiscount;
	public String billingFirstName;
	public String billingLastName;
	public String billingEmailAddress;
	public String billingCompany;
	public String billingStreet;
	public String billingCity;
	public String billingState;
	public String billingZip;
	public String billingCountry;
	public String billingPhone;
	public String shipToBilling;
	public String shippingFirstName;
	public String shippingLastName;
	public String shippingEmailAddress;
	public String shippingCompany;
	public String shippingStreet;
	public String shippingCity;
	public String shippingState;
	public String shippingZip;
	public String shippingCountry;
	public String shippingPhone;
	public String ccName;
	public String ccType;
	public String ccNumber;
	public String ccExpMonth;
	public String ccExpYear;
	public String ccVerNumber;
	public String comments;
	public String ppTxnId;
	public String ppPaymentStatus;
	public String ppPaymentGross;
	public String ppReceiverEmail;
	public String ppPayerEmail;
	public String sendOrderEmail;
	public String sendShippingEmail;

	public ShoppingorderFormData() {
	}

	public ShoppingorderFormData(
		String orderId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String number,
				String tax,
				String shipping,
				String altShipping,
				String requiresShipping,
				String insure,
				String insurance,
				String couponCodes,
				String couponDiscount,
				String billingFirstName,
				String billingLastName,
				String billingEmailAddress,
				String billingCompany,
				String billingStreet,
				String billingCity,
				String billingState,
				String billingZip,
				String billingCountry,
				String billingPhone,
				String shipToBilling,
				String shippingFirstName,
				String shippingLastName,
				String shippingEmailAddress,
				String shippingCompany,
				String shippingStreet,
				String shippingCity,
				String shippingState,
				String shippingZip,
				String shippingCountry,
				String shippingPhone,
				String ccName,
				String ccType,
				String ccNumber,
				String ccExpMonth,
				String ccExpYear,
				String ccVerNumber,
				String comments,
				String ppTxnId,
				String ppPaymentStatus,
				String ppPaymentGross,
				String ppReceiverEmail,
				String ppPayerEmail,
				String sendOrderEmail,
				String sendShippingEmail
		) {

		this.orderId = orderId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.number = number;
		this.tax = tax;
		this.shipping = shipping;
		this.altShipping = altShipping;
		this.requiresShipping = requiresShipping;
		this.insure = insure;
		this.insurance = insurance;
		this.couponCodes = couponCodes;
		this.couponDiscount = couponDiscount;
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
		this.billingEmailAddress = billingEmailAddress;
		this.billingCompany = billingCompany;
		this.billingStreet = billingStreet;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
		this.billingPhone = billingPhone;
		this.shipToBilling = shipToBilling;
		this.shippingFirstName = shippingFirstName;
		this.shippingLastName = shippingLastName;
		this.shippingEmailAddress = shippingEmailAddress;
		this.shippingCompany = shippingCompany;
		this.shippingStreet = shippingStreet;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZip = shippingZip;
		this.shippingCountry = shippingCountry;
		this.shippingPhone = shippingPhone;
		this.ccName = ccName;
		this.ccType = ccType;
		this.ccNumber = ccNumber;
		this.ccExpMonth = ccExpMonth;
		this.ccExpYear = ccExpYear;
		this.ccVerNumber = ccVerNumber;
		this.comments = comments;
		this.ppTxnId = ppTxnId;
		this.ppPaymentStatus = ppPaymentStatus;
		this.ppPaymentGross = ppPaymentGross;
		this.ppReceiverEmail = ppReceiverEmail;
		this.ppPayerEmail = ppPayerEmail;
		this.sendOrderEmail = sendOrderEmail;
		this.sendShippingEmail = sendShippingEmail;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (orderId == null || orderId.length() == 0) {
			errors.add(new ValidationError("orderId", "No orderId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
