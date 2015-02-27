package controllers.scproductversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Scproductversion data form.
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
public class ScproductversionFormData {

	public String productVersionId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String productEntryId;
	public String version;
	public String changeLog;
	public String downloadPageURL;
	public String directDownloadURL;
	public String repoStoreArtifact;

	public ScproductversionFormData() {
	}

	public ScproductversionFormData(
		String productVersionId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String productEntryId,
				String version,
				String changeLog,
				String downloadPageURL,
				String directDownloadURL,
				String repoStoreArtifact
		) {

		this.productVersionId = productVersionId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.productEntryId = productEntryId;
		this.version = version;
		this.changeLog = changeLog;
		this.downloadPageURL = downloadPageURL;
		this.directDownloadURL = directDownloadURL;
		this.repoStoreArtifact = repoStoreArtifact;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (productVersionId == null || productVersionId.length() == 0) {
			errors.add(new ValidationError("productVersionId", "No productVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
