package controllers.assettagstats;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assettagstats data form.
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
public class AssettagstatsFormData {

	public String tagStatsId;
	public String tagId;
	public String classNameId;
	public String assetCount;

	public AssettagstatsFormData() {
	}

	public AssettagstatsFormData(
		String tagStatsId,
				String tagId,
				String classNameId,
				String assetCount
		) {

		this.tagStatsId = tagStatsId;
		this.tagId = tagId;
		this.classNameId = classNameId;
		this.assetCount = assetCount;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (tagStatsId == null || tagStatsId.length() == 0) {
			errors.add(new ValidationError("tagStatsId", "No tagStatsId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
