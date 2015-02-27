package controllers.assetlink;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assetlink data form.
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
public class AssetlinkFormData {

	public String linkId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String entryId1;
	public String entryId2;
	public String customtype;
	public String weight;

	public AssetlinkFormData() {
	}

	public AssetlinkFormData(
		String linkId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String entryId1,
				String entryId2,
				String customtype,
				String weight
		) {

		this.linkId = linkId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.entryId1 = entryId1;
		this.entryId2 = entryId2;
		this.customtype = customtype;
		this.weight = weight;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (linkId == null || linkId.length() == 0) {
			errors.add(new ValidationError("linkId", "No linkId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
