
package models.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.user.UserFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class User extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userId;

	public long companyId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public boolean defaultUser;

	public long contactId;

	@Constraints.MaxLength(75)
	public String password;

	public boolean passwordEncrypted;

	public boolean passwordReset;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date passwordModifiedDate;

	@Constraints.MaxLength(255)
	public String digest;

	@Constraints.MaxLength(75)
	public String reminderQueryQuestion;

	@Constraints.MaxLength(75)
	public String reminderQueryAnswer;

	public int graceLoginCount;

	@Constraints.MaxLength(75)
	public String screenName;

	@Constraints.MaxLength(75)
	public String emailAddress;

	public long facebookId;

	public long ldapServerId;

	@Constraints.MaxLength(1024)
	public String openId;

	public long portraitId;

	@Constraints.MaxLength(75)
	public String languageId;

	@Constraints.MaxLength(75)
	public String timeZoneId;

	@Constraints.MaxLength(255)
	public String greeting;

	public String comments;

	@Constraints.MaxLength(75)
	public String firstName;

	@Constraints.MaxLength(75)
	public String middleName;

	@Constraints.MaxLength(75)
	public String lastName;

	@Constraints.MaxLength(100)
	public String jobTitle;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date loginDate;

	@Constraints.MaxLength(75)
	public String loginIP;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lastLoginDate;

	@Constraints.MaxLength(75)
	public String lastLoginIP;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lastFailedLoginDate;

	public int failedLoginAttempts;

	public boolean lockout;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lockoutDate;

	public boolean agreedToTermsOfUse;

	public boolean emailAddressVerified;

	public int status;


	// model finder attribute

	public static Finder<Long,User> find = new Finder<Long,User>(
		Long.class, User.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(boolean defaultUser) {
		this.defaultUser = defaultUser;
	}
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(boolean passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}
	public boolean getPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(boolean passwordReset) {
		this.passwordReset = passwordReset;
	}
	public Date getPasswordModifiedDate() {
		return passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		this.passwordModifiedDate = passwordModifiedDate;
	}
	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getReminderQueryQuestion() {
		return reminderQueryQuestion;
	}

	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		this.reminderQueryQuestion = reminderQueryQuestion;
	}
	public String getReminderQueryAnswer() {
		return reminderQueryAnswer;
	}

	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		this.reminderQueryAnswer = reminderQueryAnswer;
	}
	public int getGraceLoginCount() {
		return graceLoginCount;
	}

	public void setGraceLoginCount(int graceLoginCount) {
		this.graceLoginCount = graceLoginCount;
	}
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(long facebookId) {
		this.facebookId = facebookId;
	}
	public long getLdapServerId() {
		return ldapServerId;
	}

	public void setLdapServerId(long ldapServerId) {
		this.ldapServerId = ldapServerId;
	}
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public long getPortraitId() {
		return portraitId;
	}

	public void setPortraitId(long portraitId) {
		this.portraitId = portraitId;
	}
	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public Date getLastFailedLoginDate() {
		return lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		this.lastFailedLoginDate = lastFailedLoginDate;
	}
	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	public boolean getLockout() {
		return lockout;
	}

	public void setLockout(boolean lockout) {
		this.lockout = lockout;
	}
	public Date getLockoutDate() {
		return lockoutDate;
	}

	public void setLockoutDate(Date lockoutDate) {
		this.lockoutDate = lockoutDate;
	}
	public boolean getAgreedToTermsOfUse() {
		return agreedToTermsOfUse;
	}

	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		this.agreedToTermsOfUse = agreedToTermsOfUse;
	}
	public boolean getEmailAddressVerified() {
		return emailAddressVerified;
	}

	public void setEmailAddressVerified(boolean emailAddressVerified) {
		this.emailAddressVerified = emailAddressVerified;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User(){
	}

	// constructor using a formData

	public User(UserFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		userId = Long.valueOf(formData.userId);
		companyId = Long.valueOf(formData.companyId);
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		defaultUser = Boolean.valueOf(formData.defaultUser);
		contactId = Long.valueOf(formData.contactId);
		password = formData.password;
		passwordEncrypted = Boolean.valueOf(formData.passwordEncrypted);
		passwordReset = Boolean.valueOf(formData.passwordReset);
		passwordModifiedDate = new Date(formData.passwordModifiedDate);
		digest = formData.digest;
		reminderQueryQuestion = formData.reminderQueryQuestion;
		reminderQueryAnswer = formData.reminderQueryAnswer;
		graceLoginCount = Integer.valueOf(formData.graceLoginCount);
		screenName = formData.screenName;
		emailAddress = formData.emailAddress;
		facebookId = Long.valueOf(formData.facebookId);
		ldapServerId = Long.valueOf(formData.ldapServerId);
		openId = formData.openId;
		portraitId = Long.valueOf(formData.portraitId);
		languageId = formData.languageId;
		timeZoneId = formData.timeZoneId;
		greeting = formData.greeting;
		comments = formData.comments;
		firstName = formData.firstName;
		middleName = formData.middleName;
		lastName = formData.lastName;
		jobTitle = formData.jobTitle;
		loginDate = new Date(formData.loginDate);
		loginIP = formData.loginIP;
		lastLoginDate = new Date(formData.lastLoginDate);
		lastLoginIP = formData.lastLoginIP;
		lastFailedLoginDate = new Date(formData.lastFailedLoginDate);
		failedLoginAttempts = Integer.valueOf(formData.failedLoginAttempts);
		lockout = Boolean.valueOf(formData.lockout);
		lockoutDate = new Date(formData.lockoutDate);
		agreedToTermsOfUse = Boolean.valueOf(formData.agreedToTermsOfUse);
		emailAddressVerified = Boolean.valueOf(formData.emailAddressVerified);
		status = Integer.valueOf(formData.status);
	}

	public UserFormData toFormData() {
		if (userId < 0) {
			userId = 0L;
		}

		UserFormData formData = new UserFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(userId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(defaultUser)
			,
			String.valueOf(contactId)
			,
			password
			,
			String.valueOf(passwordEncrypted)
			,
			String.valueOf(passwordReset)
			,
			String.valueOf(passwordModifiedDate)
			,
			digest
			,
			reminderQueryQuestion
			,
			reminderQueryAnswer
			,
			String.valueOf(graceLoginCount)
			,
			screenName
			,
			emailAddress
			,
			String.valueOf(facebookId)
			,
			String.valueOf(ldapServerId)
			,
			openId
			,
			String.valueOf(portraitId)
			,
			languageId
			,
			timeZoneId
			,
			greeting
			,
			comments
			,
			firstName
			,
			middleName
			,
			lastName
			,
			jobTitle
			,
			String.valueOf(loginDate)
			,
			loginIP
			,
			String.valueOf(lastLoginDate)
			,
			lastLoginIP
			,
			String.valueOf(lastFailedLoginDate)
			,
			String.valueOf(failedLoginAttempts)
			,
			String.valueOf(lockout)
			,
			String.valueOf(lockoutDate)
			,
			String.valueOf(agreedToTermsOfUse)
			,
			String.valueOf(emailAddressVerified)
			,
			String.valueOf(status)
			
		);

		return formData;
	}

}
