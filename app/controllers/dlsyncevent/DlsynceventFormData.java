package controllers.dlsyncevent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlsyncevent data form.
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
public class DlsynceventFormData {

	public String syncEventId;
	public String modifiedTime;
	public String event;
	public String customtype;
	public String typePK;

	public DlsynceventFormData() {
	}

	public DlsynceventFormData(
		String syncEventId,
				String modifiedTime,
				String event,
				String customtype,
				String typePK
		) {

		this.syncEventId = syncEventId;
		this.modifiedTime = modifiedTime;
		this.event = event;
		this.customtype = customtype;
		this.typePK = typePK;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (syncEventId == null || syncEventId.length() == 0) {
			errors.add(new ValidationError("syncEventId", "No syncEventId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
