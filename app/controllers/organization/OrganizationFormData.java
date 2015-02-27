package controllers.organization;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Organization data form.
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
public class OrganizationFormData {

	public String mvccVersion;
	public String uuid;
	public String organizationId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentOrganizationId;
	public String treePath;
	public String name;
	public String customtype;
	public String recursable;
	public String regionId;
	public String countryId;
	public String statusId;
	public String comments;
	public String logoId;

	public OrganizationFormData() {
	}

	public OrganizationFormData(
		String mvccVersion,
				String uuid,
				String organizationId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentOrganizationId,
				String treePath,
				String name,
				String customtype,
				String recursable,
				String regionId,
				String countryId,
				String statusId,
				String comments,
				String logoId
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.organizationId = organizationId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentOrganizationId = parentOrganizationId;
		this.treePath = treePath;
		this.name = name;
		this.customtype = customtype;
		this.recursable = recursable;
		this.regionId = regionId;
		this.countryId = countryId;
		this.statusId = statusId;
		this.comments = comments;
		this.logoId = logoId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (organizationId == null || organizationId.length() == 0) {
			errors.add(new ValidationError("organizationId", "No organizationId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
