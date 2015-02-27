package controllers.ddmstructurelink;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmstructurelink data form.
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
public class DdmstructurelinkFormData {

	public String structureLinkId;
	public String classNameId;
	public String classPK;
	public String structureId;

	public DdmstructurelinkFormData() {
	}

	public DdmstructurelinkFormData(
		String structureLinkId,
				String classNameId,
				String classPK,
				String structureId
		) {

		this.structureLinkId = structureLinkId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.structureId = structureId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (structureLinkId == null || structureLinkId.length() == 0) {
			errors.add(new ValidationError("structureLinkId", "No structureLinkId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
