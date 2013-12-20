package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Car;

@ApplicationScoped
public class CarManager {
	private List<Car> db = new ArrayList<Car>();

	public void addCar(Car car) {
		Car newCar = new Car();

		newCar.setMark(car.getMark());
		newCar.setName(car.getName());

		newCar.setHp(car.getHp());

		db.add(newCar);
	}

	// public void deleteCar(Car car) {
	// Car carToRemove = null;
	// for (Car p : db) {
	// if (car.getPin().equals(p.getPin())) {
	// carToRemove = p;
	// break;
	// }
	// }
	// if (carToRemove != null)
	// db.remove(carToRemove);
	// }

	public List<Car> getAllCars() {
		return db;
	}
}
