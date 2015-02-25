package controllers;

import com.avaje.ebean.Ebean;

import controllers.foo.FooFormData;

import models.foo.Foo;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.foo.foo;
import views.html.foo.foos;

import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class FooApplication extends Controller {

	public static Result addFoo() {
		Form<FooFormData> form = Form.form(
			FooFormData.class).fill(new Foo().toFormData());

		return ok(foo.render(form));
	}

	public static Result get(Long id) {
		Foo dbFoo = Foo.find.byId(id);

		Form<FooFormData> form = Form.form(
			FooFormData.class).fill(dbFoo.toFormData());

		return ok(foo.render(form));
	}

	public static Result all() {
		List<Foo> fooList = Foo.find.all();

		return ok(foos.render(fooList));
	}

	public static Result submit() {
		Form<FooFormData> formData = Form.form(
			FooFormData.class).bindFromRequest();

		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addFoo();
		}
		else {
			FooFormData fooFormData = formData.get();

			String id = fooFormData.f1;

			long fooId = 0;

			if (id != null) {
				fooId = Long.valueOf(id);
			}

			Foo foo;

			if (fooId > 0) {
				foo = Foo.find.byId(fooId);

				foo.setF1(Long.valueOf(fooFormData.f1));
				foo.setF2(fooFormData.f2);
			}
			else {
				foo = new Foo(fooFormData);
			}

			Ebean.save(foo);

			flash("success", "Foo instance created/edited: " + foo);

			return all();
		}
	}

}
