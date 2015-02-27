
package models.shoppingorderitem;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingorderitem.ShoppingorderitemFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingorderitem extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long orderItemId;

	public long orderId;

	public String itemId;

	@Constraints.MaxLength(75)
	public String sku;

	@Constraints.MaxLength(200)
	public String name;

	public String description;

	public String properties;

	public double price;

	public int quantity;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date shippedDate;


	// model finder attribute

	public static Finder<Long,Shoppingorderitem> find = new Finder<Long,Shoppingorderitem>(
		Long.class, Shoppingorderitem.class
	);

	// getters and setters

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Shoppingorderitem(){
	}

	// constructor using a formData

	public Shoppingorderitem(ShoppingorderitemFormData formData) {
		orderItemId = Long.valueOf(formData.orderItemId);
		orderId = Long.valueOf(formData.orderId);
		itemId = formData.itemId;
		sku = formData.sku;
		name = formData.name;
		description = formData.description;
		properties = formData.properties;
		price = Double.valueOf(formData.price);
		quantity = Integer.valueOf(formData.quantity);
		shippedDate = new Date(formData.shippedDate);
	}

	public ShoppingorderitemFormData toFormData() {
		if (orderItemId < 0) {
			orderItemId = 0L;
		}

		ShoppingorderitemFormData formData = new ShoppingorderitemFormData(
			String.valueOf(orderItemId)
			,
			String.valueOf(orderId)
			,
			itemId
			,
			sku
			,
			name
			,
			description
			,
			properties
			,
			String.valueOf(price)
			,
			String.valueOf(quantity)
			,
			String.valueOf(shippedDate)
			
		);

		return formData;
	}

}
