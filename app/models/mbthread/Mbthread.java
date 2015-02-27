
package models.mbthread;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mbthread.MbthreadFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mbthread extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long threadId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long categoryId;

	public long rootMessageId;

	public long rootMessageUserId;

	public int messageCount;

	public int viewCount;

	public long lastPostByUserId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lastPostDate;

	public double priority;

	public boolean question;

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Mbthread> find = new Finder<Long,Mbthread>(
		Long.class, Mbthread.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
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
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getRootMessageId() {
		return rootMessageId;
	}

	public void setRootMessageId(long rootMessageId) {
		this.rootMessageId = rootMessageId;
	}
	public long getRootMessageUserId() {
		return rootMessageUserId;
	}

	public void setRootMessageUserId(long rootMessageUserId) {
		this.rootMessageUserId = rootMessageUserId;
	}
	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public long getLastPostByUserId() {
		return lastPostByUserId;
	}

	public void setLastPostByUserId(long lastPostByUserId) {
		this.lastPostByUserId = lastPostByUserId;
	}
	public Date getLastPostDate() {
		return lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		this.lastPostDate = lastPostDate;
	}
	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}
	public boolean getQuestion() {
		return question;
	}

	public void setQuestion(boolean question) {
		this.question = question;
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

	public Mbthread(){
	}

	// constructor using a formData

	public Mbthread(MbthreadFormData formData) {
		uuid = formData.uuid;
		threadId = Long.valueOf(formData.threadId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		categoryId = Long.valueOf(formData.categoryId);
		rootMessageId = Long.valueOf(formData.rootMessageId);
		rootMessageUserId = Long.valueOf(formData.rootMessageUserId);
		messageCount = Integer.valueOf(formData.messageCount);
		viewCount = Integer.valueOf(formData.viewCount);
		lastPostByUserId = Long.valueOf(formData.lastPostByUserId);
		lastPostDate = new Date(formData.lastPostDate);
		priority = Double.valueOf(formData.priority);
		question = Boolean.valueOf(formData.question);
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public MbthreadFormData toFormData() {
		if (threadId < 0) {
			threadId = 0L;
		}

		MbthreadFormData formData = new MbthreadFormData(
			uuid
			,
			String.valueOf(threadId)
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
			String.valueOf(categoryId)
			,
			String.valueOf(rootMessageId)
			,
			String.valueOf(rootMessageUserId)
			,
			String.valueOf(messageCount)
			,
			String.valueOf(viewCount)
			,
			String.valueOf(lastPostByUserId)
			,
			String.valueOf(lastPostDate)
			,
			String.valueOf(priority)
			,
			String.valueOf(question)
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
