package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.example.jsfdemo.domain.MyUser;
import com.example.jsfdemo.service.UserManager;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	private MyUser user = new MyUser();
	private boolean loggedIn;
	private String loginActionText = "Zaloguj";
	private String welcomeMessage = "";

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@Inject
	UserManager um;

	public String doLogin() {

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

	public void changeLoginActionText() {

		if (loggedIn) {
			loginActionText = "Wyloguj";
			welcomeMessage = "Witaj " + user.getLogin() + "!";
		} else {
			loginActionText = "Zaloguj";
			welcomeMessage = "";
		}

	}

	public String changeLoginStatus() {
		if (loggedIn) {
			doLogout();
			changeLoginActionText();
			setWelcomeMessage("Witaj" + user.getLogin());
			return navigationBean.redirectToLogin();

		} else
			changeLoginActionText();
		return navigationBean.redirectToLogin();
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

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
