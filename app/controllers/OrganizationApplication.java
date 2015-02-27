
package controllers;

import com.avaje.ebean.Ebean;

import controllers.organization.OrganizationFormData;

import models.organization.Organization;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.organization.organization;
import views.html.organization.organizations;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class OrganizationApplication extends Controller {

	public static Result addOrganization() {
		Form<OrganizationFormData> form = Form.form(
			OrganizationFormData.class).fill(new Organization().toFormData());

		return ok(organization.render(form));
	}

	public static Result get(Long id) {
		Organization dbOrganization = Organization.find.byId(id);

		Form<OrganizationFormData> form = Form.form(
			OrganizationFormData.class).fill(dbOrganization.toFormData());

		return ok(organization.render(form));
	}

	public static Result all() {
		List<Organization> organizationList = Organization.find.all();

		return ok(organizations.render(organizationList));
	}

	public static Result submit() {
		Form<OrganizationFormData> formData = Form.form(
			OrganizationFormData.class).bindFromRequest();

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

	public static Result edit(Form<OrganizationFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addOrganization();
		}
		else {
			OrganizationFormData organizationFormData = formData.get();

			String id = organizationFormData.organizationId;

			long organizationId = 0;

			if (id != null) {
				organizationId = Long.valueOf(id);
			}

			Organization organization;

			if (organizationId > 0) {
				organization = Organization.find.byId(organizationId);

				organization.setMvccVersion(Long.valueOf(organizationFormData.mvccVersion));
				organization.setUuid(organizationFormData.uuid);
				organization.setOrganizationId(Long.valueOf(organizationFormData.organizationId));
				organization.setCompanyId(Long.valueOf(organizationFormData.companyId));
				organization.setUserId(Long.valueOf(organizationFormData.userId));
				organization.setUserName(organizationFormData.userName);
				organization.setCreateDate(new Date(organizationFormData.createDate));
				organization.setModifiedDate(new Date(organizationFormData.modifiedDate));
				organization.setParentOrganizationId(Long.valueOf(organizationFormData.parentOrganizationId));
				organization.setTreePath(organizationFormData.treePath);
				organization.setName(organizationFormData.name);
				organization.setCustomtype(organizationFormData.customtype);
				organization.setRecursable(Boolean.valueOf(organizationFormData.recursable));
				organization.setRegionId(Long.valueOf(organizationFormData.regionId));
				organization.setCountryId(Long.valueOf(organizationFormData.countryId));
				organization.setStatusId(Long.valueOf(organizationFormData.statusId));
				organization.setComments(organizationFormData.comments);
				organization.setLogoId(Long.valueOf(organizationFormData.logoId));
			}
			else {
				organization = new Organization(organizationFormData);
			}

			Ebean.save(organization);

			flash("success", "Organization instance created/edited: " + organization);

			return all();
		}
	}

	public static Result delete(Form<OrganizationFormData> formData) {
		OrganizationFormData organizationFormData = formData.get();

		String id = organizationFormData.organizationId;

		long organizationId = 0;

		if (id != null) {
			organizationId = Long.valueOf(id);
		}

		Organization organization;

		if (organizationId > 0) {
			organization = Organization.find.byId(organizationId);

			Ebean.delete(organization);
		}
		else {
			flash("error", "Cannot delete Organization");
		}

		return all();
	}

}
