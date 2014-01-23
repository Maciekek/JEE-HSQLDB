package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Phone;
import com.example.jsfdemo.service.PhoneManager;


@SessionScoped
@Named("phoneBean")
public class PhoneFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Phone phone = new Phone();
	private ListDataModel<Phone> phones = new ListDataModel<Phone>();

	@Inject
	private PhoneManager pm;

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public ListDataModel<Phone> getAllPhone() {
		phones.setWrappedData(pm.getAllPhones());
		return phones;
	}

	// Actions
	public String addPhone() {
		pm.addPhone(phone);
		return "showPhone";
		// return null;
	}

	public String clearBean() {
		phone.setModel("");
		phone.setId(null);
		phone.setNumber(0);
		return "addPhone";
	}

	public String deletePhone() {
		Phone phoneToDelete = phones.getRowData();
		try {
			pm.phoneToDelete(phoneToDelete);
		} catch (Exception e) {
		}
		return null;
	}

	public String selectPhoneToEdit() {
		Phone phoneToEdit = phones.getRowData();
		phone = phoneToEdit;
		return "editPhone";
	}

	public String editPhone() {
		pm.editPhoneDate(phone);
		return "showPhone";
	}

	// Validators
	// public void uniqueVin(FacesContext context, UIComponent component,
	// Object value) {
	// String vin = (String) value;
	//
	// if (vin.length() == 11) {
	//
	// for (Car car : cm.getAllCars()) {
	// if (car.getVin().equalsIgnoreCase(vin)) {
	// FacesMessage message = new FacesMessage(
	// "Samochod o takim numerze Vin już istnieje!");
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	// throw new ValidatorException(message);
	// }
	// }
	// } else {
	// FacesMessage message = new FacesMessage(
	// "Vin musi posiadac 11 cyfr, a podałes:" + vin.length());
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	// throw new ValidatorException(message);
	// }
	// }
	//
	// public void yobValidator(FacesContext context, UIComponent component,
	// Object value) {
	// this.yob = (String) value;
	//
	// if (yob.length() != 10) {
	// FacesMessage message = new FacesMessage("Popraw date");
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	// throw new ValidatorException(message);
	//
	// }
	//
	// }
	//
	// public void idNumberValidateEnd(ComponentSystemEvent event) {
	// UIForm form = (UIForm) event.getComponent();
	// UIInput pesel = (UIInput) form.findComponent("idNumber");
	// // UIInput yob = (UIInput) form.findComponent("yob");
	//
	// // String dayYob = yob.getValue().toString().substring(0, 2);
	// // String monthYob = yob.getValue().toString().substring(3, 5);
	// // String yearYob = yob.getValue().toString().substring(8, 10);
	//
	// String dayYob = yob.substring(0, 2);
	// String monthYob = yob.substring(3, 5);
	// String yearYob = yob.substring(8, 10);
	//
	// String dayID = pesel.getValue().toString().substring(4, 6);
	// String monthID = pesel.getValue().toString().substring(2, 4);
	// String yearID = pesel.getValue().toString().substring(0, 2);
	//
	// if (!dayYob.equals(dayID) || !monthID.equals(monthYob)
	// || !yearID.equals(yearYob)) {
	// FacesContext context = FacesContext.getCurrentInstance();
	// context.addMessage(form.getClientId(), new FacesMessage(
	// "Nie pasuje!"));
	// context.renderResponse();
	// }
	//
	// }
	//
	// public void idNumberValidate(FacesContext context, UIComponent component,
	// Object value) {
	// String pesel = (String) value;
	//
	// String dayID;
	// String monthID;
	// String yearID;
	// String dayYob;
	// String monthYob;
	// String yearYob;
	//
	// if (pesel.length() != 11 || yob.length() != 10) {
	// FacesMessage message = new FacesMessage("Popraw date");
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	// throw new ValidatorException(message);
	// } else {
	//
	// dayID = pesel.substring(4, 6);
	// monthID = pesel.substring(2, 4);
	// yearID = pesel.substring(0, 2);
	//
	// dayYob = yob.substring(0, 2);
	// monthYob = yob.substring(3, 5);
	// yearYob = yob.substring(8, 10);
	//
	// if (!dayYob.equals(dayID) || !monthID.equals(monthYob)
	// || !yearID.equals(yearYob)) {
	// FacesMessage message = new FacesMessage("Nie pasi mi to...");
	// message.setSeverity(FacesMessage.SEVERITY_ERROR);
	// throw new ValidatorException(message);
	//
	// }
	//
	// }
	//
	// }

}
