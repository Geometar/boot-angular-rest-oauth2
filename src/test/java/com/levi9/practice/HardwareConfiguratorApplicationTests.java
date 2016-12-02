package com.levi9.practice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.levi9.practice.model.Component;
import com.levi9.practice.model.ComponentValue;
import com.levi9.practice.model.UnexistingComponentException;
import com.levi9.practice.service.ComponentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HardwareConfiguratorApplication.class)
@WebAppConfiguration
public class HardwareConfiguratorApplicationTests {

	
//	@Autowired
//	private ComponentService componentService;
	
//	@Test
//	public void testFindAll() {
//		List<Component> components = componentService.findAll();
//		Assert.assertNotEquals(null, components);
//		Assert.assertNotNull(components);
//	}
//	
//	@Test
//	public void deleteTest() throws UnexistingComponentException{
//		componentService.delete(1L);
//		Component component = componentService.findOne(1L);
//		Assert.assertNull(component);	
//	}
//	
//	@Test
//	public void testSave(){
//		List<Component> componentsBefore = componentService.findAll();
//		int pre = componentsBefore.size();
//		Component component = new Component(6L, "SDD", "Samsung", "312", 1, 100);
//		componentService.save(component);
//		List<Component> componentsAfter = componentService.findAll();
//		int posle = componentsAfter.size();
//		Assert.assertEquals(posle, pre+1);	
//	}
//	
//	@Test
//	public void testFindOne(){		
//		Component componentOne = componentService.findOne(1L);
//		Component componentTwo = new Component(1L, "Maticna ploca", "Asus", "1234", 2, 4990, ComponentValue.REQUIRED_ONE);
//		Assert.assertEquals(componentTwo.getId(), componentOne.getId());
//	}
//	
//	
//	@Test
//	public void testType(){
//		String type = "Procesor";
//		List<Component> components = componentService.findByType(type);
//		Assert.assertNotNull(components);
//	}
}
