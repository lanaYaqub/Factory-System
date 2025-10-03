package model;

import java.util.HashSet;



public class HarmonicMean implements ScoreCalculator {

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		// TODO Auto-generated method stub
		float sum = 0;
		//calculate pollution level using Harmonic average.
		for (VehicleTransportation vehicleTransportation : allVehicleTransportation) {
			sum = sum + (float) 1 / vehicleTransportation.getPollutionLevel();
		}
		return (float) allVehicleTransportation.size() / sum;
	}

}

