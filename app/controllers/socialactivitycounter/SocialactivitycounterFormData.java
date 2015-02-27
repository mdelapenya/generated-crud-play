package controllers.socialactivitycounter;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialactivitycounter data form.
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
public class SocialactivitycounterFormData {

	public String activityCounterId;
	public String groupId;
	public String companyId;
	public String classNameId;
	public String classPK;
	public String name;
	public String ownerType;
	public String currentValue;
	public String totalValue;
	public String graceValue;
	public String startPeriod;
	public String endPeriod;
	public String active;

	public SocialactivitycounterFormData() {
	}

	public SocialactivitycounterFormData(
		String activityCounterId,
				String groupId,
				String companyId,
				String classNameId,
				String classPK,
				String name,
				String ownerType,
				String currentValue,
				String totalValue,
				String graceValue,
				String startPeriod,
				String endPeriod,
				String active
		) {

		this.activityCounterId = activityCounterId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.name = name;
		this.ownerType = ownerType;
		this.currentValue = currentValue;
		this.totalValue = totalValue;
		this.graceValue = graceValue;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (activityCounterId == null || activityCounterId.length() == 0) {
			errors.add(new ValidationError("activityCounterId", "No activityCounterId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
