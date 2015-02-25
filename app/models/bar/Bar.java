package models.bar;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import controllers.bar.BarFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Bar extends Model {

	// model attributes

	@Id
	public long id;

	@Constraints.Required
	@Constraints.MaxLength(35)
	public String campo2;


	// model finder attribute

	public static Finder<Long,Bar> find = new Finder<Long,Bar>(
		Long.class, Bar.class
	);

	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public Bar(){
	}

	// constructor using a formData

	public Bar(BarFormData formData) {
		id = Long.valueOf(formData.id);
		campo2 = formData.campo2;
	}

	public BarFormData toFormData() {
		if (id < 0) {
			id = 0L;
		}

		BarFormData formData = new BarFormData(
			String.valueOf(id)
			,
			campo2
			
		);

		return formData;
	}

}
