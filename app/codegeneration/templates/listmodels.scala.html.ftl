@main("Models list") {

	<div class="container">
		<div class="jumbotron">
			<h1>Explore models present in the DB</h1>
			<p class="lead">
				Do you want to turn back to Home? Please click here: <a class="btn btn-danger" href="@routes.Application.index">Home</a>
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
		</div>
	</div>
}