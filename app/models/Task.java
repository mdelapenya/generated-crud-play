package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import controllers.task.TaskFormData;

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

	public Task(){
	}

	public Task(TaskFormData formData) {
		id = Long.valueOf(formData.id);
		name = formData.name;
		street = formData.street;
		done = Boolean.valueOf(formData.done);
	}

	public TaskFormData toFormData() {
		if (id == null) {
			id = 0L;
		}

		TaskFormData formData = new TaskFormData(
			String.valueOf(id), name, street, String.valueOf(done),
			String.valueOf(dueDate));

		return formData;
	}

}