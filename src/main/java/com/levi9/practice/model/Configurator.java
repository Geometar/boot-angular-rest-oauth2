package com.levi9.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="configuration")
public class Configurator {
	
@Id
@GeneratedValue
@Column(name="id")
private Long id;
	
@ManyToOne
@JoinColumn(name="components_id")
private Component component;
	
 public Configurator(Long id, Component component) {
	super();
		this.id = id;
		this.component = component;
	}

 public Configurator() {
		
	}

 public Long getId() {
		return id;
	}
	
 public void setId(Long id) {
		this.id = id;
	}
 public Component getComponents() {
		return component;
	}
 public void setComponents(Component component) {
		this.component = component;
	}


}
