package controllers.usertracker;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Usertracker data form.
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
public class UsertrackerFormData {

	public String mvccVersion;
	public String userTrackerId;
	public String companyId;
	public String userId;
	public String modifiedDate;
	public String sessionId;
	public String remoteAddr;
	public String remoteHost;
	public String userAgent;

	public UsertrackerFormData() {
	}

	public UsertrackerFormData(
		String mvccVersion,
				String userTrackerId,
				String companyId,
				String userId,
				String modifiedDate,
				String sessionId,
				String remoteAddr,
				String remoteHost,
				String userAgent
		) {

		this.mvccVersion = mvccVersion;
		this.userTrackerId = userTrackerId;
		this.companyId = companyId;
		this.userId = userId;
		this.modifiedDate = modifiedDate;
		this.sessionId = sessionId;
		this.remoteAddr = remoteAddr;
		this.remoteHost = remoteHost;
		this.userAgent = userAgent;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userTrackerId == null || userTrackerId.length() == 0) {
			errors.add(new ValidationError("userTrackerId", "No userTrackerId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
