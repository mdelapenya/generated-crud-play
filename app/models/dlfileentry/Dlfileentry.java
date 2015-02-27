
package models.dlfileentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfileentry.DlfileentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfileentry extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileEntryId;

	public long groupId;

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

	public long repositoryId;

	public long folderId;

	public String treePath;

	@Constraints.MaxLength(255)
	public String name;

	@Constraints.MaxLength(255)
	public String fileName;

	@Constraints.MaxLength(75)
	public String extension;

	@Constraints.MaxLength(75)
	public String mimeType;

	@Constraints.MaxLength(255)
	public String title;

	public String description;

	public String extraSettings;

	public long fileEntryTypeId;

	@Constraints.MaxLength(75)
	public String version;

	public long size;

	public int readCount;

	public long smallImageId;

	public long largeImageId;

	public long custom1ImageId;

	public long custom2ImageId;

	public boolean manualCheckInRequired;


	// model finder attribute

	public static Finder<Long,Dlfileentry> find = new Finder<Long,Dlfileentry>(
		Long.class, Dlfileentry.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
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
	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public long getSmallImageId() {
		return smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		this.smallImageId = smallImageId;
	}
	public long getLargeImageId() {
		return largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		this.largeImageId = largeImageId;
	}
	public long getCustom1ImageId() {
		return custom1ImageId;
	}

	public void setCustom1ImageId(long custom1ImageId) {
		this.custom1ImageId = custom1ImageId;
	}
	public long getCustom2ImageId() {
		return custom2ImageId;
	}

	public void setCustom2ImageId(long custom2ImageId) {
		this.custom2ImageId = custom2ImageId;
	}
	public boolean getManualCheckInRequired() {
		return manualCheckInRequired;
	}

	public void setManualCheckInRequired(boolean manualCheckInRequired) {
		this.manualCheckInRequired = manualCheckInRequired;
	}

	public Dlfileentry(){
	}

	// constructor using a formData

	public Dlfileentry(DlfileentryFormData formData) {
		uuid = formData.uuid;
		fileEntryId = Long.valueOf(formData.fileEntryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		repositoryId = Long.valueOf(formData.repositoryId);
		folderId = Long.valueOf(formData.folderId);
		treePath = formData.treePath;
		name = formData.name;
		fileName = formData.fileName;
		extension = formData.extension;
		mimeType = formData.mimeType;
		title = formData.title;
		description = formData.description;
		extraSettings = formData.extraSettings;
		fileEntryTypeId = Long.valueOf(formData.fileEntryTypeId);
		version = formData.version;
		size = Long.valueOf(formData.size);
		readCount = Integer.valueOf(formData.readCount);
		smallImageId = Long.valueOf(formData.smallImageId);
		largeImageId = Long.valueOf(formData.largeImageId);
		custom1ImageId = Long.valueOf(formData.custom1ImageId);
		custom2ImageId = Long.valueOf(formData.custom2ImageId);
		manualCheckInRequired = Boolean.valueOf(formData.manualCheckInRequired);
	}

	public DlfileentryFormData toFormData() {
		if (fileEntryId < 0) {
			fileEntryId = 0L;
		}

		DlfileentryFormData formData = new DlfileentryFormData(
			uuid
			,
			String.valueOf(fileEntryId)
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
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(repositoryId)
			,
			String.valueOf(folderId)
			,
			treePath
			,
			name
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
			extraSettings
			,
			String.valueOf(fileEntryTypeId)
			,
			version
			,
			String.valueOf(size)
			,
			String.valueOf(readCount)
			,
			String.valueOf(smallImageId)
			,
			String.valueOf(largeImageId)
			,
			String.valueOf(custom1ImageId)
			,
			String.valueOf(custom2ImageId)
			,
			String.valueOf(manualCheckInRequired)
			
		);

		return formData;
	}

}
