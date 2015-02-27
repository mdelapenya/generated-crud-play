
package models.pluginsetting;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.pluginsetting.PluginsettingFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Pluginsetting extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long pluginSettingId;

	public long companyId;

	@Constraints.MaxLength(75)
	public String pluginId;

	@Constraints.MaxLength(75)
	public String pluginType;

	public String roles;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Pluginsetting> find = new Finder<Long,Pluginsetting>(
		Long.class, Pluginsetting.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getPluginSettingId() {
		return pluginSettingId;
	}

	public void setPluginSettingId(long pluginSettingId) {
		this.pluginSettingId = pluginSettingId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getPluginId() {
		return pluginId;
	}

	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}
	public String getPluginType() {
		return pluginType;
	}

	public void setPluginType(String pluginType) {
		this.pluginType = pluginType;
	}
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Pluginsetting(){
	}

	// constructor using a formData

	public Pluginsetting(PluginsettingFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		pluginSettingId = Long.valueOf(formData.pluginSettingId);
		companyId = Long.valueOf(formData.companyId);
		pluginId = formData.pluginId;
		pluginType = formData.pluginType;
		roles = formData.roles;
		active = Boolean.valueOf(formData.active);
	}

	public PluginsettingFormData toFormData() {
		if (pluginSettingId < 0) {
			pluginSettingId = 0L;
		}

		PluginsettingFormData formData = new PluginsettingFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(pluginSettingId)
			,
			String.valueOf(companyId)
			,
			pluginId
			,
			pluginType
			,
			roles
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
