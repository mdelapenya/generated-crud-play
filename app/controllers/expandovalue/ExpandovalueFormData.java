package controllers.expandovalue;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Expandovalue data form.
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
public class ExpandovalueFormData {

	public String valueId;
	public String companyId;
	public String tableId;
	public String columnId;
	public String rowId;
	public String classNameId;
	public String classPK;
	public String data;

	public ExpandovalueFormData() {
	}

	public ExpandovalueFormData(
		String valueId,
				String companyId,
				String tableId,
				String columnId,
				String rowId,
				String classNameId,
				String classPK,
				String data
		) {

		this.valueId = valueId;
		this.companyId = companyId;
		this.tableId = tableId;
		this.columnId = columnId;
		this.rowId = rowId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.data = data;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (valueId == null || valueId.length() == 0) {
			errors.add(new ValidationError("valueId", "No valueId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
