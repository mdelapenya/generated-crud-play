<#assign primaryKey = model.primaryKey>
@(${model.name}FormData: Form[controllers.${model.name}.${model.name?cap_first}FormData])

@import helper._
@import helper.twitterBootstrap._

@main("Welcome to GeneratedCRUD application") {

	<div class="container">
		@form(routes.${model.name?cap_first}Application.submit(), 'class -> "form-horizontal") {
			<div class="jumbotron">
				@if(${model.name}FormData("${primaryKey.name}").value != "0") {
				<h1>Edition of ${model.name?cap_first} #@${model.name}FormData("${primaryKey.name}").value</h1>
				} else {
				<h1>Creation of a ${model.name?cap_first}</h1>
				}
				<p class="lead">
					What do you want to do with them?
					@if(${model.name}FormData("${primaryKey.name}").value != "0") {
					<button id="submit" name="submit" type="submit" class="btn btn-danger" value="delete">Delete</button>
					}
					<a class="btn btn-warning" href="@routes.${model.name?cap_first}Application.all()">Back to ${model.name?cap_first}s</a>
				</p>
			</div>
			<div class="container">
				<input type="hidden" id="${primaryKey.name}" name="${primaryKey.name}" value='@${model.name}FormData("${primaryKey.name}").value' />

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

				<button id="submit" name="submit" type="submit" class="btn btn-success" value="edit">Submit</button>
			</div>
		}
	</div>
}
