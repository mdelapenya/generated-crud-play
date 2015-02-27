
package models.sclicense;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.sclicense.SclicenseFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Sclicense extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long licenseId;

	@Constraints.MaxLength(75)
	public String name;

	public String url;

	public boolean openSource;

	public boolean active;

	public boolean recommended;


	// model finder attribute

	public static Finder<Long,Sclicense> find = new Finder<Long,Sclicense>(
		Long.class, Sclicense.class
	);

	// getters and setters

	public long getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(long licenseId) {
		this.licenseId = licenseId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public boolean getOpenSource() {
		return openSource;
	}

	public void setOpenSource(boolean openSource) {
		this.openSource = openSource;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public Sclicense(){
	}

	// constructor using a formData

	public Sclicense(SclicenseFormData formData) {
		licenseId = Long.valueOf(formData.licenseId);
		name = formData.name;
		url = formData.url;
		openSource = Boolean.valueOf(formData.openSource);
		active = Boolean.valueOf(formData.active);
		recommended = Boolean.valueOf(formData.recommended);
	}

	public SclicenseFormData toFormData() {
		if (licenseId < 0) {
			licenseId = 0L;
		}

		SclicenseFormData formData = new SclicenseFormData(
			String.valueOf(licenseId)
			,
			name
			,
			url
			,
			String.valueOf(openSource)
			,
			String.valueOf(active)
			,
			String.valueOf(recommended)
			
		);

		return formData;
	}

}
