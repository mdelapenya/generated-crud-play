
package models.systemevent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.systemevent.SystemeventFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Systemevent extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long systemEventId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long classNameId;

	public long classPK;

	@Constraints.MaxLength(75)
	public String classUuid;

	public long referrerClassNameId;

	public long parentSystemEventId;

	public long systemEventSetKey;

	public int customtype;

	public String extraData;


	// model finder attribute

	public static Finder<Long,Systemevent> find = new Finder<Long,Systemevent>(
		Long.class, Systemevent.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getSystemEventId() {
		return systemEventId;
	}

	public void setSystemEventId(long systemEventId) {
		this.systemEventId = systemEventId;
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
	public String getClassUuid() {
		return classUuid;
	}

	public void setClassUuid(String classUuid) {
		this.classUuid = classUuid;
	}
	public long getReferrerClassNameId() {
		return referrerClassNameId;
	}

	public void setReferrerClassNameId(long referrerClassNameId) {
		this.referrerClassNameId = referrerClassNameId;
	}
	public long getParentSystemEventId() {
		return parentSystemEventId;
	}

	public void setParentSystemEventId(long parentSystemEventId) {
		this.parentSystemEventId = parentSystemEventId;
	}
	public long getSystemEventSetKey() {
		return systemEventSetKey;
	}

	public void setSystemEventSetKey(long systemEventSetKey) {
		this.systemEventSetKey = systemEventSetKey;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public Systemevent(){
	}

	// constructor using a formData

	public Systemevent(SystemeventFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		systemEventId = Long.valueOf(formData.systemEventId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		classUuid = formData.classUuid;
		referrerClassNameId = Long.valueOf(formData.referrerClassNameId);
		parentSystemEventId = Long.valueOf(formData.parentSystemEventId);
		systemEventSetKey = Long.valueOf(formData.systemEventSetKey);
		customtype = Integer.valueOf(formData.customtype);
		extraData = formData.extraData;
	}

	public SystemeventFormData toFormData() {
		if (systemEventId < 0) {
			systemEventId = 0L;
		}

		SystemeventFormData formData = new SystemeventFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(systemEventId)
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
			classUuid
			,
			String.valueOf(referrerClassNameId)
			,
			String.valueOf(parentSystemEventId)
			,
			String.valueOf(systemEventSetKey)
			,
			String.valueOf(customtype)
			,
			extraData
			
		);

		return formData;
	}

}
