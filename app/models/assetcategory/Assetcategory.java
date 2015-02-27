
package models.assetcategory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.assetcategory.AssetcategoryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Assetcategory extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long categoryId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentCategoryId;

	public long leftCategoryId;

	public long rightCategoryId;

	@Constraints.MaxLength(75)
	public String name;

	public String title;

	public String description;

	public long vocabularyId;


	// model finder attribute

	public static Finder<Long,Assetcategory> find = new Finder<Long,Assetcategory>(
		Long.class, Assetcategory.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	public long getLeftCategoryId() {
		return leftCategoryId;
	}

	public void setLeftCategoryId(long leftCategoryId) {
		this.leftCategoryId = leftCategoryId;
	}
	public long getRightCategoryId() {
		return rightCategoryId;
	}

	public void setRightCategoryId(long rightCategoryId) {
		this.rightCategoryId = rightCategoryId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public long getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(long vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	public Assetcategory(){
	}

	// constructor using a formData

	public Assetcategory(AssetcategoryFormData formData) {
		uuid = formData.uuid;
		categoryId = Long.valueOf(formData.categoryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentCategoryId = Long.valueOf(formData.parentCategoryId);
		leftCategoryId = Long.valueOf(formData.leftCategoryId);
		rightCategoryId = Long.valueOf(formData.rightCategoryId);
		name = formData.name;
		title = formData.title;
		description = formData.description;
		vocabularyId = Long.valueOf(formData.vocabularyId);
	}

	public AssetcategoryFormData toFormData() {
		if (categoryId < 0) {
			categoryId = 0L;
		}

		AssetcategoryFormData formData = new AssetcategoryFormData(
			uuid
			,
			String.valueOf(categoryId)
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
			String.valueOf(parentCategoryId)
			,
			String.valueOf(leftCategoryId)
			,
			String.valueOf(rightCategoryId)
			,
			name
			,
			title
			,
			description
			,
			String.valueOf(vocabularyId)
			
		);

		return formData;
	}

}
