package controllers.announcementsflag;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Announcementsflag data form.
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
public class AnnouncementsflagFormData {

	public String flagId;
	public String userId;
	public String createDate;
	public String entryId;
	public String value;

	public AnnouncementsflagFormData() {
	}

	public AnnouncementsflagFormData(
		String flagId,
				String userId,
				String createDate,
				String entryId,
				String value
		) {

		this.flagId = flagId;
		this.userId = userId;
		this.createDate = createDate;
		this.entryId = entryId;
		this.value = value;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (flagId == null || flagId.length() == 0) {
			errors.add(new ValidationError("flagId", "No flagId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
