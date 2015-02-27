
package models.expandocolumn;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.expandocolumn.ExpandocolumnFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Expandocolumn extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long columnId;

	public long companyId;

	public long tableId;

	@Constraints.MaxLength(75)
	public String name;

	public int customtype;

	public String defaultData;

	public String typeSettings;


	// model finder attribute

	public static Finder<Long,Expandocolumn> find = new Finder<Long,Expandocolumn>(
		Long.class, Expandocolumn.class
	);

	// getters and setters

	public long getColumnId() {
		return columnId;
	}

	public void setColumnId(long columnId) {
		this.columnId = columnId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getDefaultData() {
		return defaultData;
	}

	public void setDefaultData(String defaultData) {
		this.defaultData = defaultData;
	}
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
	}

	public Expandocolumn(){
	}

	// constructor using a formData

	public Expandocolumn(ExpandocolumnFormData formData) {
		columnId = Long.valueOf(formData.columnId);
		companyId = Long.valueOf(formData.companyId);
		tableId = Long.valueOf(formData.tableId);
		name = formData.name;
		customtype = Integer.valueOf(formData.customtype);
		defaultData = formData.defaultData;
		typeSettings = formData.typeSettings;
	}

	public ExpandocolumnFormData toFormData() {
		if (columnId < 0) {
			columnId = 0L;
		}

		ExpandocolumnFormData formData = new ExpandocolumnFormData(
			String.valueOf(columnId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(tableId)
			,
			name
			,
			String.valueOf(customtype)
			,
			defaultData
			,
			typeSettings
			
		);

		return formData;
	}

}
