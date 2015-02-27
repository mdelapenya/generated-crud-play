
package models.contact;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.contact.ContactFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Contact extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long contactId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long classNameId;

	public long classPK;

	public long accountId;

	public long parentContactId;

	@Constraints.MaxLength(75)
	public String emailAddress;

	@Constraints.MaxLength(75)
	public String firstName;

	@Constraints.MaxLength(75)
	public String middleName;

	@Constraints.MaxLength(75)
	public String lastName;

	public long prefixId;

	public long suffixId;

	public boolean male;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date birthday;

	@Constraints.MaxLength(75)
	public String smsSn;

	@Constraints.MaxLength(75)
	public String aimSn;

	@Constraints.MaxLength(75)
	public String facebookSn;

	@Constraints.MaxLength(75)
	public String icqSn;

	@Constraints.MaxLength(75)
	public String jabberSn;

	@Constraints.MaxLength(75)
	public String msnSn;

	@Constraints.MaxLength(75)
	public String mySpaceSn;

	@Constraints.MaxLength(75)
	public String skypeSn;

	@Constraints.MaxLength(75)
	public String twitterSn;

	@Constraints.MaxLength(75)
	public String ymSn;

	@Constraints.MaxLength(75)
	public String employeeStatusId;

	@Constraints.MaxLength(75)
	public String employeeNumber;

	@Constraints.MaxLength(100)
	public String jobTitle;

	@Constraints.MaxLength(75)
	public String jobClass;

	@Constraints.MaxLength(75)
	public String hoursOfOperation;


	// model finder attribute

	public static Finder<Long,Contact> find = new Finder<Long,Contact>(
		Long.class, Contact.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getParentContactId() {
		return parentContactId;
	}

	public void setParentContactId(long parentContactId) {
		this.parentContactId = parentContactId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public long getPrefixId() {
		return prefixId;
	}

	public void setPrefixId(long prefixId) {
		this.prefixId = prefixId;
	}
	public long getSuffixId() {
		return suffixId;
	}

	public void setSuffixId(long suffixId) {
		this.suffixId = suffixId;
	}
	public boolean getMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSmsSn() {
		return smsSn;
	}

	public void setSmsSn(String smsSn) {
		this.smsSn = smsSn;
	}
	public String getAimSn() {
		return aimSn;
	}

	public void setAimSn(String aimSn) {
		this.aimSn = aimSn;
	}
	public String getFacebookSn() {
		return facebookSn;
	}

	public void setFacebookSn(String facebookSn) {
		this.facebookSn = facebookSn;
	}
	public String getIcqSn() {
		return icqSn;
	}

	public void setIcqSn(String icqSn) {
		this.icqSn = icqSn;
	}
	public String getJabberSn() {
		return jabberSn;
	}

	public void setJabberSn(String jabberSn) {
		this.jabberSn = jabberSn;
	}
	public String getMsnSn() {
		return msnSn;
	}

	public void setMsnSn(String msnSn) {
		this.msnSn = msnSn;
	}
	public String getMySpaceSn() {
		return mySpaceSn;
	}

	public void setMySpaceSn(String mySpaceSn) {
		this.mySpaceSn = mySpaceSn;
	}
	public String getSkypeSn() {
		return skypeSn;
	}

	public void setSkypeSn(String skypeSn) {
		this.skypeSn = skypeSn;
	}
	public String getTwitterSn() {
		return twitterSn;
	}

	public void setTwitterSn(String twitterSn) {
		this.twitterSn = twitterSn;
	}
	public String getYmSn() {
		return ymSn;
	}

	public void setYmSn(String ymSn) {
		this.ymSn = ymSn;
	}
	public String getEmployeeStatusId() {
		return employeeStatusId;
	}

	public void setEmployeeStatusId(String employeeStatusId) {
		this.employeeStatusId = employeeStatusId;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}
	public String getHoursOfOperation() {
		return hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}

	public Contact(){
	}

	// constructor using a formData

	public Contact(ContactFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		contactId = Long.valueOf(formData.contactId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		accountId = Long.valueOf(formData.accountId);
		parentContactId = Long.valueOf(formData.parentContactId);
		emailAddress = formData.emailAddress;
		firstName = formData.firstName;
		middleName = formData.middleName;
		lastName = formData.lastName;
		prefixId = Long.valueOf(formData.prefixId);
		suffixId = Long.valueOf(formData.suffixId);
		male = Boolean.valueOf(formData.male);
		birthday = new Date(formData.birthday);
		smsSn = formData.smsSn;
		aimSn = formData.aimSn;
		facebookSn = formData.facebookSn;
		icqSn = formData.icqSn;
		jabberSn = formData.jabberSn;
		msnSn = formData.msnSn;
		mySpaceSn = formData.mySpaceSn;
		skypeSn = formData.skypeSn;
		twitterSn = formData.twitterSn;
		ymSn = formData.ymSn;
		employeeStatusId = formData.employeeStatusId;
		employeeNumber = formData.employeeNumber;
		jobTitle = formData.jobTitle;
		jobClass = formData.jobClass;
		hoursOfOperation = formData.hoursOfOperation;
	}

	public ContactFormData toFormData() {
		if (contactId < 0) {
			contactId = 0L;
		}

		ContactFormData formData = new ContactFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(contactId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(accountId)
			,
			String.valueOf(parentContactId)
			,
			emailAddress
			,
			firstName
			,
			middleName
			,
			lastName
			,
			String.valueOf(prefixId)
			,
			String.valueOf(suffixId)
			,
			String.valueOf(male)
			,
			String.valueOf(birthday)
			,
			smsSn
			,
			aimSn
			,
			facebookSn
			,
			icqSn
			,
			jabberSn
			,
			msnSn
			,
			mySpaceSn
			,
			skypeSn
			,
			twitterSn
			,
			ymSn
			,
			employeeStatusId
			,
			employeeNumber
			,
			jobTitle
			,
			jobClass
			,
			hoursOfOperation
			
		);

		return formData;
	}

}
