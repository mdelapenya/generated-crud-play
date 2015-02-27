
package models.clustergroup;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.clustergroup.ClustergroupFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Clustergroup extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long clusterGroupId;

	@Constraints.MaxLength(75)
	public String name;

	@Constraints.MaxLength(75)
	public String clusterNodeIds;

	public boolean wholeCluster;


	// model finder attribute

	public static Finder<Long,Clustergroup> find = new Finder<Long,Clustergroup>(
		Long.class, Clustergroup.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getClusterGroupId() {
		return clusterGroupId;
	}

	public void setClusterGroupId(long clusterGroupId) {
		this.clusterGroupId = clusterGroupId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getClusterNodeIds() {
		return clusterNodeIds;
	}

	public void setClusterNodeIds(String clusterNodeIds) {
		this.clusterNodeIds = clusterNodeIds;
	}
	public boolean getWholeCluster() {
		return wholeCluster;
	}

	public void setWholeCluster(boolean wholeCluster) {
		this.wholeCluster = wholeCluster;
	}

	public Clustergroup(){
	}

	// constructor using a formData

	public Clustergroup(ClustergroupFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		clusterGroupId = Long.valueOf(formData.clusterGroupId);
		name = formData.name;
		clusterNodeIds = formData.clusterNodeIds;
		wholeCluster = Boolean.valueOf(formData.wholeCluster);
	}

	public ClustergroupFormData toFormData() {
		if (clusterGroupId < 0) {
			clusterGroupId = 0L;
		}

		ClustergroupFormData formData = new ClustergroupFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(clusterGroupId)
			,
			name
			,
			clusterNodeIds
			,
			String.valueOf(wholeCluster)
			
		);

		return formData;
	}

}
