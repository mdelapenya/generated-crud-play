
package models.socialactivity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivity.SocialactivityFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivity extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activityId;

	public long groupId;

	public long companyId;

	public long userId;

	public long createDate;

	public long activitySetId;

	public long mirrorActivityId;

	public long classNameId;

	public long classPK;

	public long parentClassNameId;

	public long parentClassPK;

	public int customtype;

	public String extraData;

	public long receiverUserId;


	// model finder attribute

	public static Finder<Long,Socialactivity> find = new Finder<Long,Socialactivity>(
		Long.class, Socialactivity.class
	);

	// getters and setters

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
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
	public long getActivitySetId() {
		return activitySetId;
	}

	public void setActivitySetId(long activitySetId) {
		this.activitySetId = activitySetId;
	}
	public long getMirrorActivityId() {
		return mirrorActivityId;
	}

	public void setMirrorActivityId(long mirrorActivityId) {
		this.mirrorActivityId = mirrorActivityId;
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
	public long getParentClassNameId() {
		return parentClassNameId;
	}

	public void setParentClassNameId(long parentClassNameId) {
		this.parentClassNameId = parentClassNameId;
	}
	public long getParentClassPK() {
		return parentClassPK;
	}

	public void setParentClassPK(long parentClassPK) {
		this.parentClassPK = parentClassPK;
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
	public long getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(long receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public Socialactivity(){
	}

	// constructor using a formData

	public Socialactivity(SocialactivityFormData formData) {
		activityId = Long.valueOf(formData.activityId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = Long.valueOf(formData.createDate);
		activitySetId = Long.valueOf(formData.activitySetId);
		mirrorActivityId = Long.valueOf(formData.mirrorActivityId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		parentClassNameId = Long.valueOf(formData.parentClassNameId);
		parentClassPK = Long.valueOf(formData.parentClassPK);
		customtype = Integer.valueOf(formData.customtype);
		extraData = formData.extraData;
		receiverUserId = Long.valueOf(formData.receiverUserId);
	}

	public SocialactivityFormData toFormData() {
		if (activityId < 0) {
			activityId = 0L;
		}

		SocialactivityFormData formData = new SocialactivityFormData(
			String.valueOf(activityId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(activitySetId)
			,
			String.valueOf(mirrorActivityId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(parentClassNameId)
			,
			String.valueOf(parentClassPK)
			,
			String.valueOf(customtype)
			,
			extraData
			,
			String.valueOf(receiverUserId)
			
		);

		return formData;
	}

}
