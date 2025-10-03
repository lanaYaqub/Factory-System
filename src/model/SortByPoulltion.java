package model;

import java.util.Comparator;

public class SortByPoulltion implements Comparator<VehicleTransportation> {
//compare two vehicle using pollution level then using price and LicensePlate.
	@Override
	public int compare(VehicleTransportation o1, VehicleTransportation o2) {
		// TODO Auto-generated method stub
		if((int) (o1.getPrice()-o2.getPrice())==0 && ((-1)*(o1.getPollutionLevel()-o2.getPollutionLevel())==0) ) {
			return o1.getLicensePlate().compareTo(o2.getLicensePlate());
		}
		
		if((-1)*(o1.getPollutionLevel()-o2.getPollutionLevel())==0){
			
			return (int) (o1.getPrice()-o2.getPrice());
		}
		
	
	
		return (-1)*(o1.getPollutionLevel()-o2.getPollutionLevel());
	}

}
