
package models.dlfileshortcut;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfileshortcut.DlfileshortcutFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfileshortcut extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileShortcutId;

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

	public long folderId;

	public long toFileEntryId;

	public String treePath;

	public boolean active;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Dlfileshortcut> find = new Finder<Long,Dlfileshortcut>(
		Long.class, Dlfileshortcut.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFileShortcutId() {
		return fileShortcutId;
	}

	public void setFileShortcutId(long fileShortcutId) {
		this.fileShortcutId = fileShortcutId;
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
	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}
	public long getToFileEntryId() {
		return toFileEntryId;
	}

	public void setToFileEntryId(long toFileEntryId) {
		this.toFileEntryId = toFileEntryId;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public Dlfileshortcut(){
	}

	// constructor using a formData

	public Dlfileshortcut(DlfileshortcutFormData formData) {
		uuid = formData.uuid;
		fileShortcutId = Long.valueOf(formData.fileShortcutId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		repositoryId = Long.valueOf(formData.repositoryId);
		folderId = Long.valueOf(formData.folderId);
		toFileEntryId = Long.valueOf(formData.toFileEntryId);
		treePath = formData.treePath;
		active = Boolean.valueOf(formData.active);
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public DlfileshortcutFormData toFormData() {
		if (fileShortcutId < 0) {
			fileShortcutId = 0L;
		}

		DlfileshortcutFormData formData = new DlfileshortcutFormData(
			uuid
			,
			String.valueOf(fileShortcutId)
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
			String.valueOf(folderId)
			,
			String.valueOf(toFileEntryId)
			,
			treePath
			,
			String.valueOf(active)
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
