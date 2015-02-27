
package models.scframeworkversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.scframeworkversion.ScframeworkversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Scframeworkversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long frameworkVersionId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String name;

	public String url;

	public boolean active;

	public int priority;


	// model finder attribute

	public static Finder<Long,Scframeworkversion> find = new Finder<Long,Scframeworkversion>(
		Long.class, Scframeworkversion.class
	);

	// getters and setters

	public long getFrameworkVersionId() {
		return frameworkVersionId;
	}

	public void setFrameworkVersionId(long frameworkVersionId) {
		this.frameworkVersionId = frameworkVersionId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Scframeworkversion(){
	}

	// constructor using a formData

	public Scframeworkversion(ScframeworkversionFormData formData) {
		frameworkVersionId = Long.valueOf(formData.frameworkVersionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		name = formData.name;
		url = formData.url;
		active = Boolean.valueOf(formData.active);
		priority = Integer.valueOf(formData.priority);
	}

	public ScframeworkversionFormData toFormData() {
		if (frameworkVersionId < 0) {
			frameworkVersionId = 0L;
		}

		ScframeworkversionFormData formData = new ScframeworkversionFormData(
			String.valueOf(frameworkVersionId)
			,
			String.valueOf(groupId)
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
			name
			,
			url
			,
			String.valueOf(active)
			,
			String.valueOf(priority)
			
		);

		return formData;
	}

}
