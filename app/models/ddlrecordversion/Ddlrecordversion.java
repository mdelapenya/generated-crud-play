
package models.ddlrecordversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddlrecordversion.DdlrecordversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddlrecordversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long recordVersionId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long DDMStorageId;

	public long recordSetId;

	public long recordId;

	@Constraints.MaxLength(75)
	public String version;

	public int displayIndex;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Ddlrecordversion> find = new Finder<Long,Ddlrecordversion>(
		Long.class, Ddlrecordversion.class
	);

	// getters and setters

	public long getRecordVersionId() {
		return recordVersionId;
	}

	public void setRecordVersionId(long recordVersionId) {
		this.recordVersionId = recordVersionId;
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
	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
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

	public Ddlrecordversion(){
	}

	// constructor using a formData

	public Ddlrecordversion(DdlrecordversionFormData formData) {
		recordVersionId = Long.valueOf(formData.recordVersionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		DDMStorageId = Long.valueOf(formData.DDMStorageId);
		recordSetId = Long.valueOf(formData.recordSetId);
		recordId = Long.valueOf(formData.recordId);
		version = formData.version;
		displayIndex = Integer.valueOf(formData.displayIndex);
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public DdlrecordversionFormData toFormData() {
		if (recordVersionId < 0) {
			recordVersionId = 0L;
		}

		DdlrecordversionFormData formData = new DdlrecordversionFormData(
			String.valueOf(recordVersionId)
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
			String.valueOf(DDMStorageId)
			,
			String.valueOf(recordSetId)
			,
			String.valueOf(recordId)
			,
			version
			,
			String.valueOf(displayIndex)
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
