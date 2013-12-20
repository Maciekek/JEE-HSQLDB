package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("photoBean")
public class ImageSwitchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> images;

	public ImageSwitchBean() {
		images = new ArrayList<String>();
		images.add("IMG_4328.JPG");
		images.add("IMG_4337.JPG");
		images.add("IMG_4345.JPG");
		images.add("IMG_4405.JPG");

	}

	public List<String> getImages() {
		return images;
	}
}
