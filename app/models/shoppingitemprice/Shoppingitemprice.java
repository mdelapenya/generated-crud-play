
package models.shoppingitemprice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingitemprice.ShoppingitempriceFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingitemprice extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long itemPriceId;

	public long itemId;

	public int minQuantity;

	public int maxQuantity;

	public double price;

	public double discount;

	public boolean taxable;

	public double shipping;

	public boolean useShippingFormula;

	public int status;


	// model finder attribute

	public static Finder<Long,Shoppingitemprice> find = new Finder<Long,Shoppingitemprice>(
		Long.class, Shoppingitemprice.class
	);

	// getters and setters

	public long getItemPriceId() {
		return itemPriceId;
	}

	public void setItemPriceId(long itemPriceId) {
		this.itemPriceId = itemPriceId;
	}
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
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
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Shoppingitemprice(){
	}

	// constructor using a formData

	public Shoppingitemprice(ShoppingitempriceFormData formData) {
		itemPriceId = Long.valueOf(formData.itemPriceId);
		itemId = Long.valueOf(formData.itemId);
		minQuantity = Integer.valueOf(formData.minQuantity);
		maxQuantity = Integer.valueOf(formData.maxQuantity);
		price = Double.valueOf(formData.price);
		discount = Double.valueOf(formData.discount);
		taxable = Boolean.valueOf(formData.taxable);
		shipping = Double.valueOf(formData.shipping);
		useShippingFormula = Boolean.valueOf(formData.useShippingFormula);
		status = Integer.valueOf(formData.status);
	}

	public ShoppingitempriceFormData toFormData() {
		if (itemPriceId < 0) {
			itemPriceId = 0L;
		}

		ShoppingitempriceFormData formData = new ShoppingitempriceFormData(
			String.valueOf(itemPriceId)
			,
			String.valueOf(itemId)
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
			String.valueOf(status)
			
		);

		return formData;
	}

}
