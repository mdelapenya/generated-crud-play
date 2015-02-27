package controllers.usernotificationdelivery;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Usernotificationdelivery data form.
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
public class UsernotificationdeliveryFormData {

	public String mvccVersion;
	public String userNotificationDeliveryId;
	public String companyId;
	public String userId;
	public String portletId;
	public String classNameId;
	public String notificationType;
	public String deliveryType;
	public String deliver;

	public UsernotificationdeliveryFormData() {
	}

	public UsernotificationdeliveryFormData(
		String mvccVersion,
				String userNotificationDeliveryId,
				String companyId,
				String userId,
				String portletId,
				String classNameId,
				String notificationType,
				String deliveryType,
				String deliver
		) {

		this.mvccVersion = mvccVersion;
		this.userNotificationDeliveryId = userNotificationDeliveryId;
		this.companyId = companyId;
		this.userId = userId;
		this.portletId = portletId;
		this.classNameId = classNameId;
		this.notificationType = notificationType;
		this.deliveryType = deliveryType;
		this.deliver = deliver;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userNotificationDeliveryId == null || userNotificationDeliveryId.length() == 0) {
			errors.add(new ValidationError("userNotificationDeliveryId", "No userNotificationDeliveryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
