package controllers.dlfileentrytype;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfileentrytype data form.
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
public class DlfileentrytypeFormData {

	public String uuid;
	public String fileEntryTypeId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String fileEntryTypeKey;
	public String name;
	public String description;

	public DlfileentrytypeFormData() {
	}

	public DlfileentrytypeFormData(
		String uuid,
				String fileEntryTypeId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String fileEntryTypeKey,
				String name,
				String description
		) {

		this.uuid = uuid;
		this.fileEntryTypeId = fileEntryTypeId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.fileEntryTypeKey = fileEntryTypeKey;
		this.name = name;
		this.description = description;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileEntryTypeId == null || fileEntryTypeId.length() == 0) {
			errors.add(new ValidationError("fileEntryTypeId", "No fileEntryTypeId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
