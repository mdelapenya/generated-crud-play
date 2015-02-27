package controllers.resourcetypepermission;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Resourcetypepermission data form.
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
public class ResourcetypepermissionFormData {

	public String mvccVersion;
	public String resourceTypePermissionId;
	public String companyId;
	public String groupId;
	public String name;
	public String roleId;
	public String actionIds;

	public ResourcetypepermissionFormData() {
	}

	public ResourcetypepermissionFormData(
		String mvccVersion,
				String resourceTypePermissionId,
				String companyId,
				String groupId,
				String name,
				String roleId,
				String actionIds
		) {

		this.mvccVersion = mvccVersion;
		this.resourceTypePermissionId = resourceTypePermissionId;
		this.companyId = companyId;
		this.groupId = groupId;
		this.name = name;
		this.roleId = roleId;
		this.actionIds = actionIds;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourceTypePermissionId == null || resourceTypePermissionId.length() == 0) {
			errors.add(new ValidationError("resourceTypePermissionId", "No resourceTypePermissionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
