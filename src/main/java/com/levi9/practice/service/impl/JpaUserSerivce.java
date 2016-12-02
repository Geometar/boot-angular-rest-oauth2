package com.levi9.practice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.User;
import com.levi9.practice.repository.UserRepository;
import com.levi9.practice.service.UserService;

@Service
@Transactional
public class JpaUserSerivce implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstname(firstname);
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
