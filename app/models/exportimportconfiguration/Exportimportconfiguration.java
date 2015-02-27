
package models.exportimportconfiguration;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.exportimportconfiguration.ExportimportconfigurationFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Exportimportconfiguration extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long exportImportConfigurationId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	public int customtype;

	public String settings;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Exportimportconfiguration> find = new Finder<Long,Exportimportconfiguration>(
		Long.class, Exportimportconfiguration.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getExportImportConfigurationId() {
		return exportImportConfigurationId;
	}

	public void setExportImportConfigurationId(long exportImportConfigurationId) {
		this.exportImportConfigurationId = exportImportConfigurationId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public long getStatusByUserId() {
		return statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		this.statusByUserId = statusByUserId;
	}
	public String getStatusByUserName() {
		return statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		this.statusByUserName = statusByUserName;
	}
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Exportimportconfiguration(){
	}

	// constructor using a formData

	public Exportimportconfiguration(ExportimportconfigurationFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		exportImportConfigurationId = Long.valueOf(formData.exportImportConfigurationId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		name = formData.name;
		description = formData.description;
		customtype = Integer.valueOf(formData.customtype);
		settings = formData.settings;
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public ExportimportconfigurationFormData toFormData() {
		if (exportImportConfigurationId < 0) {
			exportImportConfigurationId = 0L;
		}

		ExportimportconfigurationFormData formData = new ExportimportconfigurationFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(exportImportConfigurationId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			name
			,
			description
			,
			String.valueOf(customtype)
			,
			settings
			,
			String.valueOf(status)
			,
			String.valueOf(statusByUserId)
			,
			statusByUserName
			,
			String.valueOf(statusDate)
			
		);

		return formData;
	}

}
