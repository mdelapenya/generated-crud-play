package controllers.socialrelation;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Socialrelation data form.
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
public class SocialrelationFormData {

	public String uuid;
	public String relationId;
	public String companyId;
	public String createDate;
	public String userId1;
	public String userId2;
	public String customtype;

	public SocialrelationFormData() {
	}

	public SocialrelationFormData(
		String uuid,
				String relationId,
				String companyId,
				String createDate,
				String userId1,
				String userId2,
				String customtype
		) {

		this.uuid = uuid;
		this.relationId = relationId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.customtype = customtype;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (relationId == null || relationId.length() == 0) {
			errors.add(new ValidationError("relationId", "No relationId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
