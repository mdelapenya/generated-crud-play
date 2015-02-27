
package models.ddlrecordset;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddlrecordset.DdlrecordsetFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddlrecordset extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long recordSetId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long DDMStructureId;

	@Constraints.MaxLength(75)
	public String recordSetKey;

	public String name;

	public String description;

	public int minDisplayRows;

	public int scope;


	// model finder attribute

	public static Finder<Long,Ddlrecordset> find = new Finder<Long,Ddlrecordset>(
		Long.class, Ddlrecordset.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRecordSetId() {
		return recordSetId;
	}

	public void setRecordSetId(long recordSetId) {
		this.recordSetId = recordSetId;
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
	public long getDDMStructureId() {
		return DDMStructureId;
	}

	public void setDDMStructureId(long DDMStructureId) {
		this.DDMStructureId = DDMStructureId;
	}
	public String getRecordSetKey() {
		return recordSetKey;
	}

	public void setRecordSetKey(String recordSetKey) {
		this.recordSetKey = recordSetKey;
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
	public int getMinDisplayRows() {
		return minDisplayRows;
	}

	public void setMinDisplayRows(int minDisplayRows) {
		this.minDisplayRows = minDisplayRows;
	}
	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public Ddlrecordset(){
	}

	// constructor using a formData

	public Ddlrecordset(DdlrecordsetFormData formData) {
		uuid = formData.uuid;
		recordSetId = Long.valueOf(formData.recordSetId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		DDMStructureId = Long.valueOf(formData.DDMStructureId);
		recordSetKey = formData.recordSetKey;
		name = formData.name;
		description = formData.description;
		minDisplayRows = Integer.valueOf(formData.minDisplayRows);
		scope = Integer.valueOf(formData.scope);
	}

	public DdlrecordsetFormData toFormData() {
		if (recordSetId < 0) {
			recordSetId = 0L;
		}

		DdlrecordsetFormData formData = new DdlrecordsetFormData(
			uuid
			,
			String.valueOf(recordSetId)
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
			String.valueOf(DDMStructureId)
			,
			recordSetKey
			,
			name
			,
			description
			,
			String.valueOf(minDisplayRows)
			,
			String.valueOf(scope)
			
		);

		return formData;
	}

}
