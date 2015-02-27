
package models.trashversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.trashversion.TrashversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Trashversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long versionId;

	public long entryId;

	public long classNameId;

	public long classPK;

	public String typeSettings;

	public int status;


	// model finder attribute

	public static Finder<Long,Trashversion> find = new Finder<Long,Trashversion>(
		Long.class, Trashversion.class
	);

	// getters and setters

	public long getVersionId() {
		return versionId;
	}

	public void setVersionId(long versionId) {
		this.versionId = versionId;
	}
	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
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
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Trashversion(){
	}

	// constructor using a formData

	public Trashversion(TrashversionFormData formData) {
		versionId = Long.valueOf(formData.versionId);
		entryId = Long.valueOf(formData.entryId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		typeSettings = formData.typeSettings;
		status = Integer.valueOf(formData.status);
	}

	public TrashversionFormData toFormData() {
		if (versionId < 0) {
			versionId = 0L;
		}

		TrashversionFormData formData = new TrashversionFormData(
			String.valueOf(versionId)
			,
			String.valueOf(entryId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			typeSettings
			,
			String.valueOf(status)
			
		);

		return formData;
	}

}
