@(${model.name}s: List[${model.name?cap_first}])

@main("Welcome to GeneratedCRUD application") {

	<h1>${model.name?cap_first}s in the DB</h1>

	<p>
		<a href="@routes.${model.name?cap_first}Application.add${model.name?cap_first}">Create New ${model.name?cap_first}</a>
	</p>

	<ul>
	@for(${model.name} <- ${model.name}s) {
		<li>
			<div>
				<div>ID: <a href="@routes.${model.name?cap_first}Application.get(${model.name}.${model.primaryKey})">@${model.name}.${model.primaryKey}</a></div>
				<#list model.fields as field>
					<div>${field.name?cap_first}: @${model.name}.${field.name}</div>
				</#list>
			</div>
		</li>
	}
	</ul>

}
