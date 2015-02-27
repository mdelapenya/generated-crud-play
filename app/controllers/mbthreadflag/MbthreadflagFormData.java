package controllers.mbthreadflag;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbthreadflag data form.
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
public class MbthreadflagFormData {

	public String uuid;
	public String threadFlagId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String threadId;

	public MbthreadflagFormData() {
	}

	public MbthreadflagFormData(
		String uuid,
				String threadFlagId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String threadId
		) {

		this.uuid = uuid;
		this.threadFlagId = threadFlagId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.threadId = threadId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (threadFlagId == null || threadFlagId.length() == 0) {
			errors.add(new ValidationError("threadFlagId", "No threadFlagId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
