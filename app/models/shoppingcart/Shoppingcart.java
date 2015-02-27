
package models.shoppingcart;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingcart.ShoppingcartFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingcart extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long cartId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public String itemIds;

	@Constraints.MaxLength(75)
	public String couponCodes;

	public int altShipping;

	public boolean insure;


	// model finder attribute

	public static Finder<Long,Shoppingcart> find = new Finder<Long,Shoppingcart>(
		Long.class, Shoppingcart.class
	);

	// getters and setters

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
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
	public String getItemIds() {
		return itemIds;
	}

	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}
	public String getCouponCodes() {
		return couponCodes;
	}

	public void setCouponCodes(String couponCodes) {
		this.couponCodes = couponCodes;
	}
	public int getAltShipping() {
		return altShipping;
	}

	public void setAltShipping(int altShipping) {
		this.altShipping = altShipping;
	}
	public boolean getInsure() {
		return insure;
	}

	public void setInsure(boolean insure) {
		this.insure = insure;
	}

	public Shoppingcart(){
	}

	// constructor using a formData

	public Shoppingcart(ShoppingcartFormData formData) {
		cartId = Long.valueOf(formData.cartId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		itemIds = formData.itemIds;
		couponCodes = formData.couponCodes;
		altShipping = Integer.valueOf(formData.altShipping);
		insure = Boolean.valueOf(formData.insure);
	}

	public ShoppingcartFormData toFormData() {
		if (cartId < 0) {
			cartId = 0L;
		}

		ShoppingcartFormData formData = new ShoppingcartFormData(
			String.valueOf(cartId)
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
			itemIds
			,
			couponCodes
			,
			String.valueOf(altShipping)
			,
			String.valueOf(insure)
			
		);

		return formData;
	}

}
