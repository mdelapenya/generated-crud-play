
package models.ddmtemplate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ddmtemplate.DdmtemplateFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ddmtemplate extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long templateId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long classNameId;

	public long classPK;

	public long sourceClassNameId;

	@Constraints.MaxLength(75)
	public String templateKey;

	@Constraints.MaxLength(75)
	public String version;

	public String name;

	public String description;

	@Constraints.MaxLength(75)
	public String customtype;

	@Constraints.MaxLength(75)
	public String mode;

	@Constraints.MaxLength(75)
	public String language;

	public String script;

	public boolean cacheable;

	public boolean smallImage;

	public long smallImageId;

	@Constraints.MaxLength(75)
	public String smallImageURL;


	// model finder attribute

	public static Finder<Long,Ddmtemplate> find = new Finder<Long,Ddmtemplate>(
		Long.class, Ddmtemplate.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
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
	public long getSourceClassNameId() {
		return sourceClassNameId;
	}

	public void setSourceClassNameId(long sourceClassNameId) {
		this.sourceClassNameId = sourceClassNameId;
	}
	public String getTemplateKey() {
		return templateKey;
	}

	public void setTemplateKey(String templateKey) {
		this.templateKey = templateKey;
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
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
	public boolean getCacheable() {
		return cacheable;
	}

	public void setCacheable(boolean cacheable) {
		this.cacheable = cacheable;
	}
	public boolean getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		this.smallImage = smallImage;
	}
	public long getSmallImageId() {
		return smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		this.smallImageId = smallImageId;
	}
	public String getSmallImageURL() {
		return smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}

	public Ddmtemplate(){
	}

	// constructor using a formData

	public Ddmtemplate(DdmtemplateFormData formData) {
		uuid = formData.uuid;
		templateId = Long.valueOf(formData.templateId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		sourceClassNameId = Long.valueOf(formData.sourceClassNameId);
		templateKey = formData.templateKey;
		version = formData.version;
		name = formData.name;
		description = formData.description;
		customtype = formData.customtype;
		mode = formData.mode;
		language = formData.language;
		script = formData.script;
		cacheable = Boolean.valueOf(formData.cacheable);
		smallImage = Boolean.valueOf(formData.smallImage);
		smallImageId = Long.valueOf(formData.smallImageId);
		smallImageURL = formData.smallImageURL;
	}

	public DdmtemplateFormData toFormData() {
		if (templateId < 0) {
			templateId = 0L;
		}

		DdmtemplateFormData formData = new DdmtemplateFormData(
			uuid
			,
			String.valueOf(templateId)
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
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(sourceClassNameId)
			,
			templateKey
			,
			version
			,
			name
			,
			description
			,
			customtype
			,
			mode
			,
			language
			,
			script
			,
			String.valueOf(cacheable)
			,
			String.valueOf(smallImage)
			,
			String.valueOf(smallImageId)
			,
			smallImageURL
			
		);

		return formData;
	}

}
