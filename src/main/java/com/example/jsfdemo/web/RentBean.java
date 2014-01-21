package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.service.CarManagerDateBase;
import com.example.jsfdemo.service.RentManager;
import com.example.jsfdemo.service.UserManager;

@SessionScoped
@Named("rentBean")
public class RentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UserManager um;
	
	@Inject
	CarManagerDateBase cm;

	@Inject
	RentManager rm;

	private Long userId;
	private Long carId;
	private String login;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String rentCar() {

		return null;
	}
	
	public List<Car> getAllCars(){
		return cm.getAllCars();
	}

}
