package model;

import java.util.HashSet;


public class ArithmeticMean implements ScoreCalculator {

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		// TODO Auto-generated method stub
		//define variables
		Integer count = 0;
		float sum = 0, average = 0;
		for (VehicleTransportation v : allVehicleTransportation) {
			//sum all the Pollution Level to per VehicleTransportation
			sum += v.getPollutionLevel();
			count++;
		}
		//calculate the average
		average = sum / count;
		return average;
	}

}

