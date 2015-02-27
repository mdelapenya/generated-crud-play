package controllers.dlcontent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlcontent data form.
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
public class DlcontentFormData {

	public String contentId;
	public String groupId;
	public String companyId;
	public String repositoryId;
	public String path;
	public String version;

	public DlcontentFormData() {
	}

	public DlcontentFormData(
		String contentId,
				String groupId,
				String companyId,
				String repositoryId,
				String path,
				String version
		) {

		this.contentId = contentId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.repositoryId = repositoryId;
		this.path = path;
		this.version = version;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (contentId == null || contentId.length() == 0) {
			errors.add(new ValidationError("contentId", "No contentId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
