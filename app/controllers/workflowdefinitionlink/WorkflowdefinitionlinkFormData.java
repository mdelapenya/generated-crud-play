package controllers.workflowdefinitionlink;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Workflowdefinitionlink data form.
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
public class WorkflowdefinitionlinkFormData {

	public String mvccVersion;
	public String workflowDefinitionLinkId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String classNameId;
	public String classPK;
	public String typePK;
	public String workflowDefinitionName;
	public String workflowDefinitionVersion;

	public WorkflowdefinitionlinkFormData() {
	}

	public WorkflowdefinitionlinkFormData(
		String mvccVersion,
				String workflowDefinitionLinkId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String classNameId,
				String classPK,
				String typePK,
				String workflowDefinitionName,
				String workflowDefinitionVersion
		) {

		this.mvccVersion = mvccVersion;
		this.workflowDefinitionLinkId = workflowDefinitionLinkId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.typePK = typePK;
		this.workflowDefinitionName = workflowDefinitionName;
		this.workflowDefinitionVersion = workflowDefinitionVersion;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (workflowDefinitionLinkId == null || workflowDefinitionLinkId.length() == 0) {
			errors.add(new ValidationError("workflowDefinitionLinkId", "No workflowDefinitionLinkId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
