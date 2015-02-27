package controllers.socialactivityset;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivityset data form.
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
public class SocialactivitysetFormData {

	public String activitySetId;
	public String groupId;
	public String companyId;
	public String userId;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String customtype;
	public String extraData;
	public String activityCount;

	public SocialactivitysetFormData() {
	}

	public SocialactivitysetFormData(
		String activitySetId,
				String groupId,
				String companyId,
				String userId,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String customtype,
				String extraData,
				String activityCount
		) {

		this.activitySetId = activitySetId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.customtype = customtype;
		this.extraData = extraData;
		this.activityCount = activityCount;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activitySetId == null || activitySetId.length() == 0) {
			errors.add(new ValidationError("activitySetId", "No activitySetId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
