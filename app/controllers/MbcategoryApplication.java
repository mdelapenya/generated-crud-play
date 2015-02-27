
package controllers;

import com.avaje.ebean.Ebean;

import controllers.mbcategory.MbcategoryFormData;

import models.mbcategory.Mbcategory;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.mbcategory.mbcategory;
import views.html.mbcategory.mbcategorys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class MbcategoryApplication extends Controller {

	public static Result addMbcategory() {
		Form<MbcategoryFormData> form = Form.form(
			MbcategoryFormData.class).fill(new Mbcategory().toFormData());

		return ok(mbcategory.render(form));
	}

	public static Result get(Long id) {
		Mbcategory dbMbcategory = Mbcategory.find.byId(id);

		Form<MbcategoryFormData> form = Form.form(
			MbcategoryFormData.class).fill(dbMbcategory.toFormData());

		return ok(mbcategory.render(form));
	}

	public static Result all() {
		List<Mbcategory> mbcategoryList = Mbcategory.find.all();

		return ok(mbcategorys.render(mbcategoryList));
	}

	public static Result submit() {
		Form<MbcategoryFormData> formData = Form.form(
			MbcategoryFormData.class).bindFromRequest();

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

	public static Result edit(Form<MbcategoryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addMbcategory();
		}
		else {
			MbcategoryFormData mbcategoryFormData = formData.get();

			String id = mbcategoryFormData.categoryId;

			long mbcategoryId = 0;

			if (id != null) {
				mbcategoryId = Long.valueOf(id);
			}

			Mbcategory mbcategory;

			if (mbcategoryId > 0) {
				mbcategory = Mbcategory.find.byId(mbcategoryId);

				mbcategory.setUuid(mbcategoryFormData.uuid);
				mbcategory.setCategoryId(Long.valueOf(mbcategoryFormData.categoryId));
				mbcategory.setGroupId(Long.valueOf(mbcategoryFormData.groupId));
				mbcategory.setCompanyId(Long.valueOf(mbcategoryFormData.companyId));
				mbcategory.setUserId(Long.valueOf(mbcategoryFormData.userId));
				mbcategory.setUserName(mbcategoryFormData.userName);
				mbcategory.setCreateDate(new Date(mbcategoryFormData.createDate));
				mbcategory.setModifiedDate(new Date(mbcategoryFormData.modifiedDate));
				mbcategory.setParentCategoryId(Long.valueOf(mbcategoryFormData.parentCategoryId));
				mbcategory.setName(mbcategoryFormData.name);
				mbcategory.setDescription(mbcategoryFormData.description);
				mbcategory.setDisplayStyle(mbcategoryFormData.displayStyle);
				mbcategory.setThreadCount(Integer.valueOf(mbcategoryFormData.threadCount));
				mbcategory.setMessageCount(Integer.valueOf(mbcategoryFormData.messageCount));
				mbcategory.setLastPostDate(new Date(mbcategoryFormData.lastPostDate));
				mbcategory.setStatus(Integer.valueOf(mbcategoryFormData.status));
				mbcategory.setStatusByUserId(Long.valueOf(mbcategoryFormData.statusByUserId));
				mbcategory.setStatusByUserName(mbcategoryFormData.statusByUserName);
				mbcategory.setStatusDate(new Date(mbcategoryFormData.statusDate));
			}
			else {
				mbcategory = new Mbcategory(mbcategoryFormData);
			}

			Ebean.save(mbcategory);

			flash("success", "Mbcategory instance created/edited: " + mbcategory);

			return all();
		}
	}

	public static Result delete(Form<MbcategoryFormData> formData) {
		MbcategoryFormData mbcategoryFormData = formData.get();

		String id = mbcategoryFormData.categoryId;

		long mbcategoryId = 0;

		if (id != null) {
			mbcategoryId = Long.valueOf(id);
		}

		Mbcategory mbcategory;

		if (mbcategoryId > 0) {
			mbcategory = Mbcategory.find.byId(mbcategoryId);

			Ebean.delete(mbcategory);
		}
		else {
			flash("error", "Cannot delete Mbcategory");
		}

		return all();
	}

}
