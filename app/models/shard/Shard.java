
package models.shard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.shard.ShardFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Shard extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long shardId;

	public long classNameId;

	public long classPK;

	@Constraints.MaxLength(75)
	public String name;


	// model finder attribute

	public static Finder<Long,Shard> find = new Finder<Long,Shard>(
		Long.class, Shard.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getShardId() {
		return shardId;
	}

	public void setShardId(long shardId) {
		this.shardId = shardId;
	}
	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}
	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shard(){
	}

	// constructor using a formData

	public Shard(ShardFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		shardId = Long.valueOf(formData.shardId);
		classNameId = Long.valueOf(formData.classNameId);
		classPK = Long.valueOf(formData.classPK);
		name = formData.name;
	}

	public ShardFormData toFormData() {
		if (shardId < 0) {
			shardId = 0L;
		}

		ShardFormData formData = new ShardFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(shardId)
			,
			String.valueOf(classNameId)
			,
			String.valueOf(classPK)
			,
			name
			
		);

		return formData;
	}

}
