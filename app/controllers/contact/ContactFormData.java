package controllers.contact;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Contact data form.
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
public class ContactFormData {

	public String mvccVersion;
	public String contactId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String accountId;
	public String parentContactId;
	public String emailAddress;
	public String firstName;
	public String middleName;
	public String lastName;
	public String prefixId;
	public String suffixId;
	public String male;
	public String birthday;
	public String smsSn;
	public String aimSn;
	public String facebookSn;
	public String icqSn;
	public String jabberSn;
	public String msnSn;
	public String mySpaceSn;
	public String skypeSn;
	public String twitterSn;
	public String ymSn;
	public String employeeStatusId;
	public String employeeNumber;
	public String jobTitle;
	public String jobClass;
	public String hoursOfOperation;

	public ContactFormData() {
	}

	public ContactFormData(
		String mvccVersion,
				String contactId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String accountId,
				String parentContactId,
				String emailAddress,
				String firstName,
				String middleName,
				String lastName,
				String prefixId,
				String suffixId,
				String male,
				String birthday,
				String smsSn,
				String aimSn,
				String facebookSn,
				String icqSn,
				String jabberSn,
				String msnSn,
				String mySpaceSn,
				String skypeSn,
				String twitterSn,
				String ymSn,
				String employeeStatusId,
				String employeeNumber,
				String jobTitle,
				String jobClass,
				String hoursOfOperation
		) {

		this.mvccVersion = mvccVersion;
		this.contactId = contactId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.accountId = accountId;
		this.parentContactId = parentContactId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.prefixId = prefixId;
		this.suffixId = suffixId;
		this.male = male;
		this.birthday = birthday;
		this.smsSn = smsSn;
		this.aimSn = aimSn;
		this.facebookSn = facebookSn;
		this.icqSn = icqSn;
		this.jabberSn = jabberSn;
		this.msnSn = msnSn;
		this.mySpaceSn = mySpaceSn;
		this.skypeSn = skypeSn;
		this.twitterSn = twitterSn;
		this.ymSn = ymSn;
		this.employeeStatusId = employeeStatusId;
		this.employeeNumber = employeeNumber;
		this.jobTitle = jobTitle;
		this.jobClass = jobClass;
		this.hoursOfOperation = hoursOfOperation;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (contactId == null || contactId.length() == 0) {
			errors.add(new ValidationError("contactId", "No contactId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
