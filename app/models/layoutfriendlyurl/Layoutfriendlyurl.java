
package models.layoutfriendlyurl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.layoutfriendlyurl.LayoutfriendlyurlFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Layoutfriendlyurl extends Model {

	// model attributes

	public long mvccVersion;

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long layoutFriendlyURLId;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long plid;

	public boolean privateLayout;

	@Constraints.MaxLength(255)
	public String friendlyURL;

	@Constraints.MaxLength(75)
	public String languageId;


	// model finder attribute

	public static Finder<Long,Layoutfriendlyurl> find = new Finder<Long,Layoutfriendlyurl>(
		Long.class, Layoutfriendlyurl.class
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
	public long getLayoutFriendlyURLId() {
		return layoutFriendlyURLId;
	}

	public void setLayoutFriendlyURLId(long layoutFriendlyURLId) {
		this.layoutFriendlyURLId = layoutFriendlyURLId;
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
	public String getFriendlyURL() {
		return friendlyURL;
	}

	public void setFriendlyURL(String friendlyURL) {
		this.friendlyURL = friendlyURL;
	}
	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public Layoutfriendlyurl(){
	}

	// constructor using a formData

	public Layoutfriendlyurl(LayoutfriendlyurlFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		uuid = formData.uuid;
		layoutFriendlyURLId = Long.valueOf(formData.layoutFriendlyURLId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		plid = Long.valueOf(formData.plid);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		friendlyURL = formData.friendlyURL;
		languageId = formData.languageId;
	}

	public LayoutfriendlyurlFormData toFormData() {
		if (layoutFriendlyURLId < 0) {
			layoutFriendlyURLId = 0L;
		}

		LayoutfriendlyurlFormData formData = new LayoutfriendlyurlFormData(
			String.valueOf(mvccVersion)
			,
			uuid
			,
			String.valueOf(layoutFriendlyURLId)
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
			String.valueOf(plid)
			,
			String.valueOf(privateLayout)
			,
			friendlyURL
			,
			languageId
			
		);

		return formData;
	}

}
