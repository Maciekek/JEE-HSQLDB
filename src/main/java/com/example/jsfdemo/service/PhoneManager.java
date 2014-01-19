package com.example.jsfdemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.Phone;

@Stateless
public class PhoneManager {

	@PersistenceContext
	EntityManager em;

	public void addPhone(Phone phone) {
		phone.setId(null);
		em.persist(phone);
	}

	@SuppressWarnings("unchecked")
	public List<Phone> getAllPhones() {
		return em.createNamedQuery("phone.all").getResultList();
	}

	public void phoneToDelete(Phone phone) {
		phone = em.find(Phone.class, phone.getId());
		em.remove(phone);
	}

	public void editPhoneDate(Phone phone) {
		Phone phoneRetrieved = em.find(Phone.class, phone.getId());
		phoneRetrieved = phone;
		em.merge(phoneRetrieved);

	}

}
