package controllers.expandocolumn;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Expandocolumn data form.
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
public class ExpandocolumnFormData {

	public String columnId;
	public String companyId;
	public String tableId;
	public String name;
	public String customtype;
	public String defaultData;
	public String typeSettings;

	public ExpandocolumnFormData() {
	}

	public ExpandocolumnFormData(
		String columnId,
				String companyId,
				String tableId,
				String name,
				String customtype,
				String defaultData,
				String typeSettings
		) {

		this.columnId = columnId;
		this.companyId = companyId;
		this.tableId = tableId;
		this.name = name;
		this.customtype = customtype;
		this.defaultData = defaultData;
		this.typeSettings = typeSettings;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (columnId == null || columnId.length() == 0) {
			errors.add(new ValidationError("columnId", "No columnId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
