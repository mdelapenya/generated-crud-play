
package models.shoppingcategory;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingcategory.ShoppingcategoryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingcategory extends Model {

	// model attributes

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

	@Constraints.MaxLength(75)
	public String name;

	public String description;


	// model finder attribute

	public static Finder<Long,Shoppingcategory> find = new Finder<Long,Shoppingcategory>(
		Long.class, Shoppingcategory.class
	);

	// getters and setters

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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Shoppingcategory(){
	}

	// constructor using a formData

	public Shoppingcategory(ShoppingcategoryFormData formData) {
		categoryId = Long.valueOf(formData.categoryId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentCategoryId = Long.valueOf(formData.parentCategoryId);
		name = formData.name;
		description = formData.description;
	}

	public ShoppingcategoryFormData toFormData() {
		if (categoryId < 0) {
			categoryId = 0L;
		}

		ShoppingcategoryFormData formData = new ShoppingcategoryFormData(
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
			name
			,
			description
			
		);

		return formData;
	}

}
