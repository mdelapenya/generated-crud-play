package controllers.blogsstatsuser;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Blogsstatsuser data form.
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
public class BlogsstatsuserFormData {

	public String statsUserId;
	public String groupId;
	public String companyId;
	public String userId;
	public String entryCount;
	public String lastPostDate;
	public String ratingsTotalEntries;
	public String ratingsTotalScore;
	public String ratingsAverageScore;

	public BlogsstatsuserFormData() {
	}

	public BlogsstatsuserFormData(
		String statsUserId,
				String groupId,
				String companyId,
				String userId,
				String entryCount,
				String lastPostDate,
				String ratingsTotalEntries,
				String ratingsTotalScore,
				String ratingsAverageScore
		) {

		this.statsUserId = statsUserId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.entryCount = entryCount;
		this.lastPostDate = lastPostDate;
		this.ratingsTotalEntries = ratingsTotalEntries;
		this.ratingsTotalScore = ratingsTotalScore;
		this.ratingsAverageScore = ratingsAverageScore;
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
