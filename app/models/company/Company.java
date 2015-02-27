
package models.company;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.company.CompanyFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Company extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long companyId;

	public long accountId;

	@Constraints.MaxLength(75)
	public String webId;

	public String key;

	@Constraints.MaxLength(75)
	public String mx;

	public String homeURL;

	public long logoId;

	public boolean system;

	public int maxUsers;

	public boolean active;


	// model finder attribute

	public static Finder<Long,Company> find = new Finder<Long,Company>(
		Long.class, Company.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getWebId() {
		return webId;
	}

	public void setWebId(String webId) {
		this.webId = webId;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getMx() {
		return mx;
	}

	public void setMx(String mx) {
		this.mx = mx;
	}
	public String getHomeURL() {
		return homeURL;
	}

	public void setHomeURL(String homeURL) {
		this.homeURL = homeURL;
	}
	public long getLogoId() {
		return logoId;
	}

	public void setLogoId(long logoId) {
		this.logoId = logoId;
	}
	public boolean getSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}
	public int getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Company(){
	}

	// constructor using a formData

	public Company(CompanyFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		companyId = Long.valueOf(formData.companyId);
		accountId = Long.valueOf(formData.accountId);
		webId = formData.webId;
		key = formData.key;
		mx = formData.mx;
		homeURL = formData.homeURL;
		logoId = Long.valueOf(formData.logoId);
		system = Boolean.valueOf(formData.system);
		maxUsers = Integer.valueOf(formData.maxUsers);
		active = Boolean.valueOf(formData.active);
	}

	public CompanyFormData toFormData() {
		if (companyId < 0) {
			companyId = 0L;
		}

		CompanyFormData formData = new CompanyFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(companyId)
			,
			String.valueOf(accountId)
			,
			webId
			,
			key
			,
			mx
			,
			homeURL
			,
			String.valueOf(logoId)
			,
			String.valueOf(system)
			,
			String.valueOf(maxUsers)
			,
			String.valueOf(active)
			
		);

		return formData;
	}

}
