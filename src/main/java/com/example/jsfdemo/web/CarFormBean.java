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

	private Car car = new Car();
	private ListDataModel<Car> cars = new ListDataModel<Car>();

	@Inject
	CarManagerDateBase cm;

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
		car.setHp(0);
		car.setId(null);
		car.setMark(null);
		car.setName(null);
		car.setVin(null);
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

	public String home() {
		return "home";
	}



}
