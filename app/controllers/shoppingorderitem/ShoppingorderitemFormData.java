package controllers.shoppingorderitem;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingorderitem data form.
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
public class ShoppingorderitemFormData {

	public String orderItemId;
	public String orderId;
	public String itemId;
	public String sku;
	public String name;
	public String description;
	public String properties;
	public String price;
	public String quantity;
	public String shippedDate;

	public ShoppingorderitemFormData() {
	}

	public ShoppingorderitemFormData(
		String orderItemId,
				String orderId,
				String itemId,
				String sku,
				String name,
				String description,
				String properties,
				String price,
				String quantity,
				String shippedDate
		) {

		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.properties = properties;
		this.price = price;
		this.quantity = quantity;
		this.shippedDate = shippedDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (orderItemId == null || orderItemId.length() == 0) {
			errors.add(new ValidationError("orderItemId", "No orderItemId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
