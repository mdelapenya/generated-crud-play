package controllers.virtualhost;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Virtualhost data form.
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
public class VirtualhostFormData {

	public String mvccVersion;
	public String virtualHostId;
	public String companyId;
	public String layoutSetId;
	public String hostname;

	public VirtualhostFormData() {
	}

	public VirtualhostFormData(
		String mvccVersion,
				String virtualHostId,
				String companyId,
				String layoutSetId,
				String hostname
		) {

		this.mvccVersion = mvccVersion;
		this.virtualHostId = virtualHostId;
		this.companyId = companyId;
		this.layoutSetId = layoutSetId;
		this.hostname = hostname;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (virtualHostId == null || virtualHostId.length() == 0) {
			errors.add(new ValidationError("virtualHostId", "No virtualHostId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
