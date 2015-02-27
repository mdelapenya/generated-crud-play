
package controllers;

import com.avaje.ebean.Ebean;

import controllers.systemevent.SystemeventFormData;

import models.systemevent.Systemevent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.systemevent.systemevent;
import views.html.systemevent.systemevents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class SystemeventApplication extends Controller {

	public static Result addSystemevent() {
		Form<SystemeventFormData> form = Form.form(
			SystemeventFormData.class).fill(new Systemevent().toFormData());

		return ok(systemevent.render(form));
	}

	public static Result get(Long id) {
		Systemevent dbSystemevent = Systemevent.find.byId(id);

		Form<SystemeventFormData> form = Form.form(
			SystemeventFormData.class).fill(dbSystemevent.toFormData());

		return ok(systemevent.render(form));
	}

	public static Result all() {
		List<Systemevent> systemeventList = Systemevent.find.all();

		return ok(systemevents.render(systemeventList));
	}

	public static Result submit() {
		Form<SystemeventFormData> formData = Form.form(
			SystemeventFormData.class).bindFromRequest();

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

	public static Result edit(Form<SystemeventFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addSystemevent();
		}
		else {
			SystemeventFormData systemeventFormData = formData.get();

			String id = systemeventFormData.systemEventId;

			long systemeventId = 0;

			if (id != null) {
				systemeventId = Long.valueOf(id);
			}

			Systemevent systemevent;

			if (systemeventId > 0) {
				systemevent = Systemevent.find.byId(systemeventId);

				systemevent.setMvccVersion(Long.valueOf(systemeventFormData.mvccVersion));
				systemevent.setSystemEventId(Long.valueOf(systemeventFormData.systemEventId));
				systemevent.setGroupId(Long.valueOf(systemeventFormData.groupId));
				systemevent.setCompanyId(Long.valueOf(systemeventFormData.companyId));
				systemevent.setUserId(Long.valueOf(systemeventFormData.userId));
				systemevent.setUserName(systemeventFormData.userName);
				systemevent.setCreateDate(new Date(systemeventFormData.createDate));
				systemevent.setClassNameId(Long.valueOf(systemeventFormData.classNameId));
				systemevent.setClassPK(Long.valueOf(systemeventFormData.classPK));
				systemevent.setClassUuid(systemeventFormData.classUuid);
				systemevent.setReferrerClassNameId(Long.valueOf(systemeventFormData.referrerClassNameId));
				systemevent.setParentSystemEventId(Long.valueOf(systemeventFormData.parentSystemEventId));
				systemevent.setSystemEventSetKey(Long.valueOf(systemeventFormData.systemEventSetKey));
				systemevent.setCustomtype(Integer.valueOf(systemeventFormData.customtype));
				systemevent.setExtraData(systemeventFormData.extraData);
			}
			else {
				systemevent = new Systemevent(systemeventFormData);
			}

			Ebean.save(systemevent);

			flash("success", "Systemevent instance created/edited: " + systemevent);

			return all();
		}
	}

	public static Result delete(Form<SystemeventFormData> formData) {
		SystemeventFormData systemeventFormData = formData.get();

		String id = systemeventFormData.systemEventId;

		long systemeventId = 0;

		if (id != null) {
			systemeventId = Long.valueOf(id);
		}

		Systemevent systemevent;

		if (systemeventId > 0) {
			systemevent = Systemevent.find.byId(systemeventId);

			Ebean.delete(systemevent);
		}
		else {
			flash("error", "Cannot delete Systemevent");
		}

		return all();
	}

}
