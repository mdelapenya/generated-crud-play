package controllers.ticket;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Ticket data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class TicketFormData {

	public String mvccVersion;
	public String ticketId;
	public String companyId;
	public String createDate;
	public String classNameId;
	public String classPK;
	public String key;
	public String customtype;
	public String extraInfo;
	public String expirationDate;

	public TicketFormData() {
	}

	public TicketFormData(
		String mvccVersion,
				String ticketId,
				String companyId,
				String createDate,
				String classNameId,
				String classPK,
				String key,
				String customtype,
				String extraInfo,
				String expirationDate
		) {

		this.mvccVersion = mvccVersion;
		this.ticketId = ticketId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.key = key;
		this.customtype = customtype;
		this.extraInfo = extraInfo;
		this.expirationDate = expirationDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (ticketId == null || ticketId.length() == 0) {
			errors.add(new ValidationError("ticketId", "No ticketId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
