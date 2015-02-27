
package models.assetlink;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.assetlink.AssetlinkFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Assetlink extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long linkId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long entryId1;

	public long entryId2;

	public int customtype;

	public int weight;


	// model finder attribute

	public static Finder<Long,Assetlink> find = new Finder<Long,Assetlink>(
		Long.class, Assetlink.class
	);

	// getters and setters

	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
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
	public long getEntryId1() {
		return entryId1;
	}

	public void setEntryId1(long entryId1) {
		this.entryId1 = entryId1;
	}
	public long getEntryId2() {
		return entryId2;
	}

	public void setEntryId2(long entryId2) {
		this.entryId2 = entryId2;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Assetlink(){
	}

	// constructor using a formData

	public Assetlink(AssetlinkFormData formData) {
		linkId = Long.valueOf(formData.linkId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		entryId1 = Long.valueOf(formData.entryId1);
		entryId2 = Long.valueOf(formData.entryId2);
		customtype = Integer.valueOf(formData.customtype);
		weight = Integer.valueOf(formData.weight);
	}

	public AssetlinkFormData toFormData() {
		if (linkId < 0) {
			linkId = 0L;
		}

		AssetlinkFormData formData = new AssetlinkFormData(
			String.valueOf(linkId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			userName
			,
			String.valueOf(createDate)
			,
			String.valueOf(entryId1)
			,
			String.valueOf(entryId2)
			,
			String.valueOf(customtype)
			,
			String.valueOf(weight)
			
		);

		return formData;
	}

}
