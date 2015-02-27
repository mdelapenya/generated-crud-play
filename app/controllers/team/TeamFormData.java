package controllers.team;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Team data form.
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
public class TeamFormData {

	public String mvccVersion;
	public String teamId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String groupId;
	public String name;
	public String description;

	public TeamFormData() {
	}

	public TeamFormData(
		String mvccVersion,
				String teamId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String groupId,
				String name,
				String description
		) {

		this.mvccVersion = mvccVersion;
		this.teamId = teamId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.groupId = groupId;
		this.name = name;
		this.description = description;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (teamId == null || teamId.length() == 0) {
			errors.add(new ValidationError("teamId", "No teamId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
