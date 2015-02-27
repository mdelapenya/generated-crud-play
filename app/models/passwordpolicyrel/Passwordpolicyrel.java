
package models.passwordpolicyrel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.passwordpolicyrel.PasswordpolicyrelFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Passwordpolicyrel extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long passwordPolicyRelId;

	public long passwordPolicyId;

	public long classNameId;

	public long classPK;


	// model finder attribute

	public static Finder<Long,Passwordpolicyrel> find = new Finder<Long,Passwordpolicyrel>(
		Long.class, Passwordpolicyrel.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getPasswordPolicyRelId() {
		return passwordPolicyRelId;
	}

	public void setPasswordPolicyRelId(long passwordPolicyRelId) {
		this.passwordPolicyRelId = passwordPolicyRelId;
	}
	public long getPasswordPolicyId() {
		return passwordPolicyId;
	}

	public void setPasswordPolicyId(long passwordPolicyId) {
		this.passwordPolicyId = passwordPolicyId;
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

	public Passwordpolicyrel(){
	}

	// constructor using a formData

	public Passwordpolicyrel(PasswordpolicyrelFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		passwordPolicyRelId = Long.valueOf(formData.passwordPolicyRelId);
		passwordPolicyId = Long.valueOf(formData.passwordPolicyId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
	}

	public PasswordpolicyrelFormData toFormData() {
		if (passwordPolicyRelId < 0) {
			passwordPolicyRelId = 0L;
		}

		PasswordpolicyrelFormData formData = new PasswordpolicyrelFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(passwordPolicyRelId)
			,
			String.valueOf(passwordPolicyId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			
		);

		return formData;
	}

}
