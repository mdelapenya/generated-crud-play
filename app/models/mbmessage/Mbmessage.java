
package models.mbmessage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mbmessage.MbmessageFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mbmessage extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long messageId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long classNameId;

	public long classPK;

	public long categoryId;

	public long threadId;

	public long rootMessageId;

	public long parentMessageId;

	@Constraints.MaxLength(75)
	public String subject;

	public String body;

	@Constraints.MaxLength(75)
	public String format;

	public boolean anonymous;

	public double priority;

	public boolean allowPingbacks;

	public boolean answer;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Mbmessage> find = new Finder<Long,Mbmessage>(
		Long.class, Mbmessage.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
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
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
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
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}
	public long getRootMessageId() {
		return rootMessageId;
	}

	public void setRootMessageId(long rootMessageId) {
		this.rootMessageId = rootMessageId;
	}
	public long getParentMessageId() {
		return parentMessageId;
	}

	public void setParentMessageId(long parentMessageId) {
		this.parentMessageId = parentMessageId;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	public boolean getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}
	public boolean getAllowPingbacks() {
		return allowPingbacks;
	}

	public void setAllowPingbacks(boolean allowPingbacks) {
		this.allowPingbacks = allowPingbacks;
	}
	public boolean getAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public long getStatusByUserId() {
		return statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		this.statusByUserId = statusByUserId;
	}
	public String getStatusByUserName() {
		return statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		this.statusByUserName = statusByUserName;
	}
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Mbmessage(){
	}

	// constructor using a formData

	public Mbmessage(MbmessageFormData formData) {
		uuid = formData.uuid;
		messageId = Long.valueOf(formData.messageId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		categoryId = Long.valueOf(formData.categoryId);
		threadId = Long.valueOf(formData.threadId);
		rootMessageId = Long.valueOf(formData.rootMessageId);
		parentMessageId = Long.valueOf(formData.parentMessageId);
		subject = formData.subject;
		body = formData.body;
		format = formData.format;
		anonymous = Boolean.valueOf(formData.anonymous);
		priority = Double.valueOf(formData.priority);
		allowPingbacks = Boolean.valueOf(formData.allowPingbacks);
		answer = Boolean.valueOf(formData.answer);
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public MbmessageFormData toFormData() {
		if (messageId < 0) {
			messageId = 0L;
		}

		MbmessageFormData formData = new MbmessageFormData(
			uuid
			,
			String.valueOf(messageId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(categoryId)
			,
			String.valueOf(threadId)
			,
			String.valueOf(rootMessageId)
			,
			String.valueOf(parentMessageId)
			,
			subject
			,
			body
			,
			format
			,
			String.valueOf(anonymous)
			,
			String.valueOf(priority)
			,
			String.valueOf(allowPingbacks)
			,
			String.valueOf(answer)
			,
			String.valueOf(status)
			,
			String.valueOf(statusByUserId)
			,
			statusByUserName
			,
			String.valueOf(statusDate)
			
		);

		return formData;
	}

}
