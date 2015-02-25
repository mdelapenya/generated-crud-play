package controllers;

import com.avaje.ebean.Ebean;

import controllers.${model.name}.${model.name?cap_first}FormData;

import models.${model.name}.${model.name?cap_first};

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.${model.name}.${model.name};
import views.html.${model.name}.${model.name}s;

import java.util.List;

/**
 * @author Manuel de la Peña
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

		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return add${model.name?cap_first}();
		}
		else {
			${model.name?cap_first}FormData ${model.name}FormData = formData.get();

			String id = ${model.name}FormData.${model.primaryKey};

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

}
