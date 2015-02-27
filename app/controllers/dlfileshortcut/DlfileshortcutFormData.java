package controllers.dlfileshortcut;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfileshortcut data form.
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
public class DlfileshortcutFormData {

	public String uuid;
	public String fileShortcutId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String repositoryId;
	public String folderId;
	public String toFileEntryId;
	public String treePath;
	public String active;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public DlfileshortcutFormData() {
	}

	public DlfileshortcutFormData(
		String uuid,
				String fileShortcutId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String repositoryId,
				String folderId,
				String toFileEntryId,
				String treePath,
				String active,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.fileShortcutId = fileShortcutId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.repositoryId = repositoryId;
		this.folderId = folderId;
		this.toFileEntryId = toFileEntryId;
		this.treePath = treePath;
		this.active = active;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileShortcutId == null || fileShortcutId.length() == 0) {
			errors.add(new ValidationError("fileShortcutId", "No fileShortcutId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
