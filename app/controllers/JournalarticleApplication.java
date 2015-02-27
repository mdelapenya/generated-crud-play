
package controllers;

import com.avaje.ebean.Ebean;

import controllers.journalarticle.JournalarticleFormData;

import models.journalarticle.Journalarticle;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.journalarticle.journalarticle;
import views.html.journalarticle.journalarticles;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class JournalarticleApplication extends Controller {

	public static Result addJournalarticle() {
		Form<JournalarticleFormData> form = Form.form(
			JournalarticleFormData.class).fill(new Journalarticle().toFormData());

		return ok(journalarticle.render(form));
	}

	public static Result get(Long id) {
		Journalarticle dbJournalarticle = Journalarticle.find.byId(id);

		Form<JournalarticleFormData> form = Form.form(
			JournalarticleFormData.class).fill(dbJournalarticle.toFormData());

		return ok(journalarticle.render(form));
	}

	public static Result all() {
		List<Journalarticle> journalarticleList = Journalarticle.find.all();

		return ok(journalarticles.render(journalarticleList));
	}

	public static Result submit() {
		Form<JournalarticleFormData> formData = Form.form(
			JournalarticleFormData.class).bindFromRequest();

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

	public static Result edit(Form<JournalarticleFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addJournalarticle();
		}
		else {
			JournalarticleFormData journalarticleFormData = formData.get();

			String id = journalarticleFormData.id;

			long journalarticleId = 0;

			if (id != null) {
				journalarticleId = Long.valueOf(id);
			}

			Journalarticle journalarticle;

			if (journalarticleId > 0) {
				journalarticle = Journalarticle.find.byId(journalarticleId);

				journalarticle.setUuid(journalarticleFormData.uuid);
				journalarticle.setId(Long.valueOf(journalarticleFormData.id));
				journalarticle.setResourcePrimKey(Long.valueOf(journalarticleFormData.resourcePrimKey));
				journalarticle.setGroupId(Long.valueOf(journalarticleFormData.groupId));
				journalarticle.setCompanyId(Long.valueOf(journalarticleFormData.companyId));
				journalarticle.setUserId(Long.valueOf(journalarticleFormData.userId));
				journalarticle.setUserName(journalarticleFormData.userName);
				journalarticle.setCreateDate(new Date(journalarticleFormData.createDate));
				journalarticle.setModifiedDate(new Date(journalarticleFormData.modifiedDate));
				journalarticle.setFolderId(Long.valueOf(journalarticleFormData.folderId));
				journalarticle.setClassNameId(Long.valueOf(journalarticleFormData.classNameId));
				journalarticle.setClassPK(Long.valueOf(journalarticleFormData.classPK));
				journalarticle.setTreePath(journalarticleFormData.treePath);
				journalarticle.setArticleId(journalarticleFormData.articleId);
				journalarticle.setVersion(Double.valueOf(journalarticleFormData.version));
				journalarticle.setTitle(journalarticleFormData.title);
				journalarticle.setUrlTitle(journalarticleFormData.urlTitle);
				journalarticle.setDescription(journalarticleFormData.description);
				journalarticle.setContent(journalarticleFormData.content);
				journalarticle.setDDMStructureKey(journalarticleFormData.DDMStructureKey);
				journalarticle.setDDMTemplateKey(journalarticleFormData.DDMTemplateKey);
				journalarticle.setLayoutUuid(journalarticleFormData.layoutUuid);
				journalarticle.setDisplayDate(new Date(journalarticleFormData.displayDate));
				journalarticle.setExpirationDate(new Date(journalarticleFormData.expirationDate));
				journalarticle.setReviewDate(new Date(journalarticleFormData.reviewDate));
				journalarticle.setIndexable(Boolean.valueOf(journalarticleFormData.indexable));
				journalarticle.setSmallImage(Boolean.valueOf(journalarticleFormData.smallImage));
				journalarticle.setSmallImageId(Long.valueOf(journalarticleFormData.smallImageId));
				journalarticle.setSmallImageURL(journalarticleFormData.smallImageURL);
				journalarticle.setStatus(Integer.valueOf(journalarticleFormData.status));
				journalarticle.setStatusByUserId(Long.valueOf(journalarticleFormData.statusByUserId));
				journalarticle.setStatusByUserName(journalarticleFormData.statusByUserName);
				journalarticle.setStatusDate(new Date(journalarticleFormData.statusDate));
			}
			else {
				journalarticle = new Journalarticle(journalarticleFormData);
			}

			Ebean.save(journalarticle);

			flash("success", "Journalarticle instance created/edited: " + journalarticle);

			return all();
		}
	}

	public static Result delete(Form<JournalarticleFormData> formData) {
		JournalarticleFormData journalarticleFormData = formData.get();

		String id = journalarticleFormData.id;

		long journalarticleId = 0;

		if (id != null) {
			journalarticleId = Long.valueOf(id);
		}

		Journalarticle journalarticle;

		if (journalarticleId > 0) {
			journalarticle = Journalarticle.find.byId(journalarticleId);

			Ebean.delete(journalarticle);
		}
		else {
			flash("error", "Cannot delete Journalarticle");
		}

		return all();
	}

}
