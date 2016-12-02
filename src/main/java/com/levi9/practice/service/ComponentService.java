package com.levi9.practice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.levi9.practice.model.Component;
import com.levi9.practice.model.UnexistingComponentException;

public interface ComponentService {

Page<Component> findAll(Integer page);
Component findOne(Long id);
Component save(Component component);
Component delete(Long id) throws UnexistingComponentException;
Page<Component> findByType(Integer page  ,String type);
	
}
