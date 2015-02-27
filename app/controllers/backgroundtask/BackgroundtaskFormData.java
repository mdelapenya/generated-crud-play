package controllers.backgroundtask;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Backgroundtask data form.
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
public class BackgroundtaskFormData {

	public String mvccVersion;
	public String backgroundTaskId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String servletContextNames;
	public String taskExecutorClassName;
	public String taskContextMap;
	public String completed;
	public String completionDate;
	public String status;
	public String statusMessage;

	public BackgroundtaskFormData() {
	}

	public BackgroundtaskFormData(
		String mvccVersion,
				String backgroundTaskId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String servletContextNames,
				String taskExecutorClassName,
				String taskContextMap,
				String completed,
				String completionDate,
				String status,
				String statusMessage
		) {

		this.mvccVersion = mvccVersion;
		this.backgroundTaskId = backgroundTaskId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.servletContextNames = servletContextNames;
		this.taskExecutorClassName = taskExecutorClassName;
		this.taskContextMap = taskContextMap;
		this.completed = completed;
		this.completionDate = completionDate;
		this.status = status;
		this.statusMessage = statusMessage;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (backgroundTaskId == null || backgroundTaskId.length() == 0) {
			errors.add(new ValidationError("backgroundTaskId", "No backgroundTaskId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
