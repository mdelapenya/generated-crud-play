package controllers.dlfolder;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfolder data form.
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
public class DlfolderFormData {

	public String uuid;
	public String folderId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String repositoryId;
	public String mountPoint;
	public String parentFolderId;
	public String treePath;
	public String name;
	public String description;
	public String lastPostDate;
	public String defaultFileEntryTypeId;
	public String hidden;
	public String restrictionType;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public DlfolderFormData() {
	}

	public DlfolderFormData(
		String uuid,
				String folderId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String repositoryId,
				String mountPoint,
				String parentFolderId,
				String treePath,
				String name,
				String description,
				String lastPostDate,
				String defaultFileEntryTypeId,
				String hidden,
				String restrictionType,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.folderId = folderId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.repositoryId = repositoryId;
		this.mountPoint = mountPoint;
		this.parentFolderId = parentFolderId;
		this.treePath = treePath;
		this.name = name;
		this.description = description;
		this.lastPostDate = lastPostDate;
		this.defaultFileEntryTypeId = defaultFileEntryTypeId;
		this.hidden = hidden;
		this.restrictionType = restrictionType;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (folderId == null || folderId.length() == 0) {
			errors.add(new ValidationError("folderId", "No folderId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
