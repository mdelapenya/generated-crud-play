package controllers.ddmtemplateversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmtemplateversion data form.
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
public class DdmtemplateversionFormData {

	public String templateVersionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String templateId;
	public String version;
	public String name;
	public String description;
	public String language;
	public String script;

	public DdmtemplateversionFormData() {
	}

	public DdmtemplateversionFormData(
		String templateVersionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String templateId,
				String version,
				String name,
				String description,
				String language,
				String script
		) {

		this.templateVersionId = templateVersionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.templateId = templateId;
		this.version = version;
		this.name = name;
		this.description = description;
		this.language = language;
		this.script = script;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (templateVersionId == null || templateVersionId.length() == 0) {
			errors.add(new ValidationError("templateVersionId", "No templateVersionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
