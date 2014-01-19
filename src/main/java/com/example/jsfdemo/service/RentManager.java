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

	public void rentCar(Long userId, Long carId) {
		MyUser user = em.find(MyUser.class, userId);
		Car car = em.find(Car.class, carId);
		// car.setLoan(true);

		user.getCars().add(car);
	}

}
