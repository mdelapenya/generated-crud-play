package controllers.resourcepermission;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Resourcepermission data form.
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
public class ResourcepermissionFormData {

	public String mvccVersion;
	public String resourcePermissionId;
	public String companyId;
	public String name;
	public String scope;
	public String primKey;
	public String roleId;
	public String ownerId;
	public String actionIds;

	public ResourcepermissionFormData() {
	}

	public ResourcepermissionFormData(
		String mvccVersion,
				String resourcePermissionId,
				String companyId,
				String name,
				String scope,
				String primKey,
				String roleId,
				String ownerId,
				String actionIds
		) {

		this.mvccVersion = mvccVersion;
		this.resourcePermissionId = resourcePermissionId;
		this.companyId = companyId;
		this.name = name;
		this.scope = scope;
		this.primKey = primKey;
		this.roleId = roleId;
		this.ownerId = ownerId;
		this.actionIds = actionIds;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourcePermissionId == null || resourcePermissionId.length() == 0) {
			errors.add(new ValidationError("resourcePermissionId", "No resourcePermissionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
