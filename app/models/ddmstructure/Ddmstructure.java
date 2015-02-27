
package models.ddmstructure;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmstructure.DdmstructureFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmstructure extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long structureId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentStructureId;

	public long classNameId;

	@Constraints.MaxLength(75)
	public String structureKey;

	@Constraints.MaxLength(75)
	public String version;

	public String name;

	public String description;

	public String definition;

	@Constraints.MaxLength(75)
	public String storageType;

	public int customtype;


	// model finder attribute

	public static Finder<Long,Ddmstructure> find = new Finder<Long,Ddmstructure>(
		Long.class, Ddmstructure.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
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
	public long getParentStructureId() {
		return parentStructureId;
	}

	public void setParentStructureId(long parentStructureId) {
		this.parentStructureId = parentStructureId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public String getStructureKey() {
		return structureKey;
	}

	public void setStructureKey(String structureKey) {
		this.structureKey = structureKey;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}

	public Ddmstructure(){
	}

	// constructor using a formData

	public Ddmstructure(DdmstructureFormData formData) {
		uuid = formData.uuid;
		structureId = Long.valueOf(formData.structureId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentStructureId = Long.valueOf(formData.parentStructureId);
		classNameId = Long.valueOf(formData.classNameId);
		structureKey = formData.structureKey;
		version = formData.version;
		name = formData.name;
		description = formData.description;
		definition = formData.definition;
		storageType = formData.storageType;
		customtype = Integer.valueOf(formData.customtype);
	}

	public DdmstructureFormData toFormData() {
		if (structureId < 0) {
			structureId = 0L;
		}

		DdmstructureFormData formData = new DdmstructureFormData(
			uuid
			,
			String.valueOf(structureId)
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
			String.valueOf(parentStructureId)
			,
			String.valueOf(classNameId)
			,
			structureKey
			,
			version
			,
			name
			,
			description
			,
			definition
			,
			storageType
			,
			String.valueOf(customtype)
			
		);

		return formData;
	}

}
