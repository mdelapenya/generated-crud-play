
package models.expandorow;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.expandorow.ExpandorowFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Expandorow extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long rowId;

	public long companyId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long tableId;

	public long classPK;


	// model finder attribute

	public static Finder<Long,Expandorow> find = new Finder<Long,Expandorow>(
		Long.class, Expandorow.class
	);

	// getters and setters

	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public Expandorow(){
	}

	// constructor using a formData

	public Expandorow(ExpandorowFormData formData) {
		rowId = Long.valueOf(formData.rowId);
		companyId = Long.valueOf(formData.companyId);
		modifiedDate = new Date(formData.modifiedDate);
		tableId = Long.valueOf(formData.tableId);
		classPK = Long.valueOf(formData.classPK);
	}

	public ExpandorowFormData toFormData() {
		if (rowId < 0) {
			rowId = 0L;
		}

		ExpandorowFormData formData = new ExpandorowFormData(
			String.valueOf(rowId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(tableId)
			,
			String.valueOf(classPK)
			
		);

		return formData;
	}

}
