
package models.ddmtemplateversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmtemplateversion.DdmtemplateversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmtemplateversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long templateVersionId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long templateId;

	@Constraints.MaxLength(75)
	public String version;

	public String name;

	public String description;

	@Constraints.MaxLength(75)
	public String language;

	public String script;


	// model finder attribute

	public static Finder<Long,Ddmtemplateversion> find = new Finder<Long,Ddmtemplateversion>(
		Long.class, Ddmtemplateversion.class
	);

	// getters and setters

	public long getTemplateVersionId() {
		return templateVersionId;
	}

	public void setTemplateVersionId(long templateVersionId) {
		this.templateVersionId = templateVersionId;
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
	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public Ddmtemplateversion(){
	}

	// constructor using a formData

	public Ddmtemplateversion(DdmtemplateversionFormData formData) {
		templateVersionId = Long.valueOf(formData.templateVersionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		templateId = Long.valueOf(formData.templateId);
		version = formData.version;
		name = formData.name;
		description = formData.description;
		language = formData.language;
		script = formData.script;
	}

	public DdmtemplateversionFormData toFormData() {
		if (templateVersionId < 0) {
			templateVersionId = 0L;
		}

		DdmtemplateversionFormData formData = new DdmtemplateversionFormData(
			String.valueOf(templateVersionId)
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
			String.valueOf(templateId)
			,
			version
			,
			name
			,
			description
			,
			language
			,
			script
			
		);

		return formData;
	}

}
