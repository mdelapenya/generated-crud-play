package codegeneration;

import codegeneration.db.Model;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public class FreemarkerEngine {

	public FreemarkerEngine() throws IOException, URISyntaxException {
		_init();
	}

	public void generateModels(List<Model> models)
		throws IOException, TemplateException {

		generateModels(models, new OutputStreamWriter(System.out));
	}

	public void generateModels(List<Model> models, Writer out)
		throws IOException, TemplateException {

		for (Model model : models) {
			_generateApplicationTemplate(model, out);
		}
	}

	private void _generateApplicationTemplate(Model model, Writer out)
		throws IOException, TemplateException {

		// Create data-model

		Map<String, Object> root = new HashMap<>();

		root.put("model", model);

		// get the template

		Template temp = _cfg.getTemplate("application.ftl");

		// merge the template with the data-model

		temp.process(root, out);
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

	private Configuration _cfg;

}
