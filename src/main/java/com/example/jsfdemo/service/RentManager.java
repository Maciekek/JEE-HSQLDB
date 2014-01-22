package com.example.jsfdemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.MyUser;

@Stateless
public class RentManager {

	@PersistenceContext
	EntityManager em;

	public void rentCar(MyUser user, Long carId) {
		MyUser userFound = (MyUser) em.createNamedQuery("user.findByLogin")
				.setParameter("login", user.getLogin()).getSingleResult();

		MyUser userLogged = em.find(MyUser.class, userFound.getId());
		Car car = em.find(Car.class, carId);

		car.setLoan(true);
		userLogged.getCars().add(car);
	}

	public List<Car> getAllCars(MyUser user) {
		MyUser userFound = (MyUser) em.createNamedQuery("user.findByLogin")
				.setParameter("login", user.getLogin()).getSingleResult();

		MyUser userLogged = em.find(MyUser.class, userFound.getId());

		List<Car> carsRetrieved = userLogged.getCars();

		return carsRetrieved;

	}

	public void unRentCar(MyUser user, Long carId) {
		MyUser userFound = (MyUser) em.createNamedQuery("user.findByLogin")
				.setParameter("login", user.getLogin()).getSingleResult();

		MyUser userLogged = em.find(MyUser.class, userFound.getId());
		Car car = em.find(Car.class, carId);

		car.setLoan(false);
		userLogged.getCars().remove(car.getId());

	}

}
