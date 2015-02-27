<#assign primaryKey = model.primaryKey>
@(${model.name}FormData: Form[controllers.${model.name}.${model.name?cap_first}FormData])

@import helper._

@main("Welcome to GeneratedCRUD application") {

	<fieldset>
		<legend>Edition of ${model.name?cap_first} #@${model.name}FormData("${primaryKey.name}").value</legend>

		@form(routes.${model.name?cap_first}Application.submit(), 'class -> "form-horizontal") {
			@helper.inputText(${model.name}FormData("${primaryKey.name}"), 'readonly -> "readonly")

			<#list model.fields as field>
			<#if primaryKey.name != field.name>
			<!-- ${field.name?cap_first} -->
				<#if field.type == "boolean">
			<div class="checkbox">
			@helper.checkbox(${model.name}FormData("${field.name}"))
				<#else>
			<div class="form-group">
			@helper.inputText(${model.name}FormData("${field.name}"))
				</#if>
			</div>
			</#if>
			</#list>

			<a href="@routes.${model.name?cap_first}Application.all()">Back to ${model.name?cap_first} List</a>
			<button id="submit" name="submit" type="submit" class="btn btn-primary" value="edit">Submit</button>
			<button id="submit" name="submit" type="submit" class="btn btn-primary" value="delete">Delete</button>
		}
	</fieldset>

}
