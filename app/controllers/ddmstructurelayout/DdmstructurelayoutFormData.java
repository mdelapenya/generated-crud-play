package controllers.ddmstructurelayout;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ddmstructurelayout data form.
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
public class DdmstructurelayoutFormData {

	public String uuid;
	public String structureLayoutId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String structureVersionId;
	public String definition;

	public DdmstructurelayoutFormData() {
	}

	public DdmstructurelayoutFormData(
		String uuid,
				String structureLayoutId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String structureVersionId,
				String definition
		) {

		this.uuid = uuid;
		this.structureLayoutId = structureLayoutId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.structureVersionId = structureVersionId;
		this.definition = definition;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (structureLayoutId == null || structureLayoutId.length() == 0) {
			errors.add(new ValidationError("structureLayoutId", "No structureLayoutId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
