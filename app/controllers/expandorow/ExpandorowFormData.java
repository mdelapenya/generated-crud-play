package controllers.expandorow;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Expandorow data form.
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
public class ExpandorowFormData {

	public String rowId;
	public String companyId;
	public String modifiedDate;
	public String tableId;
	public String classPK;

	public ExpandorowFormData() {
	}

	public ExpandorowFormData(
		String rowId,
				String companyId,
				String modifiedDate,
				String tableId,
				String classPK
		) {

		this.rowId = rowId;
		this.companyId = companyId;
		this.modifiedDate = modifiedDate;
		this.tableId = tableId;
		this.classPK = classPK;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (rowId == null || rowId.length() == 0) {
			errors.add(new ValidationError("rowId", "No rowId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
