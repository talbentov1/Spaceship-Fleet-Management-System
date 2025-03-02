package il.ac.tau.cs.sw1.ex9.starfleet;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private static int countStealthCruiserInstances=0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		countStealthCruiserInstances++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name,commissionYear,maximalSpeed,crewMembers, Arrays.asList(new Weapon ("Laser Cannons",10,100)));
	}

	@Override
	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost()+ countStealthCruiserInstances*50;
	}

	@Override
	public String toString(){
		return "StealthCruiser"+
				"\n\tName="+this.getName()+
				"\n\tCommissionYear="+this.getCommissionYear()+
				"\n\tMaximalSpeed="+this.getMaximalSpeed()+
				"\n\tFirePower="+this.getFirePower()+
				"\n\tCrewMembers="+this.getCrewMembers().size()+
				"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+
				"\n\tWeaponArray="+this.getWeapon();
	}
}
