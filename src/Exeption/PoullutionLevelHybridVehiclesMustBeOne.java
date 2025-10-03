package Exeption;

import model.VehicleTransportation;

public class PoullutionLevelHybridVehiclesMustBeOne extends Exception{
	public PoullutionLevelHybridVehiclesMustBeOne(VehicleTransportation v) {
		super("Pollution level in hybrid vehicles must be 1. The vehicle < "+v.getLicensePlate()+" > not added to the system .");
	}

}
