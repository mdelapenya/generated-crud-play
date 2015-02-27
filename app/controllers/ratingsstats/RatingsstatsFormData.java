package controllers.ratingsstats;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ratingsstats data form.
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
public class RatingsstatsFormData {

	public String statsId;
	public String classNameId;
	public String classPK;
	public String totalEntries;
	public String totalScore;
	public String averageScore;

	public RatingsstatsFormData() {
	}

	public RatingsstatsFormData(
		String statsId,
				String classNameId,
				String classPK,
				String totalEntries,
				String totalScore,
				String averageScore
		) {

		this.statsId = statsId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.totalEntries = totalEntries;
		this.totalScore = totalScore;
		this.averageScore = averageScore;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (statsId == null || statsId.length() == 0) {
			errors.add(new ValidationError("statsId", "No statsId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
