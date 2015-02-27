
package models.socialactivityachievement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivityachievement.SocialactivityachievementFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivityachievement extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activityAchievementId;

	public long groupId;

	public long companyId;

	public long userId;

	public long createDate;

	@Constraints.MaxLength(75)
	public String name;

	public boolean firstInGroup;


	// model finder attribute

	public static Finder<Long,Socialactivityachievement> find = new Finder<Long,Socialactivityachievement>(
		Long.class, Socialactivityachievement.class
	);

	// getters and setters

	public long getActivityAchievementId() {
		return activityAchievementId;
	}

	public void setActivityAchievementId(long activityAchievementId) {
		this.activityAchievementId = activityAchievementId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean getFirstInGroup() {
		return firstInGroup;
	}

	public void setFirstInGroup(boolean firstInGroup) {
		this.firstInGroup = firstInGroup;
	}

	public Socialactivityachievement(){
	}

	// constructor using a formData

	public Socialactivityachievement(SocialactivityachievementFormData formData) {
		activityAchievementId = Long.valueOf(formData.activityAchievementId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = Long.valueOf(formData.createDate);
		name = formData.name;
		firstInGroup = Boolean.valueOf(formData.firstInGroup);
	}

	public SocialactivityachievementFormData toFormData() {
		if (activityAchievementId < 0) {
			activityAchievementId = 0L;
		}

		SocialactivityachievementFormData formData = new SocialactivityachievementFormData(
			String.valueOf(activityAchievementId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			name
			,
			String.valueOf(firstInGroup)
			
		);

		return formData;
	}

}
