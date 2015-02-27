
package controllers;

import com.avaje.ebean.Ebean;

import controllers.layout.LayoutFormData;

import models.layout.Layout;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.layout.layout;
import views.html.layout.layouts;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class LayoutApplication extends Controller {

	public static Result addLayout() {
		Form<LayoutFormData> form = Form.form(
			LayoutFormData.class).fill(new Layout().toFormData());

		return ok(layout.render(form));
	}

	public static Result get(Long id) {
		Layout dbLayout = Layout.find.byId(id);

		Form<LayoutFormData> form = Form.form(
			LayoutFormData.class).fill(dbLayout.toFormData());

		return ok(layout.render(form));
	}

	public static Result all() {
		List<Layout> layoutList = Layout.find.all();

		return ok(layouts.render(layoutList));
	}

	public static Result submit() {
		Form<LayoutFormData> formData = Form.form(
			LayoutFormData.class).bindFromRequest();

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

	public static Result edit(Form<LayoutFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addLayout();
		}
		else {
			LayoutFormData layoutFormData = formData.get();

			String id = layoutFormData.plid;

			long layoutId = 0;

			if (id != null) {
				layoutId = Long.valueOf(id);
			}

			Layout layout;

			if (layoutId > 0) {
				layout = Layout.find.byId(layoutId);

				layout.setMvccVersion(Long.valueOf(layoutFormData.mvccVersion));
				layout.setUuid(layoutFormData.uuid);
				layout.setPlid(Long.valueOf(layoutFormData.plid));
				layout.setGroupId(Long.valueOf(layoutFormData.groupId));
				layout.setCompanyId(Long.valueOf(layoutFormData.companyId));
				layout.setUserId(Long.valueOf(layoutFormData.userId));
				layout.setUserName(layoutFormData.userName);
				layout.setCreateDate(new Date(layoutFormData.createDate));
				layout.setModifiedDate(new Date(layoutFormData.modifiedDate));
				layout.setPrivateLayout(Boolean.valueOf(layoutFormData.privateLayout));
				layout.setLayoutId(Long.valueOf(layoutFormData.layoutId));
				layout.setParentLayoutId(Long.valueOf(layoutFormData.parentLayoutId));
				layout.setName(layoutFormData.name);
				layout.setTitle(layoutFormData.title);
				layout.setDescription(layoutFormData.description);
				layout.setKeywords(layoutFormData.keywords);
				layout.setRobots(layoutFormData.robots);
				layout.setCustomtype(layoutFormData.customtype);
				layout.setTypeSettings(layoutFormData.typeSettings);
				layout.setHidden(Boolean.valueOf(layoutFormData.hidden));
				layout.setFriendlyURL(layoutFormData.friendlyURL);
				layout.setIconImageId(Long.valueOf(layoutFormData.iconImageId));
				layout.setThemeId(layoutFormData.themeId);
				layout.setColorSchemeId(layoutFormData.colorSchemeId);
				layout.setWapThemeId(layoutFormData.wapThemeId);
				layout.setWapColorSchemeId(layoutFormData.wapColorSchemeId);
				layout.setCss(layoutFormData.css);
				layout.setPriority(Integer.valueOf(layoutFormData.priority));
				layout.setLayoutPrototypeUuid(layoutFormData.layoutPrototypeUuid);
				layout.setLayoutPrototypeLinkEnabled(Boolean.valueOf(layoutFormData.layoutPrototypeLinkEnabled));
				layout.setSourcePrototypeLayoutUuid(layoutFormData.sourcePrototypeLayoutUuid);
			}
			else {
				layout = new Layout(layoutFormData);
			}

			Ebean.save(layout);

			flash("success", "Layout instance created/edited: " + layout);

			return all();
		}
	}

	public static Result delete(Form<LayoutFormData> formData) {
		LayoutFormData layoutFormData = formData.get();

		String id = layoutFormData.plid;

		long layoutId = 0;

		if (id != null) {
			layoutId = Long.valueOf(id);
		}

		Layout layout;

		if (layoutId > 0) {
			layout = Layout.find.byId(layoutId);

			Ebean.delete(layout);
		}
		else {
			flash("error", "Cannot delete Layout");
		}

		return all();
	}

}
