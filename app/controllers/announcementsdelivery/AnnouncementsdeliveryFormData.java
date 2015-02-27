package controllers.announcementsdelivery;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Announcementsdelivery data form.
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
public class AnnouncementsdeliveryFormData {

	public String deliveryId;
	public String companyId;
	public String userId;
	public String customtype;
	public String email;
	public String sms;
	public String website;

	public AnnouncementsdeliveryFormData() {
	}

	public AnnouncementsdeliveryFormData(
		String deliveryId,
				String companyId,
				String userId,
				String customtype,
				String email,
				String sms,
				String website
		) {

		this.deliveryId = deliveryId;
		this.companyId = companyId;
		this.userId = userId;
		this.customtype = customtype;
		this.email = email;
		this.sms = sms;
		this.website = website;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (deliveryId == null || deliveryId.length() == 0) {
			errors.add(new ValidationError("deliveryId", "No deliveryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
