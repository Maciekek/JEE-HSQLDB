package com.example.jsfdemo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserManager {

	@PersistenceContext
	EntityManager em;



}
