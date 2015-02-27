
package models.scproductscreenshot;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.scproductscreenshot.ScproductscreenshotFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Scproductscreenshot extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long productScreenshotId;

	public long companyId;

	public long groupId;

	public long productEntryId;

	public long thumbnailId;

	public long fullImageId;

	public int priority;


	// model finder attribute

	public static Finder<Long,Scproductscreenshot> find = new Finder<Long,Scproductscreenshot>(
		Long.class, Scproductscreenshot.class
	);

	// getters and setters

	public long getProductScreenshotId() {
		return productScreenshotId;
	}

	public void setProductScreenshotId(long productScreenshotId) {
		this.productScreenshotId = productScreenshotId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getProductEntryId() {
		return productEntryId;
	}

	public void setProductEntryId(long productEntryId) {
		this.productEntryId = productEntryId;
	}
	public long getThumbnailId() {
		return thumbnailId;
	}

	public void setThumbnailId(long thumbnailId) {
		this.thumbnailId = thumbnailId;
	}
	public long getFullImageId() {
		return fullImageId;
	}

	public void setFullImageId(long fullImageId) {
		this.fullImageId = fullImageId;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Scproductscreenshot(){
	}

	// constructor using a formData

	public Scproductscreenshot(ScproductscreenshotFormData formData) {
		productScreenshotId = Long.valueOf(formData.productScreenshotId);
		companyId = Long.valueOf(formData.companyId);
		groupId = Long.valueOf(formData.groupId);
		productEntryId = Long.valueOf(formData.productEntryId);
		thumbnailId = Long.valueOf(formData.thumbnailId);
		fullImageId = Long.valueOf(formData.fullImageId);
		priority = Integer.valueOf(formData.priority);
	}

	public ScproductscreenshotFormData toFormData() {
		if (productScreenshotId < 0) {
			productScreenshotId = 0L;
		}

		ScproductscreenshotFormData formData = new ScproductscreenshotFormData(
			String.valueOf(productScreenshotId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(productEntryId)
			,
			String.valueOf(thumbnailId)
			,
			String.valueOf(fullImageId)
			,
			String.valueOf(priority)
			
		);

		return formData;
	}

}
