package controllers.exportimportconfiguration;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Exportimportconfiguration data form.
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
public class ExportimportconfigurationFormData {

	public String mvccVersion;
	public String exportImportConfigurationId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String description;
	public String customtype;
	public String settings;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public ExportimportconfigurationFormData() {
	}

	public ExportimportconfigurationFormData(
		String mvccVersion,
				String exportImportConfigurationId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String description,
				String customtype,
				String settings,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.mvccVersion = mvccVersion;
		this.exportImportConfigurationId = exportImportConfigurationId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.description = description;
		this.customtype = customtype;
		this.settings = settings;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (exportImportConfigurationId == null || exportImportConfigurationId.length() == 0) {
			errors.add(new ValidationError("exportImportConfigurationId", "No exportImportConfigurationId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
