
package models.socialrelation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.socialrelation.SocialrelationFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Socialrelation extends Model {

	// model attributes

	@Constraints.MaxLength(75)
	public String uuid;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long relationId;

	public long companyId;

	public long createDate;

	public long userId1;

	public long userId2;

	public int customtype;


	// model finder attribute

	public static Finder<Long,Socialrelation> find = new Finder<Long,Socialrelation>(
		Long.class, Socialrelation.class
	);

	// getters and setters

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getRelationId() {
		return relationId;
	}

	public void setRelationId(long relationId) {
		this.relationId = relationId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getUserId1() {
		return userId1;
	}

	public void setUserId1(long userId1) {
		this.userId1 = userId1;
	}
	public long getUserId2() {
		return userId2;
	}

	public void setUserId2(long userId2) {
		this.userId2 = userId2;
	}
	public int getCustomtype() {
		return customtype;
	}

	public void setCustomtype(int customtype) {
		this.customtype = customtype;
	}

	public Socialrelation(){
	}

	// constructor using a formData

	public Socialrelation(SocialrelationFormData formData) {
		uuid = formData.uuid;
		relationId = Long.valueOf(formData.relationId);
		companyId = Long.valueOf(formData.companyId);
		createDate = Long.valueOf(formData.createDate);
		userId1 = Long.valueOf(formData.userId1);
		userId2 = Long.valueOf(formData.userId2);
		customtype = Integer.valueOf(formData.customtype);
	}

	public SocialrelationFormData toFormData() {
		if (relationId < 0) {
			relationId = 0L;
		}

		SocialrelationFormData formData = new SocialrelationFormData(
			uuid
			,
			String.valueOf(relationId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(createDate)
			,
			String.valueOf(userId1)
			,
			String.valueOf(userId2)
			,
			String.valueOf(customtype)
			
		);

		return formData;
	}

}
