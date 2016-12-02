package com.levi9.practice.service;

import java.util.List;
import com.levi9.practice.model.Configurator;
import com.levi9.practice.model.UnexistingConfigurationException;

public interface ConfigurationService {
	
List<Configurator> findAll();
Configurator findOne(Long id);
Configurator save(Configurator configurator);
Configurator delete(Long id) throws UnexistingConfigurationException;
List<String> findComponentTypes(); 

}
