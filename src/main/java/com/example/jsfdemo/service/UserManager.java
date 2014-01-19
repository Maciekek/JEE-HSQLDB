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

	private MyUser user;

	public boolean checkLoginAndPassword(MyUser user) {
		boolean value = false;
		try {
			MyUser userRetrieved = (MyUser) em.createNamedQuery("user.findByLogin")
					.setParameter("login", user.getLogin()).getSingleResult();
			setUser(user);
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

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public void addUser(MyUser user2) {
		user2.setId(null);
		em.persist(user2);

	}

}
