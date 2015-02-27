package controllers.servicecomponent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Servicecomponent data form.
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
public class ServicecomponentFormData {

	public String mvccVersion;
	public String serviceComponentId;
	public String buildNamespace;
	public String buildNumber;
	public String buildDate;
	public String data;

	public ServicecomponentFormData() {
	}

	public ServicecomponentFormData(
		String mvccVersion,
				String serviceComponentId,
				String buildNamespace,
				String buildNumber,
				String buildDate,
				String data
		) {

		this.mvccVersion = mvccVersion;
		this.serviceComponentId = serviceComponentId;
		this.buildNamespace = buildNamespace;
		this.buildNumber = buildNumber;
		this.buildDate = buildDate;
		this.data = data;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (serviceComponentId == null || serviceComponentId.length() == 0) {
			errors.add(new ValidationError("serviceComponentId", "No serviceComponentId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
