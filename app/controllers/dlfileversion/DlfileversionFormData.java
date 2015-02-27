package controllers.dlfileversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfileversion data form.
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
public class DlfileversionFormData {

	public String uuid;
	public String fileVersionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String repositoryId;
	public String folderId;
	public String fileEntryId;
	public String treePath;
	public String fileName;
	public String extension;
	public String mimeType;
	public String title;
	public String description;
	public String changeLog;
	public String extraSettings;
	public String fileEntryTypeId;
	public String version;
	public String size;
	public String checksum;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public DlfileversionFormData() {
	}

	public DlfileversionFormData(
		String uuid,
				String fileVersionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String repositoryId,
				String folderId,
				String fileEntryId,
				String treePath,
				String fileName,
				String extension,
				String mimeType,
				String title,
				String description,
				String changeLog,
				String extraSettings,
				String fileEntryTypeId,
				String version,
				String size,
				String checksum,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.fileVersionId = fileVersionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.repositoryId = repositoryId;
		this.folderId = folderId;
		this.fileEntryId = fileEntryId;
		this.treePath = treePath;
		this.fileName = fileName;
		this.extension = extension;
		this.mimeType = mimeType;
		this.title = title;
		this.description = description;
		this.changeLog = changeLog;
		this.extraSettings = extraSettings;
		this.fileEntryTypeId = fileEntryTypeId;
		this.version = version;
		this.size = size;
		this.checksum = checksum;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileVersionId == null || fileVersionId.length() == 0) {
			errors.add(new ValidationError("fileVersionId", "No fileVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
