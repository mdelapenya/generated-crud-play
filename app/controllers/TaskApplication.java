package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.tasks;

/**
 * @author Manuel de la Peña
 */
public class TaskApplication extends Controller {

	public static Result all() {
		return ok(tasks.render("All tasks found."));
	}

}
