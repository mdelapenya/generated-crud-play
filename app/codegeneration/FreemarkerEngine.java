package codegeneration;

import codegeneration.db.Field;
import codegeneration.db.Model;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public class FreemarkerEngine {

	public static void main(String[] args) {
		try {
			FreemarkerEngine engine = new FreemarkerEngine();

			engine.generateModels(_models());
		}
		catch (Exception e) {
			System.exit(1);
		}
	}

	public FreemarkerEngine() throws IOException, URISyntaxException {
		_init();
	}

	public void generateModels(List<Model> models)
		throws IOException, TemplateException {

		_generateModelsList(models);
		_generateRoutes(models);

		for (Model model : models) {
			_generateApplicationTemplate(model);

			_generateFormData(model);

			_generateModel(model);

			_generateModelView(model);
			_generateModelsView(model);
		}
	}

	private String _capitalize(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}

	private void _generateApplicationTemplate(Model model)
		throws IOException, TemplateException {

		String targetFileName = _capitalize(model.name) + "Application.java";

		File file = _initializeGeneratedFile(
			"app", "controllers", null, targetFileName);

		_generateTemplateFromModel(
			"application.ftl", model, new FileWriter(file));
	}

	private void _generateFormData(Model model)
		throws IOException, TemplateException {

		String targetFileName = _capitalize(model.name) + "FormData.java";

		File file = _initializeGeneratedFile(
			"app", "controllers", model.name, targetFileName);

		_generateTemplateFromModel(
			"formData.ftl", model,  new FileWriter(file));
	}

	private void _generateModel(Model model)
		throws IOException, TemplateException {

		String targetFileName = _capitalize(model.name) + ".java";

		File file = _initializeGeneratedFile(
			"app", "models", model.name, targetFileName);

		_generateTemplateFromModel("model.ftl", model, new FileWriter(file));
	}

	private void _generateModelsList(List<Model> models)
		throws IOException, TemplateException {

		File file = _initializeGeneratedFile(
			"app", "views", null, "listmodels.scala.html");

		_generateTemplateFromModels(
			"listmodels.scala.html.ftl", models, new FileWriter(file));
	}

	private void _generateModelsView(Model model)
		throws IOException, TemplateException {

		String targetFileName = model.name + "s.scala.html";

		File file = _initializeGeneratedFile(
			"app", "views", model.name, targetFileName);

		_generateTemplateFromModel(
			"models.scala.html.ftl", model, new FileWriter(file));
	}

	private void _generateModelView(Model model)
		throws IOException, TemplateException {

		String targetFileName = model.name + ".scala.html";

		File file = _initializeGeneratedFile(
			"app", "views", model.name, targetFileName);

		_generateTemplateFromModel(
			"model.scala.html.ftl", model, new FileWriter(file));
	}

	private void _generateTemplateFromModel(String templateName, Model model)
		throws IOException, TemplateException {

		_generateTemplateFromModel(
			templateName, model, new OutputStreamWriter(System.out));
	}

	private void _generateTemplateFromModels(
			String templateName, List<Model> models, Writer out)
		throws IOException, TemplateException {

		// Create data-model

		Map<String, Object> root = new HashMap<>();

		root.put("models", models);

		// get the template

		Template temp = _cfg.getTemplate(templateName);

		// merge the template with the data-model

		temp.process(root, out);
	}

	private void _generateTemplateFromModel(
			String templateName, Model model, Writer out)
		throws IOException, TemplateException {

		// Create data-model

		Map<String, Object> root = new HashMap<>();

		root.put("model", model);

		// get the template

		Template temp = _cfg.getTemplate(templateName);

		// merge the template with the data-model

		temp.process(root, out);
	}

	private void _generateRoutes(List<Model> models)
		throws IOException, TemplateException {

		File file = _initializeGeneratedFile("conf", null, null, "routes");

		_generateTemplateFromModels("routes.ftl", models, new FileWriter(file));
	}

	private void _init() throws IOException, URISyntaxException {
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.21) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.

		_cfg = new Configuration(Configuration.VERSION_2_3_21);

		// Specify the source where the template files come from. Here I set a
		// plain directory for it, but non-file-system sources are possible too:

		URL url = this.getClass().getResource("/codegeneration/templates");

		_cfg.setDirectoryForTemplateLoading(
			new File(url.toURI()));

		// Set the preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		_cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During development TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.

		_cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	private File _initializeGeneratedFile(
			String moduleName, String packageName, String modelName,
			String targetFileName)
		throws IOException {

		URL classesUrl = FreemarkerEngine.class.getResource("/");

		String classes = classesUrl.toString();

		String filePreffix = "file:";
		String generatedcrud = "generatedcrud";

		int filePreffixPos = classes.indexOf(filePreffix);
		int generatedCRUDPos = classes.indexOf(generatedcrud);

		String basePath = classes.substring(
			filePreffixPos + filePreffix.length(),
			generatedCRUDPos + generatedcrud.length());

		String filePathPreffix = basePath + "/" + moduleName;

		if (packageName != null && !packageName.equals("")) {
			filePathPreffix += "/" + packageName;
		}

		if (modelName != null && !modelName.equals("")) {
			filePathPreffix += "/" + modelName;
		}

		filePathPreffix += "/";

		File file = new File(filePathPreffix + targetFileName);

		file.getParentFile().mkdirs();
		file.createNewFile();

		return file;
	}

	private static List<Model> _models() {
		List<Model> models = new ArrayList<>();

		Model model = new Model();

		model.name = "foo";

		List<Field> fields = new ArrayList<>();

		Field f1 = new Field();

		f1.maxLength = 0;
		f1.minLength = 0;
		f1.isPrimaryKey = true;
		f1.isRequired = true;
		f1.name = "id";
		f1.type = "long";
		f1.typeUppercase = "Long";

		fields.add(f1);

		model.primaryKey = f1;

		Field f2 = new Field();

		f2.maxLength = 35;
		f2.minLength = 0;
		f2.isPrimaryKey = false;
		f2.isRequired = true;
		f2.name = "f2";
		f2.type = "String";
		f2.typeUppercase = "String";

		fields.add(f2);

		model.fields = fields;

		models.add(model);

		// another model

		model = new Model();

		model.name = "bar";

		fields = new ArrayList<>();

		Field campo1 = new Field();

		campo1.maxLength = 0;
		campo1.minLength = 0;
		campo1.isPrimaryKey = true;
		campo1.isRequired = true;
		campo1.name = "id";
		campo1.type = "long";
		campo1.typeUppercase = "Long";

		fields.add(campo1);

		model.primaryKey = campo1;

		Field campo2 = new Field();

		campo2.maxLength = 35;
		campo2.minLength = 0;
		campo2.isPrimaryKey = false;
		campo2.isRequired = true;
		campo2.name = "campo2";
		campo2.type = "String";
		campo2.typeUppercase = "String";

		fields.add(campo2);

		model.fields = fields;

		models.add(model);

		return models;
	}

	private Configuration _cfg;

}
