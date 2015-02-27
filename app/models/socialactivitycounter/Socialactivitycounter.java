
package models.socialactivitycounter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialactivitycounter.SocialactivitycounterFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialactivitycounter extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long activityCounterId;

	public long groupId;

	public long companyId;

	public long classNameId;

	public long classPK;

	@Constraints.MaxLength(75)
	public String name;

	public int ownerType;

	public int currentValue;

	public int totalValue;

	public int graceValue;

	public int startPeriod;

	public int endPeriod;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Socialactivitycounter> find = new Finder<Long,Socialactivitycounter>(
		Long.class, Socialactivitycounter.class
	);

	// getters and setters

	public long getActivityCounterId() {
		return activityCounterId;
	}

	public void setActivityCounterId(long activityCounterId) {
		this.activityCounterId = activityCounterId;
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
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(int ownerType) {
		this.ownerType = ownerType;
	}
	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public int getGraceValue() {
		return graceValue;
	}

	public void setGraceValue(int graceValue) {
		this.graceValue = graceValue;
	}
	public int getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(int startPeriod) {
		this.startPeriod = startPeriod;
	}
	public int getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(int endPeriod) {
		this.endPeriod = endPeriod;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Socialactivitycounter(){
	}

	// constructor using a formData

	public Socialactivitycounter(SocialactivitycounterFormData formData) {
		activityCounterId = Long.valueOf(formData.activityCounterId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		name = formData.name;
		ownerType = Integer.valueOf(formData.ownerType);
		currentValue = Integer.valueOf(formData.currentValue);
		totalValue = Integer.valueOf(formData.totalValue);
		graceValue = Integer.valueOf(formData.graceValue);
		startPeriod = Integer.valueOf(formData.startPeriod);
		endPeriod = Integer.valueOf(formData.endPeriod);
		active = Boolean.valueOf(formData.active);
	}

	public SocialactivitycounterFormData toFormData() {
		if (activityCounterId < 0) {
			activityCounterId = 0L;
		}

		SocialactivitycounterFormData formData = new SocialactivitycounterFormData(
			String.valueOf(activityCounterId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			name
			,
			String.valueOf(ownerType)
			,
			String.valueOf(currentValue)
			,
			String.valueOf(totalValue)
			,
			String.valueOf(graceValue)
			,
			String.valueOf(startPeriod)
			,
			String.valueOf(endPeriod)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
