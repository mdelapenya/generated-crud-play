
package models.dlfileentrytype;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfileentrytype.DlfileentrytypeFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfileentrytype extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileEntryTypeId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String fileEntryTypeKey;

	public String name;

	public String description;


	// model finder attribute

	public static Finder<Long,Dlfileentrytype> find = new Finder<Long,Dlfileentrytype>(
		Long.class, Dlfileentrytype.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFileEntryTypeId() {
		return fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		this.fileEntryTypeId = fileEntryTypeId;
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
	public String getFileEntryTypeKey() {
		return fileEntryTypeKey;
	}

	public void setFileEntryTypeKey(String fileEntryTypeKey) {
		this.fileEntryTypeKey = fileEntryTypeKey;
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

	public Dlfileentrytype(){
	}

	// constructor using a formData

	public Dlfileentrytype(DlfileentrytypeFormData formData) {
		uuid = formData.uuid;
		fileEntryTypeId = Long.valueOf(formData.fileEntryTypeId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		fileEntryTypeKey = formData.fileEntryTypeKey;
		name = formData.name;
		description = formData.description;
	}

	public DlfileentrytypeFormData toFormData() {
		if (fileEntryTypeId < 0) {
			fileEntryTypeId = 0L;
		}

		DlfileentrytypeFormData formData = new DlfileentrytypeFormData(
			uuid
			,
			String.valueOf(fileEntryTypeId)
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
			fileEntryTypeKey
			,
			name
			,
			description
			
		);

		return formData;
	}

}
