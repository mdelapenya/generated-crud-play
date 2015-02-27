package controllers.mbstatsuser;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbstatsuser data form.
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
public class MbstatsuserFormData {

	public String statsUserId;
	public String groupId;
	public String userId;
	public String messageCount;
	public String lastPostDate;

	public MbstatsuserFormData() {
	}

	public MbstatsuserFormData(
		String statsUserId,
				String groupId,
				String userId,
				String messageCount,
				String lastPostDate
		) {

		this.statsUserId = statsUserId;
		this.groupId = groupId;
		this.userId = userId;
		this.messageCount = messageCount;
		this.lastPostDate = lastPostDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (statsUserId == null || statsUserId.length() == 0) {
			errors.add(new ValidationError("statsUserId", "No statsUserId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
