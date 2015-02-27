package controllers.scframeworkversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Scframeworkversion data form.
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
public class ScframeworkversionFormData {

	public String frameworkVersionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String url;
	public String active;
	public String priority;

	public ScframeworkversionFormData() {
	}

	public ScframeworkversionFormData(
		String frameworkVersionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String url,
				String active,
				String priority
		) {

		this.frameworkVersionId = frameworkVersionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.url = url;
		this.active = active;
		this.priority = priority;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (frameworkVersionId == null || frameworkVersionId.length() == 0) {
			errors.add(new ValidationError("frameworkVersionId", "No frameworkVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
