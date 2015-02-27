
package models.membershiprequest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.membershiprequest.MembershiprequestFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Membershiprequest extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long membershipRequestId;

	public long groupId;

	public long companyId;

	public long userId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public String comments;

	public String replyComments;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date replyDate;

	public long replierUserId;

	public long statusId;


	// model finder attribute

	public static Finder<Long,Membershiprequest> find = new Finder<Long,Membershiprequest>(
		Long.class, Membershiprequest.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getMembershipRequestId() {
		return membershipRequestId;
	}

	public void setMembershipRequestId(long membershipRequestId) {
		this.membershipRequestId = membershipRequestId;
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
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReplyComments() {
		return replyComments;
	}

	public void setReplyComments(String replyComments) {
		this.replyComments = replyComments;
	}
	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public long getReplierUserId() {
		return replierUserId;
	}

	public void setReplierUserId(long replierUserId) {
		this.replierUserId = replierUserId;
	}
	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Membershiprequest(){
	}

	// constructor using a formData

	public Membershiprequest(MembershiprequestFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		membershipRequestId = Long.valueOf(formData.membershipRequestId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = new Date(formData.createDate);
		comments = formData.comments;
		replyComments = formData.replyComments;
		replyDate = new Date(formData.replyDate);
		replierUserId = Long.valueOf(formData.replierUserId);
		statusId = Long.valueOf(formData.statusId);
	}

	public MembershiprequestFormData toFormData() {
		if (membershipRequestId < 0) {
			membershipRequestId = 0L;
		}

		MembershiprequestFormData formData = new MembershiprequestFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(membershipRequestId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			comments
			,
			replyComments
			,
			String.valueOf(replyDate)
			,
			String.valueOf(replierUserId)
			,
			String.valueOf(statusId)
			
		);

		return formData;
	}

}
