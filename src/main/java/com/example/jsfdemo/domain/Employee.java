package com.example.jsfdemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
@NamedQueries({ @NamedQuery(name = "employee.all", query = "Select e from Employee e") })
public class Employee {
	private Long id;

	private String firstName = "";
	private String LastName = "";

	private List<Car> cars = new ArrayList<Car>();
	private List<Phone> phones = new ArrayList<Phone>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Pattern(regexp = "[A-Z][a-z][a-z]*", message = "Imie tylko z wielkiej litery!")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Pattern(regexp = "[A-Z][a-z][a-z]*", message = "Nazwisko tylko z wielkiej litery!")
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


}
