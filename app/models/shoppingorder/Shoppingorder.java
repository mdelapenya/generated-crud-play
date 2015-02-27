
package models.shoppingorder;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingorder.ShoppingorderFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingorder extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long orderId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String number;

	public double tax;

	public double shipping;

	@Constraints.MaxLength(75)
	public String altShipping;

	public boolean requiresShipping;

	public boolean insure;

	public double insurance;

	@Constraints.MaxLength(75)
	public String couponCodes;

	public double couponDiscount;

	@Constraints.MaxLength(75)
	public String billingFirstName;

	@Constraints.MaxLength(75)
	public String billingLastName;

	@Constraints.MaxLength(75)
	public String billingEmailAddress;

	@Constraints.MaxLength(75)
	public String billingCompany;

	@Constraints.MaxLength(75)
	public String billingStreet;

	@Constraints.MaxLength(75)
	public String billingCity;

	@Constraints.MaxLength(75)
	public String billingState;

	@Constraints.MaxLength(75)
	public String billingZip;

	@Constraints.MaxLength(75)
	public String billingCountry;

	@Constraints.MaxLength(75)
	public String billingPhone;

	public boolean shipToBilling;

	@Constraints.MaxLength(75)
	public String shippingFirstName;

	@Constraints.MaxLength(75)
	public String shippingLastName;

	@Constraints.MaxLength(75)
	public String shippingEmailAddress;

	@Constraints.MaxLength(75)
	public String shippingCompany;

	@Constraints.MaxLength(75)
	public String shippingStreet;

	@Constraints.MaxLength(75)
	public String shippingCity;

	@Constraints.MaxLength(75)
	public String shippingState;

	@Constraints.MaxLength(75)
	public String shippingZip;

	@Constraints.MaxLength(75)
	public String shippingCountry;

	@Constraints.MaxLength(75)
	public String shippingPhone;

	@Constraints.MaxLength(75)
	public String ccName;

	@Constraints.MaxLength(75)
	public String ccType;

	@Constraints.MaxLength(75)
	public String ccNumber;

	public int ccExpMonth;

	public int ccExpYear;

	@Constraints.MaxLength(75)
	public String ccVerNumber;

	public String comments;

	@Constraints.MaxLength(75)
	public String ppTxnId;

	@Constraints.MaxLength(75)
	public String ppPaymentStatus;

	public double ppPaymentGross;

	@Constraints.MaxLength(75)
	public String ppReceiverEmail;

	@Constraints.MaxLength(75)
	public String ppPayerEmail;

	public boolean sendOrderEmail;

	public boolean sendShippingEmail;


	// model finder attribute

	public static Finder<Long,Shoppingorder> find = new Finder<Long,Shoppingorder>(
		Long.class, Shoppingorder.class
	);

	// getters and setters

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public String getAltShipping() {
		return altShipping;
	}

	public void setAltShipping(String altShipping) {
		this.altShipping = altShipping;
	}
	public boolean getRequiresShipping() {
		return requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
	}
	public boolean getInsure() {
		return insure;
	}

	public void setInsure(boolean insure) {
		this.insure = insure;
	}
	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public String getCouponCodes() {
		return couponCodes;
	}

	public void setCouponCodes(String couponCodes) {
		this.couponCodes = couponCodes;
	}
	public double getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	public String getBillingFirstName() {
		return billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}
	public String getBillingLastName() {
		return billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
	}
	public String getBillingEmailAddress() {
		return billingEmailAddress;
	}

	public void setBillingEmailAddress(String billingEmailAddress) {
		this.billingEmailAddress = billingEmailAddress;
	}
	public String getBillingCompany() {
		return billingCompany;
	}

	public void setBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
	}
	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}
	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}
	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingPhone() {
		return billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}
	public boolean getShipToBilling() {
		return shipToBilling;
	}

	public void setShipToBilling(boolean shipToBilling) {
		this.shipToBilling = shipToBilling;
	}
	public String getShippingFirstName() {
		return shippingFirstName;
	}

	public void setShippingFirstName(String shippingFirstName) {
		this.shippingFirstName = shippingFirstName;
	}
	public String getShippingLastName() {
		return shippingLastName;
	}

	public void setShippingLastName(String shippingLastName) {
		this.shippingLastName = shippingLastName;
	}
	public String getShippingEmailAddress() {
		return shippingEmailAddress;
	}

	public void setShippingEmailAddress(String shippingEmailAddress) {
		this.shippingEmailAddress = shippingEmailAddress;
	}
	public String getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public String getShippingStreet() {
		return shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		this.shippingStreet = shippingStreet;
	}
	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingZip() {
		return shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}
	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public int getCcExpMonth() {
		return ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		this.ccExpMonth = ccExpMonth;
	}
	public int getCcExpYear() {
		return ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		this.ccExpYear = ccExpYear;
	}
	public String getCcVerNumber() {
		return ccVerNumber;
	}

	public void setCcVerNumber(String ccVerNumber) {
		this.ccVerNumber = ccVerNumber;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPpTxnId() {
		return ppTxnId;
	}

	public void setPpTxnId(String ppTxnId) {
		this.ppTxnId = ppTxnId;
	}
	public String getPpPaymentStatus() {
		return ppPaymentStatus;
	}

	public void setPpPaymentStatus(String ppPaymentStatus) {
		this.ppPaymentStatus = ppPaymentStatus;
	}
	public double getPpPaymentGross() {
		return ppPaymentGross;
	}

	public void setPpPaymentGross(double ppPaymentGross) {
		this.ppPaymentGross = ppPaymentGross;
	}
	public String getPpReceiverEmail() {
		return ppReceiverEmail;
	}

	public void setPpReceiverEmail(String ppReceiverEmail) {
		this.ppReceiverEmail = ppReceiverEmail;
	}
	public String getPpPayerEmail() {
		return ppPayerEmail;
	}

	public void setPpPayerEmail(String ppPayerEmail) {
		this.ppPayerEmail = ppPayerEmail;
	}
	public boolean getSendOrderEmail() {
		return sendOrderEmail;
	}

	public void setSendOrderEmail(boolean sendOrderEmail) {
		this.sendOrderEmail = sendOrderEmail;
	}
	public boolean getSendShippingEmail() {
		return sendShippingEmail;
	}

	public void setSendShippingEmail(boolean sendShippingEmail) {
		this.sendShippingEmail = sendShippingEmail;
	}

	public Shoppingorder(){
	}

	// constructor using a formData

	public Shoppingorder(ShoppingorderFormData formData) {
		orderId = Long.valueOf(formData.orderId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		number = formData.number;
		tax = Double.valueOf(formData.tax);
		shipping = Double.valueOf(formData.shipping);
		altShipping = formData.altShipping;
		requiresShipping = Boolean.valueOf(formData.requiresShipping);
		insure = Boolean.valueOf(formData.insure);
		insurance = Double.valueOf(formData.insurance);
		couponCodes = formData.couponCodes;
		couponDiscount = Double.valueOf(formData.couponDiscount);
		billingFirstName = formData.billingFirstName;
		billingLastName = formData.billingLastName;
		billingEmailAddress = formData.billingEmailAddress;
		billingCompany = formData.billingCompany;
		billingStreet = formData.billingStreet;
		billingCity = formData.billingCity;
		billingState = formData.billingState;
		billingZip = formData.billingZip;
		billingCountry = formData.billingCountry;
		billingPhone = formData.billingPhone;
		shipToBilling = Boolean.valueOf(formData.shipToBilling);
		shippingFirstName = formData.shippingFirstName;
		shippingLastName = formData.shippingLastName;
		shippingEmailAddress = formData.shippingEmailAddress;
		shippingCompany = formData.shippingCompany;
		shippingStreet = formData.shippingStreet;
		shippingCity = formData.shippingCity;
		shippingState = formData.shippingState;
		shippingZip = formData.shippingZip;
		shippingCountry = formData.shippingCountry;
		shippingPhone = formData.shippingPhone;
		ccName = formData.ccName;
		ccType = formData.ccType;
		ccNumber = formData.ccNumber;
		ccExpMonth = Integer.valueOf(formData.ccExpMonth);
		ccExpYear = Integer.valueOf(formData.ccExpYear);
		ccVerNumber = formData.ccVerNumber;
		comments = formData.comments;
		ppTxnId = formData.ppTxnId;
		ppPaymentStatus = formData.ppPaymentStatus;
		ppPaymentGross = Double.valueOf(formData.ppPaymentGross);
		ppReceiverEmail = formData.ppReceiverEmail;
		ppPayerEmail = formData.ppPayerEmail;
		sendOrderEmail = Boolean.valueOf(formData.sendOrderEmail);
		sendShippingEmail = Boolean.valueOf(formData.sendShippingEmail);
	}

	public ShoppingorderFormData toFormData() {
		if (orderId < 0) {
			orderId = 0L;
		}

		ShoppingorderFormData formData = new ShoppingorderFormData(
			String.valueOf(orderId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			number
			,
			String.valueOf(tax)
			,
			String.valueOf(shipping)
			,
			altShipping
			,
			String.valueOf(requiresShipping)
			,
			String.valueOf(insure)
			,
			String.valueOf(insurance)
			,
			couponCodes
			,
			String.valueOf(couponDiscount)
			,
			billingFirstName
			,
			billingLastName
			,
			billingEmailAddress
			,
			billingCompany
			,
			billingStreet
			,
			billingCity
			,
			billingState
			,
			billingZip
			,
			billingCountry
			,
			billingPhone
			,
			String.valueOf(shipToBilling)
			,
			shippingFirstName
			,
			shippingLastName
			,
			shippingEmailAddress
			,
			shippingCompany
			,
			shippingStreet
			,
			shippingCity
			,
			shippingState
			,
			shippingZip
			,
			shippingCountry
			,
			shippingPhone
			,
			ccName
			,
			ccType
			,
			ccNumber
			,
			String.valueOf(ccExpMonth)
			,
			String.valueOf(ccExpYear)
			,
			ccVerNumber
			,
			comments
			,
			ppTxnId
			,
			ppPaymentStatus
			,
			String.valueOf(ppPaymentGross)
			,
			ppReceiverEmail
			,
			ppPayerEmail
			,
			String.valueOf(sendOrderEmail)
			,
			String.valueOf(sendShippingEmail)
			
		);

		return formData;
	}

}
