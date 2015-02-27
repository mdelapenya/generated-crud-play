
package controllers;

import com.avaje.ebean.Ebean;

import controllers.assetentry.AssetentryFormData;

import models.assetentry.Assetentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.assetentry.assetentry;
import views.html.assetentry.assetentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AssetentryApplication extends Controller {

	public static Result addAssetentry() {
		Form<AssetentryFormData> form = Form.form(
			AssetentryFormData.class).fill(new Assetentry().toFormData());

		return ok(assetentry.render(form));
	}

	public static Result get(Long id) {
		Assetentry dbAssetentry = Assetentry.find.byId(id);

		Form<AssetentryFormData> form = Form.form(
			AssetentryFormData.class).fill(dbAssetentry.toFormData());

		return ok(assetentry.render(form));
	}

	public static Result all() {
		List<Assetentry> assetentryList = Assetentry.find.all();

		return ok(assetentrys.render(assetentryList));
	}

	public static Result submit() {
		Form<AssetentryFormData> formData = Form.form(
			AssetentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<AssetentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAssetentry();
		}
		else {
			AssetentryFormData assetentryFormData = formData.get();

			String id = assetentryFormData.entryId;

			long assetentryId = 0;

			if (id != null) {
				assetentryId = Long.valueOf(id);
			}

			Assetentry assetentry;

			if (assetentryId > 0) {
				assetentry = Assetentry.find.byId(assetentryId);

				assetentry.setEntryId(Long.valueOf(assetentryFormData.entryId));
				assetentry.setGroupId(Long.valueOf(assetentryFormData.groupId));
				assetentry.setCompanyId(Long.valueOf(assetentryFormData.companyId));
				assetentry.setUserId(Long.valueOf(assetentryFormData.userId));
				assetentry.setUserName(assetentryFormData.userName);
				assetentry.setCreateDate(new Date(assetentryFormData.createDate));
				assetentry.setModifiedDate(new Date(assetentryFormData.modifiedDate));
				assetentry.setClassNameId(Long.valueOf(assetentryFormData.classNameId));
				assetentry.setClassPK(Long.valueOf(assetentryFormData.classPK));
				assetentry.setClassUuid(assetentryFormData.classUuid);
				assetentry.setClassTypeId(Long.valueOf(assetentryFormData.classTypeId));
				assetentry.setListable(Boolean.valueOf(assetentryFormData.listable));
				assetentry.setVisible(Boolean.valueOf(assetentryFormData.visible));
				assetentry.setStartDate(new Date(assetentryFormData.startDate));
				assetentry.setEndDate(new Date(assetentryFormData.endDate));
				assetentry.setPublishDate(new Date(assetentryFormData.publishDate));
				assetentry.setExpirationDate(new Date(assetentryFormData.expirationDate));
				assetentry.setMimeType(assetentryFormData.mimeType);
				assetentry.setTitle(assetentryFormData.title);
				assetentry.setDescription(assetentryFormData.description);
				assetentry.setSummary(assetentryFormData.summary);
				assetentry.setUrl(assetentryFormData.url);
				assetentry.setLayoutUuid(assetentryFormData.layoutUuid);
				assetentry.setHeight(Integer.valueOf(assetentryFormData.height));
				assetentry.setWidth(Integer.valueOf(assetentryFormData.width));
				assetentry.setPriority(Double.valueOf(assetentryFormData.priority));
				assetentry.setViewCount(Integer.valueOf(assetentryFormData.viewCount));
			}
			else {
				assetentry = new Assetentry(assetentryFormData);
			}

			Ebean.save(assetentry);

			flash("success", "Assetentry instance created/edited: " + assetentry);

			return all();
		}
	}

	public static Result delete(Form<AssetentryFormData> formData) {
		AssetentryFormData assetentryFormData = formData.get();

		String id = assetentryFormData.entryId;

		long assetentryId = 0;

		if (id != null) {
			assetentryId = Long.valueOf(id);
		}

		Assetentry assetentry;

		if (assetentryId > 0) {
			assetentry = Assetentry.find.byId(assetentryId);

			Ebean.delete(assetentry);
		}
		else {
			flash("error", "Cannot delete Assetentry");
		}

		return all();
	}

}
