package controllers.listtype;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Listtype data form.
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
public class ListtypeFormData {

	public String mvccVersion;
	public String listTypeId;
	public String name;
	public String customtype;

	public ListtypeFormData() {
	}

	public ListtypeFormData(
		String mvccVersion,
				String listTypeId,
				String name,
				String customtype
		) {

		this.mvccVersion = mvccVersion;
		this.listTypeId = listTypeId;
		this.name = name;
		this.customtype = customtype;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (listTypeId == null || listTypeId.length() == 0) {
			errors.add(new ValidationError("listTypeId", "No listTypeId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
