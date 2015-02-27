
package models.repositoryentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.repositoryentry.RepositoryentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Repositoryentry extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long repositoryEntryId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long repositoryId;

	@Constraints.MaxLength(255)
	public String mappedId;

	public boolean manualCheckInRequired;


	// model finder attribute

	public static Finder<Long,Repositoryentry> find = new Finder<Long,Repositoryentry>(
		Long.class, Repositoryentry.class
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
	public long getRepositoryEntryId() {
		return repositoryEntryId;
	}

	public void setRepositoryEntryId(long repositoryEntryId) {
		this.repositoryEntryId = repositoryEntryId;
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
	public long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		this.repositoryId = repositoryId;
	}
	public String getMappedId() {
		return mappedId;
	}

	public void setMappedId(String mappedId) {
		this.mappedId = mappedId;
	}
	public boolean getManualCheckInRequired() {
		return manualCheckInRequired;
	}

	public void setManualCheckInRequired(boolean manualCheckInRequired) {
		this.manualCheckInRequired = manualCheckInRequired;
	}

	public Repositoryentry(){
	}

	// constructor using a formData

	public Repositoryentry(RepositoryentryFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		repositoryEntryId = Long.valueOf(formData.repositoryEntryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		repositoryId = Long.valueOf(formData.repositoryId);
		mappedId = formData.mappedId;
		manualCheckInRequired = Boolean.valueOf(formData.manualCheckInRequired);
	}

	public RepositoryentryFormData toFormData() {
		if (repositoryEntryId < 0) {
			repositoryEntryId = 0L;
		}

		RepositoryentryFormData formData = new RepositoryentryFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(repositoryEntryId)
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
			String.valueOf(repositoryId)
			,
			mappedId
			,
			String.valueOf(manualCheckInRequired)
			
		);

		return formData;
	}

}
