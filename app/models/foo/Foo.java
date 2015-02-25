package models.foo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import controllers.foo.FooFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Foo extends Model {

	// model attributes

	@Id
	public long id;

	@Constraints.Required
	@Constraints.MaxLength(35)
	public String f2;


	// model finder attribute

	public static Finder<Long,Foo> find = new Finder<Long,Foo>(
		Long.class, Foo.class
	);

	// getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public Foo(){
	}

	// constructor using a formData

	public Foo(FooFormData formData) {
		id = Long.valueOf(formData.id);
		f2 = formData.f2;
	}

	public FooFormData toFormData() {
		if (id < 0) {
			id = 0L;
		}

		FooFormData formData = new FooFormData(
			String.valueOf(id)
			,
			f2
			
		);

		return formData;
	}

}
