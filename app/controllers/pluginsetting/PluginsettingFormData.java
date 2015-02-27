package controllers.pluginsetting;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Pluginsetting data form.
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
public class PluginsettingFormData {

	public String mvccVersion;
	public String pluginSettingId;
	public String companyId;
	public String pluginId;
	public String pluginType;
	public String roles;
	public String active;

	public PluginsettingFormData() {
	}

	public PluginsettingFormData(
		String mvccVersion,
				String pluginSettingId,
				String companyId,
				String pluginId,
				String pluginType,
				String roles,
				String active
		) {

		this.mvccVersion = mvccVersion;
		this.pluginSettingId = pluginSettingId;
		this.companyId = companyId;
		this.pluginId = pluginId;
		this.pluginType = pluginType;
		this.roles = roles;
		this.active = active;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (pluginSettingId == null || pluginSettingId.length() == 0) {
			errors.add(new ValidationError("pluginSettingId", "No pluginSettingId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
