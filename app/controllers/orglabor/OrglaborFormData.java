package controllers.orglabor;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Orglabor data form.
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
public class OrglaborFormData {

	public String mvccVersion;
	public String orgLaborId;
	public String organizationId;
	public String typeId;
	public String sunOpen;
	public String sunClose;
	public String monOpen;
	public String monClose;
	public String tueOpen;
	public String tueClose;
	public String wedOpen;
	public String wedClose;
	public String thuOpen;
	public String thuClose;
	public String friOpen;
	public String friClose;
	public String satOpen;
	public String satClose;

	public OrglaborFormData() {
	}

	public OrglaborFormData(
		String mvccVersion,
				String orgLaborId,
				String organizationId,
				String typeId,
				String sunOpen,
				String sunClose,
				String monOpen,
				String monClose,
				String tueOpen,
				String tueClose,
				String wedOpen,
				String wedClose,
				String thuOpen,
				String thuClose,
				String friOpen,
				String friClose,
				String satOpen,
				String satClose
		) {

		this.mvccVersion = mvccVersion;
		this.orgLaborId = orgLaborId;
		this.organizationId = organizationId;
		this.typeId = typeId;
		this.sunOpen = sunOpen;
		this.sunClose = sunClose;
		this.monOpen = monOpen;
		this.monClose = monClose;
		this.tueOpen = tueOpen;
		this.tueClose = tueClose;
		this.wedOpen = wedOpen;
		this.wedClose = wedClose;
		this.thuOpen = thuOpen;
		this.thuClose = thuClose;
		this.friOpen = friOpen;
		this.friClose = friClose;
		this.satOpen = satOpen;
		this.satClose = satClose;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (orgLaborId == null || orgLaborId.length() == 0) {
			errors.add(new ValidationError("orgLaborId", "No orgLaborId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
