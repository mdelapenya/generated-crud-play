package controllers.release;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Release data form.
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
public class ReleaseFormData {

	public String mvccVersion;
	public String releaseId;
	public String createDate;
	public String modifiedDate;
	public String servletContextName;
	public String buildNumber;
	public String buildDate;
	public String verified;
	public String state;
	public String testString;

	public ReleaseFormData() {
	}

	public ReleaseFormData(
		String mvccVersion,
				String releaseId,
				String createDate,
				String modifiedDate,
				String servletContextName,
				String buildNumber,
				String buildDate,
				String verified,
				String state,
				String testString
		) {

		this.mvccVersion = mvccVersion;
		this.releaseId = releaseId;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.servletContextName = servletContextName;
		this.buildNumber = buildNumber;
		this.buildDate = buildDate;
		this.verified = verified;
		this.state = state;
		this.testString = testString;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (releaseId == null || releaseId.length() == 0) {
			errors.add(new ValidationError("releaseId", "No releaseId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
