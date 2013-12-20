package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

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
		car.setEndSecure(null);
		car.setFirstName(null);
		car.setHp(0);
		car.setId(null);
		car.setIdNumber(null);
		car.setLastName(null);
		car.setMark(null);
		car.setName(null);
		car.setVin(null);
		car.setYob(null);
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
}
