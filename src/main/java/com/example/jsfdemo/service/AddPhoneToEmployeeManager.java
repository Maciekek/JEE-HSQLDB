package com.example.jsfdemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Employee;
import com.example.jsfdemo.domain.Phone;

@Stateless
public class AddPhoneToEmployeeManager {

	@PersistenceContext
	EntityManager em;

	public void givePhoneToEmployee(Long employeeId, Long phoneId) {
		Employee employee = em.find(Employee.class, employeeId);
		Phone phone = em.find(Phone.class, phoneId);
		phone.setStatus(true);
		employee.getPhones().add(phone);
	}

	@SuppressWarnings("unchecked")
	public List<Phone> getAvailablePhone() {
		return em.createNamedQuery("phone.ungiven").getResultList();
	}
}
