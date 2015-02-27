
package models.trashentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.trashentry.TrashentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Trashentry extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long entryId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long classNameId;

	public long classPK;

	public long systemEventSetKey;

	public String typeSettings;

	public int status;


	// model finder attribute

	public static Finder<Long,Trashentry> find = new Finder<Long,Trashentry>(
		Long.class, Trashentry.class
	);

	// getters and setters

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
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
	public long getSystemEventSetKey() {
		return systemEventSetKey;
	}

	public void setSystemEventSetKey(long systemEventSetKey) {
		this.systemEventSetKey = systemEventSetKey;
	}
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Trashentry(){
	}

	// constructor using a formData

	public Trashentry(TrashentryFormData formData) {
		entryId = Long.valueOf(formData.entryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		systemEventSetKey = Long.valueOf(formData.systemEventSetKey);
		typeSettings = formData.typeSettings;
		status = Integer.valueOf(formData.status);
	}

	public TrashentryFormData toFormData() {
		if (entryId < 0) {
			entryId = 0L;
		}

		TrashentryFormData formData = new TrashentryFormData(
			String.valueOf(entryId)
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
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(systemEventSetKey)
			,
			typeSettings
			,
			String.valueOf(status)
			
		);

		return formData;
	}

}
