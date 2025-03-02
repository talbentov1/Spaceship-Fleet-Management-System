package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceShip{

	private int CargoCapacity;
	private int PassengerCapacity;
	private static final int AnnualBasicCost= 3000;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers, AnnualBasicCost);
		this.CargoCapacity=cargoCapacity;
		this.PassengerCapacity=passengerCapacity;
	}

@Override
	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost()+ 5*this.CargoCapacity+ 3*this.PassengerCapacity;
	}

	public int getCargoCapacity(){
		return this.CargoCapacity;
	}

	public int getPassengerCapacity(){
		return this.PassengerCapacity;
	}

	@Override
	public String toString(){
		return "TransportShip"+super.toString()+
				"\n\tCargoCapacity="+this.getCargoCapacity()+
				"\n\tPassengerCapacity="+this.getPassengerCapacity();
	}

}
