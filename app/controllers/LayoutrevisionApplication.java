
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutrevision.LayoutrevisionFormData;

import models.layoutrevision.Layoutrevision;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutrevision.layoutrevision;
import views.html.layoutrevision.layoutrevisions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutrevisionApplication extends Controller {

	public static Result addLayoutrevision() {
		Form<LayoutrevisionFormData> form = Form.form(
			LayoutrevisionFormData.class).fill(new Layoutrevision().toFormData());

		return ok(layoutrevision.render(form));
	}

	public static Result get(Long id) {
		Layoutrevision dbLayoutrevision = Layoutrevision.find.byId(id);

		Form<LayoutrevisionFormData> form = Form.form(
			LayoutrevisionFormData.class).fill(dbLayoutrevision.toFormData());

		return ok(layoutrevision.render(form));
	}

	public static Result all() {
		List<Layoutrevision> layoutrevisionList = Layoutrevision.find.all();

		return ok(layoutrevisions.render(layoutrevisionList));
	}

	public static Result submit() {
		Form<LayoutrevisionFormData> formData = Form.form(
			LayoutrevisionFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutrevisionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutrevision();
		}
		else {
			LayoutrevisionFormData layoutrevisionFormData = formData.get();

			String id = layoutrevisionFormData.layoutRevisionId;

			long layoutrevisionId = 0;

			if (id != null) {
				layoutrevisionId = Long.valueOf(id);
			}

			Layoutrevision layoutrevision;

			if (layoutrevisionId > 0) {
				layoutrevision = Layoutrevision.find.byId(layoutrevisionId);

				layoutrevision.setMvccVersion(Long.valueOf(layoutrevisionFormData.mvccVersion));
				layoutrevision.setLayoutRevisionId(Long.valueOf(layoutrevisionFormData.layoutRevisionId));
				layoutrevision.setGroupId(Long.valueOf(layoutrevisionFormData.groupId));
				layoutrevision.setCompanyId(Long.valueOf(layoutrevisionFormData.companyId));
				layoutrevision.setUserId(Long.valueOf(layoutrevisionFormData.userId));
				layoutrevision.setUserName(layoutrevisionFormData.userName);
				layoutrevision.setCreateDate(new Date(layoutrevisionFormData.createDate));
				layoutrevision.setModifiedDate(new Date(layoutrevisionFormData.modifiedDate));
				layoutrevision.setLayoutSetBranchId(Long.valueOf(layoutrevisionFormData.layoutSetBranchId));
				layoutrevision.setLayoutBranchId(Long.valueOf(layoutrevisionFormData.layoutBranchId));
				layoutrevision.setParentLayoutRevisionId(Long.valueOf(layoutrevisionFormData.parentLayoutRevisionId));
				layoutrevision.setHead(Boolean.valueOf(layoutrevisionFormData.head));
				layoutrevision.setMajor(Boolean.valueOf(layoutrevisionFormData.major));
				layoutrevision.setPlid(Long.valueOf(layoutrevisionFormData.plid));
				layoutrevision.setPrivateLayout(Boolean.valueOf(layoutrevisionFormData.privateLayout));
				layoutrevision.setName(layoutrevisionFormData.name);
				layoutrevision.setTitle(layoutrevisionFormData.title);
				layoutrevision.setDescription(layoutrevisionFormData.description);
				layoutrevision.setKeywords(layoutrevisionFormData.keywords);
				layoutrevision.setRobots(layoutrevisionFormData.robots);
				layoutrevision.setTypeSettings(layoutrevisionFormData.typeSettings);
				layoutrevision.setIconImageId(Long.valueOf(layoutrevisionFormData.iconImageId));
				layoutrevision.setThemeId(layoutrevisionFormData.themeId);
				layoutrevision.setColorSchemeId(layoutrevisionFormData.colorSchemeId);
				layoutrevision.setWapThemeId(layoutrevisionFormData.wapThemeId);
				layoutrevision.setWapColorSchemeId(layoutrevisionFormData.wapColorSchemeId);
				layoutrevision.setCss(layoutrevisionFormData.css);
				layoutrevision.setStatus(Integer.valueOf(layoutrevisionFormData.status));
				layoutrevision.setStatusByUserId(Long.valueOf(layoutrevisionFormData.statusByUserId));
				layoutrevision.setStatusByUserName(layoutrevisionFormData.statusByUserName);
				layoutrevision.setStatusDate(new Date(layoutrevisionFormData.statusDate));
			}
			else {
				layoutrevision = new Layoutrevision(layoutrevisionFormData);
			}

			Ebean.save(layoutrevision);

			flash("success", "Layoutrevision instance created/edited: " + layoutrevision);

			return all();
		}
	}

	public static Result delete(Form<LayoutrevisionFormData> formData) {
		LayoutrevisionFormData layoutrevisionFormData = formData.get();

		String id = layoutrevisionFormData.layoutRevisionId;

		long layoutrevisionId = 0;

		if (id != null) {
			layoutrevisionId = Long.valueOf(id);
		}

		Layoutrevision layoutrevision;

		if (layoutrevisionId > 0) {
			layoutrevision = Layoutrevision.find.byId(layoutrevisionId);

			Ebean.delete(layoutrevision);
		}
		else {
			flash("error", "Cannot delete Layoutrevision");
		}

		return all();
	}

}
