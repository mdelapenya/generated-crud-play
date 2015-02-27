
package models.socialrequest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialrequest.SocialrequestFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialrequest extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long requestId;

	public long groupId;

	public long companyId;

	public long userId;

	public long createDate;

	public long modifiedDate;

	public long classNameId;

	public long classPK;

	public int customtype;

	public String extraData;

	public long receiverUserId;

	public int status;


	// model finder attribute

	public static Finder<Long,Socialrequest> find = new Finder<Long,Socialrequest>(
		Long.class, Socialrequest.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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
	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
	public long getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(long receiverUserId) {
		this.receiverUserId = receiverUserId;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Socialrequest(){
	}

	// constructor using a formData

	public Socialrequest(SocialrequestFormData formData) {
		uuid = formData.uuid;
		requestId = Long.valueOf(formData.requestId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = Long.valueOf(formData.createDate);
		modifiedDate = Long.valueOf(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		customtype = Integer.valueOf(formData.customtype);
		extraData = formData.extraData;
		receiverUserId = Long.valueOf(formData.receiverUserId);
		status = Integer.valueOf(formData.status);
	}

	public SocialrequestFormData toFormData() {
		if (requestId < 0) {
			requestId = 0L;
		}

		SocialrequestFormData formData = new SocialrequestFormData(
			uuid
			,
			String.valueOf(requestId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(customtype)
			,
			extraData
			,
			String.valueOf(receiverUserId)
			,
			String.valueOf(status)
			
		);

		return formData;
	}

}
