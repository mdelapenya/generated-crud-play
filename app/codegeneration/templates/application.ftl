<#assign primaryKey = model.primaryKey>

package controllers;

import com.avaje.ebean.Ebean;

import controllers.${model.name}.${model.name?cap_first}FormData;

import models.${model.name}.${model.name?cap_first};

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.${model.name}.${model.name};
import views.html.${model.name}.${model.name}s;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ${model.name?cap_first}Application extends Controller {

	public static Result add${model.name?cap_first}() {
		Form<${model.name?cap_first}FormData> form = Form.form(
			${model.name?cap_first}FormData.class).fill(new ${model.name?cap_first}().toFormData());

		return ok(${model.name}.render(form));
	}

	public static Result get(Long id) {
		${model.name?cap_first} db${model.name?cap_first} = ${model.name?cap_first}.find.byId(id);

		Form<${model.name?cap_first}FormData> form = Form.form(
			${model.name?cap_first}FormData.class).fill(db${model.name?cap_first}.toFormData());

		return ok(${model.name}.render(form));
	}

	public static Result all() {
		List<${model.name?cap_first}> ${model.name}List = ${model.name?cap_first}.find.all();

		return ok(${model.name}s.render(${model.name}List));
	}

	public static Result submit() {
		Form<${model.name?cap_first}FormData> formData = Form.form(
			${model.name?cap_first}FormData.class).bindFromRequest();

		String[] postSubmit = request().body().asFormUrlEncoded().get("submit");

		if (postSubmit == null || postSubmit.length == 0) {
			return badRequest("You must provide a valid action");
		}
		else {
			String action = postSubmit[0];

			if ("edit".equals(action)) {
				return edit(formData);
			}
			else if ("delete".equals(action)) {
				return delete(formData);
			}
			else {
				return badRequest("This action is not allowed");
			}
		}
	}

	public static Result edit(Form<${model.name?cap_first}FormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return add${model.name?cap_first}();
		}
		else {
			${model.name?cap_first}FormData ${model.name}FormData = formData.get();

			String id = ${model.name}FormData.${primaryKey.name};

			long ${model.name}Id = 0;

			if (id != null) {
				${model.name}Id = Long.valueOf(id);
			}

			${model.name?cap_first} ${model.name};

			if (${model.name}Id > 0) {
				${model.name} = ${model.name?cap_first}.find.byId(${model.name}Id);

			<#list model.fields as field>
				<#if field.type == "long">
				${model.name}.set${field.name?cap_first}(Long.valueOf(${model.name}FormData.${field.name}));
				<#elseif field.type == "int">
				${model.name}.set${field.name?cap_first}(Integer.valueOf(${model.name}FormData.${field.name}));
				<#elseif field.type == "boolean">
				${model.name}.set${field.name?cap_first}(Boolean.valueOf(${model.name}FormData.${field.name}));
				<#elseif field.type == "double">
				${model.name}.set${field.name?cap_first}(Double.valueOf(${model.name}FormData.${field.name}));
				<#elseif field.type == "Date">
				${model.name}.set${field.name?cap_first}(new Date(${model.name}FormData.${field.name}));
				<#else>
				${model.name}.set${field.name?cap_first}(${model.name}FormData.${field.name});
				</#if>
			</#list>
			}
			else {
				${model.name} = new ${model.name?cap_first}(${model.name}FormData);
			}

			Ebean.save(${model.name});

			flash("success", "${model.name?cap_first} instance created/edited: " + ${model.name});

			return all();
		}
	}

	public static Result delete(Form<${model.name?cap_first}FormData> formData) {
		${model.name?cap_first}FormData ${model.name}FormData = formData.get();

		String id = ${model.name}FormData.${primaryKey.name};

		long ${model.name}Id = 0;

		if (id != null) {
			${model.name}Id = Long.valueOf(id);
		}

		${model.name?cap_first} ${model.name};

		if (${model.name}Id > 0) {
			${model.name} = ${model.name?cap_first}.find.byId(${model.name}Id);

			Ebean.delete(${model.name});
		}
		else {
			flash("error", "Cannot delete ${model.name?cap_first}");
		}

		return all();
	}

}
