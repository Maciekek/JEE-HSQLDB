package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.example.jsfdemo.domain.Car;
import com.example.jsfdemo.domain.MyUser;
import com.example.jsfdemo.service.CarManagerDateBase;
import com.example.jsfdemo.service.RentManager;
import com.example.jsfdemo.service.UserManager;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	private String username;
	private Long userId;
	private String password;
	private MyUser user = new MyUser();
	private boolean loggedIn;
	private Long carId;
	private String loginActionText = "Zaloguj";

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@Inject
	UserManager um;
	
	@Inject
	CarManagerDateBase cm;

	@Inject
	RentManager rm;
	
	public String rentCar() {

		rm.rentCar(1L, 1L);
		return null;
	}

	public String doLogin() {
		// Get every
		setUserId(user.getId());
		// Successful login
		if (um.checkLoginAndPassword(user)) {
			loggedIn = true;
			changeLoginActionText();
			return navigationBean.redirectToCars();
		}

		// Set login ERROR
		FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// To to login page
		return navigationBean.toLogin();

	}

	/**
	 * Logout operation.
	 * 
	 * @return
	 */
	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;

		// Set logout message
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return "/login.jsf";
	}

	public List<Car> getAllCars() {
		return cm.getAllCars();
	}

	public void changeLoginActionText() {

		if (loggedIn)
			loginActionText = "Wyloguj";
		else
			loginActionText = "Zaloguj";

	}

	public String changeLoginStatus() {
		if (loggedIn) {
			doLogout();
			changeLoginActionText();
			return navigationBean.redirectToLogin();

		} else
			changeLoginActionText();
			return navigationBean.redirectToLogin();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public String getLoginActionText() {
		return loginActionText;
	}

	public void setLoginActionText(String loginActionText) {
		this.loginActionText = loginActionText;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


}
