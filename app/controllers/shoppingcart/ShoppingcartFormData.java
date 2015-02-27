package controllers.shoppingcart;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingcart data form.
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
public class ShoppingcartFormData {

	public String cartId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String itemIds;
	public String couponCodes;
	public String altShipping;
	public String insure;

	public ShoppingcartFormData() {
	}

	public ShoppingcartFormData(
		String cartId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String itemIds,
				String couponCodes,
				String altShipping,
				String insure
		) {

		this.cartId = cartId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.itemIds = itemIds;
		this.couponCodes = couponCodes;
		this.altShipping = altShipping;
		this.insure = insure;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (cartId == null || cartId.length() == 0) {
			errors.add(new ValidationError("cartId", "No cartId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
