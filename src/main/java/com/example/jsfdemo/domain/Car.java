package com.example.jsfdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

@Entity
@NamedQueries({
		@NamedQuery(name = "car.ungiven", query = "Select c from Car c where c.status = false"),
		@NamedQuery(name = "car.all", query = "Select c from Car c") })
public class Car {
	private Long id;


	private String name = "";
	private String mark = "";
	private boolean status = false;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Pattern(regexp = "[A-Z][a-z][a-z]*", message = "Nazwa tylko z wielkiej litery!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Pattern(regexp = "[A-Z][a-z][a-z]", message = "Dokładnie 3 litery i pierwsza duża")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
