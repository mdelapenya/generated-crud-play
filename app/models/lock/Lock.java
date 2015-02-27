
package models.lock;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.lock.LockFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Lock extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long lockId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Constraints.MaxLength(75)
	public String className;

	@Constraints.MaxLength(200)
	public String key;

	@Constraints.MaxLength(1024)
	public String owner;

	public boolean inheritable;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date expirationDate;


	// model finder attribute

	public static Finder<Long,Lock> find = new Finder<Long,Lock>(
		Long.class, Lock.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getLockId() {
		return lockId;
	}

	public void setLockId(long lockId) {
		this.lockId = lockId;
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
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	public boolean getInheritable() {
		return inheritable;
	}

	public void setInheritable(boolean inheritable) {
		this.inheritable = inheritable;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Lock(){
	}

	// constructor using a formData

	public Lock(LockFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		lockId = Long.valueOf(formData.lockId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		className = formData.className;
		key = formData.key;
		owner = formData.owner;
		inheritable = Boolean.valueOf(formData.inheritable);
		expirationDate = new Date(formData.expirationDate);
	}

	public LockFormData toFormData() {
		if (lockId < 0) {
			lockId = 0L;
		}

		LockFormData formData = new LockFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(lockId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			className
			,
			key
			,
			owner
			,
			String.valueOf(inheritable)
			,
			String.valueOf(expirationDate)
			
		);

		return formData;
	}

}
