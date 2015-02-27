package controllers.passwordpolicy;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Passwordpolicy data form.
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
public class PasswordpolicyFormData {

	public String mvccVersion;
	public String uuid;
	public String passwordPolicyId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String defaultPolicy;
	public String name;
	public String description;
	public String changeable;
	public String changeRequired;
	public String minAge;
	public String checkSyntax;
	public String allowDictionaryWords;
	public String minAlphanumeric;
	public String minLength;
	public String minLowerCase;
	public String minNumbers;
	public String minSymbols;
	public String minUpperCase;
	public String regex;
	public String history;
	public String historyCount;
	public String expireable;
	public String maxAge;
	public String warningTime;
	public String graceLimit;
	public String lockout;
	public String maxFailure;
	public String lockoutDuration;
	public String requireUnlock;
	public String resetFailureCount;
	public String resetTicketMaxAge;

	public PasswordpolicyFormData() {
	}

	public PasswordpolicyFormData(
		String mvccVersion,
				String uuid,
				String passwordPolicyId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String defaultPolicy,
				String name,
				String description,
				String changeable,
				String changeRequired,
				String minAge,
				String checkSyntax,
				String allowDictionaryWords,
				String minAlphanumeric,
				String minLength,
				String minLowerCase,
				String minNumbers,
				String minSymbols,
				String minUpperCase,
				String regex,
				String history,
				String historyCount,
				String expireable,
				String maxAge,
				String warningTime,
				String graceLimit,
				String lockout,
				String maxFailure,
				String lockoutDuration,
				String requireUnlock,
				String resetFailureCount,
				String resetTicketMaxAge
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.passwordPolicyId = passwordPolicyId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.defaultPolicy = defaultPolicy;
		this.name = name;
		this.description = description;
		this.changeable = changeable;
		this.changeRequired = changeRequired;
		this.minAge = minAge;
		this.checkSyntax = checkSyntax;
		this.allowDictionaryWords = allowDictionaryWords;
		this.minAlphanumeric = minAlphanumeric;
		this.minLength = minLength;
		this.minLowerCase = minLowerCase;
		this.minNumbers = minNumbers;
		this.minSymbols = minSymbols;
		this.minUpperCase = minUpperCase;
		this.regex = regex;
		this.history = history;
		this.historyCount = historyCount;
		this.expireable = expireable;
		this.maxAge = maxAge;
		this.warningTime = warningTime;
		this.graceLimit = graceLimit;
		this.lockout = lockout;
		this.maxFailure = maxFailure;
		this.lockoutDuration = lockoutDuration;
		this.requireUnlock = requireUnlock;
		this.resetFailureCount = resetFailureCount;
		this.resetTicketMaxAge = resetTicketMaxAge;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (passwordPolicyId == null || passwordPolicyId.length() == 0) {
			errors.add(new ValidationError("passwordPolicyId", "No passwordPolicyId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
