package com.levi9.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi9.practice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	public User findByFirstname(String firstname);
	
}
