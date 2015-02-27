
package controllers;

import com.avaje.ebean.Ebean;

import controllers.webdavprops.WebdavpropsFormData;

import models.webdavprops.Webdavprops;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.webdavprops.webdavprops;
import views.html.webdavprops.webdavpropss;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class WebdavpropsApplication extends Controller {

	public static Result addWebdavprops() {
		Form<WebdavpropsFormData> form = Form.form(
			WebdavpropsFormData.class).fill(new Webdavprops().toFormData());

		return ok(webdavprops.render(form));
	}

	public static Result get(Long id) {
		Webdavprops dbWebdavprops = Webdavprops.find.byId(id);

		Form<WebdavpropsFormData> form = Form.form(
			WebdavpropsFormData.class).fill(dbWebdavprops.toFormData());

		return ok(webdavprops.render(form));
	}

	public static Result all() {
		List<Webdavprops> webdavpropsList = Webdavprops.find.all();

		return ok(webdavpropss.render(webdavpropsList));
	}

	public static Result submit() {
		Form<WebdavpropsFormData> formData = Form.form(
			WebdavpropsFormData.class).bindFromRequest();

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

	public static Result edit(Form<WebdavpropsFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addWebdavprops();
		}
		else {
			WebdavpropsFormData webdavpropsFormData = formData.get();

			String id = webdavpropsFormData.webDavPropsId;

			long webdavpropsId = 0;

			if (id != null) {
				webdavpropsId = Long.valueOf(id);
			}

			Webdavprops webdavprops;

			if (webdavpropsId > 0) {
				webdavprops = Webdavprops.find.byId(webdavpropsId);

				webdavprops.setMvccVersion(Long.valueOf(webdavpropsFormData.mvccVersion));
				webdavprops.setWebDavPropsId(Long.valueOf(webdavpropsFormData.webDavPropsId));
				webdavprops.setCompanyId(Long.valueOf(webdavpropsFormData.companyId));
				webdavprops.setCreateDate(new Date(webdavpropsFormData.createDate));
				webdavprops.setModifiedDate(new Date(webdavpropsFormData.modifiedDate));
				webdavprops.setClassNameId(Long.valueOf(webdavpropsFormData.classNameId));
				webdavprops.setClassPK(Long.valueOf(webdavpropsFormData.classPK));
				webdavprops.setProps(webdavpropsFormData.props);
			}
			else {
				webdavprops = new Webdavprops(webdavpropsFormData);
			}

			Ebean.save(webdavprops);

			flash("success", "Webdavprops instance created/edited: " + webdavprops);

			return all();
		}
	}

	public static Result delete(Form<WebdavpropsFormData> formData) {
		WebdavpropsFormData webdavpropsFormData = formData.get();

		String id = webdavpropsFormData.webDavPropsId;

		long webdavpropsId = 0;

		if (id != null) {
			webdavpropsId = Long.valueOf(id);
		}

		Webdavprops webdavprops;

		if (webdavpropsId > 0) {
			webdavprops = Webdavprops.find.byId(webdavpropsId);

			Ebean.delete(webdavprops);
		}
		else {
			flash("error", "Cannot delete Webdavprops");
		}

		return all();
	}

}
