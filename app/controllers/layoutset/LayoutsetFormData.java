package controllers.layoutset;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutset data form.
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
public class LayoutsetFormData {

	public String mvccVersion;
	public String layoutSetId;
	public String groupId;
	public String companyId;
	public String createDate;
	public String modifiedDate;
	public String privateLayout;
	public String logoId;
	public String themeId;
	public String colorSchemeId;
	public String wapThemeId;
	public String wapColorSchemeId;
	public String css;
	public String pageCount;
	public String settings;
	public String layoutSetPrototypeUuid;
	public String layoutSetPrototypeLinkEnabled;

	public LayoutsetFormData() {
	}

	public LayoutsetFormData(
		String mvccVersion,
				String layoutSetId,
				String groupId,
				String companyId,
				String createDate,
				String modifiedDate,
				String privateLayout,
				String logoId,
				String themeId,
				String colorSchemeId,
				String wapThemeId,
				String wapColorSchemeId,
				String css,
				String pageCount,
				String settings,
				String layoutSetPrototypeUuid,
				String layoutSetPrototypeLinkEnabled
		) {

		this.mvccVersion = mvccVersion;
		this.layoutSetId = layoutSetId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.privateLayout = privateLayout;
		this.logoId = logoId;
		this.themeId = themeId;
		this.colorSchemeId = colorSchemeId;
		this.wapThemeId = wapThemeId;
		this.wapColorSchemeId = wapColorSchemeId;
		this.css = css;
		this.pageCount = pageCount;
		this.settings = settings;
		this.layoutSetPrototypeUuid = layoutSetPrototypeUuid;
		this.layoutSetPrototypeLinkEnabled = layoutSetPrototypeLinkEnabled;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutSetId == null || layoutSetId.length() == 0) {
			errors.add(new ValidationError("layoutSetId", "No layoutSetId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
