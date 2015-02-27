package controllers.passwordtracker;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Passwordtracker data form.
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
public class PasswordtrackerFormData {

	public String mvccVersion;
	public String passwordTrackerId;
	public String userId;
	public String createDate;
	public String password;

	public PasswordtrackerFormData() {
	}

	public PasswordtrackerFormData(
		String mvccVersion,
				String passwordTrackerId,
				String userId,
				String createDate,
				String password
		) {

		this.mvccVersion = mvccVersion;
		this.passwordTrackerId = passwordTrackerId;
		this.userId = userId;
		this.createDate = createDate;
		this.password = password;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (passwordTrackerId == null || passwordTrackerId.length() == 0) {
			errors.add(new ValidationError("passwordTrackerId", "No passwordTrackerId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
