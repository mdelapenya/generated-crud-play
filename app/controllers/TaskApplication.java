package controllers;

import controllers.task.TaskFormData;

import models.Task;

import play.data.Form;

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
		Form<TaskFormData> form = Form.form(
			TaskFormData.class).fill(new Task().toFormData());

		return ok(task.render(form));
	}

	public static Result get(Long id) {
		Task dbTask = Task.find.byId(id);

		Form<TaskFormData> form = Form.form(
			TaskFormData.class).fill(dbTask.toFormData());

		return ok(task.render(form));
	}

	public static Result all() {
		List<Task> taskList = Task.find.all();

		return ok(tasks.render(taskList));
	}

}
