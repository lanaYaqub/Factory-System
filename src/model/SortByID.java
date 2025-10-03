package model;

import java.util.Comparator;

public class SortByID implements Comparator<Employee> {
//compare two IDs..
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getID().compareTo(o2.getID());
	}

}
