
package models.servicecomponent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.servicecomponent.ServicecomponentFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Servicecomponent extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long serviceComponentId;

	@Constraints.MaxLength(75)
	public String buildNamespace;

	public long buildNumber;

	public long buildDate;

	public String data;


	// model finder attribute

	public static Finder<Long,Servicecomponent> find = new Finder<Long,Servicecomponent>(
		Long.class, Servicecomponent.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getServiceComponentId() {
		return serviceComponentId;
	}

	public void setServiceComponentId(long serviceComponentId) {
		this.serviceComponentId = serviceComponentId;
	}
	public String getBuildNamespace() {
		return buildNamespace;
	}

	public void setBuildNamespace(String buildNamespace) {
		this.buildNamespace = buildNamespace;
	}
	public long getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(long buildNumber) {
		this.buildNumber = buildNumber;
	}
	public long getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(long buildDate) {
		this.buildDate = buildDate;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Servicecomponent(){
	}

	// constructor using a formData

	public Servicecomponent(ServicecomponentFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		serviceComponentId = Long.valueOf(formData.serviceComponentId);
		buildNamespace = formData.buildNamespace;
		buildNumber = Long.valueOf(formData.buildNumber);
		buildDate = Long.valueOf(formData.buildDate);
		data = formData.data;
	}

	public ServicecomponentFormData toFormData() {
		if (serviceComponentId < 0) {
			serviceComponentId = 0L;
		}

		ServicecomponentFormData formData = new ServicecomponentFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(serviceComponentId)
			,
			buildNamespace
			,
			String.valueOf(buildNumber)
			,
			String.valueOf(buildDate)
			,
			data
			
		);

		return formData;
	}

}
