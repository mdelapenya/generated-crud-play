
package models.expandovalue;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.expandovalue.ExpandovalueFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Expandovalue extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long valueId;

	public long companyId;

	public long tableId;

	public long columnId;

	public long rowId;

	public long classNameId;

	public long classPK;

	public String data;


	// model finder attribute

	public static Finder<Long,Expandovalue> find = new Finder<Long,Expandovalue>(
		Long.class, Expandovalue.class
	);

	// getters and setters

	public long getValueId() {
		return valueId;
	}

	public void setValueId(long valueId) {
		this.valueId = valueId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public long getColumnId() {
		return columnId;
	}

	public void setColumnId(long columnId) {
		this.columnId = columnId;
	}
	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Expandovalue(){
	}

	// constructor using a formData

	public Expandovalue(ExpandovalueFormData formData) {
		valueId = Long.valueOf(formData.valueId);
		companyId = Long.valueOf(formData.companyId);
		tableId = Long.valueOf(formData.tableId);
		columnId = Long.valueOf(formData.columnId);
		rowId = Long.valueOf(formData.rowId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		data = formData.data;
	}

	public ExpandovalueFormData toFormData() {
		if (valueId < 0) {
			valueId = 0L;
		}

		ExpandovalueFormData formData = new ExpandovalueFormData(
			String.valueOf(valueId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(tableId)
			,
			String.valueOf(columnId)
			,
			String.valueOf(rowId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			data
			
		);

		return formData;
	}

}
