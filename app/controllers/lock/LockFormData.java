package controllers.lock;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Lock data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class LockFormData {

	public String mvccVersion;
	public String uuid;
	public String lockId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String className;
	public String key;
	public String owner;
	public String inheritable;
	public String expirationDate;

	public LockFormData() {
	}

	public LockFormData(
		String mvccVersion,
				String uuid,
				String lockId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String className,
				String key,
				String owner,
				String inheritable,
				String expirationDate
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.lockId = lockId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.className = className;
		this.key = key;
		this.owner = owner;
		this.inheritable = inheritable;
		this.expirationDate = expirationDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (lockId == null || lockId.length() == 0) {
			errors.add(new ValidationError("lockId", "No lockId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
