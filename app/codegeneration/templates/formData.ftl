package controllers.${model.name};

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for the ${model.name?cap_first} data form.
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
public class ${model.name?cap_first}FormData {

	<#list model.fields as field>
	public String ${field.name};
	</#list>

	public ${model.name?cap_first}FormData() {
	}

	public ${model.name?cap_first}FormData(
		<#list model.fields as field>
		String ${field.name}<#if field_has_next>,</#if>
		</#list>) {

		<#list model.fields as field>
		this.${field.name} = ${field.name};
		</#list>
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();

		<#list model.fields as field>
			<#if field.isRequired>
		if (${field.name} == null || ${field.name}.length() == 0) {
			errors.add(new ValidationError("${field.name}", "No ${field.name} was given."));
		}
			</#if>
		</#list>

		if(errors.size() > 0) {
			return errors;
		}

		return null;
	}

}
