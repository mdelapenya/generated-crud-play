
package models.expandotable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.expandotable.ExpandotableFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Expandotable extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long tableId;

	public long companyId;

	public long classNameId;

	@Constraints.MaxLength(75)
	public String name;


	// model finder attribute

	public static Finder<Long,Expandotable> find = new Finder<Long,Expandotable>(
		Long.class, Expandotable.class
	);

	// getters and setters

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expandotable(){
	}

	// constructor using a formData

	public Expandotable(ExpandotableFormData formData) {
		tableId = Long.valueOf(formData.tableId);
		companyId = Long.valueOf(formData.companyId);
		classNameId = Long.valueOf(formData.classNameId);
		name = formData.name;
	}

	public ExpandotableFormData toFormData() {
		if (tableId < 0) {
			tableId = 0L;
		}

		ExpandotableFormData formData = new ExpandotableFormData(
			String.valueOf(tableId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(classNameId)
			,
			name
			
		);

		return formData;
	}

}
