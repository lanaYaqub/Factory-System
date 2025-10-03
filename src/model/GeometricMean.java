package model;


import java.util.HashSet;


public class GeometricMean implements ScoreCalculator {

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		float sum = 1;
		for (VehicleTransportation vehicleTransportation : allVehicleTransportation) {
			//get the total level of pollution
			sum = sum * vehicleTransportation.getPollutionLevel();
			
		}
		//calculate the pollution.
		float avg = (float) Math.pow(sum, (float) 1 / allVehicleTransportation.size());
		return avg;
	}

}


