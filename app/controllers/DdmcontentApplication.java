
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ddmcontent.DdmcontentFormData;

import models.ddmcontent.Ddmcontent;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ddmcontent.ddmcontent;
import views.html.ddmcontent.ddmcontents;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class DdmcontentApplication extends Controller {

	public static Result addDdmcontent() {
		Form<DdmcontentFormData> form = Form.form(
			DdmcontentFormData.class).fill(new Ddmcontent().toFormData());

		return ok(ddmcontent.render(form));
	}

	public static Result get(Long id) {
		Ddmcontent dbDdmcontent = Ddmcontent.find.byId(id);

		Form<DdmcontentFormData> form = Form.form(
			DdmcontentFormData.class).fill(dbDdmcontent.toFormData());

		return ok(ddmcontent.render(form));
	}

	public static Result all() {
		List<Ddmcontent> ddmcontentList = Ddmcontent.find.all();

		return ok(ddmcontents.render(ddmcontentList));
	}

	public static Result submit() {
		Form<DdmcontentFormData> formData = Form.form(
			DdmcontentFormData.class).bindFromRequest();

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

	public static Result edit(Form<DdmcontentFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addDdmcontent();
		}
		else {
			DdmcontentFormData ddmcontentFormData = formData.get();

			String id = ddmcontentFormData.contentId;

			long ddmcontentId = 0;

			if (id != null) {
				ddmcontentId = Long.valueOf(id);
			}

			Ddmcontent ddmcontent;

			if (ddmcontentId > 0) {
				ddmcontent = Ddmcontent.find.byId(ddmcontentId);

				ddmcontent.setUuid(ddmcontentFormData.uuid);
				ddmcontent.setContentId(Long.valueOf(ddmcontentFormData.contentId));
				ddmcontent.setGroupId(Long.valueOf(ddmcontentFormData.groupId));
				ddmcontent.setCompanyId(Long.valueOf(ddmcontentFormData.companyId));
				ddmcontent.setUserId(Long.valueOf(ddmcontentFormData.userId));
				ddmcontent.setUserName(ddmcontentFormData.userName);
				ddmcontent.setCreateDate(new Date(ddmcontentFormData.createDate));
				ddmcontent.setModifiedDate(new Date(ddmcontentFormData.modifiedDate));
				ddmcontent.setName(ddmcontentFormData.name);
				ddmcontent.setDescription(ddmcontentFormData.description);
				ddmcontent.setData(ddmcontentFormData.data);
			}
			else {
				ddmcontent = new Ddmcontent(ddmcontentFormData);
			}

			Ebean.save(ddmcontent);

			flash("success", "Ddmcontent instance created/edited: " + ddmcontent);

			return all();
		}
	}

	public static Result delete(Form<DdmcontentFormData> formData) {
		DdmcontentFormData ddmcontentFormData = formData.get();

		String id = ddmcontentFormData.contentId;

		long ddmcontentId = 0;

		if (id != null) {
			ddmcontentId = Long.valueOf(id);
		}

		Ddmcontent ddmcontent;

		if (ddmcontentId > 0) {
			ddmcontent = Ddmcontent.find.byId(ddmcontentId);

			Ebean.delete(ddmcontent);
		}
		else {
			flash("error", "Cannot delete Ddmcontent");
		}

		return all();
	}

}
