package com.levi9.practice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_order")
public class Order {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Long orderId;
	@ManyToOne(fetch=FetchType.LAZY)
	private Component component;
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@Column
	private int quantity;
	@Column
	private double price;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ComponentValue getValue() {
		return value;
	}

	public void setValue(ComponentValue value) {
		this.value = value;
	}

	@Enumerated(EnumType.STRING)
	private ComponentValue value;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@JsonIgnore
	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
