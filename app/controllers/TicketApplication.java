
package controllers;

import com.avaje.ebean.Ebean;

import controllers.ticket.TicketFormData;

import models.ticket.Ticket;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.ticket.ticket;
import views.html.ticket.tickets;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class TicketApplication extends Controller {

	public static Result addTicket() {
		Form<TicketFormData> form = Form.form(
			TicketFormData.class).fill(new Ticket().toFormData());

		return ok(ticket.render(form));
	}

	public static Result get(Long id) {
		Ticket dbTicket = Ticket.find.byId(id);

		Form<TicketFormData> form = Form.form(
			TicketFormData.class).fill(dbTicket.toFormData());

		return ok(ticket.render(form));
	}

	public static Result all() {
		List<Ticket> ticketList = Ticket.find.all();

		return ok(tickets.render(ticketList));
	}

	public static Result submit() {
		Form<TicketFormData> formData = Form.form(
			TicketFormData.class).bindFromRequest();

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

	public static Result edit(Form<TicketFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addTicket();
		}
		else {
			TicketFormData ticketFormData = formData.get();

			String id = ticketFormData.ticketId;

			long ticketId = 0;

			if (id != null) {
				ticketId = Long.valueOf(id);
			}

			Ticket ticket;

			if (ticketId > 0) {
				ticket = Ticket.find.byId(ticketId);

				ticket.setMvccVersion(Long.valueOf(ticketFormData.mvccVersion));
				ticket.setTicketId(Long.valueOf(ticketFormData.ticketId));
				ticket.setCompanyId(Long.valueOf(ticketFormData.companyId));
				ticket.setCreateDate(new Date(ticketFormData.createDate));
				ticket.setClassNameId(Long.valueOf(ticketFormData.classNameId));
				ticket.setClassPK(Long.valueOf(ticketFormData.classPK));
				ticket.setKey(ticketFormData.key);
				ticket.setCustomtype(Integer.valueOf(ticketFormData.customtype));
				ticket.setExtraInfo(ticketFormData.extraInfo);
				ticket.setExpirationDate(new Date(ticketFormData.expirationDate));
			}
			else {
				ticket = new Ticket(ticketFormData);
			}

			Ebean.save(ticket);

			flash("success", "Ticket instance created/edited: " + ticket);

			return all();
		}
	}

	public static Result delete(Form<TicketFormData> formData) {
		TicketFormData ticketFormData = formData.get();

		String id = ticketFormData.ticketId;

		long ticketId = 0;

		if (id != null) {
			ticketId = Long.valueOf(id);
		}

		Ticket ticket;

		if (ticketId > 0) {
			ticket = Ticket.find.byId(ticketId);

			Ebean.delete(ticket);
		}
		else {
			flash("error", "Cannot delete Ticket");
		}

		return all();
	}

}
