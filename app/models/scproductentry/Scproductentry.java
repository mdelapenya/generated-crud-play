
package models.scproductentry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.scproductentry.ScproductentryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Scproductentry extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long productEntryId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String customtype;

	@Constraints.MaxLength(255)
	public String tags;

	public String shortDescription;

	public String longDescription;

	public String pageURL;

	@Constraints.MaxLength(75)
	public String author;

	@Constraints.MaxLength(75)
	public String repoGroupId;

	@Constraints.MaxLength(75)
	public String repoArtifactId;


	// model finder attribute

	public static Finder<Long,Scproductentry> find = new Finder<Long,Scproductentry>(
		Long.class, Scproductentry.class
	);

	// getters and setters

	public long getProductEntryId() {
		return productEntryId;
	}

	public void setProductEntryId(long productEntryId) {
		this.productEntryId = productEntryId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRepoGroupId() {
		return repoGroupId;
	}

	public void setRepoGroupId(String repoGroupId) {
		this.repoGroupId = repoGroupId;
	}
	public String getRepoArtifactId() {
		return repoArtifactId;
	}

	public void setRepoArtifactId(String repoArtifactId) {
		this.repoArtifactId = repoArtifactId;
	}

	public Scproductentry(){
	}

	// constructor using a formData

	public Scproductentry(ScproductentryFormData formData) {
		productEntryId = Long.valueOf(formData.productEntryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		name = formData.name;
		customtype = formData.customtype;
		tags = formData.tags;
		shortDescription = formData.shortDescription;
		longDescription = formData.longDescription;
		pageURL = formData.pageURL;
		author = formData.author;
		repoGroupId = formData.repoGroupId;
		repoArtifactId = formData.repoArtifactId;
	}

	public ScproductentryFormData toFormData() {
		if (productEntryId < 0) {
			productEntryId = 0L;
		}

		ScproductentryFormData formData = new ScproductentryFormData(
			String.valueOf(productEntryId)
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
			name
			,
			customtype
			,
			tags
			,
			shortDescription
			,
			longDescription
			,
			pageURL
			,
			author
			,
			repoGroupId
			,
			repoArtifactId
			
		);

		return formData;
	}

}
