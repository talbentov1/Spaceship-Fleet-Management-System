package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends mygetWeaponAndFirePower{

	private static final int AnnualBasicCost= 5000;
	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,crewMembers, AnnualBasicCost,weapons);
		this.numberOfTechnicians=numberOfTechnicians;
	}

	public int getNumberOfTechnicians(){
		return this.numberOfTechnicians;
	}

	public int getFirePower(){
		return super.getFirePower();
	}

	public List<Weapon> getWeapon(){
		return super.weaponslist;
	}

	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost()+ (int) (Weapon.SumOfAnnualMaintenanceCost(this.weaponslist)*(1-(this.numberOfTechnicians*0.1)));
	}

	@Override
	public String toString(){
		return "Bomber"+super.toString()+ "\n\tNumberOfTechnicians="+this.numberOfTechnicians;
	}

}
