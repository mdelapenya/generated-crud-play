package controllers.shoppingitemprice;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingitemprice data form.
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
public class ShoppingitempriceFormData {

	public String itemPriceId;
	public String itemId;
	public String minQuantity;
	public String maxQuantity;
	public String price;
	public String discount;
	public String taxable;
	public String shipping;
	public String useShippingFormula;
	public String status;

	public ShoppingitempriceFormData() {
	}

	public ShoppingitempriceFormData(
		String itemPriceId,
				String itemId,
				String minQuantity,
				String maxQuantity,
				String price,
				String discount,
				String taxable,
				String shipping,
				String useShippingFormula,
				String status
		) {

		this.itemPriceId = itemPriceId;
		this.itemId = itemId;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.price = price;
		this.discount = discount;
		this.taxable = taxable;
		this.shipping = shipping;
		this.useShippingFormula = useShippingFormula;
		this.status = status;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (itemPriceId == null || itemPriceId.length() == 0) {
			errors.add(new ValidationError("itemPriceId", "No itemPriceId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
