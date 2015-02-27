package controllers.resourceblockpermission;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Resourceblockpermission data form.
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
public class ResourceblockpermissionFormData {

	public String mvccVersion;
	public String resourceBlockPermissionId;
	public String resourceBlockId;
	public String roleId;
	public String actionIds;

	public ResourceblockpermissionFormData() {
	}

	public ResourceblockpermissionFormData(
		String mvccVersion,
				String resourceBlockPermissionId,
				String resourceBlockId,
				String roleId,
				String actionIds
		) {

		this.mvccVersion = mvccVersion;
		this.resourceBlockPermissionId = resourceBlockPermissionId;
		this.resourceBlockId = resourceBlockId;
		this.roleId = roleId;
		this.actionIds = actionIds;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourceBlockPermissionId == null || resourceBlockPermissionId.length() == 0) {
			errors.add(new ValidationError("resourceBlockPermissionId", "No resourceBlockPermissionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
