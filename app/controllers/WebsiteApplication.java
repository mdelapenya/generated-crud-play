
package controllers;

import com.avaje.ebean.Ebean;

import controllers.website.WebsiteFormData;

import models.website.Website;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.website.website;
import views.html.website.websites;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class WebsiteApplication extends Controller {

	public static Result addWebsite() {
		Form<WebsiteFormData> form = Form.form(
			WebsiteFormData.class).fill(new Website().toFormData());

		return ok(website.render(form));
	}

	public static Result get(Long id) {
		Website dbWebsite = Website.find.byId(id);

		Form<WebsiteFormData> form = Form.form(
			WebsiteFormData.class).fill(dbWebsite.toFormData());

		return ok(website.render(form));
	}

	public static Result all() {
		List<Website> websiteList = Website.find.all();

		return ok(websites.render(websiteList));
	}

	public static Result submit() {
		Form<WebsiteFormData> formData = Form.form(
			WebsiteFormData.class).bindFromRequest();

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

	public static Result edit(Form<WebsiteFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addWebsite();
		}
		else {
			WebsiteFormData websiteFormData = formData.get();

			String id = websiteFormData.websiteId;

			long websiteId = 0;

			if (id != null) {
				websiteId = Long.valueOf(id);
			}

			Website website;

			if (websiteId > 0) {
				website = Website.find.byId(websiteId);

				website.setMvccVersion(Long.valueOf(websiteFormData.mvccVersion));
				website.setUuid(websiteFormData.uuid);
				website.setWebsiteId(Long.valueOf(websiteFormData.websiteId));
				website.setCompanyId(Long.valueOf(websiteFormData.companyId));
				website.setUserId(Long.valueOf(websiteFormData.userId));
				website.setUserName(websiteFormData.userName);
				website.setCreateDate(new Date(websiteFormData.createDate));
				website.setModifiedDate(new Date(websiteFormData.modifiedDate));
				website.setClassNameId(Long.valueOf(websiteFormData.classNameId));
				website.setClassPK(Long.valueOf(websiteFormData.classPK));
				website.setUrl(websiteFormData.url);
				website.setTypeId(Long.valueOf(websiteFormData.typeId));
				website.setCustomprimary(Boolean.valueOf(websiteFormData.customprimary));
			}
			else {
				website = new Website(websiteFormData);
			}

			Ebean.save(website);

			flash("success", "Website instance created/edited: " + website);

			return all();
		}
	}

	public static Result delete(Form<WebsiteFormData> formData) {
		WebsiteFormData websiteFormData = formData.get();

		String id = websiteFormData.websiteId;

		long websiteId = 0;

		if (id != null) {
			websiteId = Long.valueOf(id);
		}

		Website website;

		if (websiteId > 0) {
			website = Website.find.byId(websiteId);

			Ebean.delete(website);
		}
		else {
			flash("error", "Cannot delete Website");
		}

		return all();
	}

}
