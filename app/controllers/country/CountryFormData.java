package controllers.country;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Country data form.
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
public class CountryFormData {

	public String mvccVersion;
	public String countryId;
	public String name;
	public String a2;
	public String a3;
	public String number;
	public String idd;
	public String zipRequired;
	public String active;

	public CountryFormData() {
	}

	public CountryFormData(
		String mvccVersion,
				String countryId,
				String name,
				String a2,
				String a3,
				String number,
				String idd,
				String zipRequired,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.countryId = countryId;
		this.name = name;
		this.a2 = a2;
		this.a3 = a3;
		this.number = number;
		this.idd = idd;
		this.zipRequired = zipRequired;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (countryId == null || countryId.length() == 0) {
			errors.add(new ValidationError("countryId", "No countryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
