package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.MyUser;
import com.example.jsfdemo.service.CarManagerDateBase;
import com.example.jsfdemo.service.RentManager;
import com.example.jsfdemo.service.UserManager;

@SessionScoped
@ManagedBean(name = "rentBean")
public class RentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UserManager um;
	
	@Inject
	CarManagerDateBase cm;

	@ManagedProperty(value = "#{loginBean.user}")
	private MyUser injectedUser;

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

	public MyUser getInjectedUser() {
		return injectedUser;
	}

	public void setInjectedUser(MyUser injectedUser) {
		this.injectedUser = injectedUser;
	}

	public String rentCar() {
		rm.rentCar(injectedUser, carId);
		return null;
	}
	
	public void loadSelectedCar(ActionEvent ae) {
		String ids = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("carId").toString();
		int id = Integer.parseInt(ids);
		carId = (long) id;
	}

	public List<Car> getAllCars(){
		return cm.getAllCars();
	}

}
