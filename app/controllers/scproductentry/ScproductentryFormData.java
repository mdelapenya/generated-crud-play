package controllers.scproductentry;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Scproductentry data form.
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
public class ScproductentryFormData {

	public String productEntryId;
	public String groupId;
	public String companyId;
	public String userId;
	public String userName;
	public String createDate;
	public String modifiedDate;
	public String name;
	public String customtype;
	public String tags;
	public String shortDescription;
	public String longDescription;
	public String pageURL;
	public String author;
	public String repoGroupId;
	public String repoArtifactId;

	public ScproductentryFormData() {
	}

	public ScproductentryFormData(
		String productEntryId,
				String groupId,
				String companyId,
				String userId,
				String userName,
				String createDate,
				String modifiedDate,
				String name,
				String customtype,
				String tags,
				String shortDescription,
				String longDescription,
				String pageURL,
				String author,
				String repoGroupId,
				String repoArtifactId
		) {

		this.productEntryId = productEntryId;
		this.groupId = groupId;
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.customtype = customtype;
		this.tags = tags;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.pageURL = pageURL;
		this.author = author;
		this.repoGroupId = repoGroupId;
		this.repoArtifactId = repoArtifactId;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (productEntryId == null || productEntryId.length() == 0) {
			errors.add(new ValidationError("productEntryId", "No productEntryId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
