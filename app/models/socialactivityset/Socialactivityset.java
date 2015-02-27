
package models.socialactivityset;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivityset.SocialactivitysetFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivityset extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activitySetId;

	public long groupId;

	public long companyId;

	public long userId;

	public long createDate;

	public long modifiedDate;

	public long classNameId;

	public long classPK;

	public int customtype;

	public String extraData;

	public int activityCount;


	// model finder attribute

	public static Finder<Long,Socialactivityset> find = new Finder<Long,Socialactivityset>(
		Long.class, Socialactivityset.class
	);

	// getters and setters

	public long getActivitySetId() {
		return activitySetId;
	}

	public void setActivitySetId(long activitySetId) {
		this.activitySetId = activitySetId;
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
	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
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
	public int getActivityCount() {
		return activityCount;
	}

	public void setActivityCount(int activityCount) {
		this.activityCount = activityCount;
	}

	public Socialactivityset(){
	}

	// constructor using a formData

	public Socialactivityset(SocialactivitysetFormData formData) {
		activitySetId = Long.valueOf(formData.activitySetId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = Long.valueOf(formData.createDate);
		modifiedDate = Long.valueOf(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		customtype = Integer.valueOf(formData.customtype);
		extraData = formData.extraData;
		activityCount = Integer.valueOf(formData.activityCount);
	}

	public SocialactivitysetFormData toFormData() {
		if (activitySetId < 0) {
			activitySetId = 0L;
		}

		SocialactivitysetFormData formData = new SocialactivitysetFormData(
			String.valueOf(activitySetId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(customtype)
			,
			extraData
			,
			String.valueOf(activityCount)
			
		);

		return formData;
	}

}
