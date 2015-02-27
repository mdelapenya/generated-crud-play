
package models.resourcepermission;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.resourcepermission.ResourcepermissionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Resourcepermission extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourcePermissionId;

	public long companyId;

	@Constraints.MaxLength(255)
	public String name;

	public int scope;

	@Constraints.MaxLength(255)
	public String primKey;

	public long roleId;

	public long ownerId;

	public long actionIds;


	// model finder attribute

	public static Finder<Long,Resourcepermission> find = new Finder<Long,Resourcepermission>(
		Long.class, Resourcepermission.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getResourcePermissionId() {
		return resourcePermissionId;
	}

	public void setResourcePermissionId(long resourcePermissionId) {
		this.resourcePermissionId = resourcePermissionId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}
	public String getPrimKey() {
		return primKey;
	}

	public void setPrimKey(String primKey) {
		this.primKey = primKey;
	}
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public long getActionIds() {
		return actionIds;
	}

	public void setActionIds(long actionIds) {
		this.actionIds = actionIds;
	}

	public Resourcepermission(){
	}

	// constructor using a formData

	public Resourcepermission(ResourcepermissionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		resourcePermissionId = Long.valueOf(formData.resourcePermissionId);
		companyId = Long.valueOf(formData.companyId);
		name = formData.name;
		scope = Integer.valueOf(formData.scope);
		primKey = formData.primKey;
		roleId = Long.valueOf(formData.roleId);
		ownerId = Long.valueOf(formData.ownerId);
		actionIds = Long.valueOf(formData.actionIds);
	}

	public ResourcepermissionFormData toFormData() {
		if (resourcePermissionId < 0) {
			resourcePermissionId = 0L;
		}

		ResourcepermissionFormData formData = new ResourcepermissionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(resourcePermissionId)
			,
			String.valueOf(companyId)
			,
			name
			,
			String.valueOf(scope)
			,
			primKey
			,
			String.valueOf(roleId)
			,
			String.valueOf(ownerId)
			,
			String.valueOf(actionIds)
			
		);

		return formData;
	}

}
