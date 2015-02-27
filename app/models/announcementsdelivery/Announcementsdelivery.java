
package models.announcementsdelivery;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.announcementsdelivery.AnnouncementsdeliveryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Announcementsdelivery extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long deliveryId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String customtype;

	public boolean email;

	public boolean sms;

	public boolean website;


	// model finder attribute

	public static Finder<Long,Announcementsdelivery> find = new Finder<Long,Announcementsdelivery>(
		Long.class, Announcementsdelivery.class
	);

	// getters and setters

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public boolean getEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}
	public boolean getSms() {
		return sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}
	public boolean getWebsite() {
		return website;
	}

	public void setWebsite(boolean website) {
		this.website = website;
	}

	public Announcementsdelivery(){
	}

	// constructor using a formData

	public Announcementsdelivery(AnnouncementsdeliveryFormData formData) {
		deliveryId = Long.valueOf(formData.deliveryId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		customtype = formData.customtype;
		email = Boolean.valueOf(formData.email);
		sms = Boolean.valueOf(formData.sms);
		website = Boolean.valueOf(formData.website);
	}

	public AnnouncementsdeliveryFormData toFormData() {
		if (deliveryId < 0) {
			deliveryId = 0L;
		}

		AnnouncementsdeliveryFormData formData = new AnnouncementsdeliveryFormData(
			String.valueOf(deliveryId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			customtype
			,
			String.valueOf(email)
			,
			String.valueOf(sms)
			,
			String.valueOf(website)
			
		);

		return formData;
	}

}
