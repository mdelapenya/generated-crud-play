
package controllers;

import com.avaje.ebean.Ebean;

import controllers.orglabor.OrglaborFormData;

import models.orglabor.Orglabor;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.orglabor.orglabor;
import views.html.orglabor.orglabors;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class OrglaborApplication extends Controller {

	public static Result addOrglabor() {
		Form<OrglaborFormData> form = Form.form(
			OrglaborFormData.class).fill(new Orglabor().toFormData());

		return ok(orglabor.render(form));
	}

	public static Result get(Long id) {
		Orglabor dbOrglabor = Orglabor.find.byId(id);

		Form<OrglaborFormData> form = Form.form(
			OrglaborFormData.class).fill(dbOrglabor.toFormData());

		return ok(orglabor.render(form));
	}

	public static Result all() {
		List<Orglabor> orglaborList = Orglabor.find.all();

		return ok(orglabors.render(orglaborList));
	}

	public static Result submit() {
		Form<OrglaborFormData> formData = Form.form(
			OrglaborFormData.class).bindFromRequest();

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

	public static Result edit(Form<OrglaborFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addOrglabor();
		}
		else {
			OrglaborFormData orglaborFormData = formData.get();

			String id = orglaborFormData.orgLaborId;

			long orglaborId = 0;

			if (id != null) {
				orglaborId = Long.valueOf(id);
			}

			Orglabor orglabor;

			if (orglaborId > 0) {
				orglabor = Orglabor.find.byId(orglaborId);

				orglabor.setMvccVersion(Long.valueOf(orglaborFormData.mvccVersion));
				orglabor.setOrgLaborId(Long.valueOf(orglaborFormData.orgLaborId));
				orglabor.setOrganizationId(Long.valueOf(orglaborFormData.organizationId));
				orglabor.setTypeId(Long.valueOf(orglaborFormData.typeId));
				orglabor.setSunOpen(Integer.valueOf(orglaborFormData.sunOpen));
				orglabor.setSunClose(Integer.valueOf(orglaborFormData.sunClose));
				orglabor.setMonOpen(Integer.valueOf(orglaborFormData.monOpen));
				orglabor.setMonClose(Integer.valueOf(orglaborFormData.monClose));
				orglabor.setTueOpen(Integer.valueOf(orglaborFormData.tueOpen));
				orglabor.setTueClose(Integer.valueOf(orglaborFormData.tueClose));
				orglabor.setWedOpen(Integer.valueOf(orglaborFormData.wedOpen));
				orglabor.setWedClose(Integer.valueOf(orglaborFormData.wedClose));
				orglabor.setThuOpen(Integer.valueOf(orglaborFormData.thuOpen));
				orglabor.setThuClose(Integer.valueOf(orglaborFormData.thuClose));
				orglabor.setFriOpen(Integer.valueOf(orglaborFormData.friOpen));
				orglabor.setFriClose(Integer.valueOf(orglaborFormData.friClose));
				orglabor.setSatOpen(Integer.valueOf(orglaborFormData.satOpen));
				orglabor.setSatClose(Integer.valueOf(orglaborFormData.satClose));
			}
			else {
				orglabor = new Orglabor(orglaborFormData);
			}

			Ebean.save(orglabor);

			flash("success", "Orglabor instance created/edited: " + orglabor);

			return all();
		}
	}

	public static Result delete(Form<OrglaborFormData> formData) {
		OrglaborFormData orglaborFormData = formData.get();

		String id = orglaborFormData.orgLaborId;

		long orglaborId = 0;

		if (id != null) {
			orglaborId = Long.valueOf(id);
		}

		Orglabor orglabor;

		if (orglaborId > 0) {
			orglabor = Orglabor.find.byId(orglaborId);

			Ebean.delete(orglabor);
		}
		else {
			flash("error", "Cannot delete Orglabor");
		}

		return all();
	}

}
