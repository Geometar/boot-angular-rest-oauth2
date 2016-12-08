package com.levi9.practice.model;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_order")
public class Order {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(name="order_id")
	private Long orderId;
	
	@ManyToMany(mappedBy="order", fetch = FetchType.LAZY)
	private List<Component> component;
	
	@Column
	private Double totalAmmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@PostPersist
	private void createDate() {
		date = new Date();
	}

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
	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalAmmount() {
		return totalAmmount;
	}
	
	public void setTotalAmmount(List<Component> component) {
		double total = 0;
		for(Component c: component){
			total = total + c.getPrice()*c.getQuantity();
		}
		this.totalAmmount = total;
	}

}
