package controllers.ddlrecord;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddlrecord data form.
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
public class DdlrecordFormData {

	public String uuid;
	public String recordId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String versionUserId;
	public String versionUserName;
	public String createDate;
	public String modifiedDate;
	public String DDMStorageId;
	public String recordSetId;
	public String version;
	public String displayIndex;

	public DdlrecordFormData() {
	}

	public DdlrecordFormData(
		String uuid,
				String recordId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String versionUserId,
				String versionUserName,
				String createDate,
				String modifiedDate,
				String DDMStorageId,
				String recordSetId,
				String version,
				String displayIndex
		) {

		this.uuid = uuid;
		this.recordId = recordId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.versionUserId = versionUserId;
		this.versionUserName = versionUserName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.DDMStorageId = DDMStorageId;
		this.recordSetId = recordSetId;
		this.version = version;
		this.displayIndex = displayIndex;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (recordId == null || recordId.length() == 0) {
			errors.add(new ValidationError("recordId", "No recordId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
