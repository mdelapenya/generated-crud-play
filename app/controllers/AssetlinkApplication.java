
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assetlink.AssetlinkFormData;

import models.assetlink.Assetlink;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assetlink.assetlink;
import views.html.assetlink.assetlinks;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssetlinkApplication extends Controller {

	public static Result addAssetlink() {
		Form<AssetlinkFormData> form = Form.form(
			AssetlinkFormData.class).fill(new Assetlink().toFormData());

		return ok(assetlink.render(form));
	}

	public static Result get(Long id) {
		Assetlink dbAssetlink = Assetlink.find.byId(id);

		Form<AssetlinkFormData> form = Form.form(
			AssetlinkFormData.class).fill(dbAssetlink.toFormData());

		return ok(assetlink.render(form));
	}

	public static Result all() {
		List<Assetlink> assetlinkList = Assetlink.find.all();

		return ok(assetlinks.render(assetlinkList));
	}

	public static Result submit() {
		Form<AssetlinkFormData> formData = Form.form(
			AssetlinkFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssetlinkFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssetlink();
		}
		else {
			AssetlinkFormData assetlinkFormData = formData.get();

			String id = assetlinkFormData.linkId;

			long assetlinkId = 0;

			if (id != null) {
				assetlinkId = Long.valueOf(id);
			}

			Assetlink assetlink;

			if (assetlinkId > 0) {
				assetlink = Assetlink.find.byId(assetlinkId);

				assetlink.setLinkId(Long.valueOf(assetlinkFormData.linkId));
				assetlink.setCompanyId(Long.valueOf(assetlinkFormData.companyId));
				assetlink.setUserId(Long.valueOf(assetlinkFormData.userId));
				assetlink.setUserName(assetlinkFormData.userName);
				assetlink.setCreateDate(new Date(assetlinkFormData.createDate));
				assetlink.setEntryId1(Long.valueOf(assetlinkFormData.entryId1));
				assetlink.setEntryId2(Long.valueOf(assetlinkFormData.entryId2));
				assetlink.setCustomtype(Integer.valueOf(assetlinkFormData.customtype));
				assetlink.setWeight(Integer.valueOf(assetlinkFormData.weight));
			}
			else {
				assetlink = new Assetlink(assetlinkFormData);
			}

			Ebean.save(assetlink);

			flash("success", "Assetlink instance created/edited: " + assetlink);

			return all();
		}
	}

	public static Result delete(Form<AssetlinkFormData> formData) {
		AssetlinkFormData assetlinkFormData = formData.get();

		String id = assetlinkFormData.linkId;

		long assetlinkId = 0;

		if (id != null) {
			assetlinkId = Long.valueOf(id);
		}

		Assetlink assetlink;

		if (assetlinkId > 0) {
			assetlink = Assetlink.find.byId(assetlinkId);

			Ebean.delete(assetlink);
		}
		else {
			flash("error", "Cannot delete Assetlink");
		}

		return all();
	}

}
