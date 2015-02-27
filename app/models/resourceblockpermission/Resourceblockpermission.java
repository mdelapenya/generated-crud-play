
package models.resourceblockpermission;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.resourceblockpermission.ResourceblockpermissionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Resourceblockpermission extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourceBlockPermissionId;

	public long resourceBlockId;

	public long roleId;

	public long actionIds;


	// model finder attribute

	public static Finder<Long,Resourceblockpermission> find = new Finder<Long,Resourceblockpermission>(
		Long.class, Resourceblockpermission.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getResourceBlockPermissionId() {
		return resourceBlockPermissionId;
	}

	public void setResourceBlockPermissionId(long resourceBlockPermissionId) {
		this.resourceBlockPermissionId = resourceBlockPermissionId;
	}
	public long getResourceBlockId() {
		return resourceBlockId;
	}

	public void setResourceBlockId(long resourceBlockId) {
		this.resourceBlockId = resourceBlockId;
	}
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getActionIds() {
		return actionIds;
	}

	public void setActionIds(long actionIds) {
		this.actionIds = actionIds;
	}

	public Resourceblockpermission(){
	}

	// constructor using a formData

	public Resourceblockpermission(ResourceblockpermissionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		resourceBlockPermissionId = Long.valueOf(formData.resourceBlockPermissionId);
		resourceBlockId = Long.valueOf(formData.resourceBlockId);
		roleId = Long.valueOf(formData.roleId);
		actionIds = Long.valueOf(formData.actionIds);
	}

	public ResourceblockpermissionFormData toFormData() {
		if (resourceBlockPermissionId < 0) {
			resourceBlockPermissionId = 0L;
		}

		ResourceblockpermissionFormData formData = new ResourceblockpermissionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(resourceBlockPermissionId)
			,
			String.valueOf(resourceBlockId)
			,
			String.valueOf(roleId)
			,
			String.valueOf(actionIds)
			
		);

		return formData;
	}

}
