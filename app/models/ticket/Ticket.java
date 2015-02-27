
package models.ticket;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.ticket.TicketFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Ticket extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long ticketId;

	public long companyId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long classNameId;

	public long classPK;

	@Constraints.MaxLength(75)
	public String key;

	public int customtype;

	public String extraInfo;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date expirationDate;


	// model finder attribute

	public static Finder<Long,Ticket> find = new Finder<Long,Ticket>(
		Long.class, Ticket.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Ticket(){
	}

	// constructor using a formData

	public Ticket(TicketFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		ticketId = Long.valueOf(formData.ticketId);
		companyId = Long.valueOf(formData.companyId);
		createDate = new Date(formData.createDate);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		key = formData.key;
		customtype = Integer.valueOf(formData.customtype);
		extraInfo = formData.extraInfo;
		expirationDate = new Date(formData.expirationDate);
	}

	public TicketFormData toFormData() {
		if (ticketId < 0) {
			ticketId = 0L;
		}

		TicketFormData formData = new TicketFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(ticketId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			key
			,
			String.valueOf(customtype)
			,
			extraInfo
			,
			String.valueOf(expirationDate)
			
		);

		return formData;
	}

}
