
package models.mbstatsuser;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.mbstatsuser.MbstatsuserFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Mbstatsuser extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long statsUserId;

	public long groupId;

	public long userId;

	public int messageCount;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lastPostDate;


	// model finder attribute

	public static Finder<Long,Mbstatsuser> find = new Finder<Long,Mbstatsuser>(
		Long.class, Mbstatsuser.class
	);

	// getters and setters

	public long getStatsUserId() {
		return statsUserId;
	}

	public void setStatsUserId(long statsUserId) {
		this.statsUserId = statsUserId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	public Date getLastPostDate() {
		return lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		this.lastPostDate = lastPostDate;
	}

	public Mbstatsuser(){
	}

	// constructor using a formData

	public Mbstatsuser(MbstatsuserFormData formData) {
		statsUserId = Long.valueOf(formData.statsUserId);
		groupId = Long.valueOf(formData.groupId);
		userId = Long.valueOf(formData.userId);
		messageCount = Integer.valueOf(formData.messageCount);
		lastPostDate = new Date(formData.lastPostDate);
	}

	public MbstatsuserFormData toFormData() {
		if (statsUserId < 0) {
			statsUserId = 0L;
		}

		MbstatsuserFormData formData = new MbstatsuserFormData(
			String.valueOf(statsUserId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(userId)
			,
			String.valueOf(messageCount)
			,
			String.valueOf(lastPostDate)
			
		);

		return formData;
	}

}
