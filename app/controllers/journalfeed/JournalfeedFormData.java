package controllers.journalfeed;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Journalfeed data form.
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
public class JournalfeedFormData {

	public String uuid;
	public String id;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String feedId;
	public String name;
	public String description;
	public String DDMStructureKey;
	public String DDMTemplateKey;
	public String DDMRendererTemplateKey;
	public String delta;
	public String orderByCol;
	public String orderByType;
	public String targetLayoutFriendlyUrl;
	public String targetPortletId;
	public String contentField;
	public String feedFormat;
	public String feedVersion;

	public JournalfeedFormData() {
	}

	public JournalfeedFormData(
		String uuid,
				String id,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String feedId,
				String name,
				String description,
				String DDMStructureKey,
				String DDMTemplateKey,
				String DDMRendererTemplateKey,
				String delta,
				String orderByCol,
				String orderByType,
				String targetLayoutFriendlyUrl,
				String targetPortletId,
				String contentField,
				String feedFormat,
				String feedVersion
		) {

		this.uuid = uuid;
		this.id = id;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.feedId = feedId;
		this.name = name;
		this.description = description;
		this.DDMStructureKey = DDMStructureKey;
		this.DDMTemplateKey = DDMTemplateKey;
		this.DDMRendererTemplateKey = DDMRendererTemplateKey;
		this.delta = delta;
		this.orderByCol = orderByCol;
		this.orderByType = orderByType;
		this.targetLayoutFriendlyUrl = targetLayoutFriendlyUrl;
		this.targetPortletId = targetPortletId;
		this.contentField = contentField;
		this.feedFormat = feedFormat;
		this.feedVersion = feedVersion;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (id == null || id.length() == 0) {
			errors.add(new ValidationError("id", "No id was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
