
package models.portlet;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.portlet.PortletFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Portlet extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long id;

	public long companyId;

	@Constraints.MaxLength(200)
	public String portletId;

	public String roles;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Portlet> find = new Finder<Long,Portlet>(
		Long.class, Portlet.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Portlet(){
	}

	// constructor using a formData

	public Portlet(PortletFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		id = Long.valueOf(formData.id);
		companyId = Long.valueOf(formData.companyId);
		portletId = formData.portletId;
		roles = formData.roles;
		active = Boolean.valueOf(formData.active);
	}

	public PortletFormData toFormData() {
		if (id < 0) {
			id = 0L;
		}

		PortletFormData formData = new PortletFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(id)
			,
			String.valueOf(companyId)
			,
			portletId
			,
			roles
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
