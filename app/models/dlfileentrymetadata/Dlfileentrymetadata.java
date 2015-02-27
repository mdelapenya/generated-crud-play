
package models.dlfileentrymetadata;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfileentrymetadata.DlfileentrymetadataFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfileentrymetadata extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileEntryMetadataId;

	public long DDMStorageId;

	public long DDMStructureId;

	public long fileEntryTypeId;

	public long fileEntryId;

	public long fileVersionId;


	// model finder attribute

	public static Finder<Long,Dlfileentrymetadata> find = new Finder<Long,Dlfileentrymetadata>(
		Long.class, Dlfileentrymetadata.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getFileEntryMetadataId() {
		return fileEntryMetadataId;
	}

	public void setFileEntryMetadataId(long fileEntryMetadataId) {
		this.fileEntryMetadataId = fileEntryMetadataId;
	}
	public long getDDMStorageId() {
		return DDMStorageId;
	}

	public void setDDMStorageId(long DDMStorageId) {
		this.DDMStorageId = DDMStorageId;
	}
	public long getDDMStructureId() {
		return DDMStructureId;
	}

	public void setDDMStructureId(long DDMStructureId) {
		this.DDMStructureId = DDMStructureId;
	}
	public long getFileEntryTypeId() {
		return fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		this.fileEntryTypeId = fileEntryTypeId;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public long getFileVersionId() {
		return fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		this.fileVersionId = fileVersionId;
	}

	public Dlfileentrymetadata(){
	}

	// constructor using a formData

	public Dlfileentrymetadata(DlfileentrymetadataFormData formData) {
		uuid = formData.uuid;
		fileEntryMetadataId = Long.valueOf(formData.fileEntryMetadataId);
		DDMStorageId = Long.valueOf(formData.DDMStorageId);
		DDMStructureId = Long.valueOf(formData.DDMStructureId);
		fileEntryTypeId = Long.valueOf(formData.fileEntryTypeId);
		fileEntryId = Long.valueOf(formData.fileEntryId);
		fileVersionId = Long.valueOf(formData.fileVersionId);
	}

	public DlfileentrymetadataFormData toFormData() {
		if (fileEntryMetadataId < 0) {
			fileEntryMetadataId = 0L;
		}

		DlfileentrymetadataFormData formData = new DlfileentrymetadataFormData(
			uuid
			,
			String.valueOf(fileEntryMetadataId)
			,
			String.valueOf(DDMStorageId)
			,
			String.valueOf(DDMStructureId)
			,
			String.valueOf(fileEntryTypeId)
			,
			String.valueOf(fileEntryId)
			,
			String.valueOf(fileVersionId)
			
		);

		return formData;
	}

}
