@main("Models list") {

	<a href="@routes.Application.index">Exit</a>

	<table id="models">
		<thead>
			<th>Model Name</th>
			<th>Actions</th>
		</thead>
		<tbody>
	<#list models as model>
			<tr>
				<td>
					${model.name?cap_first}
				</td>
				<td>
					<a href="@routes.${model.name?cap_first}Application.all">
						Show ${model.name}s
					</a>
				</td>
			</tr>
	</#list>
		</tbody>
	</table>
}