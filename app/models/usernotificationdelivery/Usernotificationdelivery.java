
package models.usernotificationdelivery;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.usernotificationdelivery.UsernotificationdeliveryFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Usernotificationdelivery extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userNotificationDeliveryId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(200)
	public String portletId;

	public long classNameId;

	public int notificationType;

	public int deliveryType;

	public boolean deliver;


	// model finder attribute

	public static Finder<Long,Usernotificationdelivery> find = new Finder<Long,Usernotificationdelivery>(
		Long.class, Usernotificationdelivery.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getUserNotificationDeliveryId() {
		return userNotificationDeliveryId;
	}

	public void setUserNotificationDeliveryId(long userNotificationDeliveryId) {
		this.userNotificationDeliveryId = userNotificationDeliveryId;
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
	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}
	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}
	public boolean getDeliver() {
		return deliver;
	}

	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	public Usernotificationdelivery(){
	}

	// constructor using a formData

	public Usernotificationdelivery(UsernotificationdeliveryFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		userNotificationDeliveryId = Long.valueOf(formData.userNotificationDeliveryId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		portletId = formData.portletId;
		classNameId = Long.valueOf(formData.classNameId);
		notificationType = Integer.valueOf(formData.notificationType);
		deliveryType = Integer.valueOf(formData.deliveryType);
		deliver = Boolean.valueOf(formData.deliver);
	}

	public UsernotificationdeliveryFormData toFormData() {
		if (userNotificationDeliveryId < 0) {
			userNotificationDeliveryId = 0L;
		}

		UsernotificationdeliveryFormData formData = new UsernotificationdeliveryFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(userNotificationDeliveryId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			portletId
			,
			String.valueOf(classNameId)
			,
			String.valueOf(notificationType)
			,
			String.valueOf(deliveryType)
			,
			String.valueOf(deliver)
			
		);

		return formData;
	}

}
