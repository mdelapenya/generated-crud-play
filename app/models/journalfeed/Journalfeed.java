
package models.journalfeed;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalfeed.JournalfeedFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalfeed extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long id;

	public long groupId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String feedId;

	@Constraints.MaxLength(75)
	public String name;

	public String description;

	@Constraints.MaxLength(75)
	public String DDMStructureKey;

	@Constraints.MaxLength(75)
	public String DDMTemplateKey;

	@Constraints.MaxLength(75)
	public String DDMRendererTemplateKey;

	public int delta;

	@Constraints.MaxLength(75)
	public String orderByCol;

	@Constraints.MaxLength(75)
	public String orderByType;

	@Constraints.MaxLength(255)
	public String targetLayoutFriendlyUrl;

	@Constraints.MaxLength(75)
	public String targetPortletId;

	@Constraints.MaxLength(75)
	public String contentField;

	@Constraints.MaxLength(75)
	public String feedFormat;

	public double feedVersion;


	// model finder attribute

	public static Finder<Long,Journalfeed> find = new Finder<Long,Journalfeed>(
		Long.class, Journalfeed.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public String getFeedId() {
		return feedId;
	}

	public void setFeedId(String feedId) {
		this.feedId = feedId;
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
	public String getDDMStructureKey() {
		return DDMStructureKey;
	}

	public void setDDMStructureKey(String DDMStructureKey) {
		this.DDMStructureKey = DDMStructureKey;
	}
	public String getDDMTemplateKey() {
		return DDMTemplateKey;
	}

	public void setDDMTemplateKey(String DDMTemplateKey) {
		this.DDMTemplateKey = DDMTemplateKey;
	}
	public String getDDMRendererTemplateKey() {
		return DDMRendererTemplateKey;
	}

	public void setDDMRendererTemplateKey(String DDMRendererTemplateKey) {
		this.DDMRendererTemplateKey = DDMRendererTemplateKey;
	}
	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}
	public String getOrderByCol() {
		return orderByCol;
	}

	public void setOrderByCol(String orderByCol) {
		this.orderByCol = orderByCol;
	}
	public String getOrderByType() {
		return orderByType;
	}

	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}
	public String getTargetLayoutFriendlyUrl() {
		return targetLayoutFriendlyUrl;
	}

	public void setTargetLayoutFriendlyUrl(String targetLayoutFriendlyUrl) {
		this.targetLayoutFriendlyUrl = targetLayoutFriendlyUrl;
	}
	public String getTargetPortletId() {
		return targetPortletId;
	}

	public void setTargetPortletId(String targetPortletId) {
		this.targetPortletId = targetPortletId;
	}
	public String getContentField() {
		return contentField;
	}

	public void setContentField(String contentField) {
		this.contentField = contentField;
	}
	public String getFeedFormat() {
		return feedFormat;
	}

	public void setFeedFormat(String feedFormat) {
		this.feedFormat = feedFormat;
	}
	public double getFeedVersion() {
		return feedVersion;
	}

	public void setFeedVersion(double feedVersion) {
		this.feedVersion = feedVersion;
	}

	public Journalfeed(){
	}

	// constructor using a formData

	public Journalfeed(JournalfeedFormData formData) {
		uuid = formData.uuid;
		id = Long.valueOf(formData.id);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		feedId = formData.feedId;
		name = formData.name;
		description = formData.description;
		DDMStructureKey = formData.DDMStructureKey;
		DDMTemplateKey = formData.DDMTemplateKey;
		DDMRendererTemplateKey = formData.DDMRendererTemplateKey;
		delta = Integer.valueOf(formData.delta);
		orderByCol = formData.orderByCol;
		orderByType = formData.orderByType;
		targetLayoutFriendlyUrl = formData.targetLayoutFriendlyUrl;
		targetPortletId = formData.targetPortletId;
		contentField = formData.contentField;
		feedFormat = formData.feedFormat;
		feedVersion = Double.valueOf(formData.feedVersion);
	}

	public JournalfeedFormData toFormData() {
		if (id < 0) {
			id = 0L;
		}

		JournalfeedFormData formData = new JournalfeedFormData(
			uuid
			,
			String.valueOf(id)
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
			feedId
			,
			name
			,
			description
			,
			DDMStructureKey
			,
			DDMTemplateKey
			,
			DDMRendererTemplateKey
			,
			String.valueOf(delta)
			,
			orderByCol
			,
			orderByType
			,
			targetLayoutFriendlyUrl
			,
			targetPortletId
			,
			contentField
			,
			feedFormat
			,
			String.valueOf(feedVersion)
			
		);

		return formData;
	}

}
