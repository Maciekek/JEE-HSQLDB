package com.example.jsfdemo.service;

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
		// MyUser userLogged = em.find(MyUser.class, user.getLogin());
		Car car = em.find(Car.class, carId);
		// car.setLoan(true);
		System.out.println(user.getImie());
		user.getCars().add(car);
	}

}
