
package models.blogsstatsuser;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.blogsstatsuser.BlogsstatsuserFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Blogsstatsuser extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long statsUserId;

	public long groupId;

	public long companyId;

	public long userId;

	public int entryCount;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date lastPostDate;

	public int ratingsTotalEntries;

	public double ratingsTotalScore;

	public double ratingsAverageScore;


	// model finder attribute

	public static Finder<Long,Blogsstatsuser> find = new Finder<Long,Blogsstatsuser>(
		Long.class, Blogsstatsuser.class
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
	public int getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(int entryCount) {
		this.entryCount = entryCount;
	}
	public Date getLastPostDate() {
		return lastPostDate;
	}

	public void setLastPostDate(Date lastPostDate) {
		this.lastPostDate = lastPostDate;
	}
	public int getRatingsTotalEntries() {
		return ratingsTotalEntries;
	}

	public void setRatingsTotalEntries(int ratingsTotalEntries) {
		this.ratingsTotalEntries = ratingsTotalEntries;
	}
	public double getRatingsTotalScore() {
		return ratingsTotalScore;
	}

	public void setRatingsTotalScore(double ratingsTotalScore) {
		this.ratingsTotalScore = ratingsTotalScore;
	}
	public double getRatingsAverageScore() {
		return ratingsAverageScore;
	}

	public void setRatingsAverageScore(double ratingsAverageScore) {
		this.ratingsAverageScore = ratingsAverageScore;
	}

	public Blogsstatsuser(){
	}

	// constructor using a formData

	public Blogsstatsuser(BlogsstatsuserFormData formData) {
		statsUserId = Long.valueOf(formData.statsUserId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		entryCount = Integer.valueOf(formData.entryCount);
		lastPostDate = new Date(formData.lastPostDate);
		ratingsTotalEntries = Integer.valueOf(formData.ratingsTotalEntries);
		ratingsTotalScore = Double.valueOf(formData.ratingsTotalScore);
		ratingsAverageScore = Double.valueOf(formData.ratingsAverageScore);
	}

	public BlogsstatsuserFormData toFormData() {
		if (statsUserId < 0) {
			statsUserId = 0L;
		}

		BlogsstatsuserFormData formData = new BlogsstatsuserFormData(
			String.valueOf(statsUserId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(entryCount)
			,
			String.valueOf(lastPostDate)
			,
			String.valueOf(ratingsTotalEntries)
			,
			String.valueOf(ratingsTotalScore)
			,
			String.valueOf(ratingsAverageScore)
			
		);

		return formData;
	}

}
