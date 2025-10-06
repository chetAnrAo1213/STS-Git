package com.boot.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="RoleBook")
public class RoleBook 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	
	String name;
	String cost;
	public RoleBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleBook(int id, String name, String cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
}
