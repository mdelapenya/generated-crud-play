package controllers.socialactivityachievement;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivityachievement data form.
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
public class SocialactivityachievementFormData {

	public String activityAchievementId;
	public String groupId;
	public String companyId;
	public String userId;
	public String createDate;
	public String name;
	public String firstInGroup;

	public SocialactivityachievementFormData() {
	}

	public SocialactivityachievementFormData(
		String activityAchievementId,
				String groupId,
				String companyId,
				String userId,
				String createDate,
				String name,
				String firstInGroup
		) {

		this.activityAchievementId = activityAchievementId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.createDate = createDate;
		this.name = name;
		this.firstInGroup = firstInGroup;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activityAchievementId == null || activityAchievementId.length() == 0) {
			errors.add(new ValidationError("activityAchievementId", "No activityAchievementId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
