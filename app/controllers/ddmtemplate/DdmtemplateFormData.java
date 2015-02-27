package controllers.ddmtemplate;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmtemplate data form.
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
public class DdmtemplateFormData {

	public String uuid;
	public String templateId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String sourceClassNameId;
	public String templateKey;
	public String version;
	public String name;
	public String description;
	public String customtype;
	public String mode;
	public String language;
	public String script;
	public String cacheable;
	public String smallImage;
	public String smallImageId;
	public String smallImageURL;

	public DdmtemplateFormData() {
	}

	public DdmtemplateFormData(
		String uuid,
				String templateId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String sourceClassNameId,
				String templateKey,
				String version,
				String name,
				String description,
				String customtype,
				String mode,
				String language,
				String script,
				String cacheable,
				String smallImage,
				String smallImageId,
				String smallImageURL
		) {

		this.uuid = uuid;
		this.templateId = templateId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.sourceClassNameId = sourceClassNameId;
		this.templateKey = templateKey;
		this.version = version;
		this.name = name;
		this.description = description;
		this.customtype = customtype;
		this.mode = mode;
		this.language = language;
		this.script = script;
		this.cacheable = cacheable;
		this.smallImage = smallImage;
		this.smallImageId = smallImageId;
		this.smallImageURL = smallImageURL;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (templateId == null || templateId.length() == 0) {
			errors.add(new ValidationError("templateId", "No templateId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
