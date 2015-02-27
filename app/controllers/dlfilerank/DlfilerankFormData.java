package controllers.dlfilerank;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfilerank data form.
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
public class DlfilerankFormData {

	public String fileRankId;
	public String groupId;
	public String companyId;
	public String userId;
	public String createDate;
	public String fileEntryId;
	public String active;

	public DlfilerankFormData() {
	}

	public DlfilerankFormData(
		String fileRankId,
				String groupId,
				String companyId,
				String userId,
				String createDate,
				String fileEntryId,
				String active
		) {

		this.fileRankId = fileRankId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.createDate = createDate;
		this.fileEntryId = fileEntryId;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileRankId == null || fileRankId.length() == 0) {
			errors.add(new ValidationError("fileRankId", "No fileRankId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
