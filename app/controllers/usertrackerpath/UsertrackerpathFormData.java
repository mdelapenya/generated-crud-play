package controllers.usertrackerpath;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Usertrackerpath data form.
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
public class UsertrackerpathFormData {

	public String mvccVersion;
	public String userTrackerPathId;
	public String userTrackerId;
	public String path;
	public String pathDate;

	public UsertrackerpathFormData() {
	}

	public UsertrackerpathFormData(
		String mvccVersion,
				String userTrackerPathId,
				String userTrackerId,
				String path,
				String pathDate
		) {

		this.mvccVersion = mvccVersion;
		this.userTrackerPathId = userTrackerPathId;
		this.userTrackerId = userTrackerId;
		this.path = path;
		this.pathDate = pathDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userTrackerPathId == null || userTrackerPathId.length() == 0) {
			errors.add(new ValidationError("userTrackerPathId", "No userTrackerPathId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
