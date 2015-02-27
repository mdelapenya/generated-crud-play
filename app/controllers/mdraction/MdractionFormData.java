package controllers.mdraction;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mdraction data form.
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
public class MdractionFormData {

	public String uuid;
	public String actionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String ruleGroupInstanceId;
	public String name;
	public String description;
	public String customtype;
	public String typeSettings;

	public MdractionFormData() {
	}

	public MdractionFormData(
		String uuid,
				String actionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String ruleGroupInstanceId,
				String name,
				String description,
				String customtype,
				String typeSettings
		) {

		this.uuid = uuid;
		this.actionId = actionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.ruleGroupInstanceId = ruleGroupInstanceId;
		this.name = name;
		this.description = description;
		this.customtype = customtype;
		this.typeSettings = typeSettings;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (actionId == null || actionId.length() == 0) {
			errors.add(new ValidationError("actionId", "No actionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
