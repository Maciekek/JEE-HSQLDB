package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.service.CarManagerDateBase;

@SessionScoped
@Named("carBean")
public class CarFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idNumber;
	private String yob;

	private Car car = new Car();
	private ListDataModel<Car> cars = new ListDataModel<Car>();

	@Inject
	private CarManagerDateBase cm;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public ListDataModel<Car> getAllCars() {
		cars.setWrappedData(cm.getAllCars());
		return cars;
	}

	// Actions
	public String addCar() {
		cm.addCar(car);
		return "showCars";
		// return null;
	}

	public String clearBean() {
		car.setName("");
		car.setId(null);
		car.setMark(null);
		car.setName(null);
		return "addSimple";
	}

	public String deleteCar() {
		Car carToDelete = cars.getRowData();
		try {
			cm.deleteCar(carToDelete);
		} catch (Exception e) {

		}
		
		return null;
	}

	public String selectCarToEdit() {
		Car carToEdit = cars.getRowData();
		car = carToEdit;
		return "editCar";
	}

	public String editCar() {
		try{
			cm.editCarDate(car);
		} catch (Exception e) {

		}
		return "showCars";
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
