package controllers.usernotificationevent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Usernotificationevent data form.
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
public class UsernotificationeventFormData {

	public String mvccVersion;
	public String uuid;
	public String userNotificationEventId;
	public String companyId;
	public String userId;
	public String customtype;
	public String timestamp;
	public String deliveryType;
	public String deliverBy;
	public String delivered;
	public String payload;
	public String actionRequired;
	public String archived;

	public UsernotificationeventFormData() {
	}

	public UsernotificationeventFormData(
		String mvccVersion,
				String uuid,
				String userNotificationEventId,
				String companyId,
				String userId,
				String customtype,
				String timestamp,
				String deliveryType,
				String deliverBy,
				String delivered,
				String payload,
				String actionRequired,
				String archived
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.userNotificationEventId = userNotificationEventId;
		this.companyId = companyId;
		this.userId = userId;
		this.customtype = customtype;
		this.timestamp = timestamp;
		this.deliveryType = deliveryType;
		this.deliverBy = deliverBy;
		this.delivered = delivered;
		this.payload = payload;
		this.actionRequired = actionRequired;
		this.archived = archived;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userNotificationEventId == null || userNotificationEventId.length() == 0) {
			errors.add(new ValidationError("userNotificationEventId", "No userNotificationEventId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
