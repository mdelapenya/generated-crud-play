@(${model.name}FormData: Form[controllers.${model.name}.${model.name?cap_first}FormData])

@import helper._

@main("Welcome to GeneratedCRUD application") {

	<fieldset>
		<legend>Edition of ${model.name?cap_first} #@${model.name}FormData("${model.primaryKey}").value</legend>

		@form(routes.${model.name?cap_first}Application.submit(), 'class -> "form-horizontal") {
			@helper.inputText(${model.name}FormData("${model.primaryKey}"), 'readonly -> "readonly")

			<#list model.fields as field>
			<!-- ${field.name?cap_first} -->
			@helper.inputText(${model.name}FormData("${field.name}"))
			</#list>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="@routes.${model.name?cap_first}Application.all()">Back to ${model.name?cap_first} List</a>
					<button id="submit" type="submit" value="Submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		}
	</fieldset>

}
