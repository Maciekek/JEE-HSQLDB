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
		MyUser userFound = (MyUser) em.createNamedQuery("user.findByLogin")
				.setParameter("login", user.getLogin()).getSingleResult();
		
		MyUser userLogged = em.find(MyUser.class, userFound.getId());
		Car car = em.find(Car.class, carId);


		userLogged.getCars().add(car);
	}

}
