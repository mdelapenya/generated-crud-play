package controllers.portletitem;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Portletitem data form.
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
public class PortletitemFormData {

	public String mvccVersion;
	public String portletItemId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String portletId;
	public String classNameId;

	public PortletitemFormData() {
	}

	public PortletitemFormData(
		String mvccVersion,
				String portletItemId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String portletId,
				String classNameId
		) {

		this.mvccVersion = mvccVersion;
		this.portletItemId = portletItemId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.portletId = portletId;
		this.classNameId = classNameId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (portletItemId == null || portletItemId.length() == 0) {
			errors.add(new ValidationError("portletItemId", "No portletItemId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
