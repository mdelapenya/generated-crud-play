package controllers.portalpreferences;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Portalpreferences data form.
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
public class PortalpreferencesFormData {

	public String mvccVersion;
	public String portalPreferencesId;
	public String ownerId;
	public String ownerType;
	public String preferences;

	public PortalpreferencesFormData() {
	}

	public PortalpreferencesFormData(
		String mvccVersion,
				String portalPreferencesId,
				String ownerId,
				String ownerType,
				String preferences
		) {

		this.mvccVersion = mvccVersion;
		this.portalPreferencesId = portalPreferencesId;
		this.ownerId = ownerId;
		this.ownerType = ownerType;
		this.preferences = preferences;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (portalPreferencesId == null || portalPreferencesId.length() == 0) {
			errors.add(new ValidationError("portalPreferencesId", "No portalPreferencesId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
