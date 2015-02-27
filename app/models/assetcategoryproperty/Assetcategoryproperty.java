
package models.assetcategoryproperty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.assetcategoryproperty.AssetcategorypropertyFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Assetcategoryproperty extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long categoryPropertyId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long categoryId;

	@Constraints.MaxLength(75)
	public String key;

	@Constraints.MaxLength(75)
	public String value;


	// model finder attribute

	public static Finder<Long,Assetcategoryproperty> find = new Finder<Long,Assetcategoryproperty>(
		Long.class, Assetcategoryproperty.class
	);

	// getters and setters

	public long getCategoryPropertyId() {
		return categoryPropertyId;
	}

	public void setCategoryPropertyId(long categoryPropertyId) {
		this.categoryPropertyId = categoryPropertyId;
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
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Assetcategoryproperty(){
	}

	// constructor using a formData

	public Assetcategoryproperty(AssetcategorypropertyFormData formData) {
		categoryPropertyId = Long.valueOf(formData.categoryPropertyId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		categoryId = Long.valueOf(formData.categoryId);
		key = formData.key;
		value = formData.value;
	}

	public AssetcategorypropertyFormData toFormData() {
		if (categoryPropertyId < 0) {
			categoryPropertyId = 0L;
		}

		AssetcategorypropertyFormData formData = new AssetcategorypropertyFormData(
			String.valueOf(categoryPropertyId)
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
			String.valueOf(categoryId)
			,
			key
			,
			value
			
		);

		return formData;
	}

}
