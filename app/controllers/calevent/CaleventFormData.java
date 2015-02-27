package controllers.calevent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Calevent data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class CaleventFormData {

	public String uuid;
	public String eventId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String title;
	public String description;
	public String location;
	public String startDate;
	public String endDate;
	public String durationHour;
	public String durationMinute;
	public String allDay;
	public String timeZoneSensitive;
	public String customtype;
	public String repeating;
	public String recurrence;
	public String remindBy;
	public String firstReminder;
	public String secondReminder;

	public CaleventFormData() {
	}

	public CaleventFormData(
		String uuid,
				String eventId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String title,
				String description,
				String location,
				String startDate,
				String endDate,
				String durationHour,
				String durationMinute,
				String allDay,
				String timeZoneSensitive,
				String customtype,
				String repeating,
				String recurrence,
				String remindBy,
				String firstReminder,
				String secondReminder
		) {

		this.uuid = uuid;
		this.eventId = eventId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.title = title;
		this.description = description;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.durationHour = durationHour;
		this.durationMinute = durationMinute;
		this.allDay = allDay;
		this.timeZoneSensitive = timeZoneSensitive;
		this.customtype = customtype;
		this.repeating = repeating;
		this.recurrence = recurrence;
		this.remindBy = remindBy;
		this.firstReminder = firstReminder;
		this.secondReminder = secondReminder;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (eventId == null || eventId.length() == 0) {
			errors.add(new ValidationError("eventId", "No eventId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
