
package models.shoppingcoupon;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingcoupon.ShoppingcouponFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingcoupon extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long couponId;

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
	public String code;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date endDate;

	public boolean active;

	public String limitCategories;

	public String limitSkus;

	public double minOrder;

	public double discount;

	@Constraints.MaxLength(75)
	public String discountType;


	// model finder attribute

	public static Finder<Long,Shoppingcoupon> find = new Finder<Long,Shoppingcoupon>(
		Long.class, Shoppingcoupon.class
	);

	// getters and setters

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
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
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLimitCategories() {
		return limitCategories;
	}

	public void setLimitCategories(String limitCategories) {
		this.limitCategories = limitCategories;
	}
	public String getLimitSkus() {
		return limitSkus;
	}

	public void setLimitSkus(String limitSkus) {
		this.limitSkus = limitSkus;
	}
	public double getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(double minOrder) {
		this.minOrder = minOrder;
	}
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Shoppingcoupon(){
	}

	// constructor using a formData

	public Shoppingcoupon(ShoppingcouponFormData formData) {
		couponId = Long.valueOf(formData.couponId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		code = formData.code;
		name = formData.name;
		description = formData.description;
		startDate = new Date(formData.startDate);
		endDate = new Date(formData.endDate);
		active = Boolean.valueOf(formData.active);
		limitCategories = formData.limitCategories;
		limitSkus = formData.limitSkus;
		minOrder = Double.valueOf(formData.minOrder);
		discount = Double.valueOf(formData.discount);
		discountType = formData.discountType;
	}

	public ShoppingcouponFormData toFormData() {
		if (couponId < 0) {
			couponId = 0L;
		}

		ShoppingcouponFormData formData = new ShoppingcouponFormData(
			String.valueOf(couponId)
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
			code
			,
			name
			,
			description
			,
			String.valueOf(startDate)
			,
			String.valueOf(endDate)
			,
			String.valueOf(active)
			,
			limitCategories
			,
			limitSkus
			,
			String.valueOf(minOrder)
			,
			String.valueOf(discount)
			,
			discountType
			
		);

		return formData;
	}

}
