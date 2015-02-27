
package models.blogsentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.blogsentry.BlogsentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Blogsentry extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long entryId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(150)
	public String title;

	public String subtitle;

	@Constraints.MaxLength(150)
	public String urlTitle;

	public String description;

	public String content;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date displayDate;

	public boolean allowPingbacks;

	public boolean allowTrackbacks;

	public String trackbacks;

	public long coverImageFileEntryId;

	@Constraints.MaxLength(75)
	public String coverImageURL;

	public boolean smallImage;

	public long smallImageFileEntryId;

	public long smallImageId;

	public String smallImageURL;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Blogsentry> find = new Finder<Long,Blogsentry>(
		Long.class, Blogsentry.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}
	public boolean getAllowPingbacks() {
		return allowPingbacks;
	}

	public void setAllowPingbacks(boolean allowPingbacks) {
		this.allowPingbacks = allowPingbacks;
	}
	public boolean getAllowTrackbacks() {
		return allowTrackbacks;
	}

	public void setAllowTrackbacks(boolean allowTrackbacks) {
		this.allowTrackbacks = allowTrackbacks;
	}
	public String getTrackbacks() {
		return trackbacks;
	}

	public void setTrackbacks(String trackbacks) {
		this.trackbacks = trackbacks;
	}
	public long getCoverImageFileEntryId() {
		return coverImageFileEntryId;
	}

	public void setCoverImageFileEntryId(long coverImageFileEntryId) {
		this.coverImageFileEntryId = coverImageFileEntryId;
	}
	public String getCoverImageURL() {
		return coverImageURL;
	}

	public void setCoverImageURL(String coverImageURL) {
		this.coverImageURL = coverImageURL;
	}
	public boolean getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		this.smallImage = smallImage;
	}
	public long getSmallImageFileEntryId() {
		return smallImageFileEntryId;
	}

	public void setSmallImageFileEntryId(long smallImageFileEntryId) {
		this.smallImageFileEntryId = smallImageFileEntryId;
	}
	public long getSmallImageId() {
		return smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		this.smallImageId = smallImageId;
	}
	public String getSmallImageURL() {
		return smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public long getStatusByUserId() {
		return statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		this.statusByUserId = statusByUserId;
	}
	public String getStatusByUserName() {
		return statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		this.statusByUserName = statusByUserName;
	}
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Blogsentry(){
	}

	// constructor using a formData

	public Blogsentry(BlogsentryFormData formData) {
		uuid = formData.uuid;
		entryId = Long.valueOf(formData.entryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		title = formData.title;
		subtitle = formData.subtitle;
		urlTitle = formData.urlTitle;
		description = formData.description;
		content = formData.content;
		displayDate = new Date(formData.displayDate);
		allowPingbacks = Boolean.valueOf(formData.allowPingbacks);
		allowTrackbacks = Boolean.valueOf(formData.allowTrackbacks);
		trackbacks = formData.trackbacks;
		coverImageFileEntryId = Long.valueOf(formData.coverImageFileEntryId);
		coverImageURL = formData.coverImageURL;
		smallImage = Boolean.valueOf(formData.smallImage);
		smallImageFileEntryId = Long.valueOf(formData.smallImageFileEntryId);
		smallImageId = Long.valueOf(formData.smallImageId);
		smallImageURL = formData.smallImageURL;
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public BlogsentryFormData toFormData() {
		if (entryId < 0) {
			entryId = 0L;
		}

		BlogsentryFormData formData = new BlogsentryFormData(
			uuid
			,
			String.valueOf(entryId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			title
			,
			subtitle
			,
			urlTitle
			,
			description
			,
			content
			,
			String.valueOf(displayDate)
			,
			String.valueOf(allowPingbacks)
			,
			String.valueOf(allowTrackbacks)
			,
			trackbacks
			,
			String.valueOf(coverImageFileEntryId)
			,
			coverImageURL
			,
			String.valueOf(smallImage)
			,
			String.valueOf(smallImageFileEntryId)
			,
			String.valueOf(smallImageId)
			,
			smallImageURL
			,
			String.valueOf(status)
			,
			String.valueOf(statusByUserId)
			,
			statusByUserName
			,
			String.valueOf(statusDate)
			
		);

		return formData;
	}

}
