<#assign primaryKey = model.primaryKey>

package models.${model.name};

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.${model.name}.${model.name?cap_first}FormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class ${model.name?cap_first} extends Model {

	// model attributes

	<#list model.fields as field>
		<#if field.primaryKey>
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
		</#if>
		<#if field.required && !field.primaryKey>
	@Constraints.Required
		</#if>
		<#if field.hasMaxLength()>
	@Constraints.MaxLength(#{field.maxLength})
		</#if>
		<#if field.hasMinLength()>
	@Constraints.Min(#{field.minLength})
		</#if>
		<#if field.type == "Date">
	@Formats.DateTime(pattern="dd/MM/yyyy")
		</#if>
	public ${field.type} ${field.name};

	</#list>

	// model finder attribute

	public static Finder<Long,${model.name?cap_first}> find = new Finder<Long,${model.name?cap_first}>(
		Long.class, ${model.name?cap_first}.class
	);

	// getters and setters

	<#list model.fields as field>
	public ${field.type} get${field.name?cap_first}() {
		return ${field.name};
	}

	public void set${field.name?cap_first}(${field.type} ${field.name}) {
		this.${field.name} = ${field.name};
	}
	</#list>

	public ${model.name?cap_first}(){
	}

	// constructor using a formData

	public ${model.name?cap_first}(${model.name?cap_first}FormData formData) {
		<#list model.fields as field>
			<#if field.type == "String">
		${field.name} = formData.${field.name};
			<#elseif field.type == "int">
		${field.name} = Integer.valueOf(formData.${field.name});
			<#elseif field.type != "Date">
		${field.name} = ${field.typeUppercase}.valueOf(formData.${field.name});
			<#else>
		${field.name} = new Date(formData.${field.name});
			</#if>
		</#list>
	}

	public ${model.name?cap_first}FormData toFormData() {
		<#if model.primaryKey.type == "String">
		if (${primaryKey.name} == null || ${primaryKey.name}.equals("")) {
			${primaryKey.name} = "0";
		}
		<#else>
		if (${primaryKey.name} < 0) {
			${primaryKey.name} = 0L;
		}
		</#if>

		${model.name?cap_first}FormData formData = new ${model.name?cap_first}FormData(
			<#list model.fields as field>
				<#if field.type != "String">
			String.valueOf(${field.name})
				<#else>
			${field.name}
				</#if>
			<#if field_has_next>,</#if>
			</#list>
		);

		return formData;
	}

}
