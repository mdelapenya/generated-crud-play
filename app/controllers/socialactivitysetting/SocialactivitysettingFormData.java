package controllers.socialactivitysetting;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivitysetting data form.
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
public class SocialactivitysettingFormData {

	public String activitySettingId;
	public String groupId;
	public String companyId;
	public String classNameId;
	public String activityType;
	public String name;
	public String value;

	public SocialactivitysettingFormData() {
	}

	public SocialactivitysettingFormData(
		String activitySettingId,
				String groupId,
				String companyId,
				String classNameId,
				String activityType,
				String name,
				String value
		) {

		this.activitySettingId = activitySettingId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.classNameId = classNameId;
		this.activityType = activityType;
		this.name = name;
		this.value = value;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activitySettingId == null || activitySettingId.length() == 0) {
			errors.add(new ValidationError("activitySettingId", "No activitySettingId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
