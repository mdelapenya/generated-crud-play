package controllers.dlfileentrymetadata;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Dlfileentrymetadata data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class DlfileentrymetadataFormData {

	public String uuid;
	public String fileEntryMetadataId;
	public String DDMStorageId;
	public String DDMStructureId;
	public String fileEntryTypeId;
	public String fileEntryId;
	public String fileVersionId;

	public DlfileentrymetadataFormData() {
	}

	public DlfileentrymetadataFormData(
		String uuid,
				String fileEntryMetadataId,
				String DDMStorageId,
				String DDMStructureId,
				String fileEntryTypeId,
				String fileEntryId,
				String fileVersionId
		) {

		this.uuid = uuid;
		this.fileEntryMetadataId = fileEntryMetadataId;
		this.DDMStorageId = DDMStorageId;
		this.DDMStructureId = DDMStructureId;
		this.fileEntryTypeId = fileEntryTypeId;
		this.fileEntryId = fileEntryId;
		this.fileVersionId = fileVersionId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (fileEntryMetadataId == null || fileEntryMetadataId.length() == 0) {
			errors.add(new ValidationError("fileEntryMetadataId", "No fileEntryMetadataId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
