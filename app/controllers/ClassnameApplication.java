
package controllers;

import com.avaje.ebean.Ebean;

import controllers.classname.ClassnameFormData;

import models.classname.Classname;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.classname.classname;
import views.html.classname.classnames;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ClassnameApplication extends Controller {

	public static Result addClassname() {
		Form<ClassnameFormData> form = Form.form(
			ClassnameFormData.class).fill(new Classname().toFormData());

		return ok(classname.render(form));
	}

	public static Result get(Long id) {
		Classname dbClassname = Classname.find.byId(id);

		Form<ClassnameFormData> form = Form.form(
			ClassnameFormData.class).fill(dbClassname.toFormData());

		return ok(classname.render(form));
	}

	public static Result all() {
		List<Classname> classnameList = Classname.find.all();

		return ok(classnames.render(classnameList));
	}

	public static Result submit() {
		Form<ClassnameFormData> formData = Form.form(
			ClassnameFormData.class).bindFromRequest();

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

	public static Result edit(Form<ClassnameFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addClassname();
		}
		else {
			ClassnameFormData classnameFormData = formData.get();

			String id = classnameFormData.classNameId;

			long classnameId = 0;

			if (id != null) {
				classnameId = Long.valueOf(id);
			}

			Classname classname;

			if (classnameId > 0) {
				classname = Classname.find.byId(classnameId);

				classname.setMvccVersion(Long.valueOf(classnameFormData.mvccVersion));
				classname.setClassNameId(Long.valueOf(classnameFormData.classNameId));
				classname.setValue(classnameFormData.value);
			}
			else {
				classname = new Classname(classnameFormData);
			}

			Ebean.save(classname);

			flash("success", "Classname instance created/edited: " + classname);

			return all();
		}
	}

	public static Result delete(Form<ClassnameFormData> formData) {
		ClassnameFormData classnameFormData = formData.get();

		String id = classnameFormData.classNameId;

		long classnameId = 0;

		if (id != null) {
			classnameId = Long.valueOf(id);
		}

		Classname classname;

		if (classnameId > 0) {
			classname = Classname.find.byId(classnameId);

			Ebean.delete(classname);
		}
		else {
			flash("error", "Cannot delete Classname");
		}

		return all();
	}

}
