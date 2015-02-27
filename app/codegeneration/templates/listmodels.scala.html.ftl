@main("Models list") {

	<a href="@routes.Application.index">Exit</a>

	<table class="table table-bordered table-hover">
		<thead>
			<th>#</th>
			<th>Model Name</th>
			<th>Actions</th>
		</thead>
		<tbody>
	<#list models as model>
			<tr>
				<td>${model_index + 1}</td>
				<td>
					${model.name?cap_first}
				</td>
				<td>
					<a href="@routes.${model.name?cap_first}Application.all">
						Show
					</a>
				</td>
			</tr>
	</#list>
		</tbody>
	</table>
}