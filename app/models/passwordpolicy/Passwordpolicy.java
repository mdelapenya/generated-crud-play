
package models.passwordpolicy;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.passwordpolicy.PasswordpolicyFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Passwordpolicy extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long passwordPolicyId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public boolean defaultPolicy;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	public boolean changeable;

	public boolean changeRequired;

	public long minAge;

	public boolean checkSyntax;

	public boolean allowDictionaryWords;

	public int minAlphanumeric;

	public int minLength;

	public int minLowerCase;

	public int minNumbers;

	public int minSymbols;

	public int minUpperCase;

	@Constraints.MaxLength(75)
	public String regex;

	public boolean history;

	public int historyCount;

	public boolean expireable;

	public long maxAge;

	public long warningTime;

	public int graceLimit;

	public boolean lockout;

	public int maxFailure;

	public long lockoutDuration;

	public boolean requireUnlock;

	public long resetFailureCount;

	public long resetTicketMaxAge;


	// model finder attribute

	public static Finder<Long,Passwordpolicy> find = new Finder<Long,Passwordpolicy>(
		Long.class, Passwordpolicy.class
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
	public long getPasswordPolicyId() {
		return passwordPolicyId;
	}

	public void setPasswordPolicyId(long passwordPolicyId) {
		this.passwordPolicyId = passwordPolicyId;
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
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean getDefaultPolicy() {
		return defaultPolicy;
	}

	public void setDefaultPolicy(boolean defaultPolicy) {
		this.defaultPolicy = defaultPolicy;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getChangeable() {
		return changeable;
	}

	public void setChangeable(boolean changeable) {
		this.changeable = changeable;
	}
	public boolean getChangeRequired() {
		return changeRequired;
	}

	public void setChangeRequired(boolean changeRequired) {
		this.changeRequired = changeRequired;
	}
	public long getMinAge() {
		return minAge;
	}

	public void setMinAge(long minAge) {
		this.minAge = minAge;
	}
	public boolean getCheckSyntax() {
		return checkSyntax;
	}

	public void setCheckSyntax(boolean checkSyntax) {
		this.checkSyntax = checkSyntax;
	}
	public boolean getAllowDictionaryWords() {
		return allowDictionaryWords;
	}

	public void setAllowDictionaryWords(boolean allowDictionaryWords) {
		this.allowDictionaryWords = allowDictionaryWords;
	}
	public int getMinAlphanumeric() {
		return minAlphanumeric;
	}

	public void setMinAlphanumeric(int minAlphanumeric) {
		this.minAlphanumeric = minAlphanumeric;
	}
	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public int getMinLowerCase() {
		return minLowerCase;
	}

	public void setMinLowerCase(int minLowerCase) {
		this.minLowerCase = minLowerCase;
	}
	public int getMinNumbers() {
		return minNumbers;
	}

	public void setMinNumbers(int minNumbers) {
		this.minNumbers = minNumbers;
	}
	public int getMinSymbols() {
		return minSymbols;
	}

	public void setMinSymbols(int minSymbols) {
		this.minSymbols = minSymbols;
	}
	public int getMinUpperCase() {
		return minUpperCase;
	}

	public void setMinUpperCase(int minUpperCase) {
		this.minUpperCase = minUpperCase;
	}
	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}
	public boolean getHistory() {
		return history;
	}

	public void setHistory(boolean history) {
		this.history = history;
	}
	public int getHistoryCount() {
		return historyCount;
	}

	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}
	public boolean getExpireable() {
		return expireable;
	}

	public void setExpireable(boolean expireable) {
		this.expireable = expireable;
	}
	public long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}
	public long getWarningTime() {
		return warningTime;
	}

	public void setWarningTime(long warningTime) {
		this.warningTime = warningTime;
	}
	public int getGraceLimit() {
		return graceLimit;
	}

	public void setGraceLimit(int graceLimit) {
		this.graceLimit = graceLimit;
	}
	public boolean getLockout() {
		return lockout;
	}

	public void setLockout(boolean lockout) {
		this.lockout = lockout;
	}
	public int getMaxFailure() {
		return maxFailure;
	}

	public void setMaxFailure(int maxFailure) {
		this.maxFailure = maxFailure;
	}
	public long getLockoutDuration() {
		return lockoutDuration;
	}

	public void setLockoutDuration(long lockoutDuration) {
		this.lockoutDuration = lockoutDuration;
	}
	public boolean getRequireUnlock() {
		return requireUnlock;
	}

	public void setRequireUnlock(boolean requireUnlock) {
		this.requireUnlock = requireUnlock;
	}
	public long getResetFailureCount() {
		return resetFailureCount;
	}

	public void setResetFailureCount(long resetFailureCount) {
		this.resetFailureCount = resetFailureCount;
	}
	public long getResetTicketMaxAge() {
		return resetTicketMaxAge;
	}

	public void setResetTicketMaxAge(long resetTicketMaxAge) {
		this.resetTicketMaxAge = resetTicketMaxAge;
	}

	public Passwordpolicy(){
	}

	// constructor using a formData

	public Passwordpolicy(PasswordpolicyFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		passwordPolicyId = Long.valueOf(formData.passwordPolicyId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		defaultPolicy = Boolean.valueOf(formData.defaultPolicy);
		name = formData.name;
		description = formData.description;
		changeable = Boolean.valueOf(formData.changeable);
		changeRequired = Boolean.valueOf(formData.changeRequired);
		minAge = Long.valueOf(formData.minAge);
		checkSyntax = Boolean.valueOf(formData.checkSyntax);
		allowDictionaryWords = Boolean.valueOf(formData.allowDictionaryWords);
		minAlphanumeric = Integer.valueOf(formData.minAlphanumeric);
		minLength = Integer.valueOf(formData.minLength);
		minLowerCase = Integer.valueOf(formData.minLowerCase);
		minNumbers = Integer.valueOf(formData.minNumbers);
		minSymbols = Integer.valueOf(formData.minSymbols);
		minUpperCase = Integer.valueOf(formData.minUpperCase);
		regex = formData.regex;
		history = Boolean.valueOf(formData.history);
		historyCount = Integer.valueOf(formData.historyCount);
		expireable = Boolean.valueOf(formData.expireable);
		maxAge = Long.valueOf(formData.maxAge);
		warningTime = Long.valueOf(formData.warningTime);
		graceLimit = Integer.valueOf(formData.graceLimit);
		lockout = Boolean.valueOf(formData.lockout);
		maxFailure = Integer.valueOf(formData.maxFailure);
		lockoutDuration = Long.valueOf(formData.lockoutDuration);
		requireUnlock = Boolean.valueOf(formData.requireUnlock);
		resetFailureCount = Long.valueOf(formData.resetFailureCount);
		resetTicketMaxAge = Long.valueOf(formData.resetTicketMaxAge);
	}

	public PasswordpolicyFormData toFormData() {
		if (passwordPolicyId < 0) {
			passwordPolicyId = 0L;
		}

		PasswordpolicyFormData formData = new PasswordpolicyFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(passwordPolicyId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(defaultPolicy)
			,
			name
			,
			description
			,
			String.valueOf(changeable)
			,
			String.valueOf(changeRequired)
			,
			String.valueOf(minAge)
			,
			String.valueOf(checkSyntax)
			,
			String.valueOf(allowDictionaryWords)
			,
			String.valueOf(minAlphanumeric)
			,
			String.valueOf(minLength)
			,
			String.valueOf(minLowerCase)
			,
			String.valueOf(minNumbers)
			,
			String.valueOf(minSymbols)
			,
			String.valueOf(minUpperCase)
			,
			regex
			,
			String.valueOf(history)
			,
			String.valueOf(historyCount)
			,
			String.valueOf(expireable)
			,
			String.valueOf(maxAge)
			,
			String.valueOf(warningTime)
			,
			String.valueOf(graceLimit)
			,
			String.valueOf(lockout)
			,
			String.valueOf(maxFailure)
			,
			String.valueOf(lockoutDuration)
			,
			String.valueOf(requireUnlock)
			,
			String.valueOf(resetFailureCount)
			,
			String.valueOf(resetTicketMaxAge)
			
		);

		return formData;
	}

}
