package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.MyUser;
import com.example.jsfdemo.service.UserManager;

@SessionScoped
@Named("userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean loggedIn = false;
	private MyUser user = new MyUser();
	private ListDataModel<MyUser> users = new ListDataModel<MyUser>();


	@Inject
	UserManager um;


	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public ListDataModel<MyUser> getUsers() {
		return users;
	}

	public void setUsers(ListDataModel<MyUser> users) {
		this.users = users;
	}

	// Actions
	public String logIn() {
		return null;

	}

	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return loggedIn;
	}

}
