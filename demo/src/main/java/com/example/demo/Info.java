package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "info")
public class Info implements Serializable {
	
	public Info(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	public Info() {
		super();
	}
	@Id
	@Column(name = "ID")
	@JsonProperty("Id")
	private int Id;
	@Column(name = "NAME")
	private String name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
