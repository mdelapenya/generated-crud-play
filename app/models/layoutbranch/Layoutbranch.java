
package models.layoutbranch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layoutbranch.LayoutbranchFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layoutbranch extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long layoutBranchId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	public long layoutSetBranchId;

	public long plid;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	public boolean master;


	// model finder attribute

	public static Finder<Long,Layoutbranch> find = new Finder<Long,Layoutbranch>(
		Long.class, Layoutbranch.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getLayoutBranchId() {
		return layoutBranchId;
	}

	public void setLayoutBranchId(long layoutBranchId) {
		this.layoutBranchId = layoutBranchId;
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
	public long getLayoutSetBranchId() {
		return layoutSetBranchId;
	}

	public void setLayoutSetBranchId(long layoutSetBranchId) {
		this.layoutSetBranchId = layoutSetBranchId;
	}
	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
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
	public boolean getMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public Layoutbranch(){
	}

	// constructor using a formData

	public Layoutbranch(LayoutbranchFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		layoutBranchId = Long.valueOf(formData.layoutBranchId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		layoutSetBranchId = Long.valueOf(formData.layoutSetBranchId);
		plid = Long.valueOf(formData.plid);
		name = formData.name;
		description = formData.description;
		master = Boolean.valueOf(formData.master);
	}

	public LayoutbranchFormData toFormData() {
		if (layoutBranchId < 0) {
			layoutBranchId = 0L;
		}

		LayoutbranchFormData formData = new LayoutbranchFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(layoutBranchId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(layoutSetBranchId)
			,
			String.valueOf(plid)
			,
			name
			,
			description
			,
			String.valueOf(master)
			
		);

		return formData;
	}

}
