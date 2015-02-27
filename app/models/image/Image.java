
package models.image;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.image.ImageFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Image extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long imageId;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	@Constraints.MaxLength(75)
	public String customtype;

	public int height;

	public int width;

	public int size;


	// model finder attribute

	public static Finder<Long,Image> find = new Finder<Long,Image>(
		Long.class, Image.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Image(){
	}

	// constructor using a formData

	public Image(ImageFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		imageId = Long.valueOf(formData.imageId);
		modifiedDate = new Date(formData.modifiedDate);
		customtype = formData.customtype;
		height = Integer.valueOf(formData.height);
		width = Integer.valueOf(formData.width);
		size = Integer.valueOf(formData.size);
	}

	public ImageFormData toFormData() {
		if (imageId < 0) {
			imageId = 0L;
		}

		ImageFormData formData = new ImageFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(imageId)
			,
			String.valueOf(modifiedDate)
			,
			customtype
			,
			String.valueOf(height)
			,
			String.valueOf(width)
			,
			String.valueOf(size)
			
		);

		return formData;
	}

}
