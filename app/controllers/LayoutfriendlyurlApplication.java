
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layoutfriendlyurl.LayoutfriendlyurlFormData;

import models.layoutfriendlyurl.Layoutfriendlyurl;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layoutfriendlyurl.layoutfriendlyurl;
import views.html.layoutfriendlyurl.layoutfriendlyurls;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutfriendlyurlApplication extends Controller {

	public static Result addLayoutfriendlyurl() {
		Form<LayoutfriendlyurlFormData> form = Form.form(
			LayoutfriendlyurlFormData.class).fill(new Layoutfriendlyurl().toFormData());

		return ok(layoutfriendlyurl.render(form));
	}

	public static Result get(Long id) {
		Layoutfriendlyurl dbLayoutfriendlyurl = Layoutfriendlyurl.find.byId(id);

		Form<LayoutfriendlyurlFormData> form = Form.form(
			LayoutfriendlyurlFormData.class).fill(dbLayoutfriendlyurl.toFormData());

		return ok(layoutfriendlyurl.render(form));
	}

	public static Result all() {
		List<Layoutfriendlyurl> layoutfriendlyurlList = Layoutfriendlyurl.find.all();

		return ok(layoutfriendlyurls.render(layoutfriendlyurlList));
	}

	public static Result submit() {
		Form<LayoutfriendlyurlFormData> formData = Form.form(
			LayoutfriendlyurlFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutfriendlyurlFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayoutfriendlyurl();
		}
		else {
			LayoutfriendlyurlFormData layoutfriendlyurlFormData = formData.get();

			String id = layoutfriendlyurlFormData.layoutFriendlyURLId;

			long layoutfriendlyurlId = 0;

			if (id != null) {
				layoutfriendlyurlId = Long.valueOf(id);
			}

			Layoutfriendlyurl layoutfriendlyurl;

			if (layoutfriendlyurlId > 0) {
				layoutfriendlyurl = Layoutfriendlyurl.find.byId(layoutfriendlyurlId);

				layoutfriendlyurl.setMvccVersion(Long.valueOf(layoutfriendlyurlFormData.mvccVersion));
				layoutfriendlyurl.setUuid(layoutfriendlyurlFormData.uuid);
				layoutfriendlyurl.setLayoutFriendlyURLId(Long.valueOf(layoutfriendlyurlFormData.layoutFriendlyURLId));
				layoutfriendlyurl.setGroupId(Long.valueOf(layoutfriendlyurlFormData.groupId));
				layoutfriendlyurl.setCompanyId(Long.valueOf(layoutfriendlyurlFormData.companyId));
				layoutfriendlyurl.setUserId(Long.valueOf(layoutfriendlyurlFormData.userId));
				layoutfriendlyurl.setUserName(layoutfriendlyurlFormData.userName);
				layoutfriendlyurl.setCreateDate(new Date(layoutfriendlyurlFormData.createDate));
				layoutfriendlyurl.setModifiedDate(new Date(layoutfriendlyurlFormData.modifiedDate));
				layoutfriendlyurl.setPlid(Long.valueOf(layoutfriendlyurlFormData.plid));
				layoutfriendlyurl.setPrivateLayout(Boolean.valueOf(layoutfriendlyurlFormData.privateLayout));
				layoutfriendlyurl.setFriendlyURL(layoutfriendlyurlFormData.friendlyURL);
				layoutfriendlyurl.setLanguageId(layoutfriendlyurlFormData.languageId);
			}
			else {
				layoutfriendlyurl = new Layoutfriendlyurl(layoutfriendlyurlFormData);
			}

			Ebean.save(layoutfriendlyurl);

			flash("success", "Layoutfriendlyurl instance created/edited: " + layoutfriendlyurl);

			return all();
		}
	}

	public static Result delete(Form<LayoutfriendlyurlFormData> formData) {
		LayoutfriendlyurlFormData layoutfriendlyurlFormData = formData.get();

		String id = layoutfriendlyurlFormData.layoutFriendlyURLId;

		long layoutfriendlyurlId = 0;

		if (id != null) {
			layoutfriendlyurlId = Long.valueOf(id);
		}

		Layoutfriendlyurl layoutfriendlyurl;

		if (layoutfriendlyurlId > 0) {
			layoutfriendlyurl = Layoutfriendlyurl.find.byId(layoutfriendlyurlId);

			Ebean.delete(layoutfriendlyurl);
		}
		else {
			flash("error", "Cannot delete Layoutfriendlyurl");
		}

		return all();
	}

}
