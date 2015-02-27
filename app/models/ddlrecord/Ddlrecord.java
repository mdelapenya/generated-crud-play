
package models.ddlrecord;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddlrecord.DdlrecordFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddlrecord extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long recordId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	public long versionUserId;

	@Constraints.MaxLength(75)
	public String versionUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long DDMStorageId;

	public long recordSetId;

	@Constraints.MaxLength(75)
	public String version;

	public int displayIndex;


	// model finder attribute

	public static Finder<Long,Ddlrecord> find = new Finder<Long,Ddlrecord>(
		Long.class, Ddlrecord.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
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
	public long getVersionUserId() {
		return versionUserId;
	}

	public void setVersionUserId(long versionUserId) {
		this.versionUserId = versionUserId;
	}
	public String getVersionUserName() {
		return versionUserName;
	}

	public void setVersionUserName(String versionUserName) {
		this.versionUserName = versionUserName;
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
	public long getDDMStorageId() {
		return DDMStorageId;
	}

	public void setDDMStorageId(long DDMStorageId) {
		this.DDMStorageId = DDMStorageId;
	}
	public long getRecordSetId() {
		return recordSetId;
	}

	public void setRecordSetId(long recordSetId) {
		this.recordSetId = recordSetId;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public int getDisplayIndex() {
		return displayIndex;
	}

	public void setDisplayIndex(int displayIndex) {
		this.displayIndex = displayIndex;
	}

	public Ddlrecord(){
	}

	// constructor using a formData

	public Ddlrecord(DdlrecordFormData formData) {
		uuid = formData.uuid;
		recordId = Long.valueOf(formData.recordId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		versionUserId = Long.valueOf(formData.versionUserId);
		versionUserName = formData.versionUserName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		DDMStorageId = Long.valueOf(formData.DDMStorageId);
		recordSetId = Long.valueOf(formData.recordSetId);
		version = formData.version;
		displayIndex = Integer.valueOf(formData.displayIndex);
	}

	public DdlrecordFormData toFormData() {
		if (recordId < 0) {
			recordId = 0L;
		}

		DdlrecordFormData formData = new DdlrecordFormData(
			uuid
			,
			String.valueOf(recordId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(versionUserId)
			,
			versionUserName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(DDMStorageId)
			,
			String.valueOf(recordSetId)
			,
			version
			,
			String.valueOf(displayIndex)
			
		);

		return formData;
	}

}
