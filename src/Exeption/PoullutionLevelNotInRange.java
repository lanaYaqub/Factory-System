package Exeption;

import model.VehicleTransportation;

public class PoullutionLevelNotInRange extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PoullutionLevelNotInRange(VehicleTransportation v) {
		super("Pollution level not in range. The vehicle < "+v.getLicensePlate()+">  not added to the system.");
	}

}
