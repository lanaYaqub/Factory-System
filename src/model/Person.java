package model;

import java.io.Serializable;

import utils.Gender;

public abstract class Person implements Serializable {
	private String ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Gender gender;
	private int yearOfBirth;

	
	public Person(String iD, String firstName, String lastName, String phoneNumber, Gender gender, int yearOfBirth) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.yearOfBirth = yearOfBirth;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "ID= " + ID + ", firstName= " + firstName + ", lastName=" + lastName + ", phoneNumber= "
				+ phoneNumber;
	}
	
	
	

}
