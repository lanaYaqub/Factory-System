package Exeption;

public class PersonNotExistException extends Exception {
	public PersonNotExistException() {
		super("The person does not exist in the System");
	}

}
