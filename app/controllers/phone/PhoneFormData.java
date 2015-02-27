package controllers.phone;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Phone data form.
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
public class PhoneFormData {

	public String mvccVersion;
	public String uuid;
	public String phoneId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String number;
	public String extension;
	public String typeId;
	public String customprimary;

	public PhoneFormData() {
	}

	public PhoneFormData(
		String mvccVersion,
				String uuid,
				String phoneId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String number,
				String extension,
				String typeId,
				String customprimary
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.phoneId = phoneId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.number = number;
		this.extension = extension;
		this.typeId = typeId;
		this.customprimary = customprimary;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (phoneId == null || phoneId.length() == 0) {
			errors.add(new ValidationError("phoneId", "No phoneId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
