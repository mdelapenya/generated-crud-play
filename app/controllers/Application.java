package controllers;

import codegeneration.FreemarkerEngine;
import codegeneration.db.Model;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import util.SQLParser;
import util.FileValidator;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
		String error = flash("error");

        return ok(index.render("Welcome to GeneratedCRUD application", error));
    }

	public static Result models() {
		return ok(listmodels.render());
	}

	public static Result uploadSQL()
		throws IOException, URISyntaxException, TemplateException {

		MultipartFormData body = request().body().asMultipartFormData();

		FilePart sqlFile = body.getFile("sqlFile");

		if (sqlFile != null) {
			String fileName = sqlFile.getFilename();
			String contentType = sqlFile.getContentType();

			if (FileValidator.hasSQLExtension(fileName)) {
				System.out.println("Processing SQL file...");

				List<String> sqls = FileUtils.readLines(sqlFile.getFile());

				List<Model> models = SQLParser.parse(sqls);

				FreemarkerEngine freemarkerEngine = new FreemarkerEngine();

				freemarkerEngine.generateModels(models);

				// wait for Play compile process

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				}

				return models();
			}

			flash("error", fileName + " is not a valid SQL file.");

			return index();
		}

		flash("error", "Please select a valid SQL file");

		return index();
	}

}
