package controllers.journalarticle;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalarticle data form.
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
public class JournalarticleFormData {

	public String uuid;
	public String id;
	public String resourcePrimKey;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String folderId;
	public String classNameId;
	public String classPK;
	public String treePath;
	public String articleId;
	public String version;
	public String title;
	public String urlTitle;
	public String description;
	public String content;
	public String DDMStructureKey;
	public String DDMTemplateKey;
	public String layoutUuid;
	public String displayDate;
	public String expirationDate;
	public String reviewDate;
	public String indexable;
	public String smallImage;
	public String smallImageId;
	public String smallImageURL;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public JournalarticleFormData() {
	}

	public JournalarticleFormData(
		String uuid,
				String id,
				String resourcePrimKey,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String folderId,
				String classNameId,
				String classPK,
				String treePath,
				String articleId,
				String version,
				String title,
				String urlTitle,
				String description,
				String content,
				String DDMStructureKey,
				String DDMTemplateKey,
				String layoutUuid,
				String displayDate,
				String expirationDate,
				String reviewDate,
				String indexable,
				String smallImage,
				String smallImageId,
				String smallImageURL,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.id = id;
		this.resourcePrimKey = resourcePrimKey;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.folderId = folderId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.treePath = treePath;
		this.articleId = articleId;
		this.version = version;
		this.title = title;
		this.urlTitle = urlTitle;
		this.description = description;
		this.content = content;
		this.DDMStructureKey = DDMStructureKey;
		this.DDMTemplateKey = DDMTemplateKey;
		this.layoutUuid = layoutUuid;
		this.displayDate = displayDate;
		this.expirationDate = expirationDate;
		this.reviewDate = reviewDate;
		this.indexable = indexable;
		this.smallImage = smallImage;
		this.smallImageId = smallImageId;
		this.smallImageURL = smallImageURL;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (id == null || id.length() == 0) {
			errors.add(new ValidationError("id", "No id was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
