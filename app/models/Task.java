package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 */
@Entity
public class Task extends Model {

	@Id
	@Constraints.Min(10)
	public Long id;

	@Constraints.Required
	public String name;

	@Constraints.MaxLength(35)
	public String street;

	public boolean done;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date dueDate = new Date();

	public static Finder<Long,Task> find = new Finder<Long,Task>(
		Long.class, Task.class
	);

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}