package Exeption;

import model.Person;

public class PersonAlreadyExistException extends Exception{
	public PersonAlreadyExistException(Person p) {
		super("The person already exists in the System: <"+p.getFirstName()+p.getLastName()+">  The person not added to the system.");
	}

}

