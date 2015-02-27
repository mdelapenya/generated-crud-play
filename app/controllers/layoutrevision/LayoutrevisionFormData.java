package controllers.layoutrevision;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutrevision data form.
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
public class LayoutrevisionFormData {

	public String mvccVersion;
	public String layoutRevisionId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String layoutSetBranchId;
	public String layoutBranchId;
	public String parentLayoutRevisionId;
	public String head;
	public String major;
	public String plid;
	public String privateLayout;
	public String name;
	public String title;
	public String description;
	public String keywords;
	public String robots;
	public String typeSettings;
	public String iconImageId;
	public String themeId;
	public String colorSchemeId;
	public String wapThemeId;
	public String wapColorSchemeId;
	public String css;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public LayoutrevisionFormData() {
	}

	public LayoutrevisionFormData(
		String mvccVersion,
				String layoutRevisionId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String layoutSetBranchId,
				String layoutBranchId,
				String parentLayoutRevisionId,
				String head,
				String major,
				String plid,
				String privateLayout,
				String name,
				String title,
				String description,
				String keywords,
				String robots,
				String typeSettings,
				String iconImageId,
				String themeId,
				String colorSchemeId,
				String wapThemeId,
				String wapColorSchemeId,
				String css,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.mvccVersion = mvccVersion;
		this.layoutRevisionId = layoutRevisionId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.layoutSetBranchId = layoutSetBranchId;
		this.layoutBranchId = layoutBranchId;
		this.parentLayoutRevisionId = parentLayoutRevisionId;
		this.head = head;
		this.major = major;
		this.plid = plid;
		this.privateLayout = privateLayout;
		this.name = name;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.robots = robots;
		this.typeSettings = typeSettings;
		this.iconImageId = iconImageId;
		this.themeId = themeId;
		this.colorSchemeId = colorSchemeId;
		this.wapThemeId = wapThemeId;
		this.wapColorSchemeId = wapColorSchemeId;
		this.css = css;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutRevisionId == null || layoutRevisionId.length() == 0) {
			errors.add(new ValidationError("layoutRevisionId", "No layoutRevisionId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
