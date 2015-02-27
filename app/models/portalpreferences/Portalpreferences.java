
package models.portalpreferences;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.portalpreferences.PortalpreferencesFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Portalpreferences extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long portalPreferencesId;

	public long ownerId;

	public int ownerType;

	public String preferences;


	// model finder attribute

	public static Finder<Long,Portalpreferences> find = new Finder<Long,Portalpreferences>(
		Long.class, Portalpreferences.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getPortalPreferencesId() {
		return portalPreferencesId;
	}

	public void setPortalPreferencesId(long portalPreferencesId) {
		this.portalPreferencesId = portalPreferencesId;
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
	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public Portalpreferences(){
	}

	// constructor using a formData

	public Portalpreferences(PortalpreferencesFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		portalPreferencesId = Long.valueOf(formData.portalPreferencesId);
		ownerId = Long.valueOf(formData.ownerId);
		ownerType = Integer.valueOf(formData.ownerType);
		preferences = formData.preferences;
	}

	public PortalpreferencesFormData toFormData() {
		if (portalPreferencesId < 0) {
			portalPreferencesId = 0L;
		}

		PortalpreferencesFormData formData = new PortalpreferencesFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(portalPreferencesId)
			,
			String.valueOf(ownerId)
			,
			String.valueOf(ownerType)
			,
			preferences
			
		);

		return formData;
	}

}
