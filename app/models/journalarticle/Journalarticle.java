
package models.journalarticle;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalarticle.JournalarticleFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalarticle extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long id;

	public long resourcePrimKey;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long folderId;

	public long classNameId;

	public long classPK;

	public String treePath;

	@Constraints.MaxLength(75)
	public String articleId;

	public double version;

	public String title;

	@Constraints.MaxLength(150)
	public String urlTitle;

	public String description;

	public String content;

	@Constraints.MaxLength(75)
	public String DDMStructureKey;

	@Constraints.MaxLength(75)
	public String DDMTemplateKey;

	@Constraints.MaxLength(75)
	public String layoutUuid;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date displayDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date expirationDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date reviewDate;

	public boolean indexable;

	public boolean smallImage;

	public long smallImageId;

	public String smallImageURL;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Journalarticle> find = new Finder<Long,Journalarticle>(
		Long.class, Journalarticle.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getResourcePrimKey() {
		return resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
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
	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
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
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	public String getDDMStructureKey() {
		return DDMStructureKey;
	}

	public void setDDMStructureKey(String DDMStructureKey) {
		this.DDMStructureKey = DDMStructureKey;
	}
	public String getDDMTemplateKey() {
		return DDMTemplateKey;
	}

	public void setDDMTemplateKey(String DDMTemplateKey) {
		this.DDMTemplateKey = DDMTemplateKey;
	}
	public String getLayoutUuid() {
		return layoutUuid;
	}

	public void setLayoutUuid(String layoutUuid) {
		this.layoutUuid = layoutUuid;
	}
	public Date getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public boolean getIndexable() {
		return indexable;
	}

	public void setIndexable(boolean indexable) {
		this.indexable = indexable;
	}
	public boolean getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		this.smallImage = smallImage;
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

	public Journalarticle(){
	}

	// constructor using a formData

	public Journalarticle(JournalarticleFormData formData) {
		uuid = formData.uuid;
		id = Long.valueOf(formData.id);
		resourcePrimKey = Long.valueOf(formData.resourcePrimKey);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		folderId = Long.valueOf(formData.folderId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		treePath = formData.treePath;
		articleId = formData.articleId;
		version = Double.valueOf(formData.version);
		title = formData.title;
		urlTitle = formData.urlTitle;
		description = formData.description;
		content = formData.content;
		DDMStructureKey = formData.DDMStructureKey;
		DDMTemplateKey = formData.DDMTemplateKey;
		layoutUuid = formData.layoutUuid;
		displayDate = new Date(formData.displayDate);
		expirationDate = new Date(formData.expirationDate);
		reviewDate = new Date(formData.reviewDate);
		indexable = Boolean.valueOf(formData.indexable);
		smallImage = Boolean.valueOf(formData.smallImage);
		smallImageId = Long.valueOf(formData.smallImageId);
		smallImageURL = formData.smallImageURL;
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public JournalarticleFormData toFormData() {
		if (id < 0) {
			id = 0L;
		}

		JournalarticleFormData formData = new JournalarticleFormData(
			uuid
			,
			String.valueOf(id)
			,
			String.valueOf(resourcePrimKey)
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
			String.valueOf(folderId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			treePath
			,
			articleId
			,
			String.valueOf(version)
			,
			title
			,
			urlTitle
			,
			description
			,
			content
			,
			DDMStructureKey
			,
			DDMTemplateKey
			,
			layoutUuid
			,
			String.valueOf(displayDate)
			,
			String.valueOf(expirationDate)
			,
			String.valueOf(reviewDate)
			,
			String.valueOf(indexable)
			,
			String.valueOf(smallImage)
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
