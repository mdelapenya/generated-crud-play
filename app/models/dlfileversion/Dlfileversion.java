
package models.dlfileversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfileversion.DlfileversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfileversion extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileVersionId;

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

	public long fileEntryId;

	public String treePath;

	@Constraints.MaxLength(255)
	public String fileName;

	@Constraints.MaxLength(75)
	public String extension;

	@Constraints.MaxLength(75)
	public String mimeType;

	@Constraints.MaxLength(255)
	public String title;

	public String description;

	@Constraints.MaxLength(75)
	public String changeLog;

	public String extraSettings;

	public long fileEntryTypeId;

	@Constraints.MaxLength(75)
	public String version;

	public long size;

	@Constraints.MaxLength(75)
	public String checksum;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Dlfileversion> find = new Finder<Long,Dlfileversion>(
		Long.class, Dlfileversion.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFileVersionId() {
		return fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		this.fileVersionId = fileVersionId;
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
	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(String changeLog) {
		this.changeLog = changeLog;
	}
	public String getExtraSettings() {
		return extraSettings;
	}

	public void setExtraSettings(String extraSettings) {
		this.extraSettings = extraSettings;
	}
	public long getFileEntryTypeId() {
		return fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		this.fileEntryTypeId = fileEntryTypeId;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
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

	public Dlfileversion(){
	}

	// constructor using a formData

	public Dlfileversion(DlfileversionFormData formData) {
		uuid = formData.uuid;
		fileVersionId = Long.valueOf(formData.fileVersionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		repositoryId = Long.valueOf(formData.repositoryId);
		folderId = Long.valueOf(formData.folderId);
		fileEntryId = Long.valueOf(formData.fileEntryId);
		treePath = formData.treePath;
		fileName = formData.fileName;
		extension = formData.extension;
		mimeType = formData.mimeType;
		title = formData.title;
		description = formData.description;
		changeLog = formData.changeLog;
		extraSettings = formData.extraSettings;
		fileEntryTypeId = Long.valueOf(formData.fileEntryTypeId);
		version = formData.version;
		size = Long.valueOf(formData.size);
		checksum = formData.checksum;
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public DlfileversionFormData toFormData() {
		if (fileVersionId < 0) {
			fileVersionId = 0L;
		}

		DlfileversionFormData formData = new DlfileversionFormData(
			uuid
			,
			String.valueOf(fileVersionId)
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
			String.valueOf(fileEntryId)
			,
			treePath
			,
			fileName
			,
			extension
			,
			mimeType
			,
			title
			,
			description
			,
			changeLog
			,
			extraSettings
			,
			String.valueOf(fileEntryTypeId)
			,
			version
			,
			String.valueOf(size)
			,
			checksum
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
