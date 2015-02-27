
package controllers;

import com.avaje.ebean.Ebean;

import controllers.region.RegionFormData;

import models.region.Region;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.region.region;
import views.html.region.regions;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class RegionApplication extends Controller {

	public static Result addRegion() {
		Form<RegionFormData> form = Form.form(
			RegionFormData.class).fill(new Region().toFormData());

		return ok(region.render(form));
	}

	public static Result get(Long id) {
		Region dbRegion = Region.find.byId(id);

		Form<RegionFormData> form = Form.form(
			RegionFormData.class).fill(dbRegion.toFormData());

		return ok(region.render(form));
	}

	public static Result all() {
		List<Region> regionList = Region.find.all();

		return ok(regions.render(regionList));
	}

	public static Result submit() {
		Form<RegionFormData> formData = Form.form(
			RegionFormData.class).bindFromRequest();

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

	public static Result edit(Form<RegionFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addRegion();
		}
		else {
			RegionFormData regionFormData = formData.get();

			String id = regionFormData.regionId;

			long regionId = 0;

			if (id != null) {
				regionId = Long.valueOf(id);
			}

			Region region;

			if (regionId > 0) {
				region = Region.find.byId(regionId);

				region.setMvccVersion(Long.valueOf(regionFormData.mvccVersion));
				region.setRegionId(Long.valueOf(regionFormData.regionId));
				region.setCountryId(Long.valueOf(regionFormData.countryId));
				region.setRegionCode(regionFormData.regionCode);
				region.setName(regionFormData.name);
				region.setActive(Boolean.valueOf(regionFormData.active));
			}
			else {
				region = new Region(regionFormData);
			}

			Ebean.save(region);

			flash("success", "Region instance created/edited: " + region);

			return all();
		}
	}

	public static Result delete(Form<RegionFormData> formData) {
		RegionFormData regionFormData = formData.get();

		String id = regionFormData.regionId;

		long regionId = 0;

		if (id != null) {
			regionId = Long.valueOf(id);
		}

		Region region;

		if (regionId > 0) {
			region = Region.find.byId(regionId);

			Ebean.delete(region);
		}
		else {
			flash("error", "Cannot delete Region");
		}

		return all();
	}

}
