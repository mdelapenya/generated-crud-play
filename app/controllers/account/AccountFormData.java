package controllers.account;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Account data form.
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
public class AccountFormData {

	public String mvccVersion;
	public String accountId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentAccountId;
	public String name;
	public String legalName;
	public String legalId;
	public String legalType;
	public String sicCode;
	public String tickerSymbol;
	public String industry;
	public String customtype;
	public String size;

	public AccountFormData() {
	}

	public AccountFormData(
		String mvccVersion,
				String accountId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentAccountId,
				String name,
				String legalName,
				String legalId,
				String legalType,
				String sicCode,
				String tickerSymbol,
				String industry,
				String customtype,
				String size
		) {

		this.mvccVersion = mvccVersion;
		this.accountId = accountId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentAccountId = parentAccountId;
		this.name = name;
		this.legalName = legalName;
		this.legalId = legalId;
		this.legalType = legalType;
		this.sicCode = sicCode;
		this.tickerSymbol = tickerSymbol;
		this.industry = industry;
		this.customtype = customtype;
		this.size = size;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (accountId == null || accountId.length() == 0) {
			errors.add(new ValidationError("accountId", "No accountId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
