package controllers.shard;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the Shard data form.
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
public class ShardFormData {

	public String mvccVersion;
	public String shardId;
	public String classNameId;
	public String classPK;
	public String name;

	public ShardFormData() {
	}

	public ShardFormData(
		String mvccVersion,
				String shardId,
				String classNameId,
				String classPK,
				String name
		) {

		this.mvccVersion = mvccVersion;
		this.shardId = shardId;
		this.classNameId = classNameId;
		this.classPK = classPK;
		this.name = name;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		if (shardId == null || shardId.length() == 0) {
			errors.add(new ValidationError("shardId", "No shardId was given."));
		}

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
