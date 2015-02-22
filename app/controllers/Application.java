package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
		String error = flash("error");

        return ok(index.render("Welcome to GeneratedCRUD application", error));
    }

	public static Result uploadSQL() {
		MultipartFormData body = request().body().asMultipartFormData();

		FilePart sqlFile = body.getFile("sqlFile");

		if (sqlFile != null) {
			String fileName = sqlFile.getFilename();
			String contentType = sqlFile.getContentType();

			if (FileValidator.hasSQLExtension(fileName)) {
				System.out.println("Processing SQL file...");

				return controllers.TaskApplication.all();
			}

			flash("error", fileName + " is not a valid SQL file.");

			return index();
		}

		flash("error", "Please select a valid SQL file");

		return index();
	}

}
