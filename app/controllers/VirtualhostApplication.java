
package controllers;

import com.avaje.ebean.Ebean;

import controllers.virtualhost.VirtualhostFormData;

import models.virtualhost.Virtualhost;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.virtualhost.virtualhost;
import views.html.virtualhost.virtualhosts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class VirtualhostApplication extends Controller {

	public static Result addVirtualhost() {
		Form<VirtualhostFormData> form = Form.form(
			VirtualhostFormData.class).fill(new Virtualhost().toFormData());

		return ok(virtualhost.render(form));
	}

	public static Result get(Long id) {
		Virtualhost dbVirtualhost = Virtualhost.find.byId(id);

		Form<VirtualhostFormData> form = Form.form(
			VirtualhostFormData.class).fill(dbVirtualhost.toFormData());

		return ok(virtualhost.render(form));
	}

	public static Result all() {
		List<Virtualhost> virtualhostList = Virtualhost.find.all();

		return ok(virtualhosts.render(virtualhostList));
	}

	public static Result submit() {
		Form<VirtualhostFormData> formData = Form.form(
			VirtualhostFormData.class).bindFromRequest();

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

	public static Result edit(Form<VirtualhostFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addVirtualhost();
		}
		else {
			VirtualhostFormData virtualhostFormData = formData.get();

			String id = virtualhostFormData.virtualHostId;

			long virtualhostId = 0;

			if (id != null) {
				virtualhostId = Long.valueOf(id);
			}

			Virtualhost virtualhost;

			if (virtualhostId > 0) {
				virtualhost = Virtualhost.find.byId(virtualhostId);

				virtualhost.setMvccVersion(Long.valueOf(virtualhostFormData.mvccVersion));
				virtualhost.setVirtualHostId(Long.valueOf(virtualhostFormData.virtualHostId));
				virtualhost.setCompanyId(Long.valueOf(virtualhostFormData.companyId));
				virtualhost.setLayoutSetId(Long.valueOf(virtualhostFormData.layoutSetId));
				virtualhost.setHostname(virtualhostFormData.hostname);
			}
			else {
				virtualhost = new Virtualhost(virtualhostFormData);
			}

			Ebean.save(virtualhost);

			flash("success", "Virtualhost instance created/edited: " + virtualhost);

			return all();
		}
	}

	public static Result delete(Form<VirtualhostFormData> formData) {
		VirtualhostFormData virtualhostFormData = formData.get();

		String id = virtualhostFormData.virtualHostId;

		long virtualhostId = 0;

		if (id != null) {
			virtualhostId = Long.valueOf(id);
		}

		Virtualhost virtualhost;

		if (virtualhostId > 0) {
			virtualhost = Virtualhost.find.byId(virtualhostId);

			Ebean.delete(virtualhost);
		}
		else {
			flash("error", "Cannot delete Virtualhost");
		}

		return all();
	}

}
