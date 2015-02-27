
package models.usergroup;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.usergroup.UsergroupFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Usergroup extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userGroupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentUserGroupId;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	public boolean addedByLDAPImport;


	// model finder attribute

	public static Finder<Long,Usergroup> find = new Finder<Long,Usergroup>(
		Long.class, Usergroup.class
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
	public long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
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
	public long getParentUserGroupId() {
		return parentUserGroupId;
	}

	public void setParentUserGroupId(long parentUserGroupId) {
		this.parentUserGroupId = parentUserGroupId;
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
	public boolean getAddedByLDAPImport() {
		return addedByLDAPImport;
	}

	public void setAddedByLDAPImport(boolean addedByLDAPImport) {
		this.addedByLDAPImport = addedByLDAPImport;
	}

	public Usergroup(){
	}

	// constructor using a formData

	public Usergroup(UsergroupFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		userGroupId = Long.valueOf(formData.userGroupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentUserGroupId = Long.valueOf(formData.parentUserGroupId);
		name = formData.name;
		description = formData.description;
		addedByLDAPImport = Boolean.valueOf(formData.addedByLDAPImport);
	}

	public UsergroupFormData toFormData() {
		if (userGroupId < 0) {
			userGroupId = 0L;
		}

		UsergroupFormData formData = new UsergroupFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(userGroupId)
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
			String.valueOf(parentUserGroupId)
			,
			name
			,
			description
			,
			String.valueOf(addedByLDAPImport)
			
		);

		return formData;
	}

}
