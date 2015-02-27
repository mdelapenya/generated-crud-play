package controllers.ddlrecordversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddlrecordversion data form.
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
public class DdlrecordversionFormData {

	public String recordVersionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String DDMStorageId;
	public String recordSetId;
	public String recordId;
	public String version;
	public String displayIndex;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public DdlrecordversionFormData() {
	}

	public DdlrecordversionFormData(
		String recordVersionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String DDMStorageId,
				String recordSetId,
				String recordId,
				String version,
				String displayIndex,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.recordVersionId = recordVersionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.DDMStorageId = DDMStorageId;
		this.recordSetId = recordSetId;
		this.recordId = recordId;
		this.version = version;
		this.displayIndex = displayIndex;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (recordVersionId == null || recordVersionId.length() == 0) {
			errors.add(new ValidationError("recordVersionId", "No recordVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
