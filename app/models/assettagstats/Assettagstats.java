
package models.assettagstats;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.assettagstats.AssettagstatsFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Assettagstats extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long tagStatsId;

	public long tagId;

	public long classNameId;

	public int assetCount;


	// model finder attribute

	public static Finder<Long,Assettagstats> find = new Finder<Long,Assettagstats>(
		Long.class, Assettagstats.class
	);

	// getters and setters

	public long getTagStatsId() {
		return tagStatsId;
	}

	public void setTagStatsId(long tagStatsId) {
		this.tagStatsId = tagStatsId;
	}
	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public int getAssetCount() {
		return assetCount;
	}

	public void setAssetCount(int assetCount) {
		this.assetCount = assetCount;
	}

	public Assettagstats(){
	}

	// constructor using a formData

	public Assettagstats(AssettagstatsFormData formData) {
		tagStatsId = Long.valueOf(formData.tagStatsId);
		tagId = Long.valueOf(formData.tagId);
		classNameId = Long.valueOf(formData.classNameId);
		assetCount = Integer.valueOf(formData.assetCount);
	}

	public AssettagstatsFormData toFormData() {
		if (tagStatsId < 0) {
			tagStatsId = 0L;
		}

		AssettagstatsFormData formData = new AssettagstatsFormData(
			String.valueOf(tagStatsId)
			,
			String.valueOf(tagId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(assetCount)
			
		);

		return formData;
	}

}
