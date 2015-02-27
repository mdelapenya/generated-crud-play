package controllers.customgroup;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Customgroup data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class CustomgroupFormData {

	public String mvccVersion;
	public String uuid;
	public String groupId;
	public String companyId;
	public String creatorUserId;
	public String classNameId;
	public String classPK;
	public String parentGroupId;
	public String liveGroupId;
	public String treePath;
	public String groupKey;
	public String name;
	public String description;
	public String customtype;
	public String typeSettings;
	public String manualMembership;
	public String membershipRestriction;
	public String friendlyURL;
	public String site;
	public String remoteStagingGroupCount;
	public String inheritContent;
	public String active;

	public CustomgroupFormData() {
	}

	public CustomgroupFormData(
		String mvccVersion,
				String uuid,
				String groupId,
				String companyId,
				String creatorUserId,
				String classNameId,
				String classPK,
				String parentGroupId,
				String liveGroupId,
				String treePath,
				String groupKey,
				String name,
				String description,
				String customtype,
				String typeSettings,
				String manualMembership,
				String membershipRestriction,
				String friendlyURL,
				String site,
				String remoteStagingGroupCount,
				String inheritContent,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.groupId = groupId;
		this.companyId = companyId;
		this.creatorUserId = creatorUserId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.parentGroupId = parentGroupId;
		this.liveGroupId = liveGroupId;
		this.treePath = treePath;
		this.groupKey = groupKey;
		this.name = name;
		this.description = description;
		this.customtype = customtype;
		this.typeSettings = typeSettings;
		this.manualMembership = manualMembership;
		this.membershipRestriction = membershipRestriction;
		this.friendlyURL = friendlyURL;
		this.site = site;
		this.remoteStagingGroupCount = remoteStagingGroupCount;
		this.inheritContent = inheritContent;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (groupId == null || groupId.length() == 0) {
			errors.add(new ValidationError("groupId", "No groupId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
