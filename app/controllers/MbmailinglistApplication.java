
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbmailinglist.MbmailinglistFormData;

import models.mbmailinglist.Mbmailinglist;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbmailinglist.mbmailinglist;
import views.html.mbmailinglist.mbmailinglists;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbmailinglistApplication extends Controller {

	public static Result addMbmailinglist() {
		Form<MbmailinglistFormData> form = Form.form(
			MbmailinglistFormData.class).fill(new Mbmailinglist().toFormData());

		return ok(mbmailinglist.render(form));
	}

	public static Result get(Long id) {
		Mbmailinglist dbMbmailinglist = Mbmailinglist.find.byId(id);

		Form<MbmailinglistFormData> form = Form.form(
			MbmailinglistFormData.class).fill(dbMbmailinglist.toFormData());

		return ok(mbmailinglist.render(form));
	}

	public static Result all() {
		List<Mbmailinglist> mbmailinglistList = Mbmailinglist.find.all();

		return ok(mbmailinglists.render(mbmailinglistList));
	}

	public static Result submit() {
		Form<MbmailinglistFormData> formData = Form.form(
			MbmailinglistFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbmailinglistFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbmailinglist();
		}
		else {
			MbmailinglistFormData mbmailinglistFormData = formData.get();

			String id = mbmailinglistFormData.mailingListId;

			long mbmailinglistId = 0;

			if (id != null) {
				mbmailinglistId = Long.valueOf(id);
			}

			Mbmailinglist mbmailinglist;

			if (mbmailinglistId > 0) {
				mbmailinglist = Mbmailinglist.find.byId(mbmailinglistId);

				mbmailinglist.setUuid(mbmailinglistFormData.uuid);
				mbmailinglist.setMailingListId(Long.valueOf(mbmailinglistFormData.mailingListId));
				mbmailinglist.setGroupId(Long.valueOf(mbmailinglistFormData.groupId));
				mbmailinglist.setCompanyId(Long.valueOf(mbmailinglistFormData.companyId));
				mbmailinglist.setUserId(Long.valueOf(mbmailinglistFormData.userId));
				mbmailinglist.setUserName(mbmailinglistFormData.userName);
				mbmailinglist.setCreateDate(new Date(mbmailinglistFormData.createDate));
				mbmailinglist.setModifiedDate(new Date(mbmailinglistFormData.modifiedDate));
				mbmailinglist.setCategoryId(Long.valueOf(mbmailinglistFormData.categoryId));
				mbmailinglist.setEmailAddress(mbmailinglistFormData.emailAddress);
				mbmailinglist.setInProtocol(mbmailinglistFormData.inProtocol);
				mbmailinglist.setInServerName(mbmailinglistFormData.inServerName);
				mbmailinglist.setInServerPort(Integer.valueOf(mbmailinglistFormData.inServerPort));
				mbmailinglist.setInUseSSL(Boolean.valueOf(mbmailinglistFormData.inUseSSL));
				mbmailinglist.setInUserName(mbmailinglistFormData.inUserName);
				mbmailinglist.setInPassword(mbmailinglistFormData.inPassword);
				mbmailinglist.setInReadInterval(Integer.valueOf(mbmailinglistFormData.inReadInterval));
				mbmailinglist.setOutEmailAddress(mbmailinglistFormData.outEmailAddress);
				mbmailinglist.setOutCustom(Boolean.valueOf(mbmailinglistFormData.outCustom));
				mbmailinglist.setOutServerName(mbmailinglistFormData.outServerName);
				mbmailinglist.setOutServerPort(Integer.valueOf(mbmailinglistFormData.outServerPort));
				mbmailinglist.setOutUseSSL(Boolean.valueOf(mbmailinglistFormData.outUseSSL));
				mbmailinglist.setOutUserName(mbmailinglistFormData.outUserName);
				mbmailinglist.setOutPassword(mbmailinglistFormData.outPassword);
				mbmailinglist.setAllowAnonymous(Boolean.valueOf(mbmailinglistFormData.allowAnonymous));
				mbmailinglist.setActive(Boolean.valueOf(mbmailinglistFormData.active));
			}
			else {
				mbmailinglist = new Mbmailinglist(mbmailinglistFormData);
			}

			Ebean.save(mbmailinglist);

			flash("success", "Mbmailinglist instance created/edited: " + mbmailinglist);

			return all();
		}
	}

	public static Result delete(Form<MbmailinglistFormData> formData) {
		MbmailinglistFormData mbmailinglistFormData = formData.get();

		String id = mbmailinglistFormData.mailingListId;

		long mbmailinglistId = 0;

		if (id != null) {
			mbmailinglistId = Long.valueOf(id);
		}

		Mbmailinglist mbmailinglist;

		if (mbmailinglistId > 0) {
			mbmailinglist = Mbmailinglist.find.byId(mbmailinglistId);

			Ebean.delete(mbmailinglist);
		}
		else {
			flash("error", "Cannot delete Mbmailinglist");
		}

		return all();
	}

}
