package controllers.membershiprequest;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Membershiprequest data form.
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
public class MembershiprequestFormData {

	public String mvccVersion;
	public String membershipRequestId;
	public String groupId;
	public String companyId;
	public String userId;
	public String createDate;
	public String comments;
	public String replyComments;
	public String replyDate;
	public String replierUserId;
	public String statusId;

	public MembershiprequestFormData() {
	}

	public MembershiprequestFormData(
		String mvccVersion,
				String membershipRequestId,
				String groupId,
				String companyId,
				String userId,
				String createDate,
				String comments,
				String replyComments,
				String replyDate,
				String replierUserId,
				String statusId
		) {

		this.mvccVersion = mvccVersion;
		this.membershipRequestId = membershipRequestId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.createDate = createDate;
		this.comments = comments;
		this.replyComments = replyComments;
		this.replyDate = replyDate;
		this.replierUserId = replierUserId;
		this.statusId = statusId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (membershipRequestId == null || membershipRequestId.length() == 0) {
			errors.add(new ValidationError("membershipRequestId", "No membershipRequestId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
