
package controllers;

import com.avaje.ebean.Ebean;

import controllers.address.AddressFormData;

import models.address.Address;

import play.data.Form;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.address.address;
import views.html.address.addresss;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @generated
 */
public class AddressApplication extends Controller {

	public static Result addAddress() {
		Form<AddressFormData> form = Form.form(
			AddressFormData.class).fill(new Address().toFormData());

		return ok(address.render(form));
	}

	public static Result get(Long id) {
		Address dbAddress = Address.find.byId(id);

		Form<AddressFormData> form = Form.form(
			AddressFormData.class).fill(dbAddress.toFormData());

		return ok(address.render(form));
	}

	public static Result all() {
		List<Address> addressList = Address.find.all();

		return ok(addresss.render(addressList));
	}

	public static Result submit() {
		Form<AddressFormData> formData = Form.form(
			AddressFormData.class).bindFromRequest();

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

	public static Result edit(Form<AddressFormData> formData) {
		if (formData.hasErrors()) {
			flash("error", "Please correct errors above.");

			return addAddress();
		}
		else {
			AddressFormData addressFormData = formData.get();

			String id = addressFormData.addressId;

			long addressId = 0;

			if (id != null) {
				addressId = Long.valueOf(id);
			}

			Address address;

			if (addressId > 0) {
				address = Address.find.byId(addressId);

				address.setMvccVersion(Long.valueOf(addressFormData.mvccVersion));
				address.setUuid(addressFormData.uuid);
				address.setAddressId(Long.valueOf(addressFormData.addressId));
				address.setCompanyId(Long.valueOf(addressFormData.companyId));
				address.setUserId(Long.valueOf(addressFormData.userId));
				address.setUserName(addressFormData.userName);
				address.setCreateDate(new Date(addressFormData.createDate));
				address.setModifiedDate(new Date(addressFormData.modifiedDate));
				address.setClassNameId(Long.valueOf(addressFormData.classNameId));
				address.setClassPK(Long.valueOf(addressFormData.classPK));
				address.setStreet1(addressFormData.street1);
				address.setStreet2(addressFormData.street2);
				address.setStreet3(addressFormData.street3);
				address.setCity(addressFormData.city);
				address.setZip(addressFormData.zip);
				address.setRegionId(Long.valueOf(addressFormData.regionId));
				address.setCountryId(Long.valueOf(addressFormData.countryId));
				address.setTypeId(Long.valueOf(addressFormData.typeId));
				address.setMailing(Boolean.valueOf(addressFormData.mailing));
				address.setCustomprimary(Boolean.valueOf(addressFormData.customprimary));
			}
			else {
				address = new Address(addressFormData);
			}

			Ebean.save(address);

			flash("success", "Address instance created/edited: " + address);

			return all();
		}
	}

	public static Result delete(Form<AddressFormData> formData) {
		AddressFormData addressFormData = formData.get();

		String id = addressFormData.addressId;

		long addressId = 0;

		if (id != null) {
			addressId = Long.valueOf(id);
		}

		Address address;

		if (addressId > 0) {
			address = Address.find.byId(addressId);

			Ebean.delete(address);
		}
		else {
			flash("error", "Cannot delete Address");
		}

		return all();
	}

}
