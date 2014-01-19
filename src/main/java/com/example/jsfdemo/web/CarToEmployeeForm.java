package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.Employee;
import com.example.jsfdemo.service.AddCarToEmployeeManager;
import com.example.jsfdemo.service.EmployeeManager;

@SessionScoped
@Named("carToEmployee")
public class CarToEmployeeForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AddCarToEmployeeManager addm;

	@Inject
	private EmployeeManager em;

	private Long carId;
	private Long employeeId;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String addCarToEmployee() {
		addm.giveCarToEmployee(employeeId, carId);
		return "showCarsFromEmployee";
	}

	public List<Employee> getAllEmployees() {
		return em.getAllEmployees();
	}

	public List<Car> getAvailableCars() {
		return addm.getAvailableCars();
	}

}
