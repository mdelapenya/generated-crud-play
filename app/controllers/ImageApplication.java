
package controllers;

import com.avaje.ebean.Ebean;

import controllers.image.ImageFormData;

import models.image.Image;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.image.image;
import views.html.image.images;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ImageApplication extends Controller {

	public static Result addImage() {
		Form<ImageFormData> form = Form.form(
			ImageFormData.class).fill(new Image().toFormData());

		return ok(image.render(form));
	}

	public static Result get(Long id) {
		Image dbImage = Image.find.byId(id);

		Form<ImageFormData> form = Form.form(
			ImageFormData.class).fill(dbImage.toFormData());

		return ok(image.render(form));
	}

	public static Result all() {
		List<Image> imageList = Image.find.all();

		return ok(images.render(imageList));
	}

	public static Result submit() {
		Form<ImageFormData> formData = Form.form(
			ImageFormData.class).bindFromRequest();

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

	public static Result edit(Form<ImageFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addImage();
		}
		else {
			ImageFormData imageFormData = formData.get();

			String id = imageFormData.imageId;

			long imageId = 0;

			if (id != null) {
				imageId = Long.valueOf(id);
			}

			Image image;

			if (imageId > 0) {
				image = Image.find.byId(imageId);

				image.setMvccVersion(Long.valueOf(imageFormData.mvccVersion));
				image.setImageId(Long.valueOf(imageFormData.imageId));
				image.setModifiedDate(new Date(imageFormData.modifiedDate));
				image.setCustomtype(imageFormData.customtype);
				image.setHeight(Integer.valueOf(imageFormData.height));
				image.setWidth(Integer.valueOf(imageFormData.width));
				image.setSize(Integer.valueOf(imageFormData.size));
			}
			else {
				image = new Image(imageFormData);
			}

			Ebean.save(image);

			flash("success", "Image instance created/edited: " + image);

			return all();
		}
	}

	public static Result delete(Form<ImageFormData> formData) {
		ImageFormData imageFormData = formData.get();

		String id = imageFormData.imageId;

		long imageId = 0;

		if (id != null) {
			imageId = Long.valueOf(id);
		}

		Image image;

		if (imageId > 0) {
			image = Image.find.byId(imageId);

			Ebean.delete(image);
		}
		else {
			flash("error", "Cannot delete Image");
		}

		return all();
	}

}
