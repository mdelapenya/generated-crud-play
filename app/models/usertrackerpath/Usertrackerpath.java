
package models.usertrackerpath;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.usertrackerpath.UsertrackerpathFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Usertrackerpath extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userTrackerPathId;

	public long userTrackerId;

	public String path;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date pathDate;


	// model finder attribute

	public static Finder<Long,Usertrackerpath> find = new Finder<Long,Usertrackerpath>(
		Long.class, Usertrackerpath.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getUserTrackerPathId() {
		return userTrackerPathId;
	}

	public void setUserTrackerPathId(long userTrackerPathId) {
		this.userTrackerPathId = userTrackerPathId;
	}
	public long getUserTrackerId() {
		return userTrackerId;
	}

	public void setUserTrackerId(long userTrackerId) {
		this.userTrackerId = userTrackerId;
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public Date getPathDate() {
		return pathDate;
	}

	public void setPathDate(Date pathDate) {
		this.pathDate = pathDate;
	}

	public Usertrackerpath(){
	}

	// constructor using a formData

	public Usertrackerpath(UsertrackerpathFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		userTrackerPathId = Long.valueOf(formData.userTrackerPathId);
		userTrackerId = Long.valueOf(formData.userTrackerId);
		path = formData.path;
		pathDate = new Date(formData.pathDate);
	}

	public UsertrackerpathFormData toFormData() {
		if (userTrackerPathId < 0) {
			userTrackerPathId = 0L;
		}

		UsertrackerpathFormData formData = new UsertrackerpathFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(userTrackerPathId)
			,
			String.valueOf(userTrackerId)
			,
			path
			,
			String.valueOf(pathDate)
			
		);

		return formData;
	}

}
