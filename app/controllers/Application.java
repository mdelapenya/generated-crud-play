package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

	public static Result uploadSQL() {
		MultipartFormData body = request().body().asMultipartFormData();

		FilePart sqlFile = body.getFile("sqlFile");

		if (sqlFile != null) {
			String fileName = sqlFile.getFilename();
			String contentType = sqlFile.getContentType();

			if (FileValidator.hasExtension(fileName, "sql")) {
				System.out.println("Processing SQL file...");

				return ok(
					"File " + fileName + " uploaded. Content-type: " +
						contentType);
			}

			return badRequest("The file is not an SQL file");
		}

		flash("error", "Missing file");

		return badRequest("The file has not been uploaded");
	}

}
