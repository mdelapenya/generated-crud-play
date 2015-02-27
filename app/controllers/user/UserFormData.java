package controllers.user;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the User data form.
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
public class UserFormData {

	public String mvccVersion;
	public String uuid;
	public String userId;
	public String companyId;
	public String createDate;
	public String modifiedDate;
	public String defaultUser;
	public String contactId;
	public String password;
	public String passwordEncrypted;
	public String passwordReset;
	public String passwordModifiedDate;
	public String digest;
	public String reminderQueryQuestion;
	public String reminderQueryAnswer;
	public String graceLoginCount;
	public String screenName;
	public String emailAddress;
	public String facebookId;
	public String ldapServerId;
	public String openId;
	public String portraitId;
	public String languageId;
	public String timeZoneId;
	public String greeting;
	public String comments;
	public String firstName;
	public String middleName;
	public String lastName;
	public String jobTitle;
	public String loginDate;
	public String loginIP;
	public String lastLoginDate;
	public String lastLoginIP;
	public String lastFailedLoginDate;
	public String failedLoginAttempts;
	public String lockout;
	public String lockoutDate;
	public String agreedToTermsOfUse;
	public String emailAddressVerified;
	public String status;

	public UserFormData() {
	}

	public UserFormData(
		String mvccVersion,
				String uuid,
				String userId,
				String companyId,
				String createDate,
				String modifiedDate,
				String defaultUser,
				String contactId,
				String password,
				String passwordEncrypted,
				String passwordReset,
				String passwordModifiedDate,
				String digest,
				String reminderQueryQuestion,
				String reminderQueryAnswer,
				String graceLoginCount,
				String screenName,
				String emailAddress,
				String facebookId,
				String ldapServerId,
				String openId,
				String portraitId,
				String languageId,
				String timeZoneId,
				String greeting,
				String comments,
				String firstName,
				String middleName,
				String lastName,
				String jobTitle,
				String loginDate,
				String loginIP,
				String lastLoginDate,
				String lastLoginIP,
				String lastFailedLoginDate,
				String failedLoginAttempts,
				String lockout,
				String lockoutDate,
				String agreedToTermsOfUse,
				String emailAddressVerified,
				String status
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.userId = userId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.defaultUser = defaultUser;
		this.contactId = contactId;
		this.password = password;
		this.passwordEncrypted = passwordEncrypted;
		this.passwordReset = passwordReset;
		this.passwordModifiedDate = passwordModifiedDate;
		this.digest = digest;
		this.reminderQueryQuestion = reminderQueryQuestion;
		this.reminderQueryAnswer = reminderQueryAnswer;
		this.graceLoginCount = graceLoginCount;
		this.screenName = screenName;
		this.emailAddress = emailAddress;
		this.facebookId = facebookId;
		this.ldapServerId = ldapServerId;
		this.openId = openId;
		this.portraitId = portraitId;
		this.languageId = languageId;
		this.timeZoneId = timeZoneId;
		this.greeting = greeting;
		this.comments = comments;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.loginDate = loginDate;
		this.loginIP = loginIP;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIP = lastLoginIP;
		this.lastFailedLoginDate = lastFailedLoginDate;
		this.failedLoginAttempts = failedLoginAttempts;
		this.lockout = lockout;
		this.lockoutDate = lockoutDate;
		this.agreedToTermsOfUse = agreedToTermsOfUse;
		this.emailAddressVerified = emailAddressVerified;
		this.status = status;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (userId == null || userId.length() == 0) {
			errors.add(new ValidationError("userId", "No userId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
