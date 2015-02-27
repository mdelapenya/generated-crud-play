
package models.mdrrulegroupinstance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mdrrulegroupinstance.MdrrulegroupinstanceFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mdrrulegroupinstance extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long ruleGroupInstanceId;

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

	public long ruleGroupId;

	public int priority;


	// model finder attribute

	public static Finder<Long,Mdrrulegroupinstance> find = new Finder<Long,Mdrrulegroupinstance>(
		Long.class, Mdrrulegroupinstance.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRuleGroupInstanceId() {
		return ruleGroupInstanceId;
	}

	public void setRuleGroupInstanceId(long ruleGroupInstanceId) {
		this.ruleGroupInstanceId = ruleGroupInstanceId;
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
	public long getRuleGroupId() {
		return ruleGroupId;
	}

	public void setRuleGroupId(long ruleGroupId) {
		this.ruleGroupId = ruleGroupId;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Mdrrulegroupinstance(){
	}

	// constructor using a formData

	public Mdrrulegroupinstance(MdrrulegroupinstanceFormData formData) {
		uuid = formData.uuid;
		ruleGroupInstanceId = Long.valueOf(formData.ruleGroupInstanceId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		ruleGroupId = Long.valueOf(formData.ruleGroupId);
		priority = Integer.valueOf(formData.priority);
	}

	public MdrrulegroupinstanceFormData toFormData() {
		if (ruleGroupInstanceId < 0) {
			ruleGroupInstanceId = 0L;
		}

		MdrrulegroupinstanceFormData formData = new MdrrulegroupinstanceFormData(
			uuid
			,
			String.valueOf(ruleGroupInstanceId)
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
			String.valueOf(ruleGroupId)
			,
			String.valueOf(priority)
			
		);

		return formData;
	}

}
