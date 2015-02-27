package controllers.role;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Role data form.
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
public class RoleFormData {

	public String mvccVersion;
	public String uuid;
	public String roleId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String name;
	public String title;
	public String description;
	public String customtype;
	public String subtype;

	public RoleFormData() {
	}

	public RoleFormData(
		String mvccVersion,
				String uuid,
				String roleId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String name,
				String title,
				String description,
				String customtype,
				String subtype
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.roleId = roleId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.name = name;
		this.title = title;
		this.description = description;
		this.customtype = customtype;
		this.subtype = subtype;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (roleId == null || roleId.length() == 0) {
			errors.add(new ValidationError("roleId", "No roleId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
