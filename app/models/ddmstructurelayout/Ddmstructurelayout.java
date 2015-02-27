
package models.ddmstructurelayout;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmstructurelayout.DdmstructurelayoutFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmstructurelayout extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long structureLayoutId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long structureVersionId;

	public String definition;


	// model finder attribute

	public static Finder<Long,Ddmstructurelayout> find = new Finder<Long,Ddmstructurelayout>(
		Long.class, Ddmstructurelayout.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getStructureLayoutId() {
		return structureLayoutId;
	}

	public void setStructureLayoutId(long structureLayoutId) {
		this.structureLayoutId = structureLayoutId;
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
	public long getStructureVersionId() {
		return structureVersionId;
	}

	public void setStructureVersionId(long structureVersionId) {
		this.structureVersionId = structureVersionId;
	}
	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Ddmstructurelayout(){
	}

	// constructor using a formData

	public Ddmstructurelayout(DdmstructurelayoutFormData formData) {
		uuid = formData.uuid;
		structureLayoutId = Long.valueOf(formData.structureLayoutId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		structureVersionId = Long.valueOf(formData.structureVersionId);
		definition = formData.definition;
	}

	public DdmstructurelayoutFormData toFormData() {
		if (structureLayoutId < 0) {
			structureLayoutId = 0L;
		}

		DdmstructurelayoutFormData formData = new DdmstructurelayoutFormData(
			uuid
			,
			String.valueOf(structureLayoutId)
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
			String.valueOf(structureVersionId)
			,
			definition
			
		);

		return formData;
	}

}
