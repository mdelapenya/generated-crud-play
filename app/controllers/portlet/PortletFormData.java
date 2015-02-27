package controllers.portlet;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Portlet data form.
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
public class PortletFormData {

	public String mvccVersion;
	public String id;
	public String companyId;
	public String portletId;
	public String roles;
	public String active;

	public PortletFormData() {
	}

	public PortletFormData(
		String mvccVersion,
				String id,
				String companyId,
				String portletId,
				String roles,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.id = id;
		this.companyId = companyId;
		this.portletId = portletId;
		this.roles = roles;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (id == null || id.length() == 0) {
			errors.add(new ValidationError("id", "No id was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
