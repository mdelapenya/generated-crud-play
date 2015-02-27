
package controllers;

import com.avaje.ebean.Ebean;

import controllers.listtype.ListtypeFormData;

import models.listtype.Listtype;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.listtype.listtype;
import views.html.listtype.listtypes;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ListtypeApplication extends Controller {

	public static Result addListtype() {
		Form<ListtypeFormData> form = Form.form(
			ListtypeFormData.class).fill(new Listtype().toFormData());

		return ok(listtype.render(form));
	}

	public static Result get(Long id) {
		Listtype dbListtype = Listtype.find.byId(id);

		Form<ListtypeFormData> form = Form.form(
			ListtypeFormData.class).fill(dbListtype.toFormData());

		return ok(listtype.render(form));
	}

	public static Result all() {
		List<Listtype> listtypeList = Listtype.find.all();

		return ok(listtypes.render(listtypeList));
	}

	public static Result submit() {
		Form<ListtypeFormData> formData = Form.form(
			ListtypeFormData.class).bindFromRequest();

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

	public static Result edit(Form<ListtypeFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addListtype();
		}
		else {
			ListtypeFormData listtypeFormData = formData.get();

			String id = listtypeFormData.listTypeId;

			long listtypeId = 0;

			if (id != null) {
				listtypeId = Long.valueOf(id);
			}

			Listtype listtype;

			if (listtypeId > 0) {
				listtype = Listtype.find.byId(listtypeId);

				listtype.setMvccVersion(Long.valueOf(listtypeFormData.mvccVersion));
				listtype.setListTypeId(Long.valueOf(listtypeFormData.listTypeId));
				listtype.setName(listtypeFormData.name);
				listtype.setCustomtype(listtypeFormData.customtype);
			}
			else {
				listtype = new Listtype(listtypeFormData);
			}

			Ebean.save(listtype);

			flash("success", "Listtype instance created/edited: " + listtype);

			return all();
		}
	}

	public static Result delete(Form<ListtypeFormData> formData) {
		ListtypeFormData listtypeFormData = formData.get();

		String id = listtypeFormData.listTypeId;

		long listtypeId = 0;

		if (id != null) {
			listtypeId = Long.valueOf(id);
		}

		Listtype listtype;

		if (listtypeId > 0) {
			listtype = Listtype.find.byId(listtypeId);

			Ebean.delete(listtype);
		}
		else {
			flash("error", "Cannot delete Listtype");
		}

		return all();
	}

}
