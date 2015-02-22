package controllers;

import models.Task;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.task;
import views.html.tasks;

import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class TaskApplication extends Controller {

	public static Result get(Long id) {
		Task dbTask = Task.find.byId(id);

		return ok(task.render(dbTask));
	}

	public static Result all() {
		List<Task> taskList = Task.find.all();

		return ok(tasks.render(taskList));
	}

}
