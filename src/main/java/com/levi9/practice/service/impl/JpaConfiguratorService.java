package com.levi9.practice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.Configurator;
import com.levi9.practice.model.UnexistingConfigurationException;
import com.levi9.practice.repository.ConfigurationRepository;
import com.levi9.practice.service.ConfigurationService;

@Service
@Transactional
public class JpaConfiguratorService implements ConfigurationService {

@Autowired
private ConfigurationRepository configurationRepository;
	
@Override
public List<Configurator> findAll() {
		
		return configurationRepository.findAll();
	}

@Override
public Configurator findOne(Long id) {
		
		return configurationRepository.findOne(id);
	}

@Override
public Configurator save(Configurator configurator) {
		
		return configurationRepository.save(configurator);
	}

@Override
public Configurator delete(Long id) throws UnexistingConfigurationException {
		Configurator configurator = configurationRepository.findOne(id);
			if(configurator==null){
			
			throw new UnexistingConfigurationException(
					"Configurator not found with ID " + id);
		
		}
			configurationRepository.delete(configurator);
		return configurator;
	}

@Override
public List<String> findComponentTypes() {
		return configurationRepository.findComponentTypes();
	}

}
