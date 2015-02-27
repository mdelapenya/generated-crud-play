
package models.journalarticleimage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalarticleimage.JournalarticleimageFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalarticleimage extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long articleImageId;

	public long groupId;

	@Constraints.MaxLength(75)
	public String articleId;

	public double version;

	@Constraints.MaxLength(75)
	public String elInstanceId;

	@Constraints.MaxLength(75)
	public String elName;

	@Constraints.MaxLength(75)
	public String languageId;

	public boolean tempImage;


	// model finder attribute

	public static Finder<Long,Journalarticleimage> find = new Finder<Long,Journalarticleimage>(
		Long.class, Journalarticleimage.class
	);

	// getters and setters

	public long getArticleImageId() {
		return articleImageId;
	}

	public void setArticleImageId(long articleImageId) {
		this.articleImageId = articleImageId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	public String getElInstanceId() {
		return elInstanceId;
	}

	public void setElInstanceId(String elInstanceId) {
		this.elInstanceId = elInstanceId;
	}
	public String getElName() {
		return elName;
	}

	public void setElName(String elName) {
		this.elName = elName;
	}
	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public boolean getTempImage() {
		return tempImage;
	}

	public void setTempImage(boolean tempImage) {
		this.tempImage = tempImage;
	}

	public Journalarticleimage(){
	}

	// constructor using a formData

	public Journalarticleimage(JournalarticleimageFormData formData) {
		articleImageId = Long.valueOf(formData.articleImageId);
		groupId = Long.valueOf(formData.groupId);
		articleId = formData.articleId;
		version = Double.valueOf(formData.version);
		elInstanceId = formData.elInstanceId;
		elName = formData.elName;
		languageId = formData.languageId;
		tempImage = Boolean.valueOf(formData.tempImage);
	}

	public JournalarticleimageFormData toFormData() {
		if (articleImageId < 0) {
			articleImageId = 0L;
		}

		JournalarticleimageFormData formData = new JournalarticleimageFormData(
			String.valueOf(articleImageId)
			,
			String.valueOf(groupId)
			,
			articleId
			,
			String.valueOf(version)
			,
			elInstanceId
			,
			elName
			,
			languageId
			,
			String.valueOf(tempImage)
			
		);

		return formData;
	}

}
