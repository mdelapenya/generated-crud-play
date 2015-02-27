package controllers.ddmstructure;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmstructure data form.
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
public class DdmstructureFormData {

	public String uuid;
	public String structureId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentStructureId;
	public String classNameId;
	public String structureKey;
	public String version;
	public String name;
	public String description;
	public String definition;
	public String storageType;
	public String customtype;

	public DdmstructureFormData() {
	}

	public DdmstructureFormData(
		String uuid,
				String structureId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentStructureId,
				String classNameId,
				String structureKey,
				String version,
				String name,
				String description,
				String definition,
				String storageType,
				String customtype
		) {

		this.uuid = uuid;
		this.structureId = structureId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentStructureId = parentStructureId;
		this.classNameId = classNameId;
		this.structureKey = structureKey;
		this.version = version;
		this.name = name;
		this.description = description;
		this.definition = definition;
		this.storageType = storageType;
		this.customtype = customtype;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (structureId == null || structureId.length() == 0) {
			errors.add(new ValidationError("structureId", "No structureId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
