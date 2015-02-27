
package models.orglabor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.orglabor.OrglaborFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Orglabor extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long orgLaborId;

	public long organizationId;

	public long typeId;

	public int sunOpen;

	public int sunClose;

	public int monOpen;

	public int monClose;

	public int tueOpen;

	public int tueClose;

	public int wedOpen;

	public int wedClose;

	public int thuOpen;

	public int thuClose;

	public int friOpen;

	public int friClose;

	public int satOpen;

	public int satClose;


	// model finder attribute

	public static Finder<Long,Orglabor> find = new Finder<Long,Orglabor>(
		Long.class, Orglabor.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getOrgLaborId() {
		return orgLaborId;
	}

	public void setOrgLaborId(long orgLaborId) {
		this.orgLaborId = orgLaborId;
	}
	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public int getSunOpen() {
		return sunOpen;
	}

	public void setSunOpen(int sunOpen) {
		this.sunOpen = sunOpen;
	}
	public int getSunClose() {
		return sunClose;
	}

	public void setSunClose(int sunClose) {
		this.sunClose = sunClose;
	}
	public int getMonOpen() {
		return monOpen;
	}

	public void setMonOpen(int monOpen) {
		this.monOpen = monOpen;
	}
	public int getMonClose() {
		return monClose;
	}

	public void setMonClose(int monClose) {
		this.monClose = monClose;
	}
	public int getTueOpen() {
		return tueOpen;
	}

	public void setTueOpen(int tueOpen) {
		this.tueOpen = tueOpen;
	}
	public int getTueClose() {
		return tueClose;
	}

	public void setTueClose(int tueClose) {
		this.tueClose = tueClose;
	}
	public int getWedOpen() {
		return wedOpen;
	}

	public void setWedOpen(int wedOpen) {
		this.wedOpen = wedOpen;
	}
	public int getWedClose() {
		return wedClose;
	}

	public void setWedClose(int wedClose) {
		this.wedClose = wedClose;
	}
	public int getThuOpen() {
		return thuOpen;
	}

	public void setThuOpen(int thuOpen) {
		this.thuOpen = thuOpen;
	}
	public int getThuClose() {
		return thuClose;
	}

	public void setThuClose(int thuClose) {
		this.thuClose = thuClose;
	}
	public int getFriOpen() {
		return friOpen;
	}

	public void setFriOpen(int friOpen) {
		this.friOpen = friOpen;
	}
	public int getFriClose() {
		return friClose;
	}

	public void setFriClose(int friClose) {
		this.friClose = friClose;
	}
	public int getSatOpen() {
		return satOpen;
	}

	public void setSatOpen(int satOpen) {
		this.satOpen = satOpen;
	}
	public int getSatClose() {
		return satClose;
	}

	public void setSatClose(int satClose) {
		this.satClose = satClose;
	}

	public Orglabor(){
	}

	// constructor using a formData

	public Orglabor(OrglaborFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		orgLaborId = Long.valueOf(formData.orgLaborId);
		organizationId = Long.valueOf(formData.organizationId);
		typeId = Long.valueOf(formData.typeId);
		sunOpen = Integer.valueOf(formData.sunOpen);
		sunClose = Integer.valueOf(formData.sunClose);
		monOpen = Integer.valueOf(formData.monOpen);
		monClose = Integer.valueOf(formData.monClose);
		tueOpen = Integer.valueOf(formData.tueOpen);
		tueClose = Integer.valueOf(formData.tueClose);
		wedOpen = Integer.valueOf(formData.wedOpen);
		wedClose = Integer.valueOf(formData.wedClose);
		thuOpen = Integer.valueOf(formData.thuOpen);
		thuClose = Integer.valueOf(formData.thuClose);
		friOpen = Integer.valueOf(formData.friOpen);
		friClose = Integer.valueOf(formData.friClose);
		satOpen = Integer.valueOf(formData.satOpen);
		satClose = Integer.valueOf(formData.satClose);
	}

	public OrglaborFormData toFormData() {
		if (orgLaborId < 0) {
			orgLaborId = 0L;
		}

		OrglaborFormData formData = new OrglaborFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(orgLaborId)
			,
			String.valueOf(organizationId)
			,
			String.valueOf(typeId)
			,
			String.valueOf(sunOpen)
			,
			String.valueOf(sunClose)
			,
			String.valueOf(monOpen)
			,
			String.valueOf(monClose)
			,
			String.valueOf(tueOpen)
			,
			String.valueOf(tueClose)
			,
			String.valueOf(wedOpen)
			,
			String.valueOf(wedClose)
			,
			String.valueOf(thuOpen)
			,
			String.valueOf(thuClose)
			,
			String.valueOf(friOpen)
			,
			String.valueOf(friClose)
			,
			String.valueOf(satOpen)
			,
			String.valueOf(satClose)
			
		);

		return formData;
	}

}
