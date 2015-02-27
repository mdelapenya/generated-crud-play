package controllers.resourceblock;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Resourceblock data form.
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
public class ResourceblockFormData {

	public String mvccVersion;
	public String resourceBlockId;
	public String companyId;
	public String groupId;
	public String name;
	public String permissionsHash;
	public String referenceCount;

	public ResourceblockFormData() {
	}

	public ResourceblockFormData(
		String mvccVersion,
				String resourceBlockId,
				String companyId,
				String groupId,
				String name,
				String permissionsHash,
				String referenceCount
		) {

		this.mvccVersion = mvccVersion;
		this.resourceBlockId = resourceBlockId;
		this.companyId = companyId;
		this.groupId = groupId;
		this.name = name;
		this.permissionsHash = permissionsHash;
		this.referenceCount = referenceCount;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourceBlockId == null || resourceBlockId.length() == 0) {
			errors.add(new ValidationError("resourceBlockId", "No resourceBlockId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
