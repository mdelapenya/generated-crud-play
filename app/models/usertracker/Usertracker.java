
package models.usertracker;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.usertracker.UsertrackerFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Usertracker extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userTrackerId;

	public long companyId;

	public long userId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(200)
	public String sessionId;

	@Constraints.MaxLength(75)
	public String remoteAddr;

	@Constraints.MaxLength(75)
	public String remoteHost;

	@Constraints.MaxLength(200)
	public String userAgent;


	// model finder attribute

	public static Finder<Long,Usertracker> find = new Finder<Long,Usertracker>(
		Long.class, Usertracker.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getUserTrackerId() {
		return userTrackerId;
	}

	public void setUserTrackerId(long userTrackerId) {
		this.userTrackerId = userTrackerId;
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
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Usertracker(){
	}

	// constructor using a formData

	public Usertracker(UsertrackerFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		userTrackerId = Long.valueOf(formData.userTrackerId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		modifiedDate = new Date(formData.modifiedDate);
		sessionId = formData.sessionId;
		remoteAddr = formData.remoteAddr;
		remoteHost = formData.remoteHost;
		userAgent = formData.userAgent;
	}

	public UsertrackerFormData toFormData() {
		if (userTrackerId < 0) {
			userTrackerId = 0L;
		}

		UsertrackerFormData formData = new UsertrackerFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(userTrackerId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(modifiedDate)
			,
			sessionId
			,
			remoteAddr
			,
			remoteHost
			,
			userAgent
			
		);

		return formData;
	}

}
