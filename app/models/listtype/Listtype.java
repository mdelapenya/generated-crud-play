
package models.listtype;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.listtype.ListtypeFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Listtype extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long listTypeId;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String customtype;


	// model finder attribute

	public static Finder<Long,Listtype> find = new Finder<Long,Listtype>(
		Long.class, Listtype.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getListTypeId() {
		return listTypeId;
	}

	public void setListTypeId(long listTypeId) {
		this.listTypeId = listTypeId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}

	public Listtype(){
	}

	// constructor using a formData

	public Listtype(ListtypeFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		listTypeId = Long.valueOf(formData.listTypeId);
		name = formData.name;
		customtype = formData.customtype;
	}

	public ListtypeFormData toFormData() {
		if (listTypeId < 0) {
			listTypeId = 0L;
		}

		ListtypeFormData formData = new ListtypeFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(listTypeId)
			,
			name
			,
			customtype
			
		);

		return formData;
	}

}
