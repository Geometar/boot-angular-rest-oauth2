package com.levi9.practice.service;

import com.levi9.practice.model.User;

public interface UserService {
	
	public User findOne(Long id);
	
	public User findByEmail(String email);
	
	public User findByFirstname(String firstname);

}
