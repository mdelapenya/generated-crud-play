
package models.socialactivitylimit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivitylimit.SocialactivitylimitFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivitylimit extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activityLimitId;

	public long groupId;

	public long companyId;

	public long userId;

	public long classNameId;

	public long classPK;

	public int activityType;

	@Constraints.MaxLength(75)
	public String activityCounterName;

	@Constraints.MaxLength(75)
	public String value;


	// model finder attribute

	public static Finder<Long,Socialactivitylimit> find = new Finder<Long,Socialactivitylimit>(
		Long.class, Socialactivitylimit.class
	);

	// getters and setters

	public long getActivityLimitId() {
		return activityLimitId;
	}

	public void setActivityLimitId(long activityLimitId) {
		this.activityLimitId = activityLimitId;
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
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	public String getActivityCounterName() {
		return activityCounterName;
	}

	public void setActivityCounterName(String activityCounterName) {
		this.activityCounterName = activityCounterName;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Socialactivitylimit(){
	}

	// constructor using a formData

	public Socialactivitylimit(SocialactivitylimitFormData formData) {
		activityLimitId = Long.valueOf(formData.activityLimitId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		activityType = Integer.valueOf(formData.activityType);
		activityCounterName = formData.activityCounterName;
		value = formData.value;
	}

	public SocialactivitylimitFormData toFormData() {
		if (activityLimitId < 0) {
			activityLimitId = 0L;
		}

		SocialactivitylimitFormData formData = new SocialactivitylimitFormData(
			String.valueOf(activityLimitId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(activityType)
			,
			activityCounterName
			,
			value
			
		);

		return formData;
	}

}
