package model;

import java.util.Comparator;

public class SortByDeals implements Comparator<Customer> {
//function that compare and sort the customer according to AllDeals size
	//then compare it to vehicle size in AllDeals.
	@Override
	public int compare(Customer c1, Customer c2) {
		// TODO Auto-generated method stub
		int size1=0,size2=0;
		if(c1.getAllDeals().size()-c2.getAllDeals().size()==0) {
		
			for(Deal deal1:c1.getAllDeals()) {
				size1+=deal1.getAllVehicleTransportation().size();
			for(Deal deal2:c2.getAllDeals()) {
				size2+=deal2.getAllVehicleTransportation().size();
		     	}
			}
			if((-1)*(size1-size2)==0 &&  c1.getAllDeals().size()-c2.getAllDeals().size()==0) {
				return  Integer.parseInt(c1.getID())-Integer.parseInt(c2.getID());
			}
			return (-1)*(size1-size2);
		}
	
		return c1.getAllDeals().size()-c2.getAllDeals().size();
	}

}
