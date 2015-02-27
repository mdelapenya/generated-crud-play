package controllers.emailaddress;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Emailaddress data form.
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
public class EmailaddressFormData {

	public String mvccVersion;
	public String uuid;
	public String emailAddressId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String address;
	public String typeId;
	public String customprimary;

	public EmailaddressFormData() {
	}

	public EmailaddressFormData(
		String mvccVersion,
				String uuid,
				String emailAddressId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String address,
				String typeId,
				String customprimary
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.emailAddressId = emailAddressId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.address = address;
		this.typeId = typeId;
		this.customprimary = customprimary;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (emailAddressId == null || emailAddressId.length() == 0) {
			errors.add(new ValidationError("emailAddressId", "No emailAddressId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
