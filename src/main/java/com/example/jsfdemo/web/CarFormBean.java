package com.example.jsfdemo.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SlideEndEvent;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.service.CarManagerDateBase;

@SessionScoped
@Named("carBean")
public class CarFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

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
		car.setFirstName(null);
		car.setHp(0);
		car.setId(null);
		car.setIdNumber(null);
		car.setLastName(null);
		car.setMark(null);
		car.setName(null);
		car.setVin(null);
		car.setYob(null);
		car.setVolume(0.0);
		return "addSimple";
	}

	public String deleteCar() {
		Car carToDelete = cars.getRowData();
		cm.deleteCar(carToDelete);
		return null;
	}

	public String selectCarToEdit() {
		Car carToEdit = cars.getRowData();
		car = carToEdit;
		return "editCar";
	}

	public String editCar() {
		cm.editCarDate(car);
		return "showCars";
	}

	// Validators
	public void uniqueVin(FacesContext context, UIComponent component,
			Object value) {
		String vin = (String) value;

		for (Car car : cm.getAllCars()) {
			if (car.getVin().equalsIgnoreCase(vin)) {
				FacesMessage message = new FacesMessage(
						"Samochod o takim numerze Vin już istnieje!");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

	public String onSlideEnd(SlideEndEvent event) {
		FacesMessage msg = new FacesMessage("Slide Ended", "Value: "
				+ event.getValue());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}

	public void idNumberValidate(ComponentSystemEvent event) {
		UIForm form = (UIForm) event.getComponent();
		UIInput pesel = (UIInput) form.findComponent("idNumber");
		UIInput yob = (UIInput) form.findComponent("yob");

		String dayYob = yob.getValue().toString().substring(0, 2);
		String monthYob = yob.getValue().toString().substring(3, 5);
		String yearYob = yob.getValue().toString().substring(8, 10);
		String dayID = pesel.getValue().toString().substring(4, 6);
		String monthID = pesel.getValue().toString().substring(2, 4);
		String yearID = pesel.getValue().toString().substring(0, 2);

		if (!dayYob.equals(dayID) || !monthID.equals(monthYob)
				|| !yearID.equals(yearYob)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(form.getClientId(), new FacesMessage(
					"Nie pasuje!" + monthID + "  " + monthYob + "\n" + dayID
							+ " " + dayYob + "\n" + yearID + "  " + yearYob
							+ "|"));
			context.renderResponse();
		}

	}

	public String dateToStringParser(String date) {
		// Sun Oct 22 00:00:00 CEST 2000
		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEEE, MMM dd, HH:mm:ss a yyyy ");
		String dateString = formatter.format(date);

		return dateString;

	}
}
