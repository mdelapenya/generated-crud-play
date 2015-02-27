
package models.resourceaction;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.resourceaction.ResourceactionFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Resourceaction extends Model {

	// model attributes

	public long mvccVersion;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long resourceActionId;

	@Constraints.MaxLength(255)
	public String name;

	@Constraints.MaxLength(75)
	public String actionId;

	public long bitwiseValue;


	// model finder attribute

	public static Finder<Long,Resourceaction> find = new Finder<Long,Resourceaction>(
		Long.class, Resourceaction.class
	);

	// getters and setters

	public long getMvccVersion() {
		return mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}
	public long getResourceActionId() {
		return resourceActionId;
	}

	public void setResourceActionId(long resourceActionId) {
		this.resourceActionId = resourceActionId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public long getBitwiseValue() {
		return bitwiseValue;
	}

	public void setBitwiseValue(long bitwiseValue) {
		this.bitwiseValue = bitwiseValue;
	}

	public Resourceaction(){
	}

	// constructor using a formData

	public Resourceaction(ResourceactionFormData formData) {
		mvccVersion = Long.valueOf(formData.mvccVersion);
		resourceActionId = Long.valueOf(formData.resourceActionId);
		name = formData.name;
		actionId = formData.actionId;
		bitwiseValue = Long.valueOf(formData.bitwiseValue);
	}

	public ResourceactionFormData toFormData() {
		if (resourceActionId < 0) {
			resourceActionId = 0L;
		}

		ResourceactionFormData formData = new ResourceactionFormData(
			String.valueOf(mvccVersion)
			,
			String.valueOf(resourceActionId)
			,
			name
			,
			actionId
			,
			String.valueOf(bitwiseValue)
			
		);

		return formData;
	}

}
