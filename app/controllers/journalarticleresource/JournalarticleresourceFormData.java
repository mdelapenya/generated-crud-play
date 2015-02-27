package controllers.journalarticleresource;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalarticleresource data form.
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
public class JournalarticleresourceFormData {

	public String uuid;
	public String resourcePrimKey;
	public String groupId;
	public String articleId;

	public JournalarticleresourceFormData() {
	}

	public JournalarticleresourceFormData(
		String uuid,
				String resourcePrimKey,
				String groupId,
				String articleId
		) {

		this.uuid = uuid;
		this.resourcePrimKey = resourcePrimKey;
		this.groupId = groupId;
		this.articleId = articleId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (resourcePrimKey == null || resourcePrimKey.length() == 0) {
			errors.add(new ValidationError("resourcePrimKey", "No resourcePrimKey was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
