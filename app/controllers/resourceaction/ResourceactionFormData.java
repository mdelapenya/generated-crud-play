package controllers.resourceaction;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Resourceaction data form.
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
public class ResourceactionFormData {

	public String mvccVersion;
	public String resourceActionId;
	public String name;
	public String actionId;
	public String bitwiseValue;

	public ResourceactionFormData() {
	}

	public ResourceactionFormData(
		String mvccVersion,
				String resourceActionId,
				String name,
				String actionId,
				String bitwiseValue
		) {

		this.mvccVersion = mvccVersion;
		this.resourceActionId = resourceActionId;
		this.name = name;
		this.actionId = actionId;
		this.bitwiseValue = bitwiseValue;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourceActionId == null || resourceActionId.length() == 0) {
			errors.add(new ValidationError("resourceActionId", "No resourceActionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
