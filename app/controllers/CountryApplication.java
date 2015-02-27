
package controllers;

import com.avaje.ebean.Ebean;

import controllers.country.CountryFormData;

import models.country.Country;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.country.country;
import views.html.country.countrys;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class CountryApplication extends Controller {

	public static Result addCountry() {
		Form<CountryFormData> form = Form.form(
			CountryFormData.class).fill(new Country().toFormData());

		return ok(country.render(form));
	}

	public static Result get(Long id) {
		Country dbCountry = Country.find.byId(id);

		Form<CountryFormData> form = Form.form(
			CountryFormData.class).fill(dbCountry.toFormData());

		return ok(country.render(form));
	}

	public static Result all() {
		List<Country> countryList = Country.find.all();

		return ok(countrys.render(countryList));
	}

	public static Result submit() {
		Form<CountryFormData> formData = Form.form(
			CountryFormData.class).bindFromRequest();

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

	public static Result edit(Form<CountryFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addCountry();
		}
		else {
			CountryFormData countryFormData = formData.get();

			String id = countryFormData.countryId;

			long countryId = 0;

			if (id != null) {
				countryId = Long.valueOf(id);
			}

			Country country;

			if (countryId > 0) {
				country = Country.find.byId(countryId);

				country.setMvccVersion(Long.valueOf(countryFormData.mvccVersion));
				country.setCountryId(Long.valueOf(countryFormData.countryId));
				country.setName(countryFormData.name);
				country.setA2(countryFormData.a2);
				country.setA3(countryFormData.a3);
				country.setNumber(countryFormData.number);
				country.setIdd(countryFormData.idd);
				country.setZipRequired(Boolean.valueOf(countryFormData.zipRequired));
				country.setActive(Boolean.valueOf(countryFormData.active));
			}
			else {
				country = new Country(countryFormData);
			}

			Ebean.save(country);

			flash("success", "Country instance created/edited: " + country);

			return all();
		}
	}

	public static Result delete(Form<CountryFormData> formData) {
		CountryFormData countryFormData = formData.get();

		String id = countryFormData.countryId;

		long countryId = 0;

		if (id != null) {
			countryId = Long.valueOf(id);
		}

		Country country;

		if (countryId > 0) {
			country = Country.find.byId(countryId);

			Ebean.delete(country);
		}
		else {
			flash("error", "Cannot delete Country");
		}

		return all();
	}

}
