
package models.organization;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.organization.OrganizationFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Organization extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long organizationId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentOrganizationId;

	public String treePath;

	@Constraints.MaxLength(100)
	public String name;

	@Constraints.MaxLength(75)
	public String customtype;

	public boolean recursable;

	public long regionId;

	public long countryId;

	public long statusId;

	public String comments;

	public long logoId;


	// model finder attribute

	public static Finder<Long,Organization> find = new Finder<Long,Organization>(
		Long.class, Organization.class
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
	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
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
	public long getParentOrganizationId() {
		return parentOrganizationId;
	}

	public void setParentOrganizationId(long parentOrganizationId) {
		this.parentOrganizationId = parentOrganizationId;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public boolean getRecursable() {
		return recursable;
	}

	public void setRecursable(boolean recursable) {
		this.recursable = recursable;
	}
	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getLogoId() {
		return logoId;
	}

	public void setLogoId(long logoId) {
		this.logoId = logoId;
	}

	public Organization(){
	}

	// constructor using a formData

	public Organization(OrganizationFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		organizationId = Long.valueOf(formData.organizationId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentOrganizationId = Long.valueOf(formData.parentOrganizationId);
		treePath = formData.treePath;
		name = formData.name;
		customtype = formData.customtype;
		recursable = Boolean.valueOf(formData.recursable);
		regionId = Long.valueOf(formData.regionId);
		countryId = Long.valueOf(formData.countryId);
		statusId = Long.valueOf(formData.statusId);
		comments = formData.comments;
		logoId = Long.valueOf(formData.logoId);
	}

	public OrganizationFormData toFormData() {
		if (organizationId < 0) {
			organizationId = 0L;
		}

		OrganizationFormData formData = new OrganizationFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(organizationId)
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
			String.valueOf(parentOrganizationId)
			,
			treePath
			,
			name
			,
			customtype
			,
			String.valueOf(recursable)
			,
			String.valueOf(regionId)
			,
			String.valueOf(countryId)
			,
			String.valueOf(statusId)
			,
			comments
			,
			String.valueOf(logoId)
			
		);

		return formData;
	}

}
