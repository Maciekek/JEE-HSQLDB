package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Employee;
import com.example.jsfdemo.domain.Phone;
import com.example.jsfdemo.service.AddPhoneToEmployeeManager;
import com.example.jsfdemo.service.EmployeeManager;

@SessionScoped
@Named("phoneToEmployee")
public class PhoneToEmployeeForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AddPhoneToEmployeeManager addphone;

	@Inject
	private EmployeeManager em;

	private Long phoneId;
	private Long employeeId;

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String addPhoneToEmployee() {
		addphone.givePhoneToEmployee(employeeId, phoneId);
		return "showPhonesFromEmployee";
	}

	public List<Employee> getAllEmployees() {
		return em.getAllEmployees();
	}

	public List<Phone> getAvailablePhones() {
		return addphone.getAvailablePhone();
	}

}
