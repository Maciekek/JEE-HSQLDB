package com.example.jsfdemo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
@NamedQueries({ @NamedQuery(name = "car.all", query = "Select c from Car c") })
public class Car {
	private Long id;
	private String firstName = "";
	private String lastName = "";
	private Date yob;
	private String vin = "";
	private Long idNumber;
	private String name = "";
	private String mark = "";
	private Date endSecure;
	private int hp;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Pattern(regexp = "[A-Z][a-z]*", message = "Imie musi zaczynac sie z wielkiej litery")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Pattern(regexp = "[A-Z][a-z]*", message = "Nazwisko musi zaczynac sie z wielkiej litery")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Past(message = "Data musi byc z przeszlosc")
	@Temporal(TemporalType.DATE)
	public Date getYob() {
		return yob;
	}

	public void setYob(Date yob) {
		this.yob = yob;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Pattern(regexp = "[0-9]{11}", message = "Numer vin musi miec 11 cyfr")
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@NotNull(message = "Uzupelnij pola!")
	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	@NotNull(message = "Uzupelnij pola!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "Uzupelnij pola!")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Future(message = "Data musi byc z przeszloci")
	@Temporal(TemporalType.DATE)
	public Date getEndSecure() {
		return endSecure;
	}

	public void setEndSecure(Date endSecure) {
		this.endSecure = endSecure;
	}

	@NotNull(message = "Uzupelnij pola!")
	@Min(10)
	@Max(1000)
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
