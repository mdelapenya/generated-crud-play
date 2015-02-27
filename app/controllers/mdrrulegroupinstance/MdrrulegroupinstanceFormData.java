package controllers.mdrrulegroupinstance;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mdrrulegroupinstance data form.
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
public class MdrrulegroupinstanceFormData {

	public String uuid;
	public String ruleGroupInstanceId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String ruleGroupId;
	public String priority;

	public MdrrulegroupinstanceFormData() {
	}

	public MdrrulegroupinstanceFormData(
		String uuid,
				String ruleGroupInstanceId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String ruleGroupId,
				String priority
		) {

		this.uuid = uuid;
		this.ruleGroupInstanceId = ruleGroupInstanceId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.ruleGroupId = ruleGroupId;
		this.priority = priority;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (ruleGroupInstanceId == null || ruleGroupInstanceId.length() == 0) {
			errors.add(new ValidationError("ruleGroupInstanceId", "No ruleGroupInstanceId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
