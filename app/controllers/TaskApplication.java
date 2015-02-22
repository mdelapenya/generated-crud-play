package controllers;

import models.Task;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.task.task;
import views.html.task.tasks;

import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class TaskApplication extends Controller {

	public static Result addTask() {
		return ok(task.render(new Task()));
	}

	public static Result get(Long id) {
		Task dbTask = Task.find.byId(id);

		return ok(task.render(dbTask));
	}

	public static Result all() {
		List<Task> taskList = Task.find.all();

		return ok(tasks.render(taskList));
	}

}
