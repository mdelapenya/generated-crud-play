<#assign primaryKey = model.primaryKey>
@(${model.name}FormData: Form[controllers.${model.name}.${model.name?cap_first}FormData])

@import helper._

@main("Welcome to GeneratedCRUD application") {

	<div class="container">
		@form(routes.${model.name?cap_first}Application.submit(), 'class -> "form-horizontal") {
			<div class="jumbotron">
				<h1>Edition of ${model.name?cap_first} #@${model.name}FormData("${primaryKey.name}").value</h1>
				<p class="lead">
					What do you want to do with them?
					<button id="submit" name="submit" type="submit" class="btn btn-primary" value="delete">Delete</button>
					<a href="@routes.${model.name?cap_first}Application.all()">Back to ${model.name?cap_first}s</a>
				</p>
			</div>
			<div class="container">
				@helper.inputText(${model.name}FormData("${primaryKey.name}"), 'readonly -> "readonly")

				<#list model.fields as field>
				<#if primaryKey.name != field.name>
				<!-- ${field.name?cap_first} -->
				<div class="form-group">
					<#if field.type == "boolean">
				@helper.checkbox(${model.name}FormData("${field.name}"))
					<#else>
				@helper.inputText(${model.name}FormData("${field.name}"))
					</#if>
				</div>
				</#if>
				</#list>

				<button id="submit" name="submit" type="submit" class="btn btn-primary" value="edit">Submit</button>
			</div>
		}
	</div>
}
