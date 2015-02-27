
package models.virtualhost;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.virtualhost.VirtualhostFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Virtualhost extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long virtualHostId;

	public long companyId;

	public long layoutSetId;

	@Constraints.MaxLength(75)
	public String hostname;


	// model finder attribute

	public static Finder<Long,Virtualhost> find = new Finder<Long,Virtualhost>(
		Long.class, Virtualhost.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getVirtualHostId() {
		return virtualHostId;
	}

	public void setVirtualHostId(long virtualHostId) {
		this.virtualHostId = virtualHostId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getLayoutSetId() {
		return layoutSetId;
	}

	public void setLayoutSetId(long layoutSetId) {
		this.layoutSetId = layoutSetId;
	}
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Virtualhost(){
	}

	// constructor using a formData

	public Virtualhost(VirtualhostFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		virtualHostId = Long.valueOf(formData.virtualHostId);
		companyId = Long.valueOf(formData.companyId);
		layoutSetId = Long.valueOf(formData.layoutSetId);
		hostname = formData.hostname;
	}

	public VirtualhostFormData toFormData() {
		if (virtualHostId < 0) {
			virtualHostId = 0L;
		}

		VirtualhostFormData formData = new VirtualhostFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(virtualHostId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(layoutSetId)
			,
			hostname
			
		);

		return formData;
	}

}
