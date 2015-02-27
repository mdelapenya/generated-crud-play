package controllers.layoutfriendlyurl;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutfriendlyurl data form.
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
public class LayoutfriendlyurlFormData {

	public String mvccVersion;
	public String uuid;
	public String layoutFriendlyURLId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String plid;
	public String privateLayout;
	public String friendlyURL;
	public String languageId;

	public LayoutfriendlyurlFormData() {
	}

	public LayoutfriendlyurlFormData(
		String mvccVersion,
				String uuid,
				String layoutFriendlyURLId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String plid,
				String privateLayout,
				String friendlyURL,
				String languageId
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.layoutFriendlyURLId = layoutFriendlyURLId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.plid = plid;
		this.privateLayout = privateLayout;
		this.friendlyURL = friendlyURL;
		this.languageId = languageId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutFriendlyURLId == null || layoutFriendlyURLId.length() == 0) {
			errors.add(new ValidationError("layoutFriendlyURLId", "No layoutFriendlyURLId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
