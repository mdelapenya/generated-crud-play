
package models.browsertracker;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.browsertracker.BrowsertrackerFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Browsertracker extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long browserTrackerId;

	public long userId;

	public long browserKey;


	// model finder attribute

	public static Finder<Long,Browsertracker> find = new Finder<Long,Browsertracker>(
		Long.class, Browsertracker.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getBrowserTrackerId() {
		return browserTrackerId;
	}

	public void setBrowserTrackerId(long browserTrackerId) {
		this.browserTrackerId = browserTrackerId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBrowserKey() {
		return browserKey;
	}

	public void setBrowserKey(long browserKey) {
		this.browserKey = browserKey;
	}

	public Browsertracker(){
	}

	// constructor using a formData

	public Browsertracker(BrowsertrackerFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		browserTrackerId = Long.valueOf(formData.browserTrackerId);
		userId = Long.valueOf(formData.userId);
		browserKey = Long.valueOf(formData.browserKey);
	}

	public BrowsertrackerFormData toFormData() {
		if (browserTrackerId < 0) {
			browserTrackerId = 0L;
		}

		BrowsertrackerFormData formData = new BrowsertrackerFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(browserTrackerId)
			,
			String.valueOf(userId)
			,
			String.valueOf(browserKey)
			
		);

		return formData;
	}

}
