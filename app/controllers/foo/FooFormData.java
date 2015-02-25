package controllers.foo;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Foo data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 */
public class FooFormData {

	public String f1;
	public String f2;

	public FooFormData() {
	}

	public FooFormData(
		String f1,
				String f2
		) {

		this.f1 = f1;
		this.f2 = f2;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (f1 == null || f1.length() == 0) {
			errors.add(new ValidationError("f1", "No f1 was given."));
		}
		if (f2 == null || f2.length() == 0) {
			errors.add(new ValidationError("f2", "No f2 was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
