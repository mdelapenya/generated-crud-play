@main("Models list") {

	<#list models as model>
	${model.name}
	</#list>

}