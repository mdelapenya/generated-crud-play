package controllers.shoppingitem;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shoppingitem data form.
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
public class ShoppingitemFormData {

	public String itemId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String categoryId;
	public String sku;
	public String name;
	public String description;
	public String properties;
	public String fields;
	public String fieldsQuantities;
	public String minQuantity;
	public String maxQuantity;
	public String price;
	public String discount;
	public String taxable;
	public String shipping;
	public String useShippingFormula;
	public String requiresShipping;
	public String stockQuantity;
	public String featured;
	public String sale;
	public String smallImage;
	public String smallImageId;
	public String smallImageURL;
	public String mediumImage;
	public String mediumImageId;
	public String mediumImageURL;
	public String largeImage;
	public String largeImageId;
	public String largeImageURL;

	public ShoppingitemFormData() {
	}

	public ShoppingitemFormData(
		String itemId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String categoryId,
				String sku,
				String name,
				String description,
				String properties,
				String fields,
				String fieldsQuantities,
				String minQuantity,
				String maxQuantity,
				String price,
				String discount,
				String taxable,
				String shipping,
				String useShippingFormula,
				String requiresShipping,
				String stockQuantity,
				String featured,
				String sale,
				String smallImage,
				String smallImageId,
				String smallImageURL,
				String mediumImage,
				String mediumImageId,
				String mediumImageURL,
				String largeImage,
				String largeImageId,
				String largeImageURL
		) {

		this.itemId = itemId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.categoryId = categoryId;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.properties = properties;
		this.fields = fields;
		this.fieldsQuantities = fieldsQuantities;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.price = price;
		this.discount = discount;
		this.taxable = taxable;
		this.shipping = shipping;
		this.useShippingFormula = useShippingFormula;
		this.requiresShipping = requiresShipping;
		this.stockQuantity = stockQuantity;
		this.featured = featured;
		this.sale = sale;
		this.smallImage = smallImage;
		this.smallImageId = smallImageId;
		this.smallImageURL = smallImageURL;
		this.mediumImage = mediumImage;
		this.mediumImageId = mediumImageId;
		this.mediumImageURL = mediumImageURL;
		this.largeImage = largeImage;
		this.largeImageId = largeImageId;
		this.largeImageURL = largeImageURL;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (itemId == null || itemId.length() == 0) {
			errors.add(new ValidationError("itemId", "No itemId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
