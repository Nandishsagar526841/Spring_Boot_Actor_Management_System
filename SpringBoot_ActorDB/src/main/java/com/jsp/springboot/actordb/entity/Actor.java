package com.jsp.springboot.actordb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// since we added spring data jpa dependency .it has jakarta package.Hence entity and Id are from jakarta. 
@Entity
public class Actor {
	@Id
	private int actorId;
	private String actorName;
	private int age;
	private String industry;
	private String nationality;
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
	
	
}
