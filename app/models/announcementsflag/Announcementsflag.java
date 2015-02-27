
package models.announcementsflag;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.announcementsflag.AnnouncementsflagFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Announcementsflag extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long flagId;

	public long userId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long entryId;

	public int value;


	// model finder attribute

	public static Finder<Long,Announcementsflag> find = new Finder<Long,Announcementsflag>(
		Long.class, Announcementsflag.class
	);

	// getters and setters

	public long getFlagId() {
		return flagId;
	}

	public void setFlagId(long flagId) {
		this.flagId = flagId;
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
	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Announcementsflag(){
	}

	// constructor using a formData

	public Announcementsflag(AnnouncementsflagFormData formData) {
		flagId = Long.valueOf(formData.flagId);
		userId = Long.valueOf(formData.userId);
		createDate = new Date(formData.createDate);
		entryId = Long.valueOf(formData.entryId);
		value = Integer.valueOf(formData.value);
	}

	public AnnouncementsflagFormData toFormData() {
		if (flagId < 0) {
			flagId = 0L;
		}

		AnnouncementsflagFormData formData = new AnnouncementsflagFormData(
			String.valueOf(flagId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(entryId)
			,
			String.valueOf(value)
			
		);

		return formData;
	}

}
