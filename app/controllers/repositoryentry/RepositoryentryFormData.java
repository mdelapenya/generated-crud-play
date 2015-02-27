package controllers.repositoryentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Repositoryentry data form.
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
public class RepositoryentryFormData {

	public String mvccVersion;
	public String uuid;
	public String repositoryEntryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String repositoryId;
	public String mappedId;
	public String manualCheckInRequired;

	public RepositoryentryFormData() {
	}

	public RepositoryentryFormData(
		String mvccVersion,
				String uuid,
				String repositoryEntryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String repositoryId,
				String mappedId,
				String manualCheckInRequired
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.repositoryEntryId = repositoryEntryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.repositoryId = repositoryId;
		this.mappedId = mappedId;
		this.manualCheckInRequired = manualCheckInRequired;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (repositoryEntryId == null || repositoryEntryId.length() == 0) {
			errors.add(new ValidationError("repositoryEntryId", "No repositoryEntryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
