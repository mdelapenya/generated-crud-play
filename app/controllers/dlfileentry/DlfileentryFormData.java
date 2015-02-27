package controllers.dlfileentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfileentry data form.
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
public class DlfileentryFormData {

	public String uuid;
	public String fileEntryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String repositoryId;
	public String folderId;
	public String treePath;
	public String name;
	public String fileName;
	public String extension;
	public String mimeType;
	public String title;
	public String description;
	public String extraSettings;
	public String fileEntryTypeId;
	public String version;
	public String size;
	public String readCount;
	public String smallImageId;
	public String largeImageId;
	public String custom1ImageId;
	public String custom2ImageId;
	public String manualCheckInRequired;

	public DlfileentryFormData() {
	}

	public DlfileentryFormData(
		String uuid,
				String fileEntryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String repositoryId,
				String folderId,
				String treePath,
				String name,
				String fileName,
				String extension,
				String mimeType,
				String title,
				String description,
				String extraSettings,
				String fileEntryTypeId,
				String version,
				String size,
				String readCount,
				String smallImageId,
				String largeImageId,
				String custom1ImageId,
				String custom2ImageId,
				String manualCheckInRequired
		) {

		this.uuid = uuid;
		this.fileEntryId = fileEntryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.repositoryId = repositoryId;
		this.folderId = folderId;
		this.treePath = treePath;
		this.name = name;
		this.fileName = fileName;
		this.extension = extension;
		this.mimeType = mimeType;
		this.title = title;
		this.description = description;
		this.extraSettings = extraSettings;
		this.fileEntryTypeId = fileEntryTypeId;
		this.version = version;
		this.size = size;
		this.readCount = readCount;
		this.smallImageId = smallImageId;
		this.largeImageId = largeImageId;
		this.custom1ImageId = custom1ImageId;
		this.custom2ImageId = custom2ImageId;
		this.manualCheckInRequired = manualCheckInRequired;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileEntryId == null || fileEntryId.length() == 0) {
			errors.add(new ValidationError("fileEntryId", "No fileEntryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
