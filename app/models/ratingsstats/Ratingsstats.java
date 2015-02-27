
package models.ratingsstats;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ratingsstats.RatingsstatsFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ratingsstats extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long statsId;

	public long classNameId;

	public long classPK;

	public int totalEntries;

	public double totalScore;

	public double averageScore;


	// model finder attribute

	public static Finder<Long,Ratingsstats> find = new Finder<Long,Ratingsstats>(
		Long.class, Ratingsstats.class
	);

	// getters and setters

	public long getStatsId() {
		return statsId;
	}

	public void setStatsId(long statsId) {
		this.statsId = statsId;
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
	public int getTotalEntries() {
		return totalEntries;
	}

	public void setTotalEntries(int totalEntries) {
		this.totalEntries = totalEntries;
	}
	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public Ratingsstats(){
	}

	// constructor using a formData

	public Ratingsstats(RatingsstatsFormData formData) {
		statsId = Long.valueOf(formData.statsId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		totalEntries = Integer.valueOf(formData.totalEntries);
		totalScore = Double.valueOf(formData.totalScore);
		averageScore = Double.valueOf(formData.averageScore);
	}

	public RatingsstatsFormData toFormData() {
		if (statsId < 0) {
			statsId = 0L;
		}

		RatingsstatsFormData formData = new RatingsstatsFormData(
			String.valueOf(statsId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			String.valueOf(totalEntries)
			,
			String.valueOf(totalScore)
			,
			String.valueOf(averageScore)
			
		);

		return formData;
	}

}
