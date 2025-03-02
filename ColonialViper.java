package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

	private static int AnnualBasicCost=4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers, AnnualBasicCost,weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		return AnnualBasicCost+ Weapon.SumOfAnnualMaintenanceCost(this.weaponslist)+
				(int) (this.getMaximalSpeed()*500)+ this.getCrewMembers().size()*500;
	}

	@Override
	public String toString(){
		return "ColonialViper"+
				"\n\tName="+this.getName()+
				"\n\tCommissionYear="+this.getCommissionYear()+
				"\n\tMaximalSpeed="+this.getMaximalSpeed()+
				"\n\tFirePower="+this.getFirePower()+
				"\n\tCrewMembers="+this.getCrewMembers().size()+
				"\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost()+
				"\n\tWeaponArray="+this.getWeapon();
	}

}
