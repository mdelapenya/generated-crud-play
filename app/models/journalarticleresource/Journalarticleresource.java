
package models.journalarticleresource;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalarticleresource.JournalarticleresourceFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalarticleresource extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourcePrimKey;

	public long groupId;

	@Constraints.MaxLength(75)
	public String articleId;


	// model finder attribute

	public static Finder<Long,Journalarticleresource> find = new Finder<Long,Journalarticleresource>(
		Long.class, Journalarticleresource.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getResourcePrimKey() {
		return resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
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

	public Journalarticleresource(){
	}

	// constructor using a formData

	public Journalarticleresource(JournalarticleresourceFormData formData) {
		uuid = formData.uuid;
		resourcePrimKey = Long.valueOf(formData.resourcePrimKey);
		groupId = Long.valueOf(formData.groupId);
		articleId = formData.articleId;
	}

	public JournalarticleresourceFormData toFormData() {
		if (resourcePrimKey < 0) {
			resourcePrimKey = 0L;
		}

		JournalarticleresourceFormData formData = new JournalarticleresourceFormData(
			uuid
			,
			String.valueOf(resourcePrimKey)
			,
			String.valueOf(groupId)
			,
			articleId
			
		);

		return formData;
	}

}
