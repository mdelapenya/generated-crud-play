
package models.country;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.country.CountryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Country extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long countryId;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String a2;

	@Constraints.MaxLength(75)
	public String a3;

	@Constraints.MaxLength(75)
	public String number;

	@Constraints.MaxLength(75)
	public String idd;

	public boolean zipRequired;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Country> find = new Finder<Long,Country>(
		Long.class, Country.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getIdd() {
		return idd;
	}

	public void setIdd(String idd) {
		this.idd = idd;
	}
	public boolean getZipRequired() {
		return zipRequired;
	}

	public void setZipRequired(boolean zipRequired) {
		this.zipRequired = zipRequired;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Country(){
	}

	// constructor using a formData

	public Country(CountryFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		countryId = Long.valueOf(formData.countryId);
		name = formData.name;
		a2 = formData.a2;
		a3 = formData.a3;
		number = formData.number;
		idd = formData.idd;
		zipRequired = Boolean.valueOf(formData.zipRequired);
		active = Boolean.valueOf(formData.active);
	}

	public CountryFormData toFormData() {
		if (countryId < 0) {
			countryId = 0L;
		}

		CountryFormData formData = new CountryFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(countryId)
			,
			name
			,
			a2
			,
			a3
			,
			number
			,
			idd
			,
			String.valueOf(zipRequired)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
