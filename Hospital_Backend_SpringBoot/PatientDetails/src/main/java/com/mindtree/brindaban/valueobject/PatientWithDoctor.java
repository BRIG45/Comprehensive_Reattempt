package com.mindtree.brindaban.valueobject;

import java.util.Date;

public class PatientWithDoctor {
	private long id;
	private String name;
	private int age;
	private String visitedDoctor;
	private Date dataOfVist;
	private String prescription;

	public PatientWithDoctor() {
		super();
	}

	public PatientWithDoctor(long id, String name, int age, String visitedDoctor, Date dataOfVist,
			String prescription) {
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

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
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
