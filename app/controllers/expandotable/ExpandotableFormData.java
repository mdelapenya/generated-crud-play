package controllers.expandotable;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Expandotable data form.
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
public class ExpandotableFormData {

	public String tableId;
	public String companyId;
	public String classNameId;
	public String name;

	public ExpandotableFormData() {
	}

	public ExpandotableFormData(
		String tableId,
				String companyId,
				String classNameId,
				String name
		) {

		this.tableId = tableId;
		this.companyId = companyId;
		this.classNameId = classNameId;
		this.name = name;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (tableId == null || tableId.length() == 0) {
			errors.add(new ValidationError("tableId", "No tableId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
