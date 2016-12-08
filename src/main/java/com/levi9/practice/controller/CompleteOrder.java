package com.levi9.practice.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_completeOrder")
public class CompleteOrder {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Long orderId;
	@Column
	private Double price;
	@Column
	private Long components;

	public Long getId() {
		return id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Double getPrice() {
		return price;
	}

	public Long getComponents() {
		return components;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setComponents(Long components) {
		this.components = components;
	}

}
