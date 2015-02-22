package controllers;

import com.avaje.ebean.Ebean;

import models.Task;

import play.*;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
		Task task = new Task();
		task.setName("test");
		task.setStreet("c/ San Nicolás 23");

		// will insert
		Ebean.save(task);

		task.setName("changed");

		// this will update
		Ebean.save(task);

		// find the inserted entity by its id
		Task task2 = Ebean.find(Task.class, task.getId());
		System.out.println("Got " + task2.getName());

		// delete
		//Ebean.delete(task);

		// Find all tasks
		List<Task> tasks = Task.find.all();

		int count = tasks.size();

		// Find a task by ID
		Task anyTask = Task.find.byId(34L);

		// More complex task query
		tasks = Task.find.where()
			.ilike("name", "%coco%")
			.orderBy("dueDate asc")
			.findPagingList(25)
			.setFetchAhead(false)
			.getPage(1)
			.getList();

		return ok(index.render("There are " + count + " tasks on DB."));
    }

}
