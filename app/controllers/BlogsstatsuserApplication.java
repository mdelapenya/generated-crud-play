
package controllers;

import com.avaje.ebean.Ebean;

import controllers.blogsstatsuser.BlogsstatsuserFormData;

import models.blogsstatsuser.Blogsstatsuser;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.blogsstatsuser.blogsstatsuser;
import views.html.blogsstatsuser.blogsstatsusers;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class BlogsstatsuserApplication extends Controller {

	public static Result addBlogsstatsuser() {
		Form<BlogsstatsuserFormData> form = Form.form(
			BlogsstatsuserFormData.class).fill(new Blogsstatsuser().toFormData());

		return ok(blogsstatsuser.render(form));
	}

	public static Result get(Long id) {
		Blogsstatsuser dbBlogsstatsuser = Blogsstatsuser.find.byId(id);

		Form<BlogsstatsuserFormData> form = Form.form(
			BlogsstatsuserFormData.class).fill(dbBlogsstatsuser.toFormData());

		return ok(blogsstatsuser.render(form));
	}

	public static Result all() {
		List<Blogsstatsuser> blogsstatsuserList = Blogsstatsuser.find.all();

		return ok(blogsstatsusers.render(blogsstatsuserList));
	}

	public static Result submit() {
		Form<BlogsstatsuserFormData> formData = Form.form(
			BlogsstatsuserFormData.class).bindFromRequest();

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

	public static Result edit(Form<BlogsstatsuserFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addBlogsstatsuser();
		}
		else {
			BlogsstatsuserFormData blogsstatsuserFormData = formData.get();

			String id = blogsstatsuserFormData.statsUserId;

			long blogsstatsuserId = 0;

			if (id != null) {
				blogsstatsuserId = Long.valueOf(id);
			}

			Blogsstatsuser blogsstatsuser;

			if (blogsstatsuserId > 0) {
				blogsstatsuser = Blogsstatsuser.find.byId(blogsstatsuserId);

				blogsstatsuser.setStatsUserId(Long.valueOf(blogsstatsuserFormData.statsUserId));
				blogsstatsuser.setGroupId(Long.valueOf(blogsstatsuserFormData.groupId));
				blogsstatsuser.setCompanyId(Long.valueOf(blogsstatsuserFormData.companyId));
				blogsstatsuser.setUserId(Long.valueOf(blogsstatsuserFormData.userId));
				blogsstatsuser.setEntryCount(Integer.valueOf(blogsstatsuserFormData.entryCount));
				blogsstatsuser.setLastPostDate(new Date(blogsstatsuserFormData.lastPostDate));
				blogsstatsuser.setRatingsTotalEntries(Integer.valueOf(blogsstatsuserFormData.ratingsTotalEntries));
				blogsstatsuser.setRatingsTotalScore(Double.valueOf(blogsstatsuserFormData.ratingsTotalScore));
				blogsstatsuser.setRatingsAverageScore(Double.valueOf(blogsstatsuserFormData.ratingsAverageScore));
			}
			else {
				blogsstatsuser = new Blogsstatsuser(blogsstatsuserFormData);
			}

			Ebean.save(blogsstatsuser);

			flash("success", "Blogsstatsuser instance created/edited: " + blogsstatsuser);

			return all();
		}
	}

	public static Result delete(Form<BlogsstatsuserFormData> formData) {
		BlogsstatsuserFormData blogsstatsuserFormData = formData.get();

		String id = blogsstatsuserFormData.statsUserId;

		long blogsstatsuserId = 0;

		if (id != null) {
			blogsstatsuserId = Long.valueOf(id);
		}

		Blogsstatsuser blogsstatsuser;

		if (blogsstatsuserId > 0) {
			blogsstatsuser = Blogsstatsuser.find.byId(blogsstatsuserId);

			Ebean.delete(blogsstatsuser);
		}
		else {
			flash("error", "Cannot delete Blogsstatsuser");
		}

		return all();
	}

}
