
package models.ddmstructurelink;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmstructurelink.DdmstructurelinkFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmstructurelink extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long structureLinkId;

	public long classNameId;

	public long classPK;

	public long structureId;


	// model finder attribute

	public static Finder<Long,Ddmstructurelink> find = new Finder<Long,Ddmstructurelink>(
		Long.class, Ddmstructurelink.class
	);

	// getters and setters

	public long getStructureLinkId() {
		return structureLinkId;
	}

	public void setStructureLinkId(long structureLinkId) {
		this.structureLinkId = structureLinkId;
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
	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

	public Ddmstructurelink(){
	}

	// constructor using a formData

	public Ddmstructurelink(DdmstructurelinkFormData formData) {
		structureLinkId = Long.valueOf(formData.structureLinkId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		structureId = Long.valueOf(formData.structureId);
	}

	public DdmstructurelinkFormData toFormData() {
		if (structureLinkId < 0) {
			structureLinkId = 0L;
		}

		DdmstructurelinkFormData formData = new DdmstructurelinkFormData(
			String.valueOf(structureLinkId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(structureId)
			
		);

		return formData;
	}

}
