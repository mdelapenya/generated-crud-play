
package controllers;

import com.avaje.ebean.Ebean;

import controllers.shard.ShardFormData;

import models.shard.Shard;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.shard.shard;
import views.html.shard.shards;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class ShardApplication extends Controller {

	public static Result addShard() {
		Form<ShardFormData> form = Form.form(
			ShardFormData.class).fill(new Shard().toFormData());

		return ok(shard.render(form));
	}

	public static Result get(Long id) {
		Shard dbShard = Shard.find.byId(id);

		Form<ShardFormData> form = Form.form(
			ShardFormData.class).fill(dbShard.toFormData());

		return ok(shard.render(form));
	}

	public static Result all() {
		List<Shard> shardList = Shard.find.all();

		return ok(shards.render(shardList));
	}

	public static Result submit() {
		Form<ShardFormData> formData = Form.form(
			ShardFormData.class).bindFromRequest();

		String[] postSubmit = request().body().asFormUrlEncoded().get("submit");

		if (postSubmit == null || postSubmit.length == 0) {
			return badRequest("You must provide a valid action");
		}
		else {
			String action = postSubmit[0];

			if ("edit".equals(action)) {
				return edit(formData);
			}
			else if ("delete".equals(action)) {
				return delete(formData);
			}
			else {
				return badRequest("This action is not allowed");
			}
		}
	}

	public static Result edit(Form<ShardFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addShard();
		}
		else {
			ShardFormData shardFormData = formData.get();

			String id = shardFormData.shardId;

			long shardId = 0;

			if (id != null) {
				shardId = Long.valueOf(id);
			}

			Shard shard;

			if (shardId > 0) {
				shard = Shard.find.byId(shardId);

				shard.setMvccVersion(Long.valueOf(shardFormData.mvccVersion));
				shard.setShardId(Long.valueOf(shardFormData.shardId));
				shard.setClassNameId(Long.valueOf(shardFormData.classNameId));
				shard.setClassPK(Long.valueOf(shardFormData.classPK));
				shard.setName(shardFormData.name);
			}
			else {
				shard = new Shard(shardFormData);
			}

			Ebean.save(shard);

			flash("success", "Shard instance created/edited: " + shard);

			return all();
		}
	}

	public static Result delete(Form<ShardFormData> formData) {
		ShardFormData shardFormData = formData.get();

		String id = shardFormData.shardId;

		long shardId = 0;

		if (id != null) {
			shardId = Long.valueOf(id);
		}

		Shard shard;

		if (shardId > 0) {
			shard = Shard.find.byId(shardId);

			Ebean.delete(shard);
		}
		else {
			flash("error", "Cannot delete Shard");
		}

		return all();
	}

}
