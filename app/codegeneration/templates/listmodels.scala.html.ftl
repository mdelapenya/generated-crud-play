@main("Models list") {

	<div class="container">
		<div class="jumbotron">
			<h1>Explore models present in the DB</h1>
			<p class="lead">
				Do you want to turn back to Home? Please click here: <a class="btn btn-danger" href="@routes.Application.index">Home</a>
			</p>
			<p id="models-tags" style="font-size:12px">
				<#list models as model>
				<a href="#${model.name?cap_first}">${model.name?cap_first}</a>&nbsp;
				</#list>
			</p>
		</div>
		<div class="container">
			<table class="table table-bordered table-hover">
				<thead>
					<th>#</th>
					<th>Model Name</th>
					<th>Actions</th>
				</thead>
				<tbody>
			<#list models as model>
					<tr>
						<td><a name="${model.name?cap_first}">${model_index + 1}</a></td>
						<td>
							${model.name?cap_first}
						</td>
						<td>
							<a class="btn btn-info" href="@routes.${model.name?cap_first}Application.all">
								Show
							</a>
						</td>
					</tr>
			</#list>
				</tbody>
			</table>
		</div>
	</div>
}