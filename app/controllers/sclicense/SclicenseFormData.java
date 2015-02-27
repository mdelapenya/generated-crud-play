package controllers.sclicense;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Sclicense data form.
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
public class SclicenseFormData {

	public String licenseId;
	public String name;
	public String url;
	public String openSource;
	public String active;
	public String recommended;

	public SclicenseFormData() {
	}

	public SclicenseFormData(
		String licenseId,
				String name,
				String url,
				String openSource,
				String active,
				String recommended
		) {

		this.licenseId = licenseId;
		this.name = name;
		this.url = url;
		this.openSource = openSource;
		this.active = active;
		this.recommended = recommended;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (licenseId == null || licenseId.length() == 0) {
			errors.add(new ValidationError("licenseId", "No licenseId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
