
package models.shoppingitemfield;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shoppingitemfield.ShoppingitemfieldFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shoppingitemfield extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long itemFieldId;

	public long itemId;

	@Constraints.MaxLength(75)
	public String name;

	public String values;

	public String description;


	// model finder attribute

	public static Finder<Long,Shoppingitemfield> find = new Finder<Long,Shoppingitemfield>(
		Long.class, Shoppingitemfield.class
	);

	// getters and setters

	public long getItemFieldId() {
		return itemFieldId;
	}

	public void setItemFieldId(long itemFieldId) {
		this.itemFieldId = itemFieldId;
	}
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Shoppingitemfield(){
	}

	// constructor using a formData

	public Shoppingitemfield(ShoppingitemfieldFormData formData) {
		itemFieldId = Long.valueOf(formData.itemFieldId);
		itemId = Long.valueOf(formData.itemId);
		name = formData.name;
		values = formData.values;
		description = formData.description;
	}

	public ShoppingitemfieldFormData toFormData() {
		if (itemFieldId < 0) {
			itemFieldId = 0L;
		}

		ShoppingitemfieldFormData formData = new ShoppingitemfieldFormData(
			String.valueOf(itemFieldId)
			,
			String.valueOf(itemId)
			,
			name
			,
			values
			,
			description
			
		);

		return formData;
	}

}
