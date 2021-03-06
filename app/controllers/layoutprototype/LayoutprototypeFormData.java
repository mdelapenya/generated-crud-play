package controllers.layoutprototype;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutprototype data form.
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
public class LayoutprototypeFormData {

	public String mvccVersion;
	public String uuid;
	public String layoutPrototypeId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String description;
	public String settings;
	public String active;

	public LayoutprototypeFormData() {
	}

	public LayoutprototypeFormData(
		String mvccVersion,
				String uuid,
				String layoutPrototypeId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String description,
				String settings,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.layoutPrototypeId = layoutPrototypeId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.description = description;
		this.settings = settings;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutPrototypeId == null || layoutPrototypeId.length() == 0) {
			errors.add(new ValidationError("layoutPrototypeId", "No layoutPrototypeId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
