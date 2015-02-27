package controllers.systemevent;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Systemevent data form.
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
public class SystemeventFormData {

	public String mvccVersion;
	public String systemEventId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String classNameId;
	public String classPK;
	public String classUuid;
	public String referrerClassNameId;
	public String parentSystemEventId;
	public String systemEventSetKey;
	public String customtype;
	public String extraData;

	public SystemeventFormData() {
	}

	public SystemeventFormData(
		String mvccVersion,
				String systemEventId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String classNameId,
				String classPK,
				String classUuid,
				String referrerClassNameId,
				String parentSystemEventId,
				String systemEventSetKey,
				String customtype,
				String extraData
		) {

		this.mvccVersion = mvccVersion;
		this.systemEventId = systemEventId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.classUuid = classUuid;
		this.referrerClassNameId = referrerClassNameId;
		this.parentSystemEventId = parentSystemEventId;
		this.systemEventSetKey = systemEventSetKey;
		this.customtype = customtype;
		this.extraData = extraData;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (systemEventId == null || systemEventId.length() == 0) {
			errors.add(new ValidationError("systemEventId", "No systemEventId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
