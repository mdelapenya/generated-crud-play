
package models.mbmailinglist;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mbmailinglist.MbmailinglistFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mbmailinglist extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long mailingListId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long categoryId;

	@Constraints.MaxLength(75)
	public String emailAddress;

	@Constraints.MaxLength(75)
	public String inProtocol;

	@Constraints.MaxLength(75)
	public String inServerName;

	public int inServerPort;

	public boolean inUseSSL;

	@Constraints.MaxLength(75)
	public String inUserName;

	@Constraints.MaxLength(75)
	public String inPassword;

	public int inReadInterval;

	@Constraints.MaxLength(75)
	public String outEmailAddress;

	public boolean outCustom;

	@Constraints.MaxLength(75)
	public String outServerName;

	public int outServerPort;

	public boolean outUseSSL;

	@Constraints.MaxLength(75)
	public String outUserName;

	@Constraints.MaxLength(75)
	public String outPassword;

	public boolean allowAnonymous;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Mbmailinglist> find = new Finder<Long,Mbmailinglist>(
		Long.class, Mbmailinglist.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getMailingListId() {
		return mailingListId;
	}

	public void setMailingListId(long mailingListId) {
		this.mailingListId = mailingListId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getInProtocol() {
		return inProtocol;
	}

	public void setInProtocol(String inProtocol) {
		this.inProtocol = inProtocol;
	}
	public String getInServerName() {
		return inServerName;
	}

	public void setInServerName(String inServerName) {
		this.inServerName = inServerName;
	}
	public int getInServerPort() {
		return inServerPort;
	}

	public void setInServerPort(int inServerPort) {
		this.inServerPort = inServerPort;
	}
	public boolean getInUseSSL() {
		return inUseSSL;
	}

	public void setInUseSSL(boolean inUseSSL) {
		this.inUseSSL = inUseSSL;
	}
	public String getInUserName() {
		return inUserName;
	}

	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}
	public String getInPassword() {
		return inPassword;
	}

	public void setInPassword(String inPassword) {
		this.inPassword = inPassword;
	}
	public int getInReadInterval() {
		return inReadInterval;
	}

	public void setInReadInterval(int inReadInterval) {
		this.inReadInterval = inReadInterval;
	}
	public String getOutEmailAddress() {
		return outEmailAddress;
	}

	public void setOutEmailAddress(String outEmailAddress) {
		this.outEmailAddress = outEmailAddress;
	}
	public boolean getOutCustom() {
		return outCustom;
	}

	public void setOutCustom(boolean outCustom) {
		this.outCustom = outCustom;
	}
	public String getOutServerName() {
		return outServerName;
	}

	public void setOutServerName(String outServerName) {
		this.outServerName = outServerName;
	}
	public int getOutServerPort() {
		return outServerPort;
	}

	public void setOutServerPort(int outServerPort) {
		this.outServerPort = outServerPort;
	}
	public boolean getOutUseSSL() {
		return outUseSSL;
	}

	public void setOutUseSSL(boolean outUseSSL) {
		this.outUseSSL = outUseSSL;
	}
	public String getOutUserName() {
		return outUserName;
	}

	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}
	public String getOutPassword() {
		return outPassword;
	}

	public void setOutPassword(String outPassword) {
		this.outPassword = outPassword;
	}
	public boolean getAllowAnonymous() {
		return allowAnonymous;
	}

	public void setAllowAnonymous(boolean allowAnonymous) {
		this.allowAnonymous = allowAnonymous;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Mbmailinglist(){
	}

	// constructor using a formData

	public Mbmailinglist(MbmailinglistFormData formData) {
		uuid = formData.uuid;
		mailingListId = Long.valueOf(formData.mailingListId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		categoryId = Long.valueOf(formData.categoryId);
		emailAddress = formData.emailAddress;
		inProtocol = formData.inProtocol;
		inServerName = formData.inServerName;
		inServerPort = Integer.valueOf(formData.inServerPort);
		inUseSSL = Boolean.valueOf(formData.inUseSSL);
		inUserName = formData.inUserName;
		inPassword = formData.inPassword;
		inReadInterval = Integer.valueOf(formData.inReadInterval);
		outEmailAddress = formData.outEmailAddress;
		outCustom = Boolean.valueOf(formData.outCustom);
		outServerName = formData.outServerName;
		outServerPort = Integer.valueOf(formData.outServerPort);
		outUseSSL = Boolean.valueOf(formData.outUseSSL);
		outUserName = formData.outUserName;
		outPassword = formData.outPassword;
		allowAnonymous = Boolean.valueOf(formData.allowAnonymous);
		active = Boolean.valueOf(formData.active);
	}

	public MbmailinglistFormData toFormData() {
		if (mailingListId < 0) {
			mailingListId = 0L;
		}

		MbmailinglistFormData formData = new MbmailinglistFormData(
			uuid
			,
			String.valueOf(mailingListId)
			,
			String.valueOf(groupId)
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
			String.valueOf(categoryId)
			,
			emailAddress
			,
			inProtocol
			,
			inServerName
			,
			String.valueOf(inServerPort)
			,
			String.valueOf(inUseSSL)
			,
			inUserName
			,
			inPassword
			,
			String.valueOf(inReadInterval)
			,
			outEmailAddress
			,
			String.valueOf(outCustom)
			,
			outServerName
			,
			String.valueOf(outServerPort)
			,
			String.valueOf(outUseSSL)
			,
			outUserName
			,
			outPassword
			,
			String.valueOf(allowAnonymous)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
