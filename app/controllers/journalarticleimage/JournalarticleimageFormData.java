package controllers.journalarticleimage;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalarticleimage data form.
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
public class JournalarticleimageFormData {

	public String articleImageId;
	public String groupId;
	public String articleId;
	public String version;
	public String elInstanceId;
	public String elName;
	public String languageId;
	public String tempImage;

	public JournalarticleimageFormData() {
	}

	public JournalarticleimageFormData(
		String articleImageId,
				String groupId,
				String articleId,
				String version,
				String elInstanceId,
				String elName,
				String languageId,
				String tempImage
		) {

		this.articleImageId = articleImageId;
		this.groupId = groupId;
		this.articleId = articleId;
		this.version = version;
		this.elInstanceId = elInstanceId;
		this.elName = elName;
		this.languageId = languageId;
		this.tempImage = tempImage;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (articleImageId == null || articleImageId.length() == 0) {
			errors.add(new ValidationError("articleImageId", "No articleImageId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
