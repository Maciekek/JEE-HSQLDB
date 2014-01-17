package com.example.jsfdemo.service;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jsfdemo.domain.MyUser;

@Stateless
public class UserManager {

	@PersistenceContext
	EntityManager em;

	public boolean checkLoginAndPassword(MyUser user) {
		boolean value = false;
		try {
			MyUser userRetrieved = (MyUser) em.createNamedQuery("user.findByLogin")
					.setParameter("login", user.getLogin()).getSingleResult();

			if (user.getPassword()
					.equalsIgnoreCase(userRetrieved.getPassword())) {
				value = true;
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return value;
	}

}