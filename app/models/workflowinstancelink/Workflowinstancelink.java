
package models.workflowinstancelink;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.workflowinstancelink.WorkflowinstancelinkFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Workflowinstancelink extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long workflowInstanceLinkId;

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

	public long workflowInstanceId;


	// model finder attribute

	public static Finder<Long,Workflowinstancelink> find = new Finder<Long,Workflowinstancelink>(
		Long.class, Workflowinstancelink.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getWorkflowInstanceLinkId() {
		return workflowInstanceLinkId;
	}

	public void setWorkflowInstanceLinkId(long workflowInstanceLinkId) {
		this.workflowInstanceLinkId = workflowInstanceLinkId;
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
	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public Workflowinstancelink(){
	}

	// constructor using a formData

	public Workflowinstancelink(WorkflowinstancelinkFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		workflowInstanceLinkId = Long.valueOf(formData.workflowInstanceLinkId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		workflowInstanceId = Long.valueOf(formData.workflowInstanceId);
	}

	public WorkflowinstancelinkFormData toFormData() {
		if (workflowInstanceLinkId < 0) {
			workflowInstanceLinkId = 0L;
		}

		WorkflowinstancelinkFormData formData = new WorkflowinstancelinkFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(workflowInstanceLinkId)
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
			String.valueOf(workflowInstanceId)
			
		);

		return formData;
	}

}
