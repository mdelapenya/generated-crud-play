
package models.webdavprops;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.webdavprops.WebdavpropsFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Webdavprops extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long webDavPropsId;

	public long companyId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long classNameId;

	public long classPK;

	public String props;


	// model finder attribute

	public static Finder<Long,Webdavprops> find = new Finder<Long,Webdavprops>(
		Long.class, Webdavprops.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getWebDavPropsId() {
		return webDavPropsId;
	}

	public void setWebDavPropsId(long webDavPropsId) {
		this.webDavPropsId = webDavPropsId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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
	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public Webdavprops(){
	}

	// constructor using a formData

	public Webdavprops(WebdavpropsFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		webDavPropsId = Long.valueOf(formData.webDavPropsId);
		companyId = Long.valueOf(formData.companyId);
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		props = formData.props;
	}

	public WebdavpropsFormData toFormData() {
		if (webDavPropsId < 0) {
			webDavPropsId = 0L;
		}

		WebdavpropsFormData formData = new WebdavpropsFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(webDavPropsId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			props
			
		);

		return formData;
	}

}
