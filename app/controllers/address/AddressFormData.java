package controllers.address;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Address data form.
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
public class AddressFormData {

	public String mvccVersion;
	public String uuid;
	public String addressId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String street1;
	public String street2;
	public String street3;
	public String city;
	public String zip;
	public String regionId;
	public String countryId;
	public String typeId;
	public String mailing;
	public String customprimary;

	public AddressFormData() {
	}

	public AddressFormData(
		String mvccVersion,
				String uuid,
				String addressId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String street1,
				String street2,
				String street3,
				String city,
				String zip,
				String regionId,
				String countryId,
				String typeId,
				String mailing,
				String customprimary
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.addressId = addressId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.street1 = street1;
		this.street2 = street2;
		this.street3 = street3;
		this.city = city;
		this.zip = zip;
		this.regionId = regionId;
		this.countryId = countryId;
		this.typeId = typeId;
		this.mailing = mailing;
		this.customprimary = customprimary;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (addressId == null || addressId.length() == 0) {
			errors.add(new ValidationError("addressId", "No addressId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
