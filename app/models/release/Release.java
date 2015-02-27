
package models.release;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.release.ReleaseFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Release extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long releaseId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String servletContextName;

	public int buildNumber;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date buildDate;

	public boolean verified;

	public int state;

	@Constraints.MaxLength(1024)
	public String testString;


	// model finder attribute

	public static Finder<Long,Release> find = new Finder<Long,Release>(
		Long.class, Release.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
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
	public String getServletContextName() {
		return servletContextName;
	}

	public void setServletContextName(String servletContextName) {
		this.servletContextName = servletContextName;
	}
	public int getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber;
	}
	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	public boolean getVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public Release(){
	}

	// constructor using a formData

	public Release(ReleaseFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		releaseId = Long.valueOf(formData.releaseId);
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		servletContextName = formData.servletContextName;
		buildNumber = Integer.valueOf(formData.buildNumber);
		buildDate = new Date(formData.buildDate);
		verified = Boolean.valueOf(formData.verified);
		state = Integer.valueOf(formData.state);
		testString = formData.testString;
	}

	public ReleaseFormData toFormData() {
		if (releaseId < 0) {
			releaseId = 0L;
		}

		ReleaseFormData formData = new ReleaseFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(releaseId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			servletContextName
			,
			String.valueOf(buildNumber)
			,
			String.valueOf(buildDate)
			,
			String.valueOf(verified)
			,
			String.valueOf(state)
			,
			testString
			
		);

		return formData;
	}

}
