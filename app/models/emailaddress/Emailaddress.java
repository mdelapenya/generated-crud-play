
package models.emailaddress;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.emailaddress.EmailaddressFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Emailaddress extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long emailAddressId;

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

	@Constraints.MaxLength(75)
	public String address;

	public long typeId;

	public boolean customprimary;


	// model finder attribute

	public static Finder<Long,Emailaddress> find = new Finder<Long,Emailaddress>(
		Long.class, Emailaddress.class
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
	public long getEmailAddressId() {
		return emailAddressId;
	}

	public void setEmailAddressId(long emailAddressId) {
		this.emailAddressId = emailAddressId;
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
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public boolean getCustomprimary() {
		return customprimary;
	}

	public void setCustomprimary(boolean customprimary) {
		this.customprimary = customprimary;
	}

	public Emailaddress(){
	}

	// constructor using a formData

	public Emailaddress(EmailaddressFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		emailAddressId = Long.valueOf(formData.emailAddressId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		address = formData.address;
		typeId = Long.valueOf(formData.typeId);
		customprimary = Boolean.valueOf(formData.customprimary);
	}

	public EmailaddressFormData toFormData() {
		if (emailAddressId < 0) {
			emailAddressId = 0L;
		}

		EmailaddressFormData formData = new EmailaddressFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(emailAddressId)
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
			address
			,
			String.valueOf(typeId)
			,
			String.valueOf(customprimary)
			
		);

		return formData;
	}

}
