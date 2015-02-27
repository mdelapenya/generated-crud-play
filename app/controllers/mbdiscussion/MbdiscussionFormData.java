package controllers.mbdiscussion;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbdiscussion data form.
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
public class MbdiscussionFormData {

	public String uuid;
	public String discussionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String threadId;

	public MbdiscussionFormData() {
	}

	public MbdiscussionFormData(
		String uuid,
				String discussionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String threadId
		) {

		this.uuid = uuid;
		this.discussionId = discussionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.threadId = threadId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (discussionId == null || discussionId.length() == 0) {
			errors.add(new ValidationError("discussionId", "No discussionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
