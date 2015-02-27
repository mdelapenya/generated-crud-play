
package models.calevent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.calevent.CaleventFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Calevent extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long eventId;

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
	public String title;

	public String description;

	public String location;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date endDate;

	public int durationHour;

	public int durationMinute;

	public boolean allDay;

	public boolean timeZoneSensitive;

	@Constraints.MaxLength(75)
	public String customtype;

	public boolean repeating;

	public String recurrence;

	public int remindBy;

	public int firstReminder;

	public int secondReminder;


	// model finder attribute

	public static Finder<Long,Calevent> find = new Finder<Long,Calevent>(
		Long.class, Calevent.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
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
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getDurationHour() {
		return durationHour;
	}

	public void setDurationHour(int durationHour) {
		this.durationHour = durationHour;
	}
	public int getDurationMinute() {
		return durationMinute;
	}

	public void setDurationMinute(int durationMinute) {
		this.durationMinute = durationMinute;
	}
	public boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	public boolean getTimeZoneSensitive() {
		return timeZoneSensitive;
	}

	public void setTimeZoneSensitive(boolean timeZoneSensitive) {
		this.timeZoneSensitive = timeZoneSensitive;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public boolean getRepeating() {
		return repeating;
	}

	public void setRepeating(boolean repeating) {
		this.repeating = repeating;
	}
	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public int getRemindBy() {
		return remindBy;
	}

	public void setRemindBy(int remindBy) {
		this.remindBy = remindBy;
	}
	public int getFirstReminder() {
		return firstReminder;
	}

	public void setFirstReminder(int firstReminder) {
		this.firstReminder = firstReminder;
	}
	public int getSecondReminder() {
		return secondReminder;
	}

	public void setSecondReminder(int secondReminder) {
		this.secondReminder = secondReminder;
	}

	public Calevent(){
	}

	// constructor using a formData

	public Calevent(CaleventFormData formData) {
		uuid = formData.uuid;
		eventId = Long.valueOf(formData.eventId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		title = formData.title;
		description = formData.description;
		location = formData.location;
		startDate = new Date(formData.startDate);
		endDate = new Date(formData.endDate);
		durationHour = Integer.valueOf(formData.durationHour);
		durationMinute = Integer.valueOf(formData.durationMinute);
		allDay = Boolean.valueOf(formData.allDay);
		timeZoneSensitive = Boolean.valueOf(formData.timeZoneSensitive);
		customtype = formData.customtype;
		repeating = Boolean.valueOf(formData.repeating);
		recurrence = formData.recurrence;
		remindBy = Integer.valueOf(formData.remindBy);
		firstReminder = Integer.valueOf(formData.firstReminder);
		secondReminder = Integer.valueOf(formData.secondReminder);
	}

	public CaleventFormData toFormData() {
		if (eventId < 0) {
			eventId = 0L;
		}

		CaleventFormData formData = new CaleventFormData(
			uuid
			,
			String.valueOf(eventId)
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
			title
			,
			description
			,
			location
			,
			String.valueOf(startDate)
			,
			String.valueOf(endDate)
			,
			String.valueOf(durationHour)
			,
			String.valueOf(durationMinute)
			,
			String.valueOf(allDay)
			,
			String.valueOf(timeZoneSensitive)
			,
			customtype
			,
			String.valueOf(repeating)
			,
			recurrence
			,
			String.valueOf(remindBy)
			,
			String.valueOf(firstReminder)
			,
			String.valueOf(secondReminder)
			
		);

		return formData;
	}

}
