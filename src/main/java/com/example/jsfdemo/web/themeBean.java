package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("themeBean")
public class themeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String css = "default.css";

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String changeStyle() {
		if (css.equals("default.css")) {
			setCss("another.css");
		} else {
			setCss("default.css");
		}
		return "home";
	}
}
