
package models.dlsyncevent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlsyncevent.DlsynceventFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlsyncevent extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long syncEventId;

	public long modifiedTime;

	@Constraints.MaxLength(75)
	public String event;

	@Constraints.MaxLength(75)
	public String customtype;

	public long typePK;


	// model finder attribute

	public static Finder<Long,Dlsyncevent> find = new Finder<Long,Dlsyncevent>(
		Long.class, Dlsyncevent.class
	);

	// getters and setters

	public long getSyncEventId() {
		return syncEventId;
	}

	public void setSyncEventId(long syncEventId) {
		this.syncEventId = syncEventId;
	}
	public long getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public long getTypePK() {
		return typePK;
	}

	public void setTypePK(long typePK) {
		this.typePK = typePK;
	}

	public Dlsyncevent(){
	}

	// constructor using a formData

	public Dlsyncevent(DlsynceventFormData formData) {
		syncEventId = Long.valueOf(formData.syncEventId);
		modifiedTime = Long.valueOf(formData.modifiedTime);
		event = formData.event;
		customtype = formData.customtype;
		typePK = Long.valueOf(formData.typePK);
	}

	public DlsynceventFormData toFormData() {
		if (syncEventId < 0) {
			syncEventId = 0L;
		}

		DlsynceventFormData formData = new DlsynceventFormData(
			String.valueOf(syncEventId)
			,
			String.valueOf(modifiedTime)
			,
			event
			,
			customtype
			,
			String.valueOf(typePK)
			
		);

		return formData;
	}

}
