package com.levi9.practice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="component")
public class Component {
	
@Id
@GeneratedValue
@Column(name="id")
private Long id;

@Column(name="type")
@NotNull
private String type;

@Column(name="name")
@NotNull
private String name;
	
@Column(name="itemCode")
@NotNull
private String itemCode;
	
@Column(name="quantity")
@NotNull
private int quantity;
	
@Column(name="price")
@NotNull
private double price;
	
@Enumerated(EnumType.STRING)
@NotNull
private ComponentValue value;

@OneToMany(mappedBy="component" ,cascade=CascadeType.REMOVE)
private List<Order> orders;

public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}

	
public Component() {
		super();
	}
public Component(Long id, String type, String name, String itemCode, int quantity, double price,
			ComponentValue value) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.price = price;
		this.value = value;
	}
	
public Component(Long id, String type, String name, String itemCode, int quantity, double price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.price = price;
	}
public ComponentValue getValue() {
		return value;
	}
public void setValue(ComponentValue value) {
		this.value = value;
	}
public Long getId() {
		return id;
	}
public void setId(Long id) {
		this.id = id;
	}
public String getType() {
		return type;
	}
public void setType(String type) {
		this.type = type;
	}
public String getName() {
		return name;
	}
public void setName(String name) {
		this.name = name;
	}
public String getItemCode() {
		return itemCode;
	}
public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
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

@Override
public String toString() {
	return "Component [id=" + id + ", type=" + type + ", name=" + name + ", itemCode=" + itemCode + ", quantity="
			+ quantity + ", price=" + price + ", value=" + value + "]";
}



}
