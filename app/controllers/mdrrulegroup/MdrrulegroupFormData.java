package controllers.mdrrulegroup;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mdrrulegroup data form.
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
public class MdrrulegroupFormData {

	public String uuid;
	public String ruleGroupId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String description;

	public MdrrulegroupFormData() {
	}

	public MdrrulegroupFormData(
		String uuid,
				String ruleGroupId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String description
		) {

		this.uuid = uuid;
		this.ruleGroupId = ruleGroupId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.description = description;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (ruleGroupId == null || ruleGroupId.length() == 0) {
			errors.add(new ValidationError("ruleGroupId", "No ruleGroupId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
