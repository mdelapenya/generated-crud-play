
package models.ddmstructureversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmstructureversion.DdmstructureversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmstructureversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long structureVersionId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long structureId;

	@Constraints.MaxLength(75)
	public String version;

	public String name;

	public String description;

	public String definition;

	@Constraints.MaxLength(75)
	public String storageType;

	public int customtype;


	// model finder attribute

	public static Finder<Long,Ddmstructureversion> find = new Finder<Long,Ddmstructureversion>(
		Long.class, Ddmstructureversion.class
	);

	// getters and setters

	public long getStructureVersionId() {
		return structureVersionId;
	}

	public void setStructureVersionId(long structureVersionId) {
		this.structureVersionId = structureVersionId;
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
	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
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

	public Ddmstructureversion(){
	}

	// constructor using a formData

	public Ddmstructureversion(DdmstructureversionFormData formData) {
		structureVersionId = Long.valueOf(formData.structureVersionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		structureId = Long.valueOf(formData.structureId);
		version = formData.version;
		name = formData.name;
		description = formData.description;
		definition = formData.definition;
		storageType = formData.storageType;
		customtype = Integer.valueOf(formData.customtype);
	}

	public DdmstructureversionFormData toFormData() {
		if (structureVersionId < 0) {
			structureVersionId = 0L;
		}

		DdmstructureversionFormData formData = new DdmstructureversionFormData(
			String.valueOf(structureVersionId)
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
			String.valueOf(structureId)
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
