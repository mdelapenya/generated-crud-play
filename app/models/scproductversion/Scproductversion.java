
package models.scproductversion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.scproductversion.ScproductversionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Scproductversion extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long productVersionId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long productEntryId;

	@Constraints.MaxLength(75)
	public String version;

	public String changeLog;

	public String downloadPageURL;

	@Constraints.MaxLength(2000)
	public String directDownloadURL;

	public boolean repoStoreArtifact;


	// model finder attribute

	public static Finder<Long,Scproductversion> find = new Finder<Long,Scproductversion>(
		Long.class, Scproductversion.class
	);

	// getters and setters

	public long getProductVersionId() {
		return productVersionId;
	}

	public void setProductVersionId(long productVersionId) {
		this.productVersionId = productVersionId;
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
	public long getProductEntryId() {
		return productEntryId;
	}

	public void setProductEntryId(long productEntryId) {
		this.productEntryId = productEntryId;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public String getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(String changeLog) {
		this.changeLog = changeLog;
	}
	public String getDownloadPageURL() {
		return downloadPageURL;
	}

	public void setDownloadPageURL(String downloadPageURL) {
		this.downloadPageURL = downloadPageURL;
	}
	public String getDirectDownloadURL() {
		return directDownloadURL;
	}

	public void setDirectDownloadURL(String directDownloadURL) {
		this.directDownloadURL = directDownloadURL;
	}
	public boolean getRepoStoreArtifact() {
		return repoStoreArtifact;
	}

	public void setRepoStoreArtifact(boolean repoStoreArtifact) {
		this.repoStoreArtifact = repoStoreArtifact;
	}

	public Scproductversion(){
	}

	// constructor using a formData

	public Scproductversion(ScproductversionFormData formData) {
		productVersionId = Long.valueOf(formData.productVersionId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		productEntryId = Long.valueOf(formData.productEntryId);
		version = formData.version;
		changeLog = formData.changeLog;
		downloadPageURL = formData.downloadPageURL;
		directDownloadURL = formData.directDownloadURL;
		repoStoreArtifact = Boolean.valueOf(formData.repoStoreArtifact);
	}

	public ScproductversionFormData toFormData() {
		if (productVersionId < 0) {
			productVersionId = 0L;
		}

		ScproductversionFormData formData = new ScproductversionFormData(
			String.valueOf(productVersionId)
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
			String.valueOf(productEntryId)
			,
			version
			,
			changeLog
			,
			downloadPageURL
			,
			directDownloadURL
			,
			String.valueOf(repoStoreArtifact)
			
		);

		return formData;
	}

}
