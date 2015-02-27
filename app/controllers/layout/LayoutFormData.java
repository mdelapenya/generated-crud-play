package controllers.layout;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layout data form.
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
public class LayoutFormData {

	public String mvccVersion;
	public String uuid;
	public String plid;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String privateLayout;
	public String layoutId;
	public String parentLayoutId;
	public String name;
	public String title;
	public String description;
	public String keywords;
	public String robots;
	public String customtype;
	public String typeSettings;
	public String hidden;
	public String friendlyURL;
	public String iconImageId;
	public String themeId;
	public String colorSchemeId;
	public String wapThemeId;
	public String wapColorSchemeId;
	public String css;
	public String priority;
	public String layoutPrototypeUuid;
	public String layoutPrototypeLinkEnabled;
	public String sourcePrototypeLayoutUuid;

	public LayoutFormData() {
	}

	public LayoutFormData(
		String mvccVersion,
				String uuid,
				String plid,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String privateLayout,
				String layoutId,
				String parentLayoutId,
				String name,
				String title,
				String description,
				String keywords,
				String robots,
				String customtype,
				String typeSettings,
				String hidden,
				String friendlyURL,
				String iconImageId,
				String themeId,
				String colorSchemeId,
				String wapThemeId,
				String wapColorSchemeId,
				String css,
				String priority,
				String layoutPrototypeUuid,
				String layoutPrototypeLinkEnabled,
				String sourcePrototypeLayoutUuid
		) {

		this.mvccVersion = mvccVersion;
		this.uuid = uuid;
		this.plid = plid;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.privateLayout = privateLayout;
		this.layoutId = layoutId;
		this.parentLayoutId = parentLayoutId;
		this.name = name;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.robots = robots;
		this.customtype = customtype;
		this.typeSettings = typeSettings;
		this.hidden = hidden;
		this.friendlyURL = friendlyURL;
		this.iconImageId = iconImageId;
		this.themeId = themeId;
		this.colorSchemeId = colorSchemeId;
		this.wapThemeId = wapThemeId;
		this.wapColorSchemeId = wapColorSchemeId;
		this.css = css;
		this.priority = priority;
		this.layoutPrototypeUuid = layoutPrototypeUuid;
		this.layoutPrototypeLinkEnabled = layoutPrototypeLinkEnabled;
		this.sourcePrototypeLayoutUuid = sourcePrototypeLayoutUuid;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (plid == null || plid.length() == 0) {
			errors.add(new ValidationError("plid", "No plid was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
