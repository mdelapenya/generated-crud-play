package controllers.webdavprops;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Webdavprops data form.
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
public class WebdavpropsFormData {

	public String mvccVersion;
	public String webDavPropsId;
	public String companyId;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String props;

	public WebdavpropsFormData() {
	}

	public WebdavpropsFormData(
		String mvccVersion,
				String webDavPropsId,
				String companyId,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String props
		) {

		this.mvccVersion = mvccVersion;
		this.webDavPropsId = webDavPropsId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.props = props;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (webDavPropsId == null || webDavPropsId.length() == 0) {
			errors.add(new ValidationError("webDavPropsId", "No webDavPropsId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
