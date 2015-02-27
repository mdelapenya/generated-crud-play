
package models.dlfilerank;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlfilerank.DlfilerankFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlfilerank extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long fileRankId;

	public long groupId;

	public long companyId;

	public long userId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	public long fileEntryId;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Dlfilerank> find = new Finder<Long,Dlfilerank>(
		Long.class, Dlfilerank.class
	);

	// getters and setters

	public long getFileRankId() {
		return fileRankId;
	}

	public void setFileRankId(long fileRankId) {
		this.fileRankId = fileRankId;
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
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Dlfilerank(){
	}

	// constructor using a formData

	public Dlfilerank(DlfilerankFormData formData) {
		fileRankId = Long.valueOf(formData.fileRankId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		createDate = new Date(formData.createDate);
		fileEntryId = Long.valueOf(formData.fileEntryId);
		active = Boolean.valueOf(formData.active);
	}

	public DlfilerankFormData toFormData() {
		if (fileRankId < 0) {
			fileRankId = 0L;
		}

		DlfilerankFormData formData = new DlfilerankFormData(
			String.valueOf(fileRankId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(userId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(fileEntryId)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
