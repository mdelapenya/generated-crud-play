package controllers.ddlrecordset;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddlrecordset data form.
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
public class DdlrecordsetFormData {

	public String uuid;
	public String recordSetId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String DDMStructureId;
	public String recordSetKey;
	public String name;
	public String description;
	public String minDisplayRows;
	public String scope;

	public DdlrecordsetFormData() {
	}

	public DdlrecordsetFormData(
		String uuid,
				String recordSetId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String DDMStructureId,
				String recordSetKey,
				String name,
				String description,
				String minDisplayRows,
				String scope
		) {

		this.uuid = uuid;
		this.recordSetId = recordSetId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.DDMStructureId = DDMStructureId;
		this.recordSetKey = recordSetKey;
		this.name = name;
		this.description = description;
		this.minDisplayRows = minDisplayRows;
		this.scope = scope;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (recordSetId == null || recordSetId.length() == 0) {
			errors.add(new ValidationError("recordSetId", "No recordSetId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
