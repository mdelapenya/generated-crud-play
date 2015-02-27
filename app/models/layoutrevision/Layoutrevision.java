
package models.layoutrevision;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layoutrevision.LayoutrevisionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layoutrevision extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long layoutRevisionId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long layoutSetBranchId;

	public long layoutBranchId;

	public long parentLayoutRevisionId;

	public boolean head;

	public boolean major;

	public long plid;

	public boolean privateLayout;

	public String name;

	public String title;

	public String description;

	public String keywords;

	public String robots;

	public String typeSettings;

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

	public int status;

	public long statusByUserId;

	@Constraints.MaxLength(75)
	public String statusByUserName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date statusDate;


	// model finder attribute

	public static Finder<Long,Layoutrevision> find = new Finder<Long,Layoutrevision>(
		Long.class, Layoutrevision.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getLayoutRevisionId() {
		return layoutRevisionId;
	}

	public void setLayoutRevisionId(long layoutRevisionId) {
		this.layoutRevisionId = layoutRevisionId;
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
	public long getLayoutSetBranchId() {
		return layoutSetBranchId;
	}

	public void setLayoutSetBranchId(long layoutSetBranchId) {
		this.layoutSetBranchId = layoutSetBranchId;
	}
	public long getLayoutBranchId() {
		return layoutBranchId;
	}

	public void setLayoutBranchId(long layoutBranchId) {
		this.layoutBranchId = layoutBranchId;
	}
	public long getParentLayoutRevisionId() {
		return parentLayoutRevisionId;
	}

	public void setParentLayoutRevisionId(long parentLayoutRevisionId) {
		this.parentLayoutRevisionId = parentLayoutRevisionId;
	}
	public boolean getHead() {
		return head;
	}

	public void setHead(boolean head) {
		this.head = head;
	}
	public boolean getMajor() {
		return major;
	}

	public void setMajor(boolean major) {
		this.major = major;
	}
	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
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
	public String getTypeSettings() {
		return typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		this.typeSettings = typeSettings;
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
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public long getStatusByUserId() {
		return statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		this.statusByUserId = statusByUserId;
	}
	public String getStatusByUserName() {
		return statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		this.statusByUserName = statusByUserName;
	}
	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Layoutrevision(){
	}

	// constructor using a formData

	public Layoutrevision(LayoutrevisionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		layoutRevisionId = Long.valueOf(formData.layoutRevisionId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		layoutSetBranchId = Long.valueOf(formData.layoutSetBranchId);
		layoutBranchId = Long.valueOf(formData.layoutBranchId);
		parentLayoutRevisionId = Long.valueOf(formData.parentLayoutRevisionId);
		head = Boolean.valueOf(formData.head);
		major = Boolean.valueOf(formData.major);
		plid = Long.valueOf(formData.plid);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		name = formData.name;
		title = formData.title;
		description = formData.description;
		keywords = formData.keywords;
		robots = formData.robots;
		typeSettings = formData.typeSettings;
		iconImageId = Long.valueOf(formData.iconImageId);
		themeId = formData.themeId;
		colorSchemeId = formData.colorSchemeId;
		wapThemeId = formData.wapThemeId;
		wapColorSchemeId = formData.wapColorSchemeId;
		css = formData.css;
		status = Integer.valueOf(formData.status);
		statusByUserId = Long.valueOf(formData.statusByUserId);
		statusByUserName = formData.statusByUserName;
		statusDate = new Date(formData.statusDate);
	}

	public LayoutrevisionFormData toFormData() {
		if (layoutRevisionId < 0) {
			layoutRevisionId = 0L;
		}

		LayoutrevisionFormData formData = new LayoutrevisionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(layoutRevisionId)
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
			String.valueOf(layoutSetBranchId)
			,
			String.valueOf(layoutBranchId)
			,
			String.valueOf(parentLayoutRevisionId)
			,
			String.valueOf(head)
			,
			String.valueOf(major)
			,
			String.valueOf(plid)
			,
			String.valueOf(privateLayout)
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
			typeSettings
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
			String.valueOf(status)
			,
			String.valueOf(statusByUserId)
			,
			statusByUserName
			,
			String.valueOf(statusDate)
			
		);

		return formData;
	}

}
