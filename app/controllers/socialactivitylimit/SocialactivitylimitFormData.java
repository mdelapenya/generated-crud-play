package controllers.socialactivitylimit;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivitylimit data form.
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
public class SocialactivitylimitFormData {

	public String activityLimitId;
	public String groupId;
	public String companyId;
	public String userId;
	public String classNameId;
	public String classPK;
	public String activityType;
	public String activityCounterName;
	public String value;

	public SocialactivitylimitFormData() {
	}

	public SocialactivitylimitFormData(
		String activityLimitId,
				String groupId,
				String companyId,
				String userId,
				String classNameId,
				String classPK,
				String activityType,
				String activityCounterName,
				String value
		) {

		this.activityLimitId = activityLimitId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.activityType = activityType;
		this.activityCounterName = activityCounterName;
		this.value = value;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activityLimitId == null || activityLimitId.length() == 0) {
			errors.add(new ValidationError("activityLimitId", "No activityLimitId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
