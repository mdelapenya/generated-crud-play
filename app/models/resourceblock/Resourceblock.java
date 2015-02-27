
package models.resourceblock;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.resourceblock.ResourceblockFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Resourceblock extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourceBlockId;

	public long companyId;

	public long groupId;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String permissionsHash;

	public long referenceCount;


	// model finder attribute

	public static Finder<Long,Resourceblock> find = new Finder<Long,Resourceblock>(
		Long.class, Resourceblock.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getResourceBlockId() {
		return resourceBlockId;
	}

	public void setResourceBlockId(long resourceBlockId) {
		this.resourceBlockId = resourceBlockId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPermissionsHash() {
		return permissionsHash;
	}

	public void setPermissionsHash(String permissionsHash) {
		this.permissionsHash = permissionsHash;
	}
	public long getReferenceCount() {
		return referenceCount;
	}

	public void setReferenceCount(long referenceCount) {
		this.referenceCount = referenceCount;
	}

	public Resourceblock(){
	}

	// constructor using a formData

	public Resourceblock(ResourceblockFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		resourceBlockId = Long.valueOf(formData.resourceBlockId);
		companyId = Long.valueOf(formData.companyId);
		groupId = Long.valueOf(formData.groupId);
		name = formData.name;
		permissionsHash = formData.permissionsHash;
		referenceCount = Long.valueOf(formData.referenceCount);
	}

	public ResourceblockFormData toFormData() {
		if (resourceBlockId < 0) {
			resourceBlockId = 0L;
		}

		ResourceblockFormData formData = new ResourceblockFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(resourceBlockId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(groupId)
			,
			name
			,
			permissionsHash
			,
			String.valueOf(referenceCount)
			
		);

		return formData;
	}

}
