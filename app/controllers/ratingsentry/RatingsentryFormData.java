package controllers.ratingsentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ratingsentry data form.
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
public class RatingsentryFormData {

	public String uuid;
	public String entryId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String score;

	public RatingsentryFormData() {
	}

	public RatingsentryFormData(
		String uuid,
				String entryId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String score
		) {

		this.uuid = uuid;
		this.entryId = entryId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.score = score;
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
