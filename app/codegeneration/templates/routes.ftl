# Routes
# This file defines all application routes (Higher priority routes first)
# ~~~~

# Home page
GET / controllers.Application.index()

# Map static resources from the /public folder to the /assets URL path
GET /assets/*file controllers.Assets.at(path="/public", file)

# Upload SQL file
POST /upload controllers.Application.uploadSQL

##
## Model routes
##
<#list models as model>

# ${model.name?cap_first}

# View a ${model.name}
GET /${model.name}s/:id controllers.${model.name?cap_first}Application.get(id: Long)

# Go to the create ${model.name} view
GET /${model.name}/add controllers.${model.name?cap_first}Application.add${model.name?cap_first}

# Display all ${model.name}s
GET /${model.name}s controllers.${model.name?cap_first}Application.all

# Save a ${model.name}
POST /${model.name}/submit controllers.${model.name?cap_first}Application.submit()
</#list>