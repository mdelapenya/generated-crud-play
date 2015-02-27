package controllers.trashversion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Trashversion data form.
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
public class TrashversionFormData {

	public String versionId;
	public String entryId;
	public String classNameId;
	public String classPK;
	public String typeSettings;
	public String status;

	public TrashversionFormData() {
	}

	public TrashversionFormData(
		String versionId,
				String entryId,
				String classNameId,
				String classPK,
				String typeSettings,
				String status
		) {

		this.versionId = versionId;
		this.entryId = entryId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.typeSettings = typeSettings;
		this.status = status;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (versionId == null || versionId.length() == 0) {
			errors.add(new ValidationError("versionId", "No versionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
