
package models.mdrrulegroup;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mdrrulegroup.MdrrulegroupFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mdrrulegroup extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long ruleGroupId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public String name;

	public String description;


	// model finder attribute

	public static Finder<Long,Mdrrulegroup> find = new Finder<Long,Mdrrulegroup>(
		Long.class, Mdrrulegroup.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRuleGroupId() {
		return ruleGroupId;
	}

	public void setRuleGroupId(long ruleGroupId) {
		this.ruleGroupId = ruleGroupId;
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Mdrrulegroup(){
	}

	// constructor using a formData

	public Mdrrulegroup(MdrrulegroupFormData formData) {
		uuid = formData.uuid;
		ruleGroupId = Long.valueOf(formData.ruleGroupId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		name = formData.name;
		description = formData.description;
	}

	public MdrrulegroupFormData toFormData() {
		if (ruleGroupId < 0) {
			ruleGroupId = 0L;
		}

		MdrrulegroupFormData formData = new MdrrulegroupFormData(
			uuid
			,
			String.valueOf(ruleGroupId)
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
			description
			
		);

		return formData;
	}

}
