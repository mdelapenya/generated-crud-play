package controllers.assetentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Assetentry data form.
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
public class AssetentryFormData {

	public String entryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String classUuid;
	public String classTypeId;
	public String listable;
	public String visible;
	public String startDate;
	public String endDate;
	public String publishDate;
	public String expirationDate;
	public String mimeType;
	public String title;
	public String description;
	public String summary;
	public String url;
	public String layoutUuid;
	public String height;
	public String width;
	public String priority;
	public String viewCount;

	public AssetentryFormData() {
	}

	public AssetentryFormData(
		String entryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String classUuid,
				String classTypeId,
				String listable,
				String visible,
				String startDate,
				String endDate,
				String publishDate,
				String expirationDate,
				String mimeType,
				String title,
				String description,
				String summary,
				String url,
				String layoutUuid,
				String height,
				String width,
				String priority,
				String viewCount
		) {

		this.entryId = entryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.classUuid = classUuid;
		this.classTypeId = classTypeId;
		this.listable = listable;
		this.visible = visible;
		this.startDate = startDate;
		this.endDate = endDate;
		this.publishDate = publishDate;
		this.expirationDate = expirationDate;
		this.mimeType = mimeType;
		this.title = title;
		this.description = description;
		this.summary = summary;
		this.url = url;
		this.layoutUuid = layoutUuid;
		this.height = height;
		this.width = width;
		this.priority = priority;
		this.viewCount = viewCount;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (entryId == null || entryId.length() == 0) {
			errors.add(new ValidationError("entryId", "No entryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
