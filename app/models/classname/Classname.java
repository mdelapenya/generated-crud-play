
package models.classname;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.classname.ClassnameFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Classname extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long classNameId;

	@Constraints.MaxLength(200)
	public String value;


	// model finder attribute

	public static Finder<Long,Classname> find = new Finder<Long,Classname>(
		Long.class, Classname.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Classname(){
	}

	// constructor using a formData

	public Classname(ClassnameFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		classNameId = Long.valueOf(formData.classNameId);
		value = formData.value;
	}

	public ClassnameFormData toFormData() {
		if (classNameId < 0) {
			classNameId = 0L;
		}

		ClassnameFormData formData = new ClassnameFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(classNameId)
			,
			value
			
		);

		return formData;
	}

}
