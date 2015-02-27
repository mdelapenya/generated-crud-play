package controllers.ddmcontent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmcontent data form.
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
public class DdmcontentFormData {

	public String uuid;
	public String contentId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String description;
	public String data;

	public DdmcontentFormData() {
	}

	public DdmcontentFormData(
		String uuid,
				String contentId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String description,
				String data
		) {

		this.uuid = uuid;
		this.contentId = contentId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.description = description;
		this.data = data;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (contentId == null || contentId.length() == 0) {
			errors.add(new ValidationError("contentId", "No contentId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
