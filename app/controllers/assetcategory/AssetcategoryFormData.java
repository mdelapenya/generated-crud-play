package controllers.assetcategory;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assetcategory data form.
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
public class AssetcategoryFormData {

	public String uuid;
	public String categoryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentCategoryId;
	public String leftCategoryId;
	public String rightCategoryId;
	public String name;
	public String title;
	public String description;
	public String vocabularyId;

	public AssetcategoryFormData() {
	}

	public AssetcategoryFormData(
		String uuid,
				String categoryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentCategoryId,
				String leftCategoryId,
				String rightCategoryId,
				String name,
				String title,
				String description,
				String vocabularyId
		) {

		this.uuid = uuid;
		this.categoryId = categoryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentCategoryId = parentCategoryId;
		this.leftCategoryId = leftCategoryId;
		this.rightCategoryId = rightCategoryId;
		this.name = name;
		this.title = title;
		this.description = description;
		this.vocabularyId = vocabularyId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (categoryId == null || categoryId.length() == 0) {
			errors.add(new ValidationError("categoryId", "No categoryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
