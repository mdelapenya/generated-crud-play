package controllers.mbmailinglist;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbmailinglist data form.
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
public class MbmailinglistFormData {

	public String uuid;
	public String mailingListId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String categoryId;
	public String emailAddress;
	public String inProtocol;
	public String inServerName;
	public String inServerPort;
	public String inUseSSL;
	public String inUserName;
	public String inPassword;
	public String inReadInterval;
	public String outEmailAddress;
	public String outCustom;
	public String outServerName;
	public String outServerPort;
	public String outUseSSL;
	public String outUserName;
	public String outPassword;
	public String allowAnonymous;
	public String active;

	public MbmailinglistFormData() {
	}

	public MbmailinglistFormData(
		String uuid,
				String mailingListId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String categoryId,
				String emailAddress,
				String inProtocol,
				String inServerName,
				String inServerPort,
				String inUseSSL,
				String inUserName,
				String inPassword,
				String inReadInterval,
				String outEmailAddress,
				String outCustom,
				String outServerName,
				String outServerPort,
				String outUseSSL,
				String outUserName,
				String outPassword,
				String allowAnonymous,
				String active
		) {

		this.uuid = uuid;
		this.mailingListId = mailingListId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.categoryId = categoryId;
		this.emailAddress = emailAddress;
		this.inProtocol = inProtocol;
		this.inServerName = inServerName;
		this.inServerPort = inServerPort;
		this.inUseSSL = inUseSSL;
		this.inUserName = inUserName;
		this.inPassword = inPassword;
		this.inReadInterval = inReadInterval;
		this.outEmailAddress = outEmailAddress;
		this.outCustom = outCustom;
		this.outServerName = outServerName;
		this.outServerPort = outServerPort;
		this.outUseSSL = outUseSSL;
		this.outUserName = outUserName;
		this.outPassword = outPassword;
		this.allowAnonymous = allowAnonymous;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (mailingListId == null || mailingListId.length() == 0) {
			errors.add(new ValidationError("mailingListId", "No mailingListId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
