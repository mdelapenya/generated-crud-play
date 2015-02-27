package controllers.shoppingitemfield;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingitemfield data form.
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
public class ShoppingitemfieldFormData {

	public String itemFieldId;
	public String itemId;
	public String name;
	public String values;
	public String description;

	public ShoppingitemfieldFormData() {
	}

	public ShoppingitemfieldFormData(
		String itemFieldId,
				String itemId,
				String name,
				String values,
				String description
		) {

		this.itemFieldId = itemFieldId;
		this.itemId = itemId;
		this.name = name;
		this.values = values;
		this.description = description;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (itemFieldId == null || itemFieldId.length() == 0) {
			errors.add(new ValidationError("itemFieldId", "No itemFieldId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
