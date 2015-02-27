package controllers.workflowinstancelink;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Workflowinstancelink data form.
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
public class WorkflowinstancelinkFormData {

	public String mvccVersion;
	public String workflowInstanceLinkId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String workflowInstanceId;

	public WorkflowinstancelinkFormData() {
	}

	public WorkflowinstancelinkFormData(
		String mvccVersion,
				String workflowInstanceLinkId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String workflowInstanceId
		) {

		this.mvccVersion = mvccVersion;
		this.workflowInstanceLinkId = workflowInstanceLinkId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.workflowInstanceId = workflowInstanceId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (workflowInstanceLinkId == null || workflowInstanceLinkId.length() == 0) {
			errors.add(new ValidationError("workflowInstanceLinkId", "No workflowInstanceLinkId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
