
package models.region;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.region.RegionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Region extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long regionId;

	public long countryId;

	@Constraints.MaxLength(75)
	public String regionCode;

	@Constraints.MaxLength(75)
	public String name;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Region> find = new Finder<Long,Region>(
		Long.class, Region.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getRegionId() {
		return regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Region(){
	}

	// constructor using a formData

	public Region(RegionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		regionId = Long.valueOf(formData.regionId);
		countryId = Long.valueOf(formData.countryId);
		regionCode = formData.regionCode;
		name = formData.name;
		active = Boolean.valueOf(formData.active);
	}

	public RegionFormData toFormData() {
		if (regionId < 0) {
			regionId = 0L;
		}

		RegionFormData formData = new RegionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(regionId)
			,
			String.valueOf(countryId)
			,
			regionCode
			,
			name
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
