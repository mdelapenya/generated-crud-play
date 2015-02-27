package controllers.subscription;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Subscription data form.
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
public class SubscriptionFormData {

	public String mvccVersion;
	public String subscriptionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String frequency;

	public SubscriptionFormData() {
	}

	public SubscriptionFormData(
		String mvccVersion,
				String subscriptionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String frequency
		) {

		this.mvccVersion = mvccVersion;
		this.subscriptionId = subscriptionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.frequency = frequency;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (subscriptionId == null || subscriptionId.length() == 0) {
			errors.add(new ValidationError("subscriptionId", "No subscriptionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
