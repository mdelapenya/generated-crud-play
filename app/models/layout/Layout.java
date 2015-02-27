
package models.layout;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layout.LayoutFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layout extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long plid;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public boolean privateLayout;

	public long layoutId;

	public long parentLayoutId;

	public String name;

	public String title;

	public String description;

	public String keywords;

	public String robots;

	@Constraints.MaxLength(75)
	public String customtype;

	public String typeSettings;

	public boolean hidden;

	@Constraints.MaxLength(255)
	public String friendlyURL;

	public long iconImageId;

	@Constraints.MaxLength(75)
	public String themeId;

	@Constraints.MaxLength(75)
	public String colorSchemeId;

	@Constraints.MaxLength(75)
	public String wapThemeId;

	@Constraints.MaxLength(75)
	public String wapColorSchemeId;

	public String css;

	public int priority;

	@Constraints.MaxLength(75)
	public String layoutPrototypeUuid;

	public boolean layoutPrototypeLinkEnabled;

	@Constraints.MaxLength(75)
	public String sourcePrototypeLayoutUuid;


	// model finder attribute

	public static Finder<Long,Layout> find = new Finder<Long,Layout>(
		Long.class, Layout.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean getPrivateLayout() {
		return privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		this.privateLayout = privateLayout;
	}
	public long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}
	public long getParentLayoutId() {
		return parentLayoutId;
	}

	public void setParentLayoutId(long parentLayoutId) {
		this.parentLayoutId = parentLayoutId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getRobots() {
		return robots;
	}

	public void setRobots(String robots) {
		this.robots = robots;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
	}
	public boolean getHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public String getFriendlyURL() {
		return friendlyURL;
	}

	public void setFriendlyURL(String friendlyURL) {
		this.friendlyURL = friendlyURL;
	}
	public long getIconImageId() {
		return iconImageId;
	}

	public void setIconImageId(long iconImageId) {
		this.iconImageId = iconImageId;
	}
	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	public String getColorSchemeId() {
		return colorSchemeId;
	}

	public void setColorSchemeId(String colorSchemeId) {
		this.colorSchemeId = colorSchemeId;
	}
	public String getWapThemeId() {
		return wapThemeId;
	}

	public void setWapThemeId(String wapThemeId) {
		this.wapThemeId = wapThemeId;
	}
	public String getWapColorSchemeId() {
		return wapColorSchemeId;
	}

	public void setWapColorSchemeId(String wapColorSchemeId) {
		this.wapColorSchemeId = wapColorSchemeId;
	}
	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getLayoutPrototypeUuid() {
		return layoutPrototypeUuid;
	}

	public void setLayoutPrototypeUuid(String layoutPrototypeUuid) {
		this.layoutPrototypeUuid = layoutPrototypeUuid;
	}
	public boolean getLayoutPrototypeLinkEnabled() {
		return layoutPrototypeLinkEnabled;
	}

	public void setLayoutPrototypeLinkEnabled(boolean layoutPrototypeLinkEnabled) {
		this.layoutPrototypeLinkEnabled = layoutPrototypeLinkEnabled;
	}
	public String getSourcePrototypeLayoutUuid() {
		return sourcePrototypeLayoutUuid;
	}

	public void setSourcePrototypeLayoutUuid(String sourcePrototypeLayoutUuid) {
		this.sourcePrototypeLayoutUuid = sourcePrototypeLayoutUuid;
	}

	public Layout(){
	}

	// constructor using a formData

	public Layout(LayoutFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		plid = Long.valueOf(formData.plid);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		layoutId = Long.valueOf(formData.layoutId);
		parentLayoutId = Long.valueOf(formData.parentLayoutId);
		name = formData.name;
		title = formData.title;
		description = formData.description;
		keywords = formData.keywords;
		robots = formData.robots;
		customtype = formData.customtype;
		typeSettings = formData.typeSettings;
		hidden = Boolean.valueOf(formData.hidden);
		friendlyURL = formData.friendlyURL;
		iconImageId = Long.valueOf(formData.iconImageId);
		themeId = formData.themeId;
		colorSchemeId = formData.colorSchemeId;
		wapThemeId = formData.wapThemeId;
		wapColorSchemeId = formData.wapColorSchemeId;
		css = formData.css;
		priority = Integer.valueOf(formData.priority);
		layoutPrototypeUuid = formData.layoutPrototypeUuid;
		layoutPrototypeLinkEnabled = Boolean.valueOf(formData.layoutPrototypeLinkEnabled);
		sourcePrototypeLayoutUuid = formData.sourcePrototypeLayoutUuid;
	}

	public LayoutFormData toFormData() {
		if (plid < 0) {
			plid = 0L;
		}

		LayoutFormData formData = new LayoutFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(plid)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(privateLayout)
			,
			String.valueOf(layoutId)
			,
			String.valueOf(parentLayoutId)
			,
			name
			,
			title
			,
			description
			,
			keywords
			,
			robots
			,
			customtype
			,
			typeSettings
			,
			String.valueOf(hidden)
			,
			friendlyURL
			,
			String.valueOf(iconImageId)
			,
			themeId
			,
			colorSchemeId
			,
			wapThemeId
			,
			wapColorSchemeId
			,
			css
			,
			String.valueOf(priority)
			,
			layoutPrototypeUuid
			,
			String.valueOf(layoutPrototypeLinkEnabled)
			,
			sourcePrototypeLayoutUuid
			
		);

		return formData;
	}

}
