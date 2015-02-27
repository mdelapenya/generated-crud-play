package controllers.usergroup;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Usergroup data form.
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
public class UsergroupFormData {

	public String mvccVersion;
	public String uuid;
	public String userGroupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentUserGroupId;
	public String name;
	public String description;
	public String addedByLDAPImport;

	public UsergroupFormData() {
	}

	public UsergroupFormData(
		String mvccVersion,
				String uuid,
				String userGroupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentUserGroupId,
				String name,
				String description,
				String addedByLDAPImport
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.userGroupId = userGroupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentUserGroupId = parentUserGroupId;
		this.name = name;
		this.description = description;
		this.addedByLDAPImport = addedByLDAPImport;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userGroupId == null || userGroupId.length() == 0) {
			errors.add(new ValidationError("userGroupId", "No userGroupId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
