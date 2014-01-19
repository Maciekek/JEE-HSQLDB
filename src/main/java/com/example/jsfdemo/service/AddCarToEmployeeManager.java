package com.example.jsfdemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.Employee;

@Stateless
public class AddCarToEmployeeManager {

	@PersistenceContext
	EntityManager em;

	public void giveCarToEmployee(Long employeeId, Long carId) {
		Employee employee = em.find(Employee.class, employeeId);
		Car car = em.find(Car.class, carId);
		car.setStatus(true);
		employee.getCars().add(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCars() {
		return em.createNamedQuery("car.ungiven").getResultList();
	}
}
