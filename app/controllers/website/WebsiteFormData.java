package controllers.website;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Website data form.
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
public class WebsiteFormData {

	public String mvccVersion;
	public String uuid;
	public String websiteId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String url;
	public String typeId;
	public String customprimary;

	public WebsiteFormData() {
	}

	public WebsiteFormData(
		String mvccVersion,
				String uuid,
				String websiteId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String url,
				String typeId,
				String customprimary
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.websiteId = websiteId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.url = url;
		this.typeId = typeId;
		this.customprimary = customprimary;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (websiteId == null || websiteId.length() == 0) {
			errors.add(new ValidationError("websiteId", "No websiteId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
