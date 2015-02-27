
package models.resourcetypepermission;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.resourcetypepermission.ResourcetypepermissionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Resourcetypepermission extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourceTypePermissionId;

	public long companyId;

	public long groupId;

	@Constraints.MaxLength(75)
	public String name;

	public long roleId;

	public long actionIds;


	// model finder attribute

	public static Finder<Long,Resourcetypepermission> find = new Finder<Long,Resourcetypepermission>(
		Long.class, Resourcetypepermission.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getResourceTypePermissionId() {
		return resourceTypePermissionId;
	}

	public void setResourceTypePermissionId(long resourceTypePermissionId) {
		this.resourceTypePermissionId = resourceTypePermissionId;
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

	public Resourcetypepermission(){
	}

	// constructor using a formData

	public Resourcetypepermission(ResourcetypepermissionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		resourceTypePermissionId = Long.valueOf(formData.resourceTypePermissionId);
		companyId = Long.valueOf(formData.companyId);
		groupId = Long.valueOf(formData.groupId);
		name = formData.name;
		roleId = Long.valueOf(formData.roleId);
		actionIds = Long.valueOf(formData.actionIds);
	}

	public ResourcetypepermissionFormData toFormData() {
		if (resourceTypePermissionId < 0) {
			resourceTypePermissionId = 0L;
		}

		ResourcetypepermissionFormData formData = new ResourcetypepermissionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(resourceTypePermissionId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(groupId)
			,
			name
			,
			String.valueOf(roleId)
			,
			String.valueOf(actionIds)
			
		);

		return formData;
	}

}
