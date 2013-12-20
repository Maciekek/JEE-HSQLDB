package com.example.jsfdemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Car;

@Stateless
public class CarManagerDateBase {

	@PersistenceContext
	EntityManager em;

	public void addCar(Car car) {
		car.setId(null);
		em.persist(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		return em.createNamedQuery("car.all").getResultList();
	}

	public void deleteCar(Car car) {
		car = em.find(Car.class, car.getId());
		em.remove(car);
	}

	public void editCarDate(Car car) {
		System.out.println(car.getHp());
		Car carRetrieved = em.find(Car.class, car.getId());
		carRetrieved = car;
		em.merge(carRetrieved);
	}

}
