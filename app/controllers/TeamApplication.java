
package controllers;

import com.avaje.ebean.Ebean;

import controllers.team.TeamFormData;

import models.team.Team;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.team.team;
import views.html.team.teams;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class TeamApplication extends Controller {

	public static Result addTeam() {
		Form<TeamFormData> form = Form.form(
			TeamFormData.class).fill(new Team().toFormData());

		return ok(team.render(form));
	}

	public static Result get(Long id) {
		Team dbTeam = Team.find.byId(id);

		Form<TeamFormData> form = Form.form(
			TeamFormData.class).fill(dbTeam.toFormData());

		return ok(team.render(form));
	}

	public static Result all() {
		List<Team> teamList = Team.find.all();

		return ok(teams.render(teamList));
	}

	public static Result submit() {
		Form<TeamFormData> formData = Form.form(
			TeamFormData.class).bindFromRequest();

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

	public static Result edit(Form<TeamFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addTeam();
		}
		else {
			TeamFormData teamFormData = formData.get();

			String id = teamFormData.teamId;

			long teamId = 0;

			if (id != null) {
				teamId = Long.valueOf(id);
			}

			Team team;

			if (teamId > 0) {
				team = Team.find.byId(teamId);

				team.setMvccVersion(Long.valueOf(teamFormData.mvccVersion));
				team.setTeamId(Long.valueOf(teamFormData.teamId));
				team.setCompanyId(Long.valueOf(teamFormData.companyId));
				team.setUserId(Long.valueOf(teamFormData.userId));
				team.setUserName(teamFormData.userName);
				team.setCreateDate(new Date(teamFormData.createDate));
				team.setModifiedDate(new Date(teamFormData.modifiedDate));
				team.setGroupId(Long.valueOf(teamFormData.groupId));
				team.setName(teamFormData.name);
				team.setDescription(teamFormData.description);
			}
			else {
				team = new Team(teamFormData);
			}

			Ebean.save(team);

			flash("success", "Team instance created/edited: " + team);

			return all();
		}
	}

	public static Result delete(Form<TeamFormData> formData) {
		TeamFormData teamFormData = formData.get();

		String id = teamFormData.teamId;

		long teamId = 0;

		if (id != null) {
			teamId = Long.valueOf(id);
		}

		Team team;

		if (teamId > 0) {
			team = Team.find.byId(teamId);

			Ebean.delete(team);
		}
		else {
			flash("error", "Cannot delete Team");
		}

		return all();
	}

}
