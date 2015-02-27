package controllers.mbban;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbban data form.
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
public class MbbanFormData {

	public String uuid;
	public String banId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String banUserId;

	public MbbanFormData() {
	}

	public MbbanFormData(
		String uuid,
				String banId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String banUserId
		) {

		this.uuid = uuid;
		this.banId = banId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.banUserId = banUserId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (banId == null || banId.length() == 0) {
			errors.add(new ValidationError("banId", "No banId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
