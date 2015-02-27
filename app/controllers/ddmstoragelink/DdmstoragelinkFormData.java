package controllers.ddmstoragelink;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmstoragelink data form.
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
public class DdmstoragelinkFormData {

	public String uuid;
	public String storageLinkId;
	public String classNameId;
	public String classPK;
	public String structureId;

	public DdmstoragelinkFormData() {
	}

	public DdmstoragelinkFormData(
		String uuid,
				String storageLinkId,
				String classNameId,
				String classPK,
				String structureId
		) {

		this.uuid = uuid;
		this.storageLinkId = storageLinkId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.structureId = structureId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (storageLinkId == null || storageLinkId.length() == 0) {
			errors.add(new ValidationError("storageLinkId", "No storageLinkId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
