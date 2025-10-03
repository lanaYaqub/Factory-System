package model;

import java.util.HashSet;

public interface ScoreCalculator {
	
	float calculate (HashSet<VehicleTransportation>allVehicleTransportations);

}
