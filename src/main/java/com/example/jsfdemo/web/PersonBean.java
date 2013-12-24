package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.validation.constraints.Size;

@Named("personBean")
public class PersonBean {
	@Size(min = 5, message = "Za malo liczb")
	private String firstname;
	@Size(min = 5)
	private String surname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void savePerson(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Welcome " + firstname + " " + surname + "!"));
	}
}
