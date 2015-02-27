
package models.customgroup;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.customgroup.CustomgroupFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Customgroup extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long groupId;

	public long companyId;

	public long creatorUserId;

	public long classNameId;

	public long classPK;

	public long parentGroupId;

	public long liveGroupId;

	public String treePath;

	@Constraints.MaxLength(150)
	public String groupKey;

	public String name;

	public String description;

	public int customtype;

	public String typeSettings;

	public boolean manualMembership;

	public int membershipRestriction;

	@Constraints.MaxLength(255)
	public String friendlyURL;

	public boolean site;

	public int remoteStagingGroupCount;

	public boolean inheritContent;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Customgroup> find = new Finder<Long,Customgroup>(
		Long.class, Customgroup.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public long getParentGroupId() {
		return parentGroupId;
	}

	public void setParentGroupId(long parentGroupId) {
		this.parentGroupId = parentGroupId;
	}
	public long getLiveGroupId() {
		return liveGroupId;
	}

	public void setLiveGroupId(long liveGroupId) {
		this.liveGroupId = liveGroupId;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
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
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
	}
	public boolean getManualMembership() {
		return manualMembership;
	}

	public void setManualMembership(boolean manualMembership) {
		this.manualMembership = manualMembership;
	}
	public int getMembershipRestriction() {
		return membershipRestriction;
	}

	public void setMembershipRestriction(int membershipRestriction) {
		this.membershipRestriction = membershipRestriction;
	}
	public String getFriendlyURL() {
		return friendlyURL;
	}

	public void setFriendlyURL(String friendlyURL) {
		this.friendlyURL = friendlyURL;
	}
	public boolean getSite() {
		return site;
	}

	public void setSite(boolean site) {
		this.site = site;
	}
	public int getRemoteStagingGroupCount() {
		return remoteStagingGroupCount;
	}

	public void setRemoteStagingGroupCount(int remoteStagingGroupCount) {
		this.remoteStagingGroupCount = remoteStagingGroupCount;
	}
	public boolean getInheritContent() {
		return inheritContent;
	}

	public void setInheritContent(boolean inheritContent) {
		this.inheritContent = inheritContent;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Customgroup(){
	}

	// constructor using a formData

	public Customgroup(CustomgroupFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		creatorUserId = Long.valueOf(formData.creatorUserId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		parentGroupId = Long.valueOf(formData.parentGroupId);
		liveGroupId = Long.valueOf(formData.liveGroupId);
		treePath = formData.treePath;
		groupKey = formData.groupKey;
		name = formData.name;
		description = formData.description;
		customtype = Integer.valueOf(formData.customtype);
		typeSettings = formData.typeSettings;
		manualMembership = Boolean.valueOf(formData.manualMembership);
		membershipRestriction = Integer.valueOf(formData.membershipRestriction);
		friendlyURL = formData.friendlyURL;
		site = Boolean.valueOf(formData.site);
		remoteStagingGroupCount = Integer.valueOf(formData.remoteStagingGroupCount);
		inheritContent = Boolean.valueOf(formData.inheritContent);
		active = Boolean.valueOf(formData.active);
	}

	public CustomgroupFormData toFormData() {
		if (groupId < 0) {
			groupId = 0L;
		}

		CustomgroupFormData formData = new CustomgroupFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(creatorUserId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(parentGroupId)
			,
			String.valueOf(liveGroupId)
			,
			treePath
			,
			groupKey
			,
			name
			,
			description
			,
			String.valueOf(customtype)
			,
			typeSettings
			,
			String.valueOf(manualMembership)
			,
			String.valueOf(membershipRestriction)
			,
			friendlyURL
			,
			String.valueOf(site)
			,
			String.valueOf(remoteStagingGroupCount)
			,
			String.valueOf(inheritContent)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
