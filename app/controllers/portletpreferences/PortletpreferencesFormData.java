package controllers.portletpreferences;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Portletpreferences data form.
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
public class PortletpreferencesFormData {

	public String mvccVersion;
	public String portletPreferencesId;
	public String ownerId;
	public String ownerType;
	public String plid;
	public String portletId;
	public String preferences;

	public PortletpreferencesFormData() {
	}

	public PortletpreferencesFormData(
		String mvccVersion,
				String portletPreferencesId,
				String ownerId,
				String ownerType,
				String plid,
				String portletId,
				String preferences
		) {

		this.mvccVersion = mvccVersion;
		this.portletPreferencesId = portletPreferencesId;
		this.ownerId = ownerId;
		this.ownerType = ownerType;
		this.plid = plid;
		this.portletId = portletId;
		this.preferences = preferences;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (portletPreferencesId == null || portletPreferencesId.length() == 0) {
			errors.add(new ValidationError("portletPreferencesId", "No portletPreferencesId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
