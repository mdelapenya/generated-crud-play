
package models.workflowdefinitionlink;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.workflowdefinitionlink.WorkflowdefinitionlinkFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Workflowdefinitionlink extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long workflowDefinitionLinkId;

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

	public long typePK;

	@Constraints.MaxLength(75)
	public String workflowDefinitionName;

	public int workflowDefinitionVersion;


	// model finder attribute

	public static Finder<Long,Workflowdefinitionlink> find = new Finder<Long,Workflowdefinitionlink>(
		Long.class, Workflowdefinitionlink.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getWorkflowDefinitionLinkId() {
		return workflowDefinitionLinkId;
	}

	public void setWorkflowDefinitionLinkId(long workflowDefinitionLinkId) {
		this.workflowDefinitionLinkId = workflowDefinitionLinkId;
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
	public long getTypePK() {
		return typePK;
	}

	public void setTypePK(long typePK) {
		this.typePK = typePK;
	}
	public String getWorkflowDefinitionName() {
		return workflowDefinitionName;
	}

	public void setWorkflowDefinitionName(String workflowDefinitionName) {
		this.workflowDefinitionName = workflowDefinitionName;
	}
	public int getWorkflowDefinitionVersion() {
		return workflowDefinitionVersion;
	}

	public void setWorkflowDefinitionVersion(int workflowDefinitionVersion) {
		this.workflowDefinitionVersion = workflowDefinitionVersion;
	}

	public Workflowdefinitionlink(){
	}

	// constructor using a formData

	public Workflowdefinitionlink(WorkflowdefinitionlinkFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		workflowDefinitionLinkId = Long.valueOf(formData.workflowDefinitionLinkId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		typePK = Long.valueOf(formData.typePK);
		workflowDefinitionName = formData.workflowDefinitionName;
		workflowDefinitionVersion = Integer.valueOf(formData.workflowDefinitionVersion);
	}

	public WorkflowdefinitionlinkFormData toFormData() {
		if (workflowDefinitionLinkId < 0) {
			workflowDefinitionLinkId = 0L;
		}

		WorkflowdefinitionlinkFormData formData = new WorkflowdefinitionlinkFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(workflowDefinitionLinkId)
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
			String.valueOf(typePK)
			,
			workflowDefinitionName
			,
			String.valueOf(workflowDefinitionVersion)
			
		);

		return formData;
	}

}
