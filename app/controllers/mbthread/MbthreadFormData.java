package controllers.mbthread;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbthread data form.
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
public class MbthreadFormData {

	public String uuid;
	public String threadId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String categoryId;
	public String rootMessageId;
	public String rootMessageUserId;
	public String messageCount;
	public String viewCount;
	public String lastPostByUserId;
	public String lastPostDate;
	public String priority;
	public String question;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public MbthreadFormData() {
	}

	public MbthreadFormData(
		String uuid,
				String threadId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String categoryId,
				String rootMessageId,
				String rootMessageUserId,
				String messageCount,
				String viewCount,
				String lastPostByUserId,
				String lastPostDate,
				String priority,
				String question,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.threadId = threadId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.categoryId = categoryId;
		this.rootMessageId = rootMessageId;
		this.rootMessageUserId = rootMessageUserId;
		this.messageCount = messageCount;
		this.viewCount = viewCount;
		this.lastPostByUserId = lastPostByUserId;
		this.lastPostDate = lastPostDate;
		this.priority = priority;
		this.question = question;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (threadId == null || threadId.length() == 0) {
			errors.add(new ValidationError("threadId", "No threadId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
