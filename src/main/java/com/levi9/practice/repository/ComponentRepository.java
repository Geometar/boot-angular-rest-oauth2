package com.levi9.practice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levi9.practice.model.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long>{
	
 Page<Component> findByTypeLike(Pageable pageable , String type);

}
