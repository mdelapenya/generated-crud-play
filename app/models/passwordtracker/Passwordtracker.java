
package models.passwordtracker;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.passwordtracker.PasswordtrackerFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Passwordtracker extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long passwordTrackerId;

	public long userId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Constraints.MaxLength(75)
	public String password;


	// model finder attribute

	public static Finder<Long,Passwordtracker> find = new Finder<Long,Passwordtracker>(
		Long.class, Passwordtracker.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getPasswordTrackerId() {
		return passwordTrackerId;
	}

	public void setPasswordTrackerId(long passwordTrackerId) {
		this.passwordTrackerId = passwordTrackerId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Passwordtracker(){
	}

	// constructor using a formData

	public Passwordtracker(PasswordtrackerFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		passwordTrackerId = Long.valueOf(formData.passwordTrackerId);
		userId = Long.valueOf(formData.userId);
		createDate = new Date(formData.createDate);
		password = formData.password;
	}

	public PasswordtrackerFormData toFormData() {
		if (passwordTrackerId < 0) {
			passwordTrackerId = 0L;
		}

		PasswordtrackerFormData formData = new PasswordtrackerFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(passwordTrackerId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			password
			
		);

		return formData;
	}

}
