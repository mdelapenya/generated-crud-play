package controllers.layoutbranch;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Layoutbranch data form.
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
public class LayoutbranchFormData {

	public String mvccVersion;
	public String layoutBranchId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String layoutSetBranchId;
	public String plid;
	public String name;
	public String description;
	public String master;

	public LayoutbranchFormData() {
	}

	public LayoutbranchFormData(
		String mvccVersion,
				String layoutBranchId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String layoutSetBranchId,
				String plid,
				String name,
				String description,
				String master
		) {

		this.mvccVersion = mvccVersion;
		this.layoutBranchId = layoutBranchId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.layoutSetBranchId = layoutSetBranchId;
		this.plid = plid;
		this.name = name;
		this.description = description;
		this.master = master;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (layoutBranchId == null || layoutBranchId.length() == 0) {
			errors.add(new ValidationError("layoutBranchId", "No layoutBranchId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
