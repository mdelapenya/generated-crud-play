
package models.assetentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.assetentry.AssetentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Assetentry extends Model {

	// model attributes

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

	public long classNameId;

	public long classPK;

	@Constraints.MaxLength(75)
	public String classUuid;

	public long classTypeId;

	public boolean listable;

	public boolean visible;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date startDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date endDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date publishDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date expirationDate;

	@Constraints.MaxLength(75)
	public String mimeType;

	public String title;

	public String description;

	public String summary;

	public String url;

	@Constraints.MaxLength(75)
	public String layoutUuid;

	public int height;

	public int width;

	public double priority;

	public int viewCount;


	// model finder attribute

	public static Finder<Long,Assetentry> find = new Finder<Long,Assetentry>(
		Long.class, Assetentry.class
	);

	// getters and setters

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
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public String getClassUuid() {
		return classUuid;
	}

	public void setClassUuid(String classUuid) {
		this.classUuid = classUuid;
	}
	public long getClassTypeId() {
		return classTypeId;
	}

	public void setClassTypeId(long classTypeId) {
		this.classTypeId = classTypeId;
	}
	public boolean getListable() {
		return listable;
	}

	public void setListable(boolean listable) {
		this.listable = listable;
	}
	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getLayoutUuid() {
		return layoutUuid;
	}

	public void setLayoutUuid(String layoutUuid) {
		this.layoutUuid = layoutUuid;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Assetentry(){
	}

	// constructor using a formData

	public Assetentry(AssetentryFormData formData) {
		entryId = Long.valueOf(formData.entryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		classUuid = formData.classUuid;
		classTypeId = Long.valueOf(formData.classTypeId);
		listable = Boolean.valueOf(formData.listable);
		visible = Boolean.valueOf(formData.visible);
		startDate = new Date(formData.startDate);
		endDate = new Date(formData.endDate);
		publishDate = new Date(formData.publishDate);
		expirationDate = new Date(formData.expirationDate);
		mimeType = formData.mimeType;
		title = formData.title;
		description = formData.description;
		summary = formData.summary;
		url = formData.url;
		layoutUuid = formData.layoutUuid;
		height = Integer.valueOf(formData.height);
		width = Integer.valueOf(formData.width);
		priority = Double.valueOf(formData.priority);
		viewCount = Integer.valueOf(formData.viewCount);
	}

	public AssetentryFormData toFormData() {
		if (entryId < 0) {
			entryId = 0L;
		}

		AssetentryFormData formData = new AssetentryFormData(
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
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			classUuid
			,
			String.valueOf(classTypeId)
			,
			String.valueOf(listable)
			,
			String.valueOf(visible)
			,
			String.valueOf(startDate)
			,
			String.valueOf(endDate)
			,
			String.valueOf(publishDate)
			,
			String.valueOf(expirationDate)
			,
			mimeType
			,
			title
			,
			description
			,
			summary
			,
			url
			,
			layoutUuid
			,
			String.valueOf(height)
			,
			String.valueOf(width)
			,
			String.valueOf(priority)
			,
			String.valueOf(viewCount)
			
		);

		return formData;
	}

}
