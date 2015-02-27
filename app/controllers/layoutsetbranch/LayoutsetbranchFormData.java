package controllers.layoutsetbranch;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutsetbranch data form.
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
public class LayoutsetbranchFormData {

	public String mvccVersion;
	public String layoutSetBranchId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String privateLayout;
	public String name;
	public String description;
	public String master;
	public String logoId;
	public String themeId;
	public String colorSchemeId;
	public String wapThemeId;
	public String wapColorSchemeId;
	public String css;
	public String settings;
	public String layoutSetPrototypeUuid;
	public String layoutSetPrototypeLinkEnabled;

	public LayoutsetbranchFormData() {
	}

	public LayoutsetbranchFormData(
		String mvccVersion,
				String layoutSetBranchId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String privateLayout,
				String name,
				String description,
				String master,
				String logoId,
				String themeId,
				String colorSchemeId,
				String wapThemeId,
				String wapColorSchemeId,
				String css,
				String settings,
				String layoutSetPrototypeUuid,
				String layoutSetPrototypeLinkEnabled
		) {

		this.mvccVersion = mvccVersion;
		this.layoutSetBranchId = layoutSetBranchId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.privateLayout = privateLayout;
		this.name = name;
		this.description = description;
		this.master = master;
		this.logoId = logoId;
		this.themeId = themeId;
		this.colorSchemeId = colorSchemeId;
		this.wapThemeId = wapThemeId;
		this.wapColorSchemeId = wapColorSchemeId;
		this.css = css;
		this.settings = settings;
		this.layoutSetPrototypeUuid = layoutSetPrototypeUuid;
		this.layoutSetPrototypeLinkEnabled = layoutSetPrototypeLinkEnabled;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutSetBranchId == null || layoutSetBranchId.length() == 0) {
			errors.add(new ValidationError("layoutSetBranchId", "No layoutSetBranchId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
