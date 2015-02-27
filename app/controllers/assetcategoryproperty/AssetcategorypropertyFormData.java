package controllers.assetcategoryproperty;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assetcategoryproperty data form.
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
public class AssetcategorypropertyFormData {

	public String categoryPropertyId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String categoryId;
	public String key;
	public String value;

	public AssetcategorypropertyFormData() {
	}

	public AssetcategorypropertyFormData(
		String categoryPropertyId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String categoryId,
				String key,
				String value
		) {

		this.categoryPropertyId = categoryPropertyId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.categoryId = categoryId;
		this.key = key;
		this.value = value;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (categoryPropertyId == null || categoryPropertyId.length() == 0) {
			errors.add(new ValidationError("categoryPropertyId", "No categoryPropertyId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
