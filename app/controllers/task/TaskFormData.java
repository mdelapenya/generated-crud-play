package controllers.task;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Task data form.
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
public class TaskFormData {

	public String id;
	public String name;
	public String street;
	public String done;
	public String dueDate;

	public TaskFormData() {
	}

	public TaskFormData(
		String id, String name, String street, String done, String dueDate) {

		this.id = id;
		this.name = name;
		this.street = street;
		this.done = done;
		this.dueDate = dueDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (name == null || name.length() == 0) {
			errors.add(new ValidationError("name", "No name was given."));
		}

		if (street == null || street.length() == 0) {
			errors.add(new ValidationError("street", "No street was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}