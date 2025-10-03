package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;

import utils.Gender;

public class Employee extends Person implements Serializable{
	
	private Date dateOfStartWork;
	private double salary;
	private Department dep;
	Image image;

	public Employee(String iD, String firstName, String lastName, String phoneNumber, Gender gender,
			Date dateOfStartWork, double salary, Department dep, int yearOfBirth) {
		super(iD, firstName, lastName, phoneNumber, gender,yearOfBirth);
		this.dateOfStartWork = dateOfStartWork;
		this.salary = salary;
		this.dep = dep;
	}
	public Date getDateOfStartWork() {
		return dateOfStartWork;
	}
	public void setDateOfStartWork(Date dateOfStartWork) {
		this.dateOfStartWork = dateOfStartWork;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	} 
	@Override
	public String toString() {
		return super.toString() + ", salary= " + salary  +" Department= " +getDep().getDepartmentID();
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	
	
	
	

}
