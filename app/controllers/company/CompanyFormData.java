package controllers.company;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Company data form.
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
public class CompanyFormData {

	public String mvccVersion;
	public String companyId;
	public String accountId;
	public String webId;
	public String key;
	public String mx;
	public String homeURL;
	public String logoId;
	public String system;
	public String maxUsers;
	public String active;

	public CompanyFormData() {
	}

	public CompanyFormData(
		String mvccVersion,
				String companyId,
				String accountId,
				String webId,
				String key,
				String mx,
				String homeURL,
				String logoId,
				String system,
				String maxUsers,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.companyId = companyId;
		this.accountId = accountId;
		this.webId = webId;
		this.key = key;
		this.mx = mx;
		this.homeURL = homeURL;
		this.logoId = logoId;
		this.system = system;
		this.maxUsers = maxUsers;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (companyId == null || companyId.length() == 0) {
			errors.add(new ValidationError("companyId", "No companyId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
