package com.mindtree.brindaban.valueobject;

public class DoctorWithPatient {

	private long id;
	private String name;
	private int age;
	private String gender;
	private String specialist;
	private int numberOfPatient;

	public DoctorWithPatient() {
		super();
	}

	public DoctorWithPatient(long id, String name, int age, String gender, String specialist, int numberOfPatient) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
		this.numberOfPatient = numberOfPatient;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getNumberOfPatient() {
		return numberOfPatient;
	}

	public void setNumberOfPatient(int numberOfPatient) {
		this.numberOfPatient = numberOfPatient;
	}
}
