package controllers.trashentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Trashentry data form.
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
public class TrashentryFormData {

	public String entryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String classNameId;
	public String classPK;
	public String systemEventSetKey;
	public String typeSettings;
	public String status;

	public TrashentryFormData() {
	}

	public TrashentryFormData(
		String entryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String classNameId,
				String classPK,
				String systemEventSetKey,
				String typeSettings,
				String status
		) {

		this.entryId = entryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.systemEventSetKey = systemEventSetKey;
		this.typeSettings = typeSettings;
		this.status = status;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (entryId == null || entryId.length() == 0) {
			errors.add(new ValidationError("entryId", "No entryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
