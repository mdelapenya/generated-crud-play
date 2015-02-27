
package models.useridmapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.useridmapper.UseridmapperFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Useridmapper extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userIdMapperId;

	public long userId;

	@Constraints.MaxLength(75)
	public String customtype;

	@Constraints.MaxLength(75)
	public String description;

	@Constraints.MaxLength(75)
	public String externalUserId;


	// model finder attribute

	public static Finder<Long,Useridmapper> find = new Finder<Long,Useridmapper>(
		Long.class, Useridmapper.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getUserIdMapperId() {
		return userIdMapperId;
	}

	public void setUserIdMapperId(long userIdMapperId) {
		this.userIdMapperId = userIdMapperId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getExternalUserId() {
		return externalUserId;
	}

	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}

	public Useridmapper(){
	}

	// constructor using a formData

	public Useridmapper(UseridmapperFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		userIdMapperId = Long.valueOf(formData.userIdMapperId);
		userId = Long.valueOf(formData.userId);
		customtype = formData.customtype;
		description = formData.description;
		externalUserId = formData.externalUserId;
	}

	public UseridmapperFormData toFormData() {
		if (userIdMapperId < 0) {
			userIdMapperId = 0L;
		}

		UseridmapperFormData formData = new UseridmapperFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(userIdMapperId)
			,
			String.valueOf(userId)
			,
			customtype
			,
			description
			,
			externalUserId
			
		);

		return formData;
	}

}
