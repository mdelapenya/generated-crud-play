package controllers.mbcategory;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Mbcategory data form.
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
public class MbcategoryFormData {

	public String uuid;
	public String categoryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String parentCategoryId;
	public String name;
	public String description;
	public String displayStyle;
	public String threadCount;
	public String messageCount;
	public String lastPostDate;
	public String status;
	public String statusByUserId;
	public String statusByUserName;
	public String statusDate;

	public MbcategoryFormData() {
	}

	public MbcategoryFormData(
		String uuid,
				String categoryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String parentCategoryId,
				String name,
				String description,
				String displayStyle,
				String threadCount,
				String messageCount,
				String lastPostDate,
				String status,
				String statusByUserId,
				String statusByUserName,
				String statusDate
		) {

		this.uuid = uuid;
		this.categoryId = categoryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentCategoryId = parentCategoryId;
		this.name = name;
		this.description = description;
		this.displayStyle = displayStyle;
		this.threadCount = threadCount;
		this.messageCount = messageCount;
		this.lastPostDate = lastPostDate;
		this.status = status;
		this.statusByUserId = statusByUserId;
		this.statusByUserName = statusByUserName;
		this.statusDate = statusDate;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (categoryId == null || categoryId.length() == 0) {
			errors.add(new ValidationError("categoryId", "No categoryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
