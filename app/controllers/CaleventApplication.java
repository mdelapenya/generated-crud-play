
package controllers;

import com.avaje.ebean.Ebean;

import controllers.calevent.CaleventFormData;

import models.calevent.Calevent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.calevent.calevent;
import views.html.calevent.calevents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class CaleventApplication extends Controller {

	public static Result addCalevent() {
		Form<CaleventFormData> form = Form.form(
			CaleventFormData.class).fill(new Calevent().toFormData());

		return ok(calevent.render(form));
	}

	public static Result get(Long id) {
		Calevent dbCalevent = Calevent.find.byId(id);

		Form<CaleventFormData> form = Form.form(
			CaleventFormData.class).fill(dbCalevent.toFormData());

		return ok(calevent.render(form));
	}

	public static Result all() {
		List<Calevent> caleventList = Calevent.find.all();

		return ok(calevents.render(caleventList));
	}

	public static Result submit() {
		Form<CaleventFormData> formData = Form.form(
			CaleventFormData.class).bindFromRequest();

		String[] postSubmit = request().body().asFormUrlEncoded().get("submit");

		if (postSubmit == null || postSubmit.length == 0) {
			return badRequest("You must provide a valid action");
		}
		else {
			String action = postSubmit[0];

			if ("edit".equals(action)) {
				return edit(formData);
			}
			else if ("delete".equals(action)) {
				return delete(formData);
			}
			else {
				return badRequest("This action is not allowed");
			}
		}
	}

	public static Result edit(Form<CaleventFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addCalevent();
		}
		else {
			CaleventFormData caleventFormData = formData.get();

			String id = caleventFormData.eventId;

			long caleventId = 0;

			if (id != null) {
				caleventId = Long.valueOf(id);
			}

			Calevent calevent;

			if (caleventId > 0) {
				calevent = Calevent.find.byId(caleventId);

				calevent.setUuid(caleventFormData.uuid);
				calevent.setEventId(Long.valueOf(caleventFormData.eventId));
				calevent.setGroupId(Long.valueOf(caleventFormData.groupId));
				calevent.setCompanyId(Long.valueOf(caleventFormData.companyId));
				calevent.setUserId(Long.valueOf(caleventFormData.userId));
				calevent.setUserName(caleventFormData.userName);
				calevent.setCreateDate(new Date(caleventFormData.createDate));
				calevent.setModifiedDate(new Date(caleventFormData.modifiedDate));
				calevent.setTitle(caleventFormData.title);
				calevent.setDescription(caleventFormData.description);
				calevent.setLocation(caleventFormData.location);
				calevent.setStartDate(new Date(caleventFormData.startDate));
				calevent.setEndDate(new Date(caleventFormData.endDate));
				calevent.setDurationHour(Integer.valueOf(caleventFormData.durationHour));
				calevent.setDurationMinute(Integer.valueOf(caleventFormData.durationMinute));
				calevent.setAllDay(Boolean.valueOf(caleventFormData.allDay));
				calevent.setTimeZoneSensitive(Boolean.valueOf(caleventFormData.timeZoneSensitive));
				calevent.setCustomtype(caleventFormData.customtype);
				calevent.setRepeating(Boolean.valueOf(caleventFormData.repeating));
				calevent.setRecurrence(caleventFormData.recurrence);
				calevent.setRemindBy(Integer.valueOf(caleventFormData.remindBy));
				calevent.setFirstReminder(Integer.valueOf(caleventFormData.firstReminder));
				calevent.setSecondReminder(Integer.valueOf(caleventFormData.secondReminder));
			}
			else {
				calevent = new Calevent(caleventFormData);
			}

			Ebean.save(calevent);

			flash("success", "Calevent instance created/edited: " + calevent);

			return all();
		}
	}

	public static Result delete(Form<CaleventFormData> formData) {
		CaleventFormData caleventFormData = formData.get();

		String id = caleventFormData.eventId;

		long caleventId = 0;

		if (id != null) {
			caleventId = Long.valueOf(id);
		}

		Calevent calevent;

		if (caleventId > 0) {
			calevent = Calevent.find.byId(caleventId);

			Ebean.delete(calevent);
		}
		else {
			flash("error", "Cannot delete Calevent");
		}

		return all();
	}

}
