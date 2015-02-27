
package models.backgroundtask;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.backgroundtask.BackgroundtaskFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Backgroundtask extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long backgroundTaskId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(255)
	public String name;

	@Constraints.MaxLength(255)
	public String servletContextNames;

	@Constraints.MaxLength(200)
	public String taskExecutorClassName;

	public String taskContextMap;

	public boolean completed;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date completionDate;

	public int status;

	public String statusMessage;


	// model finder attribute

	public static Finder<Long,Backgroundtask> find = new Finder<Long,Backgroundtask>(
		Long.class, Backgroundtask.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getBackgroundTaskId() {
		return backgroundTaskId;
	}

	public void setBackgroundTaskId(long backgroundTaskId) {
		this.backgroundTaskId = backgroundTaskId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getServletContextNames() {
		return servletContextNames;
	}

	public void setServletContextNames(String servletContextNames) {
		this.servletContextNames = servletContextNames;
	}
	public String getTaskExecutorClassName() {
		return taskExecutorClassName;
	}

	public void setTaskExecutorClassName(String taskExecutorClassName) {
		this.taskExecutorClassName = taskExecutorClassName;
	}
	public String getTaskContextMap() {
		return taskContextMap;
	}

	public void setTaskContextMap(String taskContextMap) {
		this.taskContextMap = taskContextMap;
	}
	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Backgroundtask(){
	}

	// constructor using a formData

	public Backgroundtask(BackgroundtaskFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		backgroundTaskId = Long.valueOf(formData.backgroundTaskId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		name = formData.name;
		servletContextNames = formData.servletContextNames;
		taskExecutorClassName = formData.taskExecutorClassName;
		taskContextMap = formData.taskContextMap;
		completed = Boolean.valueOf(formData.completed);
		completionDate = new Date(formData.completionDate);
		status = Integer.valueOf(formData.status);
		statusMessage = formData.statusMessage;
	}

	public BackgroundtaskFormData toFormData() {
		if (backgroundTaskId < 0) {
			backgroundTaskId = 0L;
		}

		BackgroundtaskFormData formData = new BackgroundtaskFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(backgroundTaskId)
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
			name
			,
			servletContextNames
			,
			taskExecutorClassName
			,
			taskContextMap
			,
			String.valueOf(completed)
			,
			String.valueOf(completionDate)
			,
			String.valueOf(status)
			,
			statusMessage
			
		);

		return formData;
	}

}
