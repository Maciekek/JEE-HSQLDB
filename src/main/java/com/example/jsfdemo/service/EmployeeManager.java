package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.Employee;
import com.example.jsfdemo.domain.Phone;

@Stateless
public class EmployeeManager {

	@PersistenceContext
	EntityManager em;

	public void addEmployee(Employee employee) {
		employee.setId(null);
		em.persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return em.createNamedQuery("employee.all").getResultList();
	}

	public List<Car> getOwnedCar(Employee employee) {
		employee = em.find(Employee.class, employee.getId());
		List<Car> cars = new ArrayList<Car>(employee.getCars());
		return cars;
	}

	public void employeeToDelete(Employee employee) {
		employee = em.find(Employee.class, employee.getId());
		em.remove(employee);
	}

	public void editEmployeeDate(Employee employee) {

		Employee employeeRetrieved = em.find(Employee.class, employee.getId());
		employeeRetrieved = employee;
		em.merge(employeeRetrieved);

	}

	public List<Phone> getOwnedPhone(Employee employee) {
		employee = em.find(Employee.class, employee.getId());
		List<Phone> phones = new ArrayList<Phone>(employee.getPhones());
		return phones;
	}

}
