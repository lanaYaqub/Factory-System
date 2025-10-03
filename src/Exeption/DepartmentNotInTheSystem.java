package Exeption;
public class DepartmentNotInTheSystem  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DepartmentNotInTheSystem() {
		super("The Department not found in the system");
	}

}
