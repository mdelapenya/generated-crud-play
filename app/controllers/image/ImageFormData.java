package controllers.image;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Image data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class ImageFormData {

	public String mvccVersion;
	public String imageId;
	public String modifiedDate;
	public String customtype;
	public String height;
	public String width;
	public String size;

	public ImageFormData() {
	}

	public ImageFormData(
		String mvccVersion,
				String imageId,
				String modifiedDate,
				String customtype,
				String height,
				String width,
				String size
		) {

		this.mvccVersion = mvccVersion;
		this.imageId = imageId;
		this.modifiedDate = modifiedDate;
		this.customtype = customtype;
		this.height = height;
		this.width = width;
		this.size = size;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (imageId == null || imageId.length() == 0) {
			errors.add(new ValidationError("imageId", "No imageId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
