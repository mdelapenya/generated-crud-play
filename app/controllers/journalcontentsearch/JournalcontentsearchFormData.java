package controllers.journalcontentsearch;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalcontentsearch data form.
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
public class JournalcontentsearchFormData {

	public String contentSearchId;
	public String groupId;
	public String companyId;
	public String privateLayout;
	public String layoutId;
	public String portletId;
	public String articleId;

	public JournalcontentsearchFormData() {
	}

	public JournalcontentsearchFormData(
		String contentSearchId,
				String groupId,
				String companyId,
				String privateLayout,
				String layoutId,
				String portletId,
				String articleId
		) {

		this.contentSearchId = contentSearchId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.privateLayout = privateLayout;
		this.layoutId = layoutId;
		this.portletId = portletId;
		this.articleId = articleId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (contentSearchId == null || contentSearchId.length() == 0) {
			errors.add(new ValidationError("contentSearchId", "No contentSearchId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
