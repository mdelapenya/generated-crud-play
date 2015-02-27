package controllers.journalfolder;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalfolder data form.
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
public class JournalfolderFormData {

	public String uuid;
	public String folderId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentFolderId;
	public String treePath;
	public String name;
	public String description;
	public String restrictionType;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public JournalfolderFormData() {
	}

	public JournalfolderFormData(
		String uuid,
				String folderId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentFolderId,
				String treePath,
				String name,
				String description,
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
		this.parentFolderId = parentFolderId;
		this.treePath = treePath;
		this.name = name;
		this.description = description;
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
