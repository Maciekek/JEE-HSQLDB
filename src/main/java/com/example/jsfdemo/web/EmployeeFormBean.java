package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.Employee;
import com.example.jsfdemo.domain.Phone;
import com.example.jsfdemo.service.EmployeeManager;

@SessionScoped
@Named("employeeBean")
public class EmployeeFormBean implements Serializable {

	private static final long serialVersionUID = 1L;


	private Employee employee = new Employee();
	private ListDataModel<Employee> employees = new ListDataModel<Employee>();

	private ListDataModel<Car> cars = new ListDataModel<Car>();
	private ListDataModel<Phone> phones = new ListDataModel<Phone>();

	@Inject
	private EmployeeManager em;

	private Employee emp = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ListDataModel<Employee> getAllEmployees() {
		employees.setWrappedData(em.getAllEmployees());
		return employees;
	}

	public ListDataModel<Car> getOwnedCar() {
		cars.setWrappedData(em.getOwnedCar(employee));
		return cars;
	}

	public ListDataModel<Phone> getOwnedPhone() {
		phones.setWrappedData(em.getOwnedPhone(employee));
		return phones;
	}


	// Actions
	public String addEmployee() {
		em.addEmployee(employee);
		return "showEmployee";
		// return null;
	}

	public String clearBean() {
		employee.setFirstName("");
		employee.setLastName(null);
		return "addEmploye";
	}

	public String deleteEmployee() {
		Employee employeeToDelete = employees.getRowData();
		em.employeeToDelete(employeeToDelete);
		return null;
	}

	public String selectEmployeeToEdit() {
		Employee employeeToEdit = employees.getRowData();
		employee = employeeToEdit;
		return "editEmployee";
	}

	public String editEmployee() {
		em.editEmployeeDate(employee);
		return "showEmployee";
	}

	public String selectEmployeeToShowCars() {
		return "showCarsFromEmployee";
	}

	public String selectEmployeeToShowPhones() {
		return "showPhonesFromEmployee";
	}

	public List<Car> getAllCars() {
		return emp.getCars();

	}



}
