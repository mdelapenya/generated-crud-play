package controllers.ddmstructureversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmstructureversion data form.
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
public class DdmstructureversionFormData {

	public String structureVersionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String structureId;
	public String version;
	public String name;
	public String description;
	public String definition;
	public String storageType;
	public String customtype;

	public DdmstructureversionFormData() {
	}

	public DdmstructureversionFormData(
		String structureVersionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String structureId,
				String version,
				String name,
				String description,
				String definition,
				String storageType,
				String customtype
		) {

		this.structureVersionId = structureVersionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.structureId = structureId;
		this.version = version;
		this.name = name;
		this.description = description;
		this.definition = definition;
		this.storageType = storageType;
		this.customtype = customtype;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (structureVersionId == null || structureVersionId.length() == 0) {
			errors.add(new ValidationError("structureVersionId", "No structureVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
