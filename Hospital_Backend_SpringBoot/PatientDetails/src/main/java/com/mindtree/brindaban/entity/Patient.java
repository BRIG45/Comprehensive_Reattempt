package com.mindtree.brindaban.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	private long visitedDoctor;
	private Date dataOfVist;
	private String prescription;

	public Patient() {
		super();
	}

	public Patient(long id, String name, int age, long visitedDoctor, Date dataOfVist, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.visitedDoctor = visitedDoctor;
		this.dataOfVist = dataOfVist;
		this.prescription = prescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(long visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDataOfVist() {
		return dataOfVist;
	}

	public void setDataOfVist(Date dataOfVist) {
		this.dataOfVist = dataOfVist;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

}
