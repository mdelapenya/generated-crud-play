package controllers.browsertracker;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Browsertracker data form.
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
public class BrowsertrackerFormData {

	public String mvccVersion;
	public String browserTrackerId;
	public String userId;
	public String browserKey;

	public BrowsertrackerFormData() {
	}

	public BrowsertrackerFormData(
		String mvccVersion,
				String browserTrackerId,
				String userId,
				String browserKey
		) {

		this.mvccVersion = mvccVersion;
		this.browserTrackerId = browserTrackerId;
		this.userId = userId;
		this.browserKey = browserKey;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (browserTrackerId == null || browserTrackerId.length() == 0) {
			errors.add(new ValidationError("browserTrackerId", "No browserTrackerId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
