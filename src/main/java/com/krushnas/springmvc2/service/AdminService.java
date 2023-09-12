package com.krushnas.springmvc2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushnas.springmvc2.pojo.AdminPOJO;
import com.krushnas.springmvc2.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO getAdmin() {
		AdminPOJO pojo = repository.getAdmin();
		return pojo;
	}

	public AdminPOJO createAccount(String username, String password) {
		AdminPOJO pojo = repository.createAccount(username, password);
		return pojo;
	}

	public AdminPOJO login(String username, String password) {
		AdminPOJO pojo = repository.login(username, password);
		return pojo;
	}

}
