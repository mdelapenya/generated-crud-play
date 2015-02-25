package controllers.bar;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Bar data form.
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
public class BarFormData {

	public String id;
	public String campo2;

	public BarFormData() {
	}

	public BarFormData(
		String id,
				String campo2
		) {

		this.id = id;
		this.campo2 = campo2;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (id == null || id.length() == 0) {
			errors.add(new ValidationError("id", "No id was given."));
		}
		if (campo2 == null || campo2.length() == 0) {
			errors.add(new ValidationError("campo2", "No campo2 was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
