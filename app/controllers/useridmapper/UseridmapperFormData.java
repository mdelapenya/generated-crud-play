package controllers.useridmapper;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Useridmapper data form.
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
public class UseridmapperFormData {

	public String mvccVersion;
	public String userIdMapperId;
	public String userId;
	public String customtype;
	public String description;
	public String externalUserId;

	public UseridmapperFormData() {
	}

	public UseridmapperFormData(
		String mvccVersion,
				String userIdMapperId,
				String userId,
				String customtype,
				String description,
				String externalUserId
		) {

		this.mvccVersion = mvccVersion;
		this.userIdMapperId = userIdMapperId;
		this.userId = userId;
		this.customtype = customtype;
		this.description = description;
		this.externalUserId = externalUserId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userIdMapperId == null || userIdMapperId.length() == 0) {
			errors.add(new ValidationError("userIdMapperId", "No userIdMapperId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
