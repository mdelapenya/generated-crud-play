
package models.ddmstoragelink;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmstoragelink.DdmstoragelinkFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmstoragelink extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long storageLinkId;

	public long classNameId;

	public long classPK;

	public long structureId;


	// model finder attribute

	public static Finder<Long,Ddmstoragelink> find = new Finder<Long,Ddmstoragelink>(
		Long.class, Ddmstoragelink.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getStorageLinkId() {
		return storageLinkId;
	}

	public void setStorageLinkId(long storageLinkId) {
		this.storageLinkId = storageLinkId;
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

	public Ddmstoragelink(){
	}

	// constructor using a formData

	public Ddmstoragelink(DdmstoragelinkFormData formData) {
		uuid = formData.uuid;
		storageLinkId = Long.valueOf(formData.storageLinkId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		structureId = Long.valueOf(formData.structureId);
	}

	public DdmstoragelinkFormData toFormData() {
		if (storageLinkId < 0) {
			storageLinkId = 0L;
		}

		DdmstoragelinkFormData formData = new DdmstoragelinkFormData(
			uuid
			,
			String.valueOf(storageLinkId)
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
