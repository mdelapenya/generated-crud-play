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
 */
@Entity
public class Foo extends Model {

	// model attributes

	@Id
	@Constraints.Required
	public long f1;

	@Id
	@Constraints.Required
	@Constraints.MaxLength(35)
	public String f2;


	// model finder attribute

	public static Finder<Long,Foo> find = new Finder<Long,Foo>(
		Long.class, Foo.class
	);

	// getters and setters

	public long getF1() {
		return f1;
	}

	public void setF1(long f1) {
		this.f1 = f1;
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
		f1 = Long.valueOf(formData.f1);
		f2 = formData.f2;
	}

	public FooFormData toFormData() {
		if (f1 < 0) {
			f1 = 0L;
		}

		FooFormData formData = new FooFormData(
			String.valueOf(f1)
			,
			f2
			
		);

		return formData;
	}

}
