package controllers.scproductscreenshot;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Scproductscreenshot data form.
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
public class ScproductscreenshotFormData {

	public String productScreenshotId;
	public String companyId;
	public String groupId;
	public String productEntryId;
	public String thumbnailId;
	public String fullImageId;
	public String priority;

	public ScproductscreenshotFormData() {
	}

	public ScproductscreenshotFormData(
		String productScreenshotId,
				String companyId,
				String groupId,
				String productEntryId,
				String thumbnailId,
				String fullImageId,
				String priority
		) {

		this.productScreenshotId = productScreenshotId;
		this.companyId = companyId;
		this.groupId = groupId;
		this.productEntryId = productEntryId;
		this.thumbnailId = thumbnailId;
		this.fullImageId = fullImageId;
		this.priority = priority;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (productScreenshotId == null || productScreenshotId.length() == 0) {
			errors.add(new ValidationError("productScreenshotId", "No productScreenshotId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
