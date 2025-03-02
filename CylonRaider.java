package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	private static int AnnualBasicCost=3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers, AnnualBasicCost,weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		return AnnualBasicCost+ Weapon.SumOfAnnualMaintenanceCost(this.weaponslist)+
				(int) (this.getMaximalSpeed()*1200)+ this.getCrewMembers().size()*500;
	}

	@Override
	public String toString(){
		return "CylonRaider"+
				"\n\tName="+this.getName()+
				"\n\tCommissionYear="+this.getCommissionYear()+
				"\n\tMaximalSpeed="+this.getMaximalSpeed()+
				"\n\tFirePower="+this.getFirePower()+
				"\n\tCrewMembers="+this.getCrewMembers().size()+
				"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+
				"\n\tWeaponArray="+this.getWeapon();
	}
}
