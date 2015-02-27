package controllers.region;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Region data form.
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
public class RegionFormData {

	public String mvccVersion;
	public String regionId;
	public String countryId;
	public String regionCode;
	public String name;
	public String active;

	public RegionFormData() {
	}

	public RegionFormData(
		String mvccVersion,
				String regionId,
				String countryId,
				String regionCode,
				String name,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.regionId = regionId;
		this.countryId = countryId;
		this.regionCode = regionCode;
		this.name = name;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (regionId == null || regionId.length() == 0) {
			errors.add(new ValidationError("regionId", "No regionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
