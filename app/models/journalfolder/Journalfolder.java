
package models.journalfolder;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalfolder.JournalfolderFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalfolder extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long folderId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentFolderId;

	public String treePath;

	@Constraints.MaxLength(100)
	public String name;

	public String description;

	public int restrictionType;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Journalfolder> find = new Finder<Long,Journalfolder>(
		Long.class, Journalfolder.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
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
	public long getParentFolderId() {
		return parentFolderId;
	}

	public void setParentFolderId(long parentFolderId) {
		this.parentFolderId = parentFolderId;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getRestrictionType() {
		return restrictionType;
	}

	public void setRestrictionType(int restrictionType) {
		this.restrictionType = restrictionType;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public long getStatusByUserId() {
		return statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		this.statusByUserId = statusByUserId;
	}
	public String getStatusByUserName() {
		return statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		this.statusByUserName = statusByUserName;
	}
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Journalfolder(){
	}

	// constructor using a formData

	public Journalfolder(JournalfolderFormData formData) {
		uuid = formData.uuid;
		folderId = Long.valueOf(formData.folderId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentFolderId = Long.valueOf(formData.parentFolderId);
		treePath = formData.treePath;
		name = formData.name;
		description = formData.description;
		restrictionType = Integer.valueOf(formData.restrictionType);
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public JournalfolderFormData toFormData() {
		if (folderId < 0) {
			folderId = 0L;
		}

		JournalfolderFormData formData = new JournalfolderFormData(
			uuid
			,
			String.valueOf(folderId)
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
			String.valueOf(parentFolderId)
			,
			treePath
			,
			name
			,
			description
			,
			String.valueOf(restrictionType)
			,
			String.valueOf(status)
			,
			String.valueOf(statusByUserId)
			,
			statusByUserName
			,
			String.valueOf(statusDate)
			
		);

		return formData;
	}

}
