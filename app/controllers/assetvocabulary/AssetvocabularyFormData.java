package controllers.assetvocabulary;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assetvocabulary data form.
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
public class AssetvocabularyFormData {

	public String uuid;
	public String vocabularyId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String title;
	public String description;
	public String settings;

	public AssetvocabularyFormData() {
	}

	public AssetvocabularyFormData(
		String uuid,
				String vocabularyId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String title,
				String description,
				String settings
		) {

		this.uuid = uuid;
		this.vocabularyId = vocabularyId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.title = title;
		this.description = description;
		this.settings = settings;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (vocabularyId == null || vocabularyId.length() == 0) {
			errors.add(new ValidationError("vocabularyId", "No vocabularyId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
