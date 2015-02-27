package controllers.mdrrule;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mdrrule data form.
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
public class MdrruleFormData {

	public String uuid;
	public String ruleId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String ruleGroupId;
	public String name;
	public String description;
	public String customtype;
	public String typeSettings;

	public MdrruleFormData() {
	}

	public MdrruleFormData(
		String uuid,
				String ruleId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String ruleGroupId,
				String name,
				String description,
				String customtype,
				String typeSettings
		) {

		this.uuid = uuid;
		this.ruleId = ruleId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.ruleGroupId = ruleGroupId;
		this.name = name;
		this.description = description;
		this.customtype = customtype;
		this.typeSettings = typeSettings;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (ruleId == null || ruleId.length() == 0) {
			errors.add(new ValidationError("ruleId", "No ruleId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
