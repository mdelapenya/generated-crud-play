
package controllers;

import com.avaje.ebean.Ebean;

import controllers.clustergroup.ClustergroupFormData;

import models.clustergroup.Clustergroup;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.clustergroup.clustergroup;
import views.html.clustergroup.clustergroups;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ClustergroupApplication extends Controller {

	public static Result addClustergroup() {
		Form<ClustergroupFormData> form = Form.form(
			ClustergroupFormData.class).fill(new Clustergroup().toFormData());

		return ok(clustergroup.render(form));
	}

	public static Result get(Long id) {
		Clustergroup dbClustergroup = Clustergroup.find.byId(id);

		Form<ClustergroupFormData> form = Form.form(
			ClustergroupFormData.class).fill(dbClustergroup.toFormData());

		return ok(clustergroup.render(form));
	}

	public static Result all() {
		List<Clustergroup> clustergroupList = Clustergroup.find.all();

		return ok(clustergroups.render(clustergroupList));
	}

	public static Result submit() {
		Form<ClustergroupFormData> formData = Form.form(
			ClustergroupFormData.class).bindFromRequest();

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

	public static Result edit(Form<ClustergroupFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addClustergroup();
		}
		else {
			ClustergroupFormData clustergroupFormData = formData.get();

			String id = clustergroupFormData.clusterGroupId;

			long clustergroupId = 0;

			if (id != null) {
				clustergroupId = Long.valueOf(id);
			}

			Clustergroup clustergroup;

			if (clustergroupId > 0) {
				clustergroup = Clustergroup.find.byId(clustergroupId);

				clustergroup.setMvccVersion(Long.valueOf(clustergroupFormData.mvccVersion));
				clustergroup.setClusterGroupId(Long.valueOf(clustergroupFormData.clusterGroupId));
				clustergroup.setName(clustergroupFormData.name);
				clustergroup.setClusterNodeIds(clustergroupFormData.clusterNodeIds);
				clustergroup.setWholeCluster(Boolean.valueOf(clustergroupFormData.wholeCluster));
			}
			else {
				clustergroup = new Clustergroup(clustergroupFormData);
			}

			Ebean.save(clustergroup);

			flash("success", "Clustergroup instance created/edited: " + clustergroup);

			return all();
		}
	}

	public static Result delete(Form<ClustergroupFormData> formData) {
		ClustergroupFormData clustergroupFormData = formData.get();

		String id = clustergroupFormData.clusterGroupId;

		long clustergroupId = 0;

		if (id != null) {
			clustergroupId = Long.valueOf(id);
		}

		Clustergroup clustergroup;

		if (clustergroupId > 0) {
			clustergroup = Clustergroup.find.byId(clustergroupId);

			Ebean.delete(clustergroup);
		}
		else {
			flash("error", "Cannot delete Clustergroup");
		}

		return all();
	}

}
