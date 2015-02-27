
package controllers;

import com.avaje.ebean.Ebean;

import controllers.lock.LockFormData;

import models.lock.Lock;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.lock.lock;
import views.html.lock.locks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LockApplication extends Controller {

	public static Result addLock() {
		Form<LockFormData> form = Form.form(
			LockFormData.class).fill(new Lock().toFormData());

		return ok(lock.render(form));
	}

	public static Result get(Long id) {
		Lock dbLock = Lock.find.byId(id);

		Form<LockFormData> form = Form.form(
			LockFormData.class).fill(dbLock.toFormData());

		return ok(lock.render(form));
	}

	public static Result all() {
		List<Lock> lockList = Lock.find.all();

		return ok(locks.render(lockList));
	}

	public static Result submit() {
		Form<LockFormData> formData = Form.form(
			LockFormData.class).bindFromRequest();

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

	public static Result edit(Form<LockFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLock();
		}
		else {
			LockFormData lockFormData = formData.get();

			String id = lockFormData.lockId;

			long lockId = 0;

			if (id != null) {
				lockId = Long.valueOf(id);
			}

			Lock lock;

			if (lockId > 0) {
				lock = Lock.find.byId(lockId);

				lock.setMvccVersion(Long.valueOf(lockFormData.mvccVersion));
				lock.setUuid(lockFormData.uuid);
				lock.setLockId(Long.valueOf(lockFormData.lockId));
				lock.setCompanyId(Long.valueOf(lockFormData.companyId));
				lock.setUserId(Long.valueOf(lockFormData.userId));
				lock.setUserName(lockFormData.userName);
				lock.setCreateDate(new Date(lockFormData.createDate));
				lock.setClassName(lockFormData.className);
				lock.setKey(lockFormData.key);
				lock.setOwner(lockFormData.owner);
				lock.setInheritable(Boolean.valueOf(lockFormData.inheritable));
				lock.setExpirationDate(new Date(lockFormData.expirationDate));
			}
			else {
				lock = new Lock(lockFormData);
			}

			Ebean.save(lock);

			flash("success", "Lock instance created/edited: " + lock);

			return all();
		}
	}

	public static Result delete(Form<LockFormData> formData) {
		LockFormData lockFormData = formData.get();

		String id = lockFormData.lockId;

		long lockId = 0;

		if (id != null) {
			lockId = Long.valueOf(id);
		}

		Lock lock;

		if (lockId > 0) {
			lock = Lock.find.byId(lockId);

			Ebean.delete(lock);
		}
		else {
			flash("error", "Cannot delete Lock");
		}

		return all();
	}

}
