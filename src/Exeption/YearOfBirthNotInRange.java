package Exeption;

import model.Person;

public class YearOfBirthNotInRange extends Exception {
	public YearOfBirthNotInRange(Person p) {
		super("The person's year of birth must be between 1900-2022. The person <"+ p.getID() +"> not added to the system.");
	}


}
