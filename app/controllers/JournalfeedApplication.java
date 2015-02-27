
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalfeed.JournalfeedFormData;

import models.journalfeed.Journalfeed;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalfeed.journalfeed;
import views.html.journalfeed.journalfeeds;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalfeedApplication extends Controller {

	public static Result addJournalfeed() {
		Form<JournalfeedFormData> form = Form.form(
			JournalfeedFormData.class).fill(new Journalfeed().toFormData());

		return ok(journalfeed.render(form));
	}

	public static Result get(Long id) {
		Journalfeed dbJournalfeed = Journalfeed.find.byId(id);

		Form<JournalfeedFormData> form = Form.form(
			JournalfeedFormData.class).fill(dbJournalfeed.toFormData());

		return ok(journalfeed.render(form));
	}

	public static Result all() {
		List<Journalfeed> journalfeedList = Journalfeed.find.all();

		return ok(journalfeeds.render(journalfeedList));
	}

	public static Result submit() {
		Form<JournalfeedFormData> formData = Form.form(
			JournalfeedFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalfeedFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalfeed();
		}
		else {
			JournalfeedFormData journalfeedFormData = formData.get();

			String id = journalfeedFormData.id;

			long journalfeedId = 0;

			if (id != null) {
				journalfeedId = Long.valueOf(id);
			}

			Journalfeed journalfeed;

			if (journalfeedId > 0) {
				journalfeed = Journalfeed.find.byId(journalfeedId);

				journalfeed.setUuid(journalfeedFormData.uuid);
				journalfeed.setId(Long.valueOf(journalfeedFormData.id));
				journalfeed.setGroupId(Long.valueOf(journalfeedFormData.groupId));
				journalfeed.setCompanyId(Long.valueOf(journalfeedFormData.companyId));
				journalfeed.setUserId(Long.valueOf(journalfeedFormData.userId));
				journalfeed.setUserName(journalfeedFormData.userName);
				journalfeed.setCreateDate(new Date(journalfeedFormData.createDate));
				journalfeed.setModifiedDate(new Date(journalfeedFormData.modifiedDate));
				journalfeed.setFeedId(journalfeedFormData.feedId);
				journalfeed.setName(journalfeedFormData.name);
				journalfeed.setDescription(journalfeedFormData.description);
				journalfeed.setDDMStructureKey(journalfeedFormData.DDMStructureKey);
				journalfeed.setDDMTemplateKey(journalfeedFormData.DDMTemplateKey);
				journalfeed.setDDMRendererTemplateKey(journalfeedFormData.DDMRendererTemplateKey);
				journalfeed.setDelta(Integer.valueOf(journalfeedFormData.delta));
				journalfeed.setOrderByCol(journalfeedFormData.orderByCol);
				journalfeed.setOrderByType(journalfeedFormData.orderByType);
				journalfeed.setTargetLayoutFriendlyUrl(journalfeedFormData.targetLayoutFriendlyUrl);
				journalfeed.setTargetPortletId(journalfeedFormData.targetPortletId);
				journalfeed.setContentField(journalfeedFormData.contentField);
				journalfeed.setFeedFormat(journalfeedFormData.feedFormat);
				journalfeed.setFeedVersion(Double.valueOf(journalfeedFormData.feedVersion));
			}
			else {
				journalfeed = new Journalfeed(journalfeedFormData);
			}

			Ebean.save(journalfeed);

			flash("success", "Journalfeed instance created/edited: " + journalfeed);

			return all();
		}
	}

	public static Result delete(Form<JournalfeedFormData> formData) {
		JournalfeedFormData journalfeedFormData = formData.get();

		String id = journalfeedFormData.id;

		long journalfeedId = 0;

		if (id != null) {
			journalfeedId = Long.valueOf(id);
		}

		Journalfeed journalfeed;

		if (journalfeedId > 0) {
			journalfeed = Journalfeed.find.byId(journalfeedId);

			Ebean.delete(journalfeed);
		}
		else {
			flash("error", "Cannot delete Journalfeed");
		}

		return all();
	}

}
