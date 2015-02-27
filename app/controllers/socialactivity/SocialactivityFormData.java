package controllers.socialactivity;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivity data form.
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
public class SocialactivityFormData {

	public String activityId;
	public String groupId;
	public String companyId;
	public String userId;
	public String createDate;
	public String activitySetId;
	public String mirrorActivityId;
	public String classNameId;
	public String classPK;
	public String parentClassNameId;
	public String parentClassPK;
	public String customtype;
	public String extraData;
	public String receiverUserId;

	public SocialactivityFormData() {
	}

	public SocialactivityFormData(
		String activityId,
				String groupId,
				String companyId,
				String userId,
				String createDate,
				String activitySetId,
				String mirrorActivityId,
				String classNameId,
				String classPK,
				String parentClassNameId,
				String parentClassPK,
				String customtype,
				String extraData,
				String receiverUserId
		) {

		this.activityId = activityId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.createDate = createDate;
		this.activitySetId = activitySetId;
		this.mirrorActivityId = mirrorActivityId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.parentClassNameId = parentClassNameId;
		this.parentClassPK = parentClassPK;
		this.customtype = customtype;
		this.extraData = extraData;
		this.receiverUserId = receiverUserId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activityId == null || activityId.length() == 0) {
			errors.add(new ValidationError("activityId", "No activityId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
