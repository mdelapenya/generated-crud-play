package controllers.passwordpolicyrel;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Passwordpolicyrel data form.
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
public class PasswordpolicyrelFormData {

	public String mvccVersion;
	public String passwordPolicyRelId;
	public String passwordPolicyId;
	public String classNameId;
	public String classPK;

	public PasswordpolicyrelFormData() {
	}

	public PasswordpolicyrelFormData(
		String mvccVersion,
				String passwordPolicyRelId,
				String passwordPolicyId,
				String classNameId,
				String classPK
		) {

		this.mvccVersion = mvccVersion;
		this.passwordPolicyRelId = passwordPolicyRelId;
		this.passwordPolicyId = passwordPolicyId;
		this.classNameId = classNameId;
		this.classPK = classPK;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (passwordPolicyRelId == null || passwordPolicyRelId.length() == 0) {
			errors.add(new ValidationError("passwordPolicyRelId", "No passwordPolicyRelId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
