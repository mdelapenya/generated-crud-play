package controllers.mbmessage;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbmessage data form.
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
public class MbmessageFormData {

	public String uuid;
	public String messageId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String categoryId;
	public String threadId;
	public String rootMessageId;
	public String parentMessageId;
	public String subject;
	public String body;
	public String format;
	public String anonymous;
	public String priority;
	public String allowPingbacks;
	public String answer;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public MbmessageFormData() {
	}

	public MbmessageFormData(
		String uuid,
				String messageId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String categoryId,
				String threadId,
				String rootMessageId,
				String parentMessageId,
				String subject,
				String body,
				String format,
				String anonymous,
				String priority,
				String allowPingbacks,
				String answer,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.messageId = messageId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.categoryId = categoryId;
		this.threadId = threadId;
		this.rootMessageId = rootMessageId;
		this.parentMessageId = parentMessageId;
		this.subject = subject;
		this.body = body;
		this.format = format;
		this.anonymous = anonymous;
		this.priority = priority;
		this.allowPingbacks = allowPingbacks;
		this.answer = answer;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (messageId == null || messageId.length() == 0) {
			errors.add(new ValidationError("messageId", "No messageId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
