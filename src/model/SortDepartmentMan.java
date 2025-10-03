package model;

import java.util.Comparator;

public class SortDepartmentMan implements Comparator<DepartmentManager>{
//compare two manager using the salary and AppointmentDate.
	@Override
	public int compare(DepartmentManager d1, DepartmentManager d2) {
		// TODO Auto-generated method stub
		if((d1.getSalary()-d2.getSalary())==0) {
			return d1.getAppointmentDate().compareTo(d2.getAppointmentDate());
		}
		return (int) (d1.getSalary()-d2.getSalary());
	}

}
