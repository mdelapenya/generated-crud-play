package controllers.shoppingcoupon;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingcoupon data form.
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
public class ShoppingcouponFormData {

	public String couponId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String code;
	public String name;
	public String description;
	public String startDate;
	public String endDate;
	public String active;
	public String limitCategories;
	public String limitSkus;
	public String minOrder;
	public String discount;
	public String discountType;

	public ShoppingcouponFormData() {
	}

	public ShoppingcouponFormData(
		String couponId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String code,
				String name,
				String description,
				String startDate,
				String endDate,
				String active,
				String limitCategories,
				String limitSkus,
				String minOrder,
				String discount,
				String discountType
		) {

		this.couponId = couponId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.code = code;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
		this.limitCategories = limitCategories;
		this.limitSkus = limitSkus;
		this.minOrder = minOrder;
		this.discount = discount;
		this.discountType = discountType;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (couponId == null || couponId.length() == 0) {
			errors.add(new ValidationError("couponId", "No couponId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
