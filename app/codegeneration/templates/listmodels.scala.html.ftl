@main("Models list") {

	<ul>
	<#list models as model>
		<li>
			${model.name?cap_first}
			(<a href="@routes.${model.name?cap_first}Application.all">
				Show ${model.name}s
			</a>)
		</li>
	</#list>
	</ul>
}