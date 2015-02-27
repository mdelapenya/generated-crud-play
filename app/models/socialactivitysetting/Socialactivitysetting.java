
package models.socialactivitysetting;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivitysetting.SocialactivitysettingFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivitysetting extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activitySettingId;

	public long groupId;

	public long companyId;

	public long classNameId;

	public int activityType;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(1024)
	public String value;


	// model finder attribute

	public static Finder<Long,Socialactivitysetting> find = new Finder<Long,Socialactivitysetting>(
		Long.class, Socialactivitysetting.class
	);

	// getters and setters

	public long getActivitySettingId() {
		return activitySettingId;
	}

	public void setActivitySettingId(long activitySettingId) {
		this.activitySettingId = activitySettingId;
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
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Socialactivitysetting(){
	}

	// constructor using a formData

	public Socialactivitysetting(SocialactivitysettingFormData formData) {
		activitySettingId = Long.valueOf(formData.activitySettingId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		classNameId = Long.valueOf(formData.classNameId);
		activityType = Integer.valueOf(formData.activityType);
		name = formData.name;
		value = formData.value;
	}

	public SocialactivitysettingFormData toFormData() {
		if (activitySettingId < 0) {
			activitySettingId = 0L;
		}

		SocialactivitysettingFormData formData = new SocialactivitysettingFormData(
			String.valueOf(activitySettingId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(activityType)
			,
			name
			,
			value
			
		);

		return formData;
	}

}
