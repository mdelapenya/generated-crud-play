
package models.dlcontent;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.dlcontent.DlcontentFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Dlcontent extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long contentId;

	public long groupId;

	public long companyId;

	public long repositoryId;

	@Constraints.MaxLength(255)
	public String path;

	@Constraints.MaxLength(75)
	public String version;


	// model finder attribute

	public static Finder<Long,Dlcontent> find = new Finder<Long,Dlcontent>(
		Long.class, Dlcontent.class
	);

	// getters and setters

	public long getContentId() {
		return contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
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
	public long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		this.repositoryId = repositoryId;
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Dlcontent(){
	}

	// constructor using a formData

	public Dlcontent(DlcontentFormData formData) {
		contentId = Long.valueOf(formData.contentId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		repositoryId = Long.valueOf(formData.repositoryId);
		path = formData.path;
		version = formData.version;
	}

	public DlcontentFormData toFormData() {
		if (contentId < 0) {
			contentId = 0L;
		}

		DlcontentFormData formData = new DlcontentFormData(
			String.valueOf(contentId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(repositoryId)
			,
			path
			,
			version
			
		);

		return formData;
	}

}
