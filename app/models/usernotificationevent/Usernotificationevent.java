
package models.usernotificationevent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.usernotificationevent.UsernotificationeventFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Usernotificationevent extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long userNotificationEventId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String customtype;

	public long timestamp;

	public int deliveryType;

	public long deliverBy;

	public boolean delivered;

	public String payload;

	public boolean actionRequired;

	public boolean archived;


	// model finder attribute

	public static Finder<Long,Usernotificationevent> find = new Finder<Long,Usernotificationevent>(
		Long.class, Usernotificationevent.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getUserNotificationEventId() {
		return userNotificationEventId;
	}

	public void setUserNotificationEventId(long userNotificationEventId) {
		this.userNotificationEventId = userNotificationEventId;
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
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}
	public long getDeliverBy() {
		return deliverBy;
	}

	public void setDeliverBy(long deliverBy) {
		this.deliverBy = deliverBy;
	}
	public boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	public boolean getActionRequired() {
		return actionRequired;
	}

	public void setActionRequired(boolean actionRequired) {
		this.actionRequired = actionRequired;
	}
	public boolean getArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public Usernotificationevent(){
	}

	// constructor using a formData

	public Usernotificationevent(UsernotificationeventFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		userNotificationEventId = Long.valueOf(formData.userNotificationEventId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		customtype = formData.customtype;
		timestamp = Long.valueOf(formData.timestamp);
		deliveryType = Integer.valueOf(formData.deliveryType);
		deliverBy = Long.valueOf(formData.deliverBy);
		delivered = Boolean.valueOf(formData.delivered);
		payload = formData.payload;
		actionRequired = Boolean.valueOf(formData.actionRequired);
		archived = Boolean.valueOf(formData.archived);
	}

	public UsernotificationeventFormData toFormData() {
		if (userNotificationEventId < 0) {
			userNotificationEventId = 0L;
		}

		UsernotificationeventFormData formData = new UsernotificationeventFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(userNotificationEventId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			customtype
			,
			String.valueOf(timestamp)
			,
			String.valueOf(deliveryType)
			,
			String.valueOf(deliverBy)
			,
			String.valueOf(delivered)
			,
			payload
			,
			String.valueOf(actionRequired)
			,
			String.valueOf(archived)
			
		);

		return formData;
	}

}
