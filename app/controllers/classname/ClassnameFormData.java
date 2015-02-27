package controllers.classname;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Classname data form.
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
public class ClassnameFormData {

	public String mvccVersion;
	public String classNameId;
	public String value;

	public ClassnameFormData() {
	}

	public ClassnameFormData(
		String mvccVersion,
				String classNameId,
				String value
		) {

		this.mvccVersion = mvccVersion;
		this.classNameId = classNameId;
		this.value = value;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (classNameId == null || classNameId.length() == 0) {
			errors.add(new ValidationError("classNameId", "No classNameId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
