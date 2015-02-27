
package models.layoutsetbranch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layoutsetbranch.LayoutsetbranchFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layoutsetbranch extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long layoutSetBranchId;

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

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	public boolean master;

	public long logoId;

	@Constraints.MaxLength(75)
	public String themeId;

	@Constraints.MaxLength(75)
	public String colorSchemeId;

	@Constraints.MaxLength(75)
	public String wapThemeId;

	@Constraints.MaxLength(75)
	public String wapColorSchemeId;

	public String css;

	public String settings;

	@Constraints.MaxLength(75)
	public String layoutSetPrototypeUuid;

	public boolean layoutSetPrototypeLinkEnabled;


	// model finder attribute

	public static Finder<Long,Layoutsetbranch> find = new Finder<Long,Layoutsetbranch>(
		Long.class, Layoutsetbranch.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getLayoutSetBranchId() {
		return layoutSetBranchId;
	}

	public void setLayoutSetBranchId(long layoutSetBranchId) {
		this.layoutSetBranchId = layoutSetBranchId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}
	public long getLogoId() {
		return logoId;
	}

	public void setLogoId(long logoId) {
		this.logoId = logoId;
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
	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}
	public String getLayoutSetPrototypeUuid() {
		return layoutSetPrototypeUuid;
	}

	public void setLayoutSetPrototypeUuid(String layoutSetPrototypeUuid) {
		this.layoutSetPrototypeUuid = layoutSetPrototypeUuid;
	}
	public boolean getLayoutSetPrototypeLinkEnabled() {
		return layoutSetPrototypeLinkEnabled;
	}

	public void setLayoutSetPrototypeLinkEnabled(boolean layoutSetPrototypeLinkEnabled) {
		this.layoutSetPrototypeLinkEnabled = layoutSetPrototypeLinkEnabled;
	}

	public Layoutsetbranch(){
	}

	// constructor using a formData

	public Layoutsetbranch(LayoutsetbranchFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		layoutSetBranchId = Long.valueOf(formData.layoutSetBranchId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		name = formData.name;
		description = formData.description;
		master = Boolean.valueOf(formData.master);
		logoId = Long.valueOf(formData.logoId);
		themeId = formData.themeId;
		colorSchemeId = formData.colorSchemeId;
		wapThemeId = formData.wapThemeId;
		wapColorSchemeId = formData.wapColorSchemeId;
		css = formData.css;
		settings = formData.settings;
		layoutSetPrototypeUuid = formData.layoutSetPrototypeUuid;
		layoutSetPrototypeLinkEnabled = Boolean.valueOf(formData.layoutSetPrototypeLinkEnabled);
	}

	public LayoutsetbranchFormData toFormData() {
		if (layoutSetBranchId < 0) {
			layoutSetBranchId = 0L;
		}

		LayoutsetbranchFormData formData = new LayoutsetbranchFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(layoutSetBranchId)
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
			name
			,
			description
			,
			String.valueOf(master)
			,
			String.valueOf(logoId)
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
			settings
			,
			layoutSetPrototypeUuid
			,
			String.valueOf(layoutSetPrototypeLinkEnabled)
			
		);

		return formData;
	}

}
