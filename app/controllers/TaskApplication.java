package controllers;

import com.avaje.ebean.Ebean;

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

	public static Result submit() {
		Form<TaskFormData> formData = Form.form(
			TaskFormData.class).bindFromRequest();

		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addTask();
		}
		else {
			TaskFormData taskFormData = formData.get();

			String id = taskFormData.id;

			long taskId = 0;

			if (id != null) {
				taskId = Long.valueOf(id);
			}

			Task task;

			if (taskId > 0) {
				task = Task.find.byId(taskId);

				task.setName(taskFormData.name);
				task.setStreet(taskFormData.street);
			}
			else {
				task = new Task(taskFormData);
			}

			Ebean.save(task);

			flash("success", "Task instance created/edited: " + task);

			return all();
		}
	}

}
