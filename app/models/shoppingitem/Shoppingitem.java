
package models.shoppingitem;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingitem.ShoppingitemFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingitem extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long itemId;

	public long groupId;

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
	public String sku;

	@Constraints.MaxLength(200)
	public String name;

	public String description;

	public String properties;

	public boolean fields;

	public String fieldsQuantities;

	public int minQuantity;

	public int maxQuantity;

	public double price;

	public double discount;

	public boolean taxable;

	public double shipping;

	public boolean useShippingFormula;

	public boolean requiresShipping;

	public int stockQuantity;

	public boolean featured;

	public boolean sale;

	public boolean smallImage;

	public long smallImageId;

	public String smallImageURL;

	public boolean mediumImage;

	public long mediumImageId;

	public String mediumImageURL;

	public boolean largeImage;

	public long largeImageId;

	public String largeImageURL;


	// model finder attribute

	public static Finder<Long,Shoppingitem> find = new Finder<Long,Shoppingitem>(
		Long.class, Shoppingitem.class
	);

	// getters and setters

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
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
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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
	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}
	public boolean getFields() {
		return fields;
	}

	public void setFields(boolean fields) {
		this.fields = fields;
	}
	public String getFieldsQuantities() {
		return fieldsQuantities;
	}

	public void setFieldsQuantities(String fieldsQuantities) {
		this.fieldsQuantities = fieldsQuantities;
	}
	public int getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean getTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public boolean getUseShippingFormula() {
		return useShippingFormula;
	}

	public void setUseShippingFormula(boolean useShippingFormula) {
		this.useShippingFormula = useShippingFormula;
	}
	public boolean getRequiresShipping() {
		return requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		this.requiresShipping = requiresShipping;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public boolean getFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public boolean getSale() {
		return sale;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
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
	public boolean getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(boolean mediumImage) {
		this.mediumImage = mediumImage;
	}
	public long getMediumImageId() {
		return mediumImageId;
	}

	public void setMediumImageId(long mediumImageId) {
		this.mediumImageId = mediumImageId;
	}
	public String getMediumImageURL() {
		return mediumImageURL;
	}

	public void setMediumImageURL(String mediumImageURL) {
		this.mediumImageURL = mediumImageURL;
	}
	public boolean getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(boolean largeImage) {
		this.largeImage = largeImage;
	}
	public long getLargeImageId() {
		return largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		this.largeImageId = largeImageId;
	}
	public String getLargeImageURL() {
		return largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}

	public Shoppingitem(){
	}

	// constructor using a formData

	public Shoppingitem(ShoppingitemFormData formData) {
		itemId = Long.valueOf(formData.itemId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		categoryId = Long.valueOf(formData.categoryId);
		sku = formData.sku;
		name = formData.name;
		description = formData.description;
		properties = formData.properties;
		fields = Boolean.valueOf(formData.fields);
		fieldsQuantities = formData.fieldsQuantities;
		minQuantity = Integer.valueOf(formData.minQuantity);
		maxQuantity = Integer.valueOf(formData.maxQuantity);
		price = Double.valueOf(formData.price);
		discount = Double.valueOf(formData.discount);
		taxable = Boolean.valueOf(formData.taxable);
		shipping = Double.valueOf(formData.shipping);
		useShippingFormula = Boolean.valueOf(formData.useShippingFormula);
		requiresShipping = Boolean.valueOf(formData.requiresShipping);
		stockQuantity = Integer.valueOf(formData.stockQuantity);
		featured = Boolean.valueOf(formData.featured);
		sale = Boolean.valueOf(formData.sale);
		smallImage = Boolean.valueOf(formData.smallImage);
		smallImageId = Long.valueOf(formData.smallImageId);
		smallImageURL = formData.smallImageURL;
		mediumImage = Boolean.valueOf(formData.mediumImage);
		mediumImageId = Long.valueOf(formData.mediumImageId);
		mediumImageURL = formData.mediumImageURL;
		largeImage = Boolean.valueOf(formData.largeImage);
		largeImageId = Long.valueOf(formData.largeImageId);
		largeImageURL = formData.largeImageURL;
	}

	public ShoppingitemFormData toFormData() {
		if (itemId < 0) {
			itemId = 0L;
		}

		ShoppingitemFormData formData = new ShoppingitemFormData(
			String.valueOf(itemId)
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
			String.valueOf(categoryId)
			,
			sku
			,
			name
			,
			description
			,
			properties
			,
			String.valueOf(fields)
			,
			fieldsQuantities
			,
			String.valueOf(minQuantity)
			,
			String.valueOf(maxQuantity)
			,
			String.valueOf(price)
			,
			String.valueOf(discount)
			,
			String.valueOf(taxable)
			,
			String.valueOf(shipping)
			,
			String.valueOf(useShippingFormula)
			,
			String.valueOf(requiresShipping)
			,
			String.valueOf(stockQuantity)
			,
			String.valueOf(featured)
			,
			String.valueOf(sale)
			,
			String.valueOf(smallImage)
			,
			String.valueOf(smallImageId)
			,
			smallImageURL
			,
			String.valueOf(mediumImage)
			,
			String.valueOf(mediumImageId)
			,
			mediumImageURL
			,
			String.valueOf(largeImage)
			,
			String.valueOf(largeImageId)
			,
			largeImageURL
			
		);

		return formData;
	}

}
