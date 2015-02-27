package controllers.clustergroup;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Clustergroup data form.
 * Requirements:
 * <ul>
 * <li> All fields are public,
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 *
 * @author Manuel de la Peña
 * @generated
 */
public class ClustergroupFormData {

	public String mvccVersion;
	public String clusterGroupId;
	public String name;
	public String clusterNodeIds;
	public String wholeCluster;

	public ClustergroupFormData() {
	}

	public ClustergroupFormData(
		String mvccVersion,
				String clusterGroupId,
				String name,
				String clusterNodeIds,
				String wholeCluster
		) {

		this.mvccVersion = mvccVersion;
		this.clusterGroupId = clusterGroupId;
		this.name = name;
		this.clusterNodeIds = clusterNodeIds;
		this.wholeCluster = wholeCluster;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (clusterGroupId == null || clusterGroupId.length() == 0) {
			errors.add(new ValidationError("clusterGroupId", "No clusterGroupId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
