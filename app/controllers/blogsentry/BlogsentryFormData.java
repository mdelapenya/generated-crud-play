package controllers.blogsentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Blogsentry data form.
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
public class BlogsentryFormData {

	public String uuid;
	public String entryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String title;
	public String subtitle;
	public String urlTitle;
	public String description;
	public String content;
	public String displayDate;
	public String allowPingbacks;
	public String allowTrackbacks;
	public String trackbacks;
	public String coverImageFileEntryId;
	public String coverImageURL;
	public String smallImage;
	public String smallImageFileEntryId;
	public String smallImageId;
	public String smallImageURL;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public BlogsentryFormData() {
	}

	public BlogsentryFormData(
		String uuid,
				String entryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String title,
				String subtitle,
				String urlTitle,
				String description,
				String content,
				String displayDate,
				String allowPingbacks,
				String allowTrackbacks,
				String trackbacks,
				String coverImageFileEntryId,
				String coverImageURL,
				String smallImage,
				String smallImageFileEntryId,
				String smallImageId,
				String smallImageURL,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.entryId = entryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.title = title;
		this.subtitle = subtitle;
		this.urlTitle = urlTitle;
		this.description = description;
		this.content = content;
		this.displayDate = displayDate;
		this.allowPingbacks = allowPingbacks;
		this.allowTrackbacks = allowTrackbacks;
		this.trackbacks = trackbacks;
		this.coverImageFileEntryId = coverImageFileEntryId;
		this.coverImageURL = coverImageURL;
		this.smallImage = smallImage;
		this.smallImageFileEntryId = smallImageFileEntryId;
		this.smallImageId = smallImageId;
		this.smallImageURL = smallImageURL;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
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
