package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import com.example.jsfdemo.domain.MyUser;
import com.example.jsfdemo.service.UserManager;

@SessionScoped
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean loggedIn;

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
	public boolean getLoggedIn() {
		// TODO Auto-generated method stub
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String addUser() {
		um.addUser(user);
		return "login";
	}

}
