
package controllers;

import com.avaje.ebean.Ebean;

import controllers.blogsentry.BlogsentryFormData;

import models.blogsentry.Blogsentry;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.blogsentry.blogsentry;
import views.html.blogsentry.blogsentrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class BlogsentryApplication extends Controller {

	public static Result addBlogsentry() {
		Form<BlogsentryFormData> form = Form.form(
			BlogsentryFormData.class).fill(new Blogsentry().toFormData());

		return ok(blogsentry.render(form));
	}

	public static Result get(Long id) {
		Blogsentry dbBlogsentry = Blogsentry.find.byId(id);

		Form<BlogsentryFormData> form = Form.form(
			BlogsentryFormData.class).fill(dbBlogsentry.toFormData());

		return ok(blogsentry.render(form));
	}

	public static Result all() {
		List<Blogsentry> blogsentryList = Blogsentry.find.all();

		return ok(blogsentrys.render(blogsentryList));
	}

	public static Result submit() {
		Form<BlogsentryFormData> formData = Form.form(
			BlogsentryFormData.class).bindFromRequest();

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

	public static Result edit(Form<BlogsentryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addBlogsentry();
		}
		else {
			BlogsentryFormData blogsentryFormData = formData.get();

			String id = blogsentryFormData.entryId;

			long blogsentryId = 0;

			if (id != null) {
				blogsentryId = Long.valueOf(id);
			}

			Blogsentry blogsentry;

			if (blogsentryId > 0) {
				blogsentry = Blogsentry.find.byId(blogsentryId);

				blogsentry.setUuid(blogsentryFormData.uuid);
				blogsentry.setEntryId(Long.valueOf(blogsentryFormData.entryId));
				blogsentry.setGroupId(Long.valueOf(blogsentryFormData.groupId));
				blogsentry.setCompanyId(Long.valueOf(blogsentryFormData.companyId));
				blogsentry.setUserId(Long.valueOf(blogsentryFormData.userId));
				blogsentry.setUserName(blogsentryFormData.userName);
				blogsentry.setCreateDate(new Date(blogsentryFormData.createDate));
				blogsentry.setModifiedDate(new Date(blogsentryFormData.modifiedDate));
				blogsentry.setTitle(blogsentryFormData.title);
				blogsentry.setSubtitle(blogsentryFormData.subtitle);
				blogsentry.setUrlTitle(blogsentryFormData.urlTitle);
				blogsentry.setDescription(blogsentryFormData.description);
				blogsentry.setContent(blogsentryFormData.content);
				blogsentry.setDisplayDate(new Date(blogsentryFormData.displayDate));
				blogsentry.setAllowPingbacks(Boolean.valueOf(blogsentryFormData.allowPingbacks));
				blogsentry.setAllowTrackbacks(Boolean.valueOf(blogsentryFormData.allowTrackbacks));
				blogsentry.setTrackbacks(blogsentryFormData.trackbacks);
				blogsentry.setCoverImageFileEntryId(Long.valueOf(blogsentryFormData.coverImageFileEntryId));
				blogsentry.setCoverImageURL(blogsentryFormData.coverImageURL);
				blogsentry.setSmallImage(Boolean.valueOf(blogsentryFormData.smallImage));
				blogsentry.setSmallImageFileEntryId(Long.valueOf(blogsentryFormData.smallImageFileEntryId));
				blogsentry.setSmallImageId(Long.valueOf(blogsentryFormData.smallImageId));
				blogsentry.setSmallImageURL(blogsentryFormData.smallImageURL);
				blogsentry.setStatus(Integer.valueOf(blogsentryFormData.status));
				blogsentry.setStatusByUserId(Long.valueOf(blogsentryFormData.statusByUserId));
				blogsentry.setStatusByUserName(blogsentryFormData.statusByUserName);
				blogsentry.setStatusDate(new Date(blogsentryFormData.statusDate));
			}
			else {
				blogsentry = new Blogsentry(blogsentryFormData);
			}

			Ebean.save(blogsentry);

			flash("success", "Blogsentry instance created/edited: " + blogsentry);

			return all();
		}
	}

	public static Result delete(Form<BlogsentryFormData> formData) {
		BlogsentryFormData blogsentryFormData = formData.get();

		String id = blogsentryFormData.entryId;

		long blogsentryId = 0;

		if (id != null) {
			blogsentryId = Long.valueOf(id);
		}

		Blogsentry blogsentry;

		if (blogsentryId > 0) {
			blogsentry = Blogsentry.find.byId(blogsentryId);

			Ebean.delete(blogsentry);
		}
		else {
			flash("error", "Cannot delete Blogsentry");
		}

		return all();
	}

}
