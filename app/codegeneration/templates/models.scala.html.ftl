<#assign primaryKey = model.primaryKey>
@(${model.name}s: List[models.${model.name}.${model.name?cap_first}])

@main("Welcome to GeneratedCRUD application") {

	<div class="container">
		<div class="jumbotron">
			<h1>${model.name?cap_first} in the DB</h1>
			<p class="lead">
				What do you want to do with them?
				<a class="btn btn-success" href="@routes.${model.name?cap_first}Application.add${model.name?cap_first}">Create New ${model.name?cap_first}</a>
				<a class="btn btn-warning" href="@routes.Application.models">Back to Models</a>
			</p>
		</div>
		<div class="container">
			<ul>
			@for(${model.name} <- ${model.name}s) {
				<li>
					<div>
						<div>ID: <a href="@routes.${model.name?cap_first}Application.get(${model.name}.${primaryKey.name})">@${model.name}.${primaryKey.name}</a></div>
						<#list model.fields as field>
							<#if primaryKey.name != field.name>
						<div>${field.name?cap_first}: @${model.name}.${field.name}</div>
							</#if>
						</#list>
					</div>
				</li>
			}
			</ul>
		</div>
	</div>
}
