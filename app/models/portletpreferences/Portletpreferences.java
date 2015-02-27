
package models.portletpreferences;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.portletpreferences.PortletpreferencesFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Portletpreferences extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long portletPreferencesId;

	public long ownerId;

	public int ownerType;

	public long plid;

	@Constraints.MaxLength(200)
	public String portletId;

	public String preferences;


	// model finder attribute

	public static Finder<Long,Portletpreferences> find = new Finder<Long,Portletpreferences>(
		Long.class, Portletpreferences.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getPortletPreferencesId() {
		return portletPreferencesId;
	}

	public void setPortletPreferencesId(long portletPreferencesId) {
		this.portletPreferencesId = portletPreferencesId;
	}
	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public int getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(int ownerType) {
		this.ownerType = ownerType;
	}
	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
	}
	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public Portletpreferences(){
	}

	// constructor using a formData

	public Portletpreferences(PortletpreferencesFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		portletPreferencesId = Long.valueOf(formData.portletPreferencesId);
		ownerId = Long.valueOf(formData.ownerId);
		ownerType = Integer.valueOf(formData.ownerType);
		plid = Long.valueOf(formData.plid);
		portletId = formData.portletId;
		preferences = formData.preferences;
	}

	public PortletpreferencesFormData toFormData() {
		if (portletPreferencesId < 0) {
			portletPreferencesId = 0L;
		}

		PortletpreferencesFormData formData = new PortletpreferencesFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(portletPreferencesId)
			,
			String.valueOf(ownerId)
			,
			String.valueOf(ownerType)
			,
			String.valueOf(plid)
			,
			portletId
			,
			preferences
			
		);

		return formData;
	}

}
