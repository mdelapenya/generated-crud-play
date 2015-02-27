
package models.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.account.AccountFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Account extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long accountId;

	public long companyId;

	public long userId;

	@Constraints.MaxLength(75)
	public String userName;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createDate;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date modifiedDate;

	public long parentAccountId;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String legalName;

	@Constraints.MaxLength(75)
	public String legalId;

	@Constraints.MaxLength(75)
	public String legalType;

	@Constraints.MaxLength(75)
	public String sicCode;

	@Constraints.MaxLength(75)
	public String tickerSymbol;

	@Constraints.MaxLength(75)
	public String industry;

	@Constraints.MaxLength(75)
	public String customtype;

	@Constraints.MaxLength(75)
	public String size;


	// model finder attribute

	public static Finder<Long,Account> find = new Finder<Long,Account>(
		Long.class, Account.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
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
	public long getParentAccountId() {
		return parentAccountId;
	}

	public void setParentAccountId(long parentAccountId) {
		this.parentAccountId = parentAccountId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getLegalId() {
		return legalId;
	}

	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getLegalType() {
		return legalType;
	}

	public void setLegalType(String legalType) {
		this.legalType = legalType;
	}
	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Account(){
	}

	// constructor using a formData

	public Account(AccountFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		accountId = Long.valueOf(formData.accountId);
		companyId = Long.valueOf(formData.companyId);
		userId = Long.valueOf(formData.userId);
		userName = formData.userName;
		createDate = new Date(formData.createDate);
		modifiedDate = new Date(formData.modifiedDate);
		parentAccountId = Long.valueOf(formData.parentAccountId);
		name = formData.name;
		legalName = formData.legalName;
		legalId = formData.legalId;
		legalType = formData.legalType;
		sicCode = formData.sicCode;
		tickerSymbol = formData.tickerSymbol;
		industry = formData.industry;
		customtype = formData.customtype;
		size = formData.size;
	}

	public AccountFormData toFormData() {
		if (accountId < 0) {
			accountId = 0L;
		}

		AccountFormData formData = new AccountFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(accountId)
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
			String.valueOf(parentAccountId)
			,
			name
			,
			legalName
			,
			legalId
			,
			legalType
			,
			sicCode
			,
			tickerSymbol
			,
			industry
			,
			customtype
			,
			size
			
		);

		return formData;
	}

}
