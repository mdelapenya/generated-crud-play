
package models.layoutset;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layoutset.LayoutsetFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layoutset extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long layoutSetId;

	public long groupId;

	public long companyId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public boolean privateLayout;

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

	public int pageCount;

	public String settings;

	@Constraints.MaxLength(75)
	public String layoutSetPrototypeUuid;

	public boolean layoutSetPrototypeLinkEnabled;


	// model finder attribute

	public static Finder<Long,Layoutset> find = new Finder<Long,Layoutset>(
		Long.class, Layoutset.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getLayoutSetId() {
		return layoutSetId;
	}

	public void setLayoutSetId(long layoutSetId) {
		this.layoutSetId = layoutSetId;
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
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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

	public Layoutset(){
	}

	// constructor using a formData

	public Layoutset(LayoutsetFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		layoutSetId = Long.valueOf(formData.layoutSetId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		logoId = Long.valueOf(formData.logoId);
		themeId = formData.themeId;
		colorSchemeId = formData.colorSchemeId;
		wapThemeId = formData.wapThemeId;
		wapColorSchemeId = formData.wapColorSchemeId;
		css = formData.css;
		pageCount = Integer.valueOf(formData.pageCount);
		settings = formData.settings;
		layoutSetPrototypeUuid = formData.layoutSetPrototypeUuid;
		layoutSetPrototypeLinkEnabled = Boolean.valueOf(formData.layoutSetPrototypeLinkEnabled);
	}

	public LayoutsetFormData toFormData() {
		if (layoutSetId < 0) {
			layoutSetId = 0L;
		}

		LayoutsetFormData formData = new LayoutsetFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(layoutSetId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(modifiedDate)
			,
			String.valueOf(privateLayout)
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
			String.valueOf(pageCount)
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
