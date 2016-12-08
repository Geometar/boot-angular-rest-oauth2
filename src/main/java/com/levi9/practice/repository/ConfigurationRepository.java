package com.levi9.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.levi9.practice.model.Configurator;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configurator, Long> {

	@Query("select distinct c.type from Component as c")
	List<String> findComponentTypes();

}
